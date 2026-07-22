package com.lifeline.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BloodBankRequestDTO {

    private String bloodBankName;
    private String email;
    private String phoneNumber;
    private String address;

    private Double latitude;
    private Double longitude;

    private Integer aPositive;
    private Integer aNegative;
    private Integer bPositive;
    private Integer bNegative;
    private Integer abPositive;
    private Integer abNegative;
    private Integer oPositive;
    private Integer oNegative;
}