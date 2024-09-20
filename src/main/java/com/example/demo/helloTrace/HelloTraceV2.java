package com.example.demo.helloTrace;

import com.example.demo.trace.TraceId;
import com.example.demo.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV2 {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    public TraceStatus begin(String message) {
        TraceId traceId = new TraceId();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    public TraceStatus beginSync(TraceId traceId, String message) {
        TraceId nextTraceId = traceId.createNextTraceId(traceId);
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", nextTraceId.getId(), addSpace(START_PREFIX, nextTraceId.getLevel()), message);
        return new TraceStatus(nextTraceId, startTimeMs, message);
    }

    public void end(TraceStatus traceStatus) {
        complete(traceStatus, null);
    }

    public void exception(TraceStatus traceStatus, Exception e) {
        complete(traceStatus, e);
    }

    private void complete(TraceStatus status, Exception e) {
        TraceId traceId = status.getTraceId();
        String message = status.getMessage();
        Long stopTimeMs = System.currentTimeMillis();
        Long resultTimeMs = stopTimeMs - status.getStartMs();
        log.info("[{}] {}{}", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), message);
        new TraceStatus(traceId, stopTimeMs, message);

        if (e != null) {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs, e.toString());
        } else {
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs);
        }
    }

    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append((i == level - 1) ? "|" + prefix : "|  ");
        }
        return sb.toString();
    }
}
