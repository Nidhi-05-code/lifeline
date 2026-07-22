package com.lifeline.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequestDTO {

    @NotNull
    private Long userId;

    @NotBlank
    private String title;

    @NotBlank
    private String message;
}