package com.hczhang.hummingbird.demo.spring.model.event;

import com.hczhang.hummingbird.event.AbstractEvent;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by steven on 8/12/15.
 */
public class EditTodoItemEvent extends AbstractEvent<String> {

    private String key;
    private String item;
    private String memo;

    @Override
    public String getAggregateID() {
        return key;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("key", key)
                .append("item", item)
                .append("memo", memo)
                .toString();
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
