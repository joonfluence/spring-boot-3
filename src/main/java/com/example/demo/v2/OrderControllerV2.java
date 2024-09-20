
package com.example.demo.v2;

import com.example.demo.OrderCreateRequest;
import com.example.demo.helloTrace.HelloTraceV1;
import com.example.demo.helloTrace.HelloTraceV2;
import com.example.demo.trace.TraceId;
import com.example.demo.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/orders")
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @PostMapping
    public String createOrderItem(@RequestBody OrderCreateRequest request){
        TraceStatus status = null;
        try {
            TraceId traceId = new TraceId();
            status = trace.beginSync(traceId, "OrderControllerV2.createOrderItem");
            orderService.save(status.getTraceId(), request.getItemId());
            trace.end(status);
            return "OK";
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}

