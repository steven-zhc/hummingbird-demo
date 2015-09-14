package com.hczhang.hummingbird.demo.spring.model.cmd;

import com.hczhang.hummingbird.command.AbstractCommand;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by steven on 8/12/15.
 */
public class EditTodoItemCmd extends AbstractCommand<String> {
    private String key;
    private String item;
    private String memo;

    public EditTodoItemCmd(String key) {
        this.key = key;
    }

    @Override
    public String getAggregateID() {
        return key;
    }

    public EditTodoItemCmd item(String item) {
        this.item = item;
        return this;
    }

    public EditTodoItemCmd memo(String memo) {
        this.memo = memo;
        return this;
    }

    public String getItem() {
        return item;
    }

    public String getMemo() {
        return memo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("key", key)
                .append("item", item)
                .append("memo", memo)
                .toString();
    }
}
