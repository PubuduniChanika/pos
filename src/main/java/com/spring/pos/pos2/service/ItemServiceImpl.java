package com.spring.pos.pos2.service;

import com.spring.pos.pos2.dto.paginated.PaginatedResponseItemDto;
import com.spring.pos.pos2.dto.request.ItemSaveRequestDto;
import com.spring.pos.pos2.dto.response.ItemGetResponseDto;
import com.spring.pos.pos2.entity.Item;
import com.spring.pos.pos2.exception.NotFoundException;
import com.spring.pos.pos2.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    public String saveItem(ItemSaveRequestDto itemSaveRequestDto){

        Item item = modelMapper.map(itemSaveRequestDto, Item.class);
        if(!itemRepository.existsById(item.getItemId())) {
            itemRepository.save(item);
            return "Saved!!!"+item.getItemId();
        }else{
            throw new DuplicateKeyException("Already added   ");
        }
    }

    @Override
    public List<ItemGetResponseDto> getItemByNameAndStatus(String itemName) {
        List<Item> items = itemRepository.findAllByItemNameEqualsAndActiveEquals(itemName,true);
        List<ItemGetResponseDto> itemDtos = modelMapper.map(items, new TypeToken<List<ItemGetResponseDto>>(){}.getType());
        return itemDtos;
    }

    @Override
    public List<ItemGetResponseDto> getItemByStatus(boolean activeState) {
        List<Item> items = itemRepository.findAllByActiveEquals(activeState);
        List<ItemGetResponseDto> itemDtos = modelMapper.map(items, new TypeToken<List<ItemGetResponseDto>>(){}.getType());
        return itemDtos;
    }

    @Override
    public PaginatedResponseItemDto getItemByStatusPaginated(boolean activeState, int page, int size) {
        Page<Item> items = itemRepository.findAllByActiveEquals(activeState, PageRequest.of(page,size));
        int count = itemRepository.countAllByActiveEquals(activeState);
        if(items.getSize()<1){
            throw new NotFoundException("No Data");
        }
        List<ItemGetResponseDto> itemDtos = items.map(item -> modelMapper.map(item, ItemGetResponseDto.class))
                .getContent();
        PaginatedResponseItemDto paginatedResponseItemDto = new PaginatedResponseItemDto(
                itemDtos,count
        );

        return paginatedResponseItemDto;
    }

//    @Override
//    public List<ItemGetResponseDto> getItemByNameAndStatus(String itemName) {
//        List<ItemGetResponseDto> itemDtos = itemRepository.findAllByNameEqualsAndStatusEquals(itemName,true);
//        return itemDtos;
//    }

//    @Override
//    public List<ItemGetResponseDto> getItemByNameAndStatus(String itemName) {
////        List<Item> items = itemRepository.findAllByNameEqualsAndStatusEquals(itemName,true);
////        List<ItemGetResponseDto> itemDtos = modelMapper.map(items, new TypeToken<List<ItemGetResponseDto>>(){}.getType());
////        //List<CustomerDto> customerDtos = customerMapper.entityListToDtoList(allCustomers);
//        return null;
//
//    }
}
