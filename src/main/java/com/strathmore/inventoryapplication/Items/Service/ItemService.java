package com.strathmore.inventoryapplication.Items.Service;

import com.strathmore.inventoryapplication.Common.AppResponse;
import com.strathmore.inventoryapplication.Items.Dto.ItemRequestDto;
import com.strathmore.inventoryapplication.Items.Entity.ItemEntity;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    ItemEntity createItem(ItemRequestDto itemRequestDto);

    ItemEntity updateItem(ItemRequestDto itemRequestDto);

    List<ItemEntity> getAllItems();

    ItemEntity getByPublicId(UUID publicId);

    ItemEntity getItemCode(Long itemCode);

    AppResponse deleteItem(Long itemCode);
}