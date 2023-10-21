package com.spring.pos.pos2.controller;

import com.spring.pos.pos2.dto.CustomerDto;
import com.spring.pos.pos2.dto.paginated.PaginatedResponseItemDto;
import com.spring.pos.pos2.dto.request.ItemSaveRequestDto;
import com.spring.pos.pos2.dto.response.ItemGetResponseDto;
import com.spring.pos.pos2.entity.Item;
import com.spring.pos.pos2.service.ItemService;
import com.spring.pos.pos2.util.mappers.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("item/v1")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto){
        String message = itemService.saveItem(itemSaveRequestDto);
//        ResponseEntity<StandardResponse> responseEntity= new ResponseEntity<StandardResponse>(
//                new StandardResponse(201,"success",message),
//                HttpStatus.CREATED
//        );
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",message),
                HttpStatus.CREATED
        );
    }
    @GetMapping(path = "/get-by-name", params = "name")
    public ResponseEntity<StandardResponse> getItemByName(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDto> message = itemService.getItemByNameAndStatus(itemName);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",message),
                HttpStatus.OK
        );
        //return itemService.getItemByNameAndStatus(itemName);
    }
    @GetMapping(path = "/get-all-by-active-state", params = {"activeState","page","size"})
    public PaginatedResponseItemDto getItemByStatusPaginated(
            @RequestParam(value = "activeState") boolean activeState,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
            ) {
        PaginatedResponseItemDto paginatedResponseItemDto = itemService.getItemByStatusPaginated(activeState, page, size);
//        return itemService.getItemByStatus(activeState, page, size);
        return paginatedResponseItemDto;
    }

}
