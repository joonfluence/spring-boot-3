package com.example.demo.trace;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TraceId {
    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private TraceId createNextTraceId() {
        return new TraceId(createId(), this.level + 1);
    }

    private TraceId createPreviousTraceId() {
        return new TraceId(createId(), this.level - 1);
    }

    private boolean isFirstLevel(){
        return this.level == 0;
    }
}
