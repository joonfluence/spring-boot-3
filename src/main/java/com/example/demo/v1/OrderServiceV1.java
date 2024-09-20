
package com.example.demo.v1;

import com.example.demo.helloTrace.HelloTraceV1;
import com.example.demo.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 repository;
    private final HelloTraceV1 traceV1;

    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderServiceV1.save");
            repository.save(itemId);
            traceV1.end(status);
        } catch (Exception e){
            traceV1.exception(status, e);
            throw e;
        }
    }
}
