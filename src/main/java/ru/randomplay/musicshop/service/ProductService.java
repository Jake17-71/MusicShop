package ru.randomplay.musicshop.service;

import ru.randomplay.musicshop.dto.request.ProductRequest;
import ru.randomplay.musicshop.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse get(Long id);

    List<ProductResponse> getAll();

    void save(ProductRequest productRequest);
}
