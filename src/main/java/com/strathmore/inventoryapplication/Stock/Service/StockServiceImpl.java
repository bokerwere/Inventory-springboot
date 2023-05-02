package com.strathmore.inventoryapplication.Stock.Service;

import com.strathmore.inventoryapplication.Exception.ResourceNotFoundException;
import com.strathmore.inventoryapplication.Items.Entity.ItemEntity;
import com.strathmore.inventoryapplication.Items.Repository.ItemRepository;
import com.strathmore.inventoryapplication.Stock.Dto.StockRequestDto;
import com.strathmore.inventoryapplication.Stock.Entity.StockEntity;
import com.strathmore.inventoryapplication.Stock.Repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StockServiceImpl implements StockService {
    private final ItemRepository itemRepository;
    private final StockRepository stockRepository;

    public StockServiceImpl(ItemRepository itemRepository, StockRepository stockRepository) {
        this.itemRepository = itemRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public StockEntity purchase(StockRequestDto stockRequestDto) {
        ItemEntity itemEntity = itemRepository.findByItemCode(stockRequestDto.getItemCode())
                .orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
        try {
            if (stockRequestDto.getItemCode() == itemEntity.getItemCode()) {
                StockEntity stockEntity = new StockEntity();
                stockEntity.setStockCode(stockEntity.getStockCode());
                stockEntity.setItemCode(itemEntity.getItemCode());
                stockEntity.setSupplierCode(stockRequestDto.getSupplierCode());
                return stockRepository.save(stockEntity);
            }
        } catch (Exception exception) {
            String errorMessage = exception.getMessage();
            exception.printStackTrace();
            log.error("errorBody{}", errorMessage);
            //throw new ResourceNotFoundException("Resource not found");
        }
        return null;
    }

    @Override
    public StockEntity sell(StockRequestDto stockRequestDto) {
        ItemEntity itemEntity = itemRepository.findByItemCode(stockRequestDto.getItemCode())
                .orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));

        StockEntity newStock = new StockEntity();
        newStock.setStockCode(newStock.getStockCode());
        newStock.setItemCode(itemEntity.getItemCode());
        newStock.setStockQuantity(stockRequestDto.getStockQuantity() * -1);
        newStock.setSupplierCode(stockRequestDto.getSupplierCode());
        return stockRepository.save(newStock);
    }

    @Override
    public List<StockEntity> getAllStocks() {
        return stockRepository.findAll();
    }


}
