package com.kdes.searchservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "orders")
public class Order {
    @Id
    private UUID orderId;
    @Field(name = "customer_id")
    private UUID customerId;
    @Field(name = "created_at")
    private Long createdAt;
    @Field(name = "total_amount")
    private double totalAmount;
}
