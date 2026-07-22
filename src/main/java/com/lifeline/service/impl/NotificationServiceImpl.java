package com.lifeline.service.impl;

import com.lifeline.dto.NotificationRequestDTO;
import com.lifeline.dto.NotificationResponseDTO;
import com.lifeline.entity.Notification;
import com.lifeline.entity.User;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.NotificationMapper;
import com.lifeline.repository.NotificationRepository;
import com.lifeline.repository.UserRepository;
import com.lifeline.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public NotificationResponseDTO sendNotification(
            NotificationRequestDTO requestDTO) {

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        Notification notification =
                notificationMapper.toEntity(requestDTO);

        notification.setUser(user);

        Notification saved =
                notificationRepository.save(notification);

        return notificationMapper.toResponseDTO(saved);
    }

    @Override
    public List<NotificationResponseDTO> getUserNotifications(
            Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        return notificationRepository.findByUser(user)
                .stream()
                .map(notificationMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<NotificationResponseDTO> getUnreadNotifications(
            Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        return notificationRepository.findByUserAndIsReadFalse(user)
                .stream()
                .map(notificationMapper::toResponseDTO)
                .toList();
    }

    @Override
    public NotificationResponseDTO markAsRead(Long id) {

        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Notification not found"));

        notification.setIsRead(true);

        Notification updated =
                notificationRepository.save(notification);

        return notificationMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteNotification(Long id) {

        notificationRepository.deleteById(id);
    }
}