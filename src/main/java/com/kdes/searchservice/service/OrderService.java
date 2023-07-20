package com.kdes.searchservice.service;

import com.kdes.searchservice.mapper.ItemMapper;
import com.kdes.searchservice.model.Item;
import com.kdes.searchservice.model.dto.OrderDto;
import com.kdes.searchservice.repository.ItemRepo;
import com.kdes.searchservice.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final ItemRepo itemRepo;
    private final ItemMapper itemMapper;

    public Optional<OrderDto> findByOrderId(UUID orderId){
        var optionalOrder = orderRepo.findById(orderId);
        if(optionalOrder.isPresent()){
            var order = optionalOrder.get();
            List<Item> items = itemRepo.findAllByOrderId(orderId);
            return Optional.of(
                OrderDto
                    .builder()
                    .orderId(order.getOrderId())
                    .customerId(order.getCustomerId())
                    .createdAt(Instant.ofEpochMilli(order.getCreatedAt()).atZone(ZoneId.systemDefault()).toLocalDateTime())
                    .totalAmount(order.getTotalAmount())
                    .items(itemMapper.toDtos(items))
                    .build()
            );
        }

        return Optional.empty();
    }

}
