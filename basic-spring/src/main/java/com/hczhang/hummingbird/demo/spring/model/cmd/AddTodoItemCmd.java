package com.hczhang.hummingbird.demo.spring.model.cmd;

import com.hczhang.hummingbird.command.AbstractCommand;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Created by steven on 8/12/15.
 */
public class AddTodoItemCmd extends AbstractCommand<String> {

    private String item;
    private String memo;
    private Date createdTime;

    public AddTodoItemCmd() {
        createdTime = new Date();
    }

    @Override
    public String getAggregateID() {
        return null;
    }

    public String getItem() {
        return item;
    }

    public AddTodoItemCmd item(String item) {
        this.item = item;
        return this;
    }

    public String getMemo() {
        return memo;
    }

    public AddTodoItemCmd memo(String memo) {
        this.memo = memo;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public AddTodoItemCmd createdTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("item", item)
                .append("memo", memo)
                .append("createdTime", createdTime)
                .toString();
    }
}
