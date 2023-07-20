package com.kdes.searchservice.repository;

import com.kdes.searchservice.model.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepo extends ElasticsearchRepository<Item, UUID> {

    public List<Item> findAllByOrderId(UUID orderId);

}
