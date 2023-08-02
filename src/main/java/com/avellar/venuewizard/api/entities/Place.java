package com.avellar.venuewizard.api.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

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

    public Place(Long id, String name, String slug, String city, String state, Date createdAt, Date updatedAt){
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.city = city;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Place(){
    }

    public boolean isNovo() {
        return id == null;
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

    @GeneratedValue(strategy=GenerationType.AUTO)
    public String getSlug() {
        String slug = Slug.getSlug(name);
        return slug;
    }

    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "state", nullable = false)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "created_at", nullable = false)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at", nullable = false)
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        createdAt = atual;
        updatedAt = atual;
    }

    @Override
    public String toString() {
        return "Place [id=" + id + ", slug=" + slug + ", city=" + city + ", state=" + state + ", created at=" + createdAt
                + ", updated at=" + updatedAt + "]";
    }
}
