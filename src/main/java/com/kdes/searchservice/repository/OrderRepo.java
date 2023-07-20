package com.kdes.searchservice.repository;

import com.kdes.searchservice.model.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.UUID;

public interface OrderRepo extends ElasticsearchRepository<Order, UUID> {
}
