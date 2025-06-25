package com.brayan.market.web.controller;

import com.brayan.market.domain.Purchase;
import com.brayan.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@Tag(name = "Purchases", description = "Operations related to purchase records")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    @Operation(summary = "Retrieve all purchases")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved purchase list")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    @Operation(summary = "Get purchases made by a specific client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Purchases found for the client"),
            @ApiResponse(responseCode = "404", description = "No purchases found for the client")
    })
    public ResponseEntity<List<Purchase>> getByClient(
            @Parameter(description = "Client ID", required = true, example = "4546221")
            @PathVariable("id") String clienteId) {
        return ResponseEntity.of(purchaseService.getByClient(clienteId));
    }

    @PostMapping
    @Operation(summary = "Save a new purchase")
    @ApiResponse(responseCode = "201", description = "Purchase saved successfully")
    public ResponseEntity<Purchase> save(
            @Parameter(description = "Purchase to be saved", required = true)
            @RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
