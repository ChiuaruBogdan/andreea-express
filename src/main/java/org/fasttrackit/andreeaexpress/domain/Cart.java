package org.fasttrackit.andreeaexpress.domain;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    private long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
