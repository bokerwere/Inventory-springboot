package com.strathmore.inventoryapplication.Items.Controller;

import com.strathmore.inventoryapplication.Common.AppResponse;
import com.strathmore.inventoryapplication.Items.Dto.ItemRequestDto;
import com.strathmore.inventoryapplication.Items.Entity.ItemEntity;
import com.strathmore.inventoryapplication.Items.Service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create-item/")
    @Operation(summary = "create item", description = "This end point saves items",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successfully saved a application", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json"))
            })
    public ResponseEntity<ItemEntity> createItem(@RequestBody ItemRequestDto itemRequestDto) {
        log.info("===============create item endpoint=======================");
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(itemRequestDto));
    }

    @PutMapping("/update-item/")
    @Operation(summary = "update item", description = "This end point updates item",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successfully saved a application", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "401", description = "You are not authorized", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json"))
            })
    public ResponseEntity<ItemEntity> updateItem(@RequestBody ItemRequestDto itemRequestDto) {
        log.info("=============== item update endpoint=======================");
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.updateItem(itemRequestDto));
    }

    @GetMapping("/getAllItems/")
    public ResponseEntity<List<ItemEntity>> findAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/getItemByItemCode/")
    public ResponseEntity<ItemEntity> getItemByCode(@RequestParam(name = "itemCode") Long itemCode) {
        return ResponseEntity.ok(itemService.getItemCode(itemCode));
    }

    @GetMapping("/getItemByPublicId/")
    public ResponseEntity<ItemEntity> getItemByPublicId(@RequestParam(name = "publicId") UUID publicId) {
        return ResponseEntity.ok(itemService.getByPublicId(publicId));
    }

    @DeleteMapping("/deleteItem/")
    public ResponseEntity<AppResponse> deleteItem(@RequestParam (name="itemCode") Long itemCode) {
        return ResponseEntity.ok(itemService.deleteItem(itemCode));
    }
}