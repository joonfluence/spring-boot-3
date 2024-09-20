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

    public String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextTraceId() {
        return new TraceId(createId(), level + 1);
    }

    public TraceId createNextTraceId(TraceId traceId) {
        return new TraceId(traceId.getId(), traceId.getLevel() + 1);
    }

    public TraceId createPreviousTraceId() {
        return new TraceId(createId(), level - 1);
    }

    public boolean isFirstLevel(){
        return this.level == 0;
    }
}
