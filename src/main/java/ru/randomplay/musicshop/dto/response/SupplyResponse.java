package ru.randomplay.musicshop.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class SupplyResponse {
    private Long id;
    private String warehouseManagerLastName;
    private String warehouseManagerFirstName;
    private LocalDate date;
    private Map<String, Integer> supplyItems;
}
