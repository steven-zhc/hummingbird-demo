package com.hczhang.hummingbird.demo.spring.model.event;

import com.hczhang.hummingbird.event.AbstractEvent;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by steven on 8/12/15.
 */
public class MarkCompleteEvent extends AbstractEvent {

    private String key;

    @Override
    public Object getAggregateID() {
        return key;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("key", key)
                .toString();
    }

    public void setKey(String key) {
        this.key = key;
    }
}
