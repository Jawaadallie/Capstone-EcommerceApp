/* NotificationRepositoryImplTest.java
   NotificationRepositoryImplTest class
   Author: Tlangelani Chauke
   Date: 21 June 2026
*/
package repository.impl;

import domain.Notification;
import factory.NotificationFactory;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class NotificationRepositoryImplTest {
    private final NotificationRepositoryImpl repo = new NotificationRepositoryImpl();

    @Test
    void testNotificationCRUD() {
        Date now = new Date();
        // 1. Create
        Notification notification = NotificationFactory.createNotification(
                "NOTIF-99",
                "CUST-007",
                "Your order has shipped!",
                now,
                "Sent"
        );
        assertNotNull(notification);
        Notification created = repo.create(notification);
        assertEquals(notification.getNotificationId(), created.getNotificationId());

        // 2. Read
        Notification read = repo.read(notification.getNotificationId());
        assertNotNull(read);
        assertEquals("Your order has shipped!", read.getMessage());

        // 3. Update
        Notification updated = new Notification.Builder().copy(read)
                .setStatus("Read")
                .build();
        Notification result = repo.update(updated);
        assertNotNull(result);
        assertEquals("Read", repo.read(notification.getNotificationId()).getStatus());

        // 4. Find All
        assertEquals(1, repo.findAll().size());

        // 5. Delete
        boolean deleted = repo.delete(notification.getNotificationId());
        assertTrue(deleted);
        assertEquals(0, repo.findAll().size());
    }
}
