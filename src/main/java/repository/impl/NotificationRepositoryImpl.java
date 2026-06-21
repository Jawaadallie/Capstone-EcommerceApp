/* NotificationRepositoryImpl.java
   NotificationRepositoryImpl class
   Author: Tlangelani Chauke
   Date: 21 June 2026
*/
package repository.impl;

import domain.Notification;
import repository.NotificationRepository;
import java.util.*;

public class NotificationRepositoryImpl implements NotificationRepository {
    private static NotificationRepositoryImpl repository = null;
    private final Map<String, Notification> notificationDB = new HashMap<>();

    public NotificationRepositoryImpl() {
    }

    public static NotificationRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new NotificationRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Notification create(Notification notification) {
        notificationDB.put(notification.getNotificationId(), notification);
        return notification;
    }

    @Override
    public Notification read(String notificationId) {
        return notificationDB.get(notificationId);
    }

    @Override
    public Notification update(Notification notification) {
        if (notificationDB.containsKey(notification.getNotificationId())) {
            notificationDB.put(notification.getNotificationId(), notification);
            return notification;
        }
        return null;
    }

    @Override
    public boolean delete(String notificationId) {
        return notificationDB.remove(notificationId) != null;
    }

    @Override
    public List<Notification> findAll() {
        return new ArrayList<>(notificationDB.values());
    }
}
