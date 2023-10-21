package com.spring.pos.pos2.service;

import com.spring.pos.pos2.dto.paginated.PaginatedResponseOrderDto;
import com.spring.pos.pos2.dto.request.OrderRequestSaveDto;

public interface OrderService {
    String saveItem(OrderRequestSaveDto orderRequestSaveDto);

    PaginatedResponseOrderDto getOrderByStatusPaginated(boolean activeState, int page, int size);
}
