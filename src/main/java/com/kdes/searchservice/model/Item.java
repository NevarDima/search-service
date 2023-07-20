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
@Document(indexName = "items")
public class Item {
    @Id
    private UUID itemId;
    @Field(name = "order_id")
    private UUID orderId;
    @Field(name = "product_id")
    private UUID productId;
    @Field(name = "quantity")
    private int quantity;
    @Field(name = "price")
    private double price;
}
