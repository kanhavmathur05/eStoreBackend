package com.estore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder implements Serializable
{
	@Id
    @GeneratedValue
    private int customerOrderID;

    @OneToOne
    @JoinColumn(name="cartID")
    private Cart cart;

    @OneToOne
    @JoinColumn(name="customerID")
    private Customer customer;

    @OneToOne
    @JoinColumn(name="billingAddressID")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name="shippingAddressID")
    private ShippingAddress shippingAddress;

    public int getCustomerOrderID() {
        return customerOrderID;
    }

    public void setCustomerOrderID(int customerOrderID) {
        this.customerOrderID=customerOrderID;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart=cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer=customer;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress=billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress=shippingAddress;
    }
}
