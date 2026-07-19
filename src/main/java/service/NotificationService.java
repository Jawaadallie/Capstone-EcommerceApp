package service;

import domain.Notification;
import java.util.List;

public interface NotificationService extends IService<Notification, String> {
    List<Notification> findAll();
}
