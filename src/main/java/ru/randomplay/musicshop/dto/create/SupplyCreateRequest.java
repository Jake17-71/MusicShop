package ru.randomplay.musicshop.dto.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class SupplyCreateRequest {
    @NotNull
    @NotEmpty
    private Map<@NotNull @Positive Long, @NotNull @Min(1) Integer> productsId;
}
