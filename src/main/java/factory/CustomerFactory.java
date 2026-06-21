/* 
  Customer____.java
  Author: 222709006 Qhama dyushu
  Date: 22/03/2026
    */
package factory;

import domain.Customer;

public class CustomerFactory {

    public static Customer createCustomer(String id, String name, String email, String phone) {

        if (id == null || name == null) {
            return null;
        }

        return new Customer.Builder()
                .setCustomerId(id)
                .setName(name)
                .setEmail(email)
                .setPhone(phone)
                .build();
    }
}
