package service;

import domain.Invoice;
import java.util.List;

public interface InvoiceService extends IService<Invoice, String> {
    List<Invoice> findAll();
}
