package org.example.pojo;

import java.sql.Date;
import java.util.Objects;

/**
 * @author caiyuping
 * @date 2026/10/17 21:09
 * @description: 订单表
 */
public class Orders {
    /**
     * 订单ID
     */
    private int id;
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 产品ID
     */
    private int productId;

    public Orders() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && userId == orders.userId && productId == orders.productId && quantity == orders.quantity && Double.compare(totalPrice, orders.totalPrice) == 0 && status == orders.status && Objects.equals(createdAt, orders.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productId, quantity, totalPrice, status, createdAt);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 订单数量
     */
    private int quantity;
    /**
     * 订单总价
     */
    private double totalPrice;

    public Orders(int id, int userId, int productId, int quantity, double totalPrice, char status, Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
    }

    /**
     * 订单状态
     */
    private char status;
    /**
     * 订单创建时间
     */
    private Date createdAt;

}
