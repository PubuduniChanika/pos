package com.spring.pos.pos2.dto.paginated;

import com.spring.pos.pos2.dto.response.ItemGetResponseDto;
import com.spring.pos.pos2.dto.response.OrderGetResponseDto;
import com.spring.pos.pos2.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDto {
    List<OrderGetResponseDto> list;
    private long dataCount;
}
