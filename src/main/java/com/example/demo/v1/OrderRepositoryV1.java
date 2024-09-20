package com.example.demo.v1;

import com.example.demo.helloTrace.HelloTraceV1;
import com.example.demo.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 traceV1;

    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderRepositoryV1.save");
            sleep(1000);
            if (itemId.equals("ex")){
                throw new IllegalStateException("예외 발생!");
            }
            traceV1.end(status);
        } catch (Exception e){
            traceV1.exception(status, e);
            throw e;
        }
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
