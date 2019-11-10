package com.asal.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "created_on")
    private ZonedDateTime createdOn;

    public Manufacturer() {
    }

    public Manufacturer(String name, ZonedDateTime createdOn) {
        this.name = name;
        this.createdOn = createdOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(ZonedDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
