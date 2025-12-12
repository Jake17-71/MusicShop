package ru.randomplay.musicshop.service;

import ru.randomplay.musicshop.dto.create.SupplyCreateRequest;
import ru.randomplay.musicshop.dto.response.SupplyResponse;
import ru.randomplay.musicshop.entity.WarehouseManager;

import java.util.List;

public interface SupplyService {
    List<SupplyResponse> getAll();

    void create(SupplyCreateRequest supplyCreateRequest, WarehouseManager warehouseManager);
}
