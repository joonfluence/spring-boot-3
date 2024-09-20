
package com.example.demo.v1;

import com.example.demo.OrderCreateRequest;
import com.example.demo.helloTrace.HelloTraceV1;
import com.example.demo.trace.TraceStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 traceV1;

    @PostMapping
    public String createOrderItem(@RequestBody OrderCreateRequest request){
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderControllerV1.createOrderItem");
            orderService.save(request.getItemId());
            traceV1.end(status);
            return "OK";
        } catch (Exception e){
            traceV1.exception(status, e);
            throw e;
        }
    }
}

