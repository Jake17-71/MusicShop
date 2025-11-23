package ru.randomplay.musicshop.service;

import ru.randomplay.musicshop.dto.EmployeeCreateRequest;

public interface EmployeeService {
    void save(EmployeeCreateRequest employeeCreateRequest);
}
