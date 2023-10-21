package com.spring.pos.pos2.dto.paginated;

import com.spring.pos.pos2.dto.response.ItemGetResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDto {
    List<ItemGetResponseDto> list;
    private long dataCount;
}
