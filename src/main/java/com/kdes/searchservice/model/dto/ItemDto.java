package com.kdes.searchservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private UUID itemId;
    private UUID productId;
    private int quantity;
    private double price;
}
