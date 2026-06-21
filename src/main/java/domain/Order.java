/* 
  Order____.java
  Author: Joshua Jonathan Bird - 230444032
  Date: 22/03/2026
    */
package domain;

public class Order {
    private final String orderId;
    private final String customerId;
    private final String orderDate;
    private final double totalAmount;

    private Order (Builder builder) {
        this.orderId = builder.orderId;
        this.customerId = builder.customerId;
        this.orderDate = builder.orderDate;
        this.totalAmount = builder.totalAmount;
    }

    //Getters
    public String getOrderId() {
        return orderId;

    }
    public String getCustomerId() {
        return customerId;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public double getTotalAmount() {
        return totalAmount;
    }

    public static class Builder {
        private  String orderId;
        private  String customerId;
        private  String orderDate;
        private  double totalAmount;

        //Setters
        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }
        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }
        public Builder setOrderDate(String orderDate) {
            this.orderDate = orderDate;
            return this;
        }
        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
