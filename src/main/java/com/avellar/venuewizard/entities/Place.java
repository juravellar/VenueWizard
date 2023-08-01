package com.avellar.venuewizard.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "place")
public class Place implements Serializable {
    @Serial
    private static final long serialVersionUID = -5847685370122207455L;
    private Long id;
    private String name;
    private String slug;
    private String city;
    private String state;
    private Date createdAt;
    private Date updatedAt;

    public Place(){

    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
