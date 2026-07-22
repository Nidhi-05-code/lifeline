package com.lifeline.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class MedicineResponseDTO {

    private Long id;

    private Long hospitalId;

    private String hospitalName;

    private String medicineName;

    private String manufacturer;

    private Integer quantity;

    private BigDecimal price;

    private LocalDate expiryDate;

    private Boolean available;
}