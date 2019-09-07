package ru.krivonos;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private Long orderId;
    private Date creationDate;
    private String customerName;
    private Long totalAmount;

    public Order() {
    }

    public Order(Long orderId, Date creationDate, String customerName, Long totalAmount) {
        this.orderId = orderId;
        this.creationDate = creationDate;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OrderDTO");
        sb.append("{orderId=").append(orderId);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", totalAmount=").append(totalAmount);
        sb.append('}');
        return sb.toString();
    }
}