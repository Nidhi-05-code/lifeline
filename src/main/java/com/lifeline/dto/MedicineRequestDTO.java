package com.lifeline.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class MedicineRequestDTO {

    @NotNull
    private Long hospitalId;

    @NotBlank
    private String medicineName;

    @NotBlank
    private String manufacturer;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal price;

    @NotNull
    private LocalDate expiryDate;

    private Boolean available = true;
}