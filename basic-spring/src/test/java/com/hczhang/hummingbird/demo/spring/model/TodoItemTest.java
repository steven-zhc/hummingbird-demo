package com.hczhang.hummingbird.demo.spring.model;

import com.hczhang.hummingbird.demo.spring.model.cmd.AddTodoItemCmd;
import com.hczhang.hummingbird.demo.spring.model.cmd.DeleteTodoItemCmd;
import com.hczhang.hummingbird.demo.spring.model.cmd.EditTodoItemCmd;
import com.hczhang.hummingbird.demo.spring.model.cmd.MarkCompleteCmd;
import com.hczhang.hummingbird.gateway.Gateway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by steven on 8/14/15.
 */
public class TodoItemTest {

    private Gateway gateway;

    @BeforeClass
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("cloud.xml");

        gateway = context.getBean(Gateway.class);
    }

    @Test
    public void testTodoItemCommands() throws Exception {
        AddTodoItemCmd addTodoItemCmd = new AddTodoItemCmd()
                .item("This is first item.")
                .memo("create a todo item");
        TodoItem item = gateway.send(addTodoItemCmd, TodoItem.class);

        String key = item.getAggregateID();

        assertNotNull(key);

        // update TodoItem
        String newMessage = "This is first [updated] item.";
        EditTodoItemCmd editTodoItemCmd = new EditTodoItemCmd(key)
                .item(newMessage);
        item = gateway.send(editTodoItemCmd, TodoItem.class);

        assertEquals(item.getItem(), newMessage);

        // mark complete
        MarkCompleteCmd markCompleteCmd = new MarkCompleteCmd(key);
        item = gateway.send(markCompleteCmd, TodoItem.class);

        assertTrue(item.getComplete());

        // delete TodoItem
        DeleteTodoItemCmd deleteTodoItemCmd = new DeleteTodoItemCmd(key);
        item = gateway.send(deleteTodoItemCmd, TodoItem.class);

        assertTrue(item.isDeleted());
    }

}