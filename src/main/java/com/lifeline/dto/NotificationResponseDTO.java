package com.lifeline.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationResponseDTO {

    private Long id;

    private Long userId;

    private String userName;

    private String title;

    private String message;

    private Boolean isRead;
}