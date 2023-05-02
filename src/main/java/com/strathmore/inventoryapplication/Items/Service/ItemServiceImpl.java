package com.strathmore.inventoryapplication.Items.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strathmore.inventoryapplication.Common.AppResponse;
import com.strathmore.inventoryapplication.Exception.ResourceNotFoundException;
import com.strathmore.inventoryapplication.Items.Dto.ItemRequestDto;
import com.strathmore.inventoryapplication.Items.Entity.ItemEntity;
import com.strathmore.inventoryapplication.Items.Repository.ItemRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @SneakyThrows
    @Override
    public ItemEntity createItem(ItemRequestDto itemRequestDto) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemCode(itemEntity.getItemCode());
        itemEntity.setItemName(itemRequestDto.getItemName());
        itemEntity.setItemCost(itemRequestDto.getItemCost());
        itemEntity.setItemSalePrice(itemRequestDto.getItemSalePrice());
        log.info("payload{}", itemEntity);
        ItemEntity saveItem = itemRepository.save(itemEntity);
        log.info("savedItem{}", mapper.writeValueAsString(saveItem));
        return saveItem;
    }

    @SneakyThrows
    @Override
    public ItemEntity updateItem(ItemRequestDto itemRequestDto) {
        ItemEntity itemEntity = itemRepository.findByPublicId(itemRequestDto.getPublicId())
                .orElseThrow(()
                        -> new ResourceNotFoundException(itemRequestDto.getPublicId() + " not found"));
        itemEntity.setItemName(itemRequestDto.getItemName());
        itemEntity.setItemName(itemRequestDto.getItemName());
        itemEntity.setItemCost(itemRequestDto.getItemCost());
        itemEntity.setItemSalePrice(itemRequestDto.getItemSalePrice());
        log.info("payload{}", itemEntity);
        ItemEntity saveItem = itemRepository.save(itemEntity);
        log.info("savedItem{}", mapper.writeValueAsString(saveItem));
        return saveItem;

    }

    @Override
    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public ItemEntity getByPublicId(UUID publicId) {
        ItemEntity savedItem = itemRepository.findByPublicId(publicId)
                .orElseThrow(()
                        -> new ResourceNotFoundException(publicId + " not found"));
        log.info("savedItem{}", savedItem);
        return savedItem;
    }


    @Override
    public ItemEntity getItemCode(Long itemCode) {
        ItemEntity savedItem = itemRepository.findByItemCode(itemCode)
                .orElseThrow(()
                        -> new ResourceNotFoundException(itemCode + " not found"));
        log.info("savedItem{}", savedItem);
        return savedItem;
    }

    @Override
    public AppResponse deleteItem(Long itemCode) {
        ItemEntity savedItem = itemRepository.findByItemCode(itemCode)
                .orElseThrow(()
                        -> new ResourceNotFoundException(itemCode + " does not exit"));
        log.info("savedItem{}", savedItem);
        itemRepository.delete(savedItem);

        return AppResponse.builder().status("deleted").timestamp(LocalDateTime.now()).build();
    }
}