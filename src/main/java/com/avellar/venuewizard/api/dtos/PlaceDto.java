package com.avellar.venuewizard.api.dtos;

public class PlaceDto {
    private String slug;
    private String city;
    private String state;

    public PlaceDto(){
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString(){
        return "PlaceDto [slug" + slug + ", city=" + city + ", state=" + state + "]";

    }




















}
