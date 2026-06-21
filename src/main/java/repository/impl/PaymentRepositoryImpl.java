/* PaymentRepositoryImpl.java
   This is the implementation class for PaymentRepository.
   Author: Mogamad Jawaad Allie - 230472125
   Date: 25 March 2026
*/
package repository.impl;

import domain.Payment;
import repository.PaymentRepository;
import java.util.*;

public class PaymentRepositoryImpl implements PaymentRepository {
    private final Map<String, Payment> paymentDB = new HashMap<>();

    @Override
    public Payment create(Payment payment) {
        paymentDB.put(payment.getPaymentId(), payment);
        return payment;
    }

    @Override
    public Payment read(String id) {
        return paymentDB.get(id);
    }

    @Override
    public Payment update(Payment payment) {
        // If the payment exists, update it
        if (paymentDB.containsKey(payment.getPaymentId())) {
            paymentDB.put(payment.getPaymentId(), payment);
            return payment;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (paymentDB.containsKey(id)) {
            paymentDB.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(paymentDB.values());
    }
}
