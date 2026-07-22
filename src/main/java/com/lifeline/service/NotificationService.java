package com.lifeline.service;

import com.lifeline.dto.NotificationRequestDTO;
import com.lifeline.dto.NotificationResponseDTO;

import java.util.List;

public interface NotificationService {

    NotificationResponseDTO sendNotification(
            NotificationRequestDTO requestDTO);

    List<NotificationResponseDTO> getUserNotifications(
            Long userId);

    List<NotificationResponseDTO> getUnreadNotifications(
            Long userId);

    NotificationResponseDTO markAsRead(Long id);

    void deleteNotification(Long id);
}