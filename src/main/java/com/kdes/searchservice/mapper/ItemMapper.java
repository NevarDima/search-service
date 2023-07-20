package com.kdes.searchservice.mapper;

import com.kdes.searchservice.model.Item;
import com.kdes.searchservice.model.dto.ItemDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    default ItemDto toDto(Item itemEntity){
        ItemDto itemDto = new ItemDto();
        itemDto.setItemId(itemEntity.getItemId());
        itemDto.setProductId(itemEntity.getProductId());
        itemDto.setQuantity(itemEntity.getQuantity());
        itemDto.setPrice(itemEntity.getPrice());
        return itemDto;
    }

    List<ItemDto> toDtos (List<Item> itemEntities);
}
