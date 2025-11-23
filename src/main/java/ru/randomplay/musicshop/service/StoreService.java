package ru.randomplay.musicshop.service;

import ru.randomplay.musicshop.dto.StoreCreateRequest;
import ru.randomplay.musicshop.dto.StoreResponse;

import java.util.List;

public interface StoreService {
    List<StoreResponse> getAll();

    void save(StoreCreateRequest storeCreateRequest);
}
