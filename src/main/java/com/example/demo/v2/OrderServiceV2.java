
package com.example.demo.v2;

import com.example.demo.helloTrace.HelloTraceV1;
import com.example.demo.helloTrace.HelloTraceV2;
import com.example.demo.trace.TraceId;
import com.example.demo.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 repository;
    private final HelloTraceV2 traceV2;

    public void save(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = traceV2.beginSync(traceId, "OrderServiceV2.save");
            repository.save(status.getTraceId(), itemId);
            traceV2.end(status);
        } catch (Exception e){
            traceV2.exception(status, e);
            throw e;
        }
    }
}
