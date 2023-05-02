package com.strathmore.inventoryapplication.Stock.Service;

import com.strathmore.inventoryapplication.Stock.Dto.StockRequestDto;
import com.strathmore.inventoryapplication.Stock.Entity.StockEntity;

import java.util.List;

public interface StockService {
    StockEntity purchase(StockRequestDto stockRequestDto);
    StockEntity sell( StockRequestDto stockRequestDto);
    List<StockEntity> getAllStocks();

    //StockDto sell(long code, StockDto stockDto);

}
