package com.hczhang.hummingbird.demo.spring.model.cmd;

import com.hczhang.hummingbird.command.AbstractCommand;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by steven on 8/12/15.
 */
public class MarkCompleteCmd extends AbstractCommand<String> {

    private String key;

    public MarkCompleteCmd(String key) {
        this.key = key;
    }

    @Override
    public String getAggregateID() {
        return key;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("key", key)
                .toString();
    }
}
