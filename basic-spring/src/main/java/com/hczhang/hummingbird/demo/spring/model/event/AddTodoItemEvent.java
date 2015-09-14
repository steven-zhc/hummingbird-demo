package com.hczhang.hummingbird.demo.spring.model.event;

import com.hczhang.hummingbird.event.AbstractEvent;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Created by steven on 8/12/15.
 */
public class AddTodoItemEvent extends AbstractEvent<String> {

    private String key;
    private String item;
    private String memo;
    private Date createdTime;
    private Boolean complete;

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getAggregateID() {
        return key;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
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
