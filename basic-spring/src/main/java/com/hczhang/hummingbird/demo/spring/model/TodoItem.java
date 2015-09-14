package com.hczhang.hummingbird.demo.spring.model;

import com.hczhang.hummingbird.demo.spring.model.cmd.AddTodoItemCmd;
import com.hczhang.hummingbird.demo.spring.model.cmd.DeleteTodoItemCmd;
import com.hczhang.hummingbird.demo.spring.model.cmd.EditTodoItemCmd;
import com.hczhang.hummingbird.demo.spring.model.cmd.MarkCompleteCmd;
import com.hczhang.hummingbird.demo.spring.model.event.AddTodoItemEvent;
import com.hczhang.hummingbird.demo.spring.model.event.DeleteTodoItemEvent;
import com.hczhang.hummingbird.demo.spring.model.event.EditTodoItemEvent;
import com.hczhang.hummingbird.demo.spring.model.event.MarkCompleteEvent;
import com.hczhang.hummingbird.model.AbstractAnnotationAggregateRoot;
import com.hczhang.hummingbird.model.annotation.AggregateID;
import com.hczhang.hummingbird.model.annotation.AggregateRoot;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.UUID;

/**
 * Created by steven on 8/12/15.
 */
@AggregateRoot
public class TodoItem extends AbstractAnnotationAggregateRoot<String> {

    @AggregateID
    private String key;
    private String item;
    private String memo;
    private Date createdTime;
    private Boolean complete;

    public TodoItem() {
    }

    public TodoItem(AddTodoItemCmd cmd) {
        AddTodoItemEvent event = new AddTodoItemEvent();
        event.setKey(UUID.randomUUID().toString());
        event.setItem(cmd.getItem());
        event.setMemo(cmd.getMemo());
        event.setCreatedTime(cmd.getCreatedTime());
        event.withMetaData(cmd.getEnv());

        this.applyEvent(event);
    }

    public void edit(EditTodoItemCmd cmd) {
        EditTodoItemEvent event = new EditTodoItemEvent();
        event.setKey(cmd.getAggregateID());
        event.setItem(cmd.getItem());
        event.setMemo(cmd.getMemo());

        event.withMetaData(cmd.getEnv());

        this.applyEvent(event);
    }

    public void complete(MarkCompleteCmd cmd) {
        MarkCompleteEvent event = new MarkCompleteEvent();
        event.setKey(cmd.getAggregateID());
        event.withMetaData(cmd.getEnv());

        this.applyEvent(event);
    }

    public void delete(DeleteTodoItemCmd cmd) {
        DeleteTodoItemEvent event = new DeleteTodoItemEvent();
        event.setKey(cmd.getAggregateID());
        event.withMetaData(cmd.getEnv());

        this.applyEvent(event);
    }

    public void onEvent(AddTodoItemEvent event) {
        this.key = event.getAggregateID();
        this.item = event.getItem();
        this.memo = event.getMemo();
        this.createdTime = event.getCreatedTime();
        this.complete = event.getComplete();
    }

    public void onEvent(EditTodoItemEvent event) {
        if (StringUtils.isNotBlank(event.getItem())) {
            this.item = event.getItem();
        }

        if (StringUtils.isNotBlank(event.getMemo())) {
            this.memo = event.getMemo();
        }
    }

    public void onEvent(MarkCompleteEvent event) {

        this.complete = true;
    }

    public void onEvent(DeleteTodoItemEvent event) {

        this.delete();
    }

    public String getKey() {
        return key;
    }

    public String getItem() {
        return item;
    }

    public String getMemo() {
        return memo;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Boolean getComplete() {
        return complete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("key", key)
                .append("item", item)
                .append("memo", memo)
                .append("createdTime", createdTime)
                .append("complete", complete)
                .toString();
    }
}
