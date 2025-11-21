package ru.randomplay.musicshop.service;

import ru.randomplay.musicshop.dto.UserCreateRequest;
import ru.randomplay.musicshop.entity.Customer;

public interface CustomerService {
    Customer save(UserCreateRequest userCreateRequest);
}
