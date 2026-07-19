package service;

import domain.Payment;
import java.util.List;

public interface PaymentService extends IService<Payment, String> {
    List<Payment> findAll();
}
