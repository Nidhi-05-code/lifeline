package com.lifeline.mapper;

import com.lifeline.dto.NotificationRequestDTO;
import com.lifeline.dto.NotificationResponseDTO;
import com.lifeline.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public Notification toEntity(NotificationRequestDTO dto) {

        Notification notification = new Notification();

        notification.setTitle(dto.getTitle());
        notification.setMessage(dto.getMessage());

        return notification;
    }

    public NotificationResponseDTO toResponseDTO(Notification notification) {

        NotificationResponseDTO response = new NotificationResponseDTO();

        response.setId(notification.getId());

        if (notification.getUser() != null) {
            response.setUserId(notification.getUser().getId());
            response.setUserName(
                    notification.getUser().getFirstName() + " "
                            + notification.getUser().getLastName()
            );
        }

        response.setTitle(notification.getTitle());
        response.setMessage(notification.getMessage());
        response.setIsRead(notification.getIsRead());

        return response;
    }
}