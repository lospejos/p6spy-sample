package com.hainet.p6spy.sample.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

public class P6SpyConfig implements MessageFormattingStrategy {

    @Override
    public String formatMessage(
            final int connectionId, final String now, final long elapsed,
            final String category, final String prepared, final String sql) {
        return "SQL: " + sql + "\t" + "Elapsed: " + elapsed + "ms";
    }
}
