/* InvoiceRepositoryImpl.java
   InvoiceRepositoryImpl class
   Author: Mogamad Jawaad Allie - 230472125
   Date: 21 June 2026
*/
package repository.impl;

import domain.Invoice;
import repository.InvoiceRepository;
import java.util.*;

public class InvoiceRepositoryImpl implements InvoiceRepository {
    private static InvoiceRepositoryImpl repository = null;
    private final Map<String, Invoice> invoiceDB = new HashMap<>();

    public InvoiceRepositoryImpl() {
    }

    public static InvoiceRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new InvoiceRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Invoice create(Invoice invoice) {
        invoiceDB.put(invoice.getInvoiceId(), invoice);
        return invoice;
    }

    @Override
    public Invoice read(String invoiceId) {
        return invoiceDB.get(invoiceId);
    }

    @Override
    public Invoice update(Invoice invoice) {
        if (invoiceDB.containsKey(invoice.getInvoiceId())) {
            invoiceDB.put(invoice.getInvoiceId(), invoice);
            return invoice;
        }
        return null;
    }

    @Override
    public boolean delete(String invoiceId) {
        return invoiceDB.remove(invoiceId) != null;
    }

    @Override
    public List<Invoice> findAll() {
        return new ArrayList<>(invoiceDB.values());
    }
}
