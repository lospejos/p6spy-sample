package com.hainet.p6spy.sample.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

public class P6SpyMessageFormat implements MessageFormattingStrategy {

    @Override
    public String formatMessage(
            final int connectionId, final String now, final long elapsed,
            final String category, final String prepared, final String sql) {
        return "SQL: " + sql + "\tElapsed: " + elapsed + "ms";
    }
}
