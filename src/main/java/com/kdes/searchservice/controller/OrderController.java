package com.kdes.searchservice.controller;

import com.kdes.searchservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable UUID orderId){
        var optionalOrder = orderService.findByOrderId(orderId);
        if(optionalOrder.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Get optionalOrder: '{}'", optionalOrder.get().getOrderId());
        return new ResponseEntity<>(optionalOrder.get(), HttpStatus.OK);
    }

}
