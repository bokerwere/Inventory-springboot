package com.strathmore.inventoryapplication.Stock.Controller;

import com.strathmore.inventoryapplication.Stock.Dto.StockRequestDto;
import com.strathmore.inventoryapplication.Stock.Entity.StockEntity;
import com.strathmore.inventoryapplication.Stock.Service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items/")
public class StockController {
    private  final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
@PostMapping("/addStock/")
    public ResponseEntity<StockEntity>addStock(@RequestBody StockRequestDto stockRequestDto){
       return ResponseEntity.ok(stockService.purchase(stockRequestDto));
    }
    @PostMapping("/sellStock/")
    public ResponseEntity<StockEntity>sell(@RequestBody StockRequestDto stockRequestDto){
        return ResponseEntity.ok(stockService.sell(stockRequestDto));
    }
    @GetMapping("/getAllStock/")
    public ResponseEntity<List<StockEntity>>getAllStock(){
        return ResponseEntity.ok(stockService.getAllStocks());
    }

}
