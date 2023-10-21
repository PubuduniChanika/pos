package com.spring.pos.pos2.controller;

import com.spring.pos.pos2.dto.paginated.PaginatedResponseItemDto;
import com.spring.pos.pos2.dto.paginated.PaginatedResponseOrderDto;
import com.spring.pos.pos2.dto.request.ItemSaveRequestDto;
import com.spring.pos.pos2.dto.request.OrderRequestSaveDto;
import com.spring.pos.pos2.service.ItemService;
import com.spring.pos.pos2.service.OrderService;
import com.spring.pos.pos2.util.mappers.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody OrderRequestSaveDto orderRequestSaveDto){
        String message = orderService.saveItem(orderRequestSaveDto);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",message),
                HttpStatus.CREATED
        );
    }
    @GetMapping(path = "/get-order-details", params = {"activeState","page","size"})
    public ResponseEntity<StandardResponse> getItemByStatusPaginated(
            @RequestParam(value = "activeState") boolean activeState,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        PaginatedResponseOrderDto paginatedResponseOrderDto = orderService.getOrderByStatusPaginated(activeState, page, size);
//        return itemService.getItemByStatus(activeState, page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",paginatedResponseOrderDto),
                HttpStatus.OK
        );
    }


}
