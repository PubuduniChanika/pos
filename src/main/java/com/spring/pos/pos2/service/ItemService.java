package com.spring.pos.pos2.service;

import com.spring.pos.pos2.dto.paginated.PaginatedResponseItemDto;
import com.spring.pos.pos2.dto.request.ItemSaveRequestDto;
import com.spring.pos.pos2.dto.response.ItemGetResponseDto;

import java.util.List;

public interface ItemService {

    String saveItem(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemGetResponseDto> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDto> getItemByStatus(boolean activeState);

    PaginatedResponseItemDto getItemByStatusPaginated(boolean activeState, int page, int size);

//    List<ItemGetResponseDto> getItemByNameAndStatus(String itemName);
}
