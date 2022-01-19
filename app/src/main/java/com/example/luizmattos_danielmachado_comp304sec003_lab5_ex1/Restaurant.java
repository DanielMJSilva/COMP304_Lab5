package com.example.luizmattos_danielmachado_comp304sec003_lab5_ex1;

public class Restaurant {

    private String id;
    private String type;
    private String name;
    private String address;
    private String lat;
    private String lon;

    public Restaurant(String id, String type, String name, String address, String lat, String lon) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lon = lon;

    }

    public String getId () {
        return id;
    }

    public void setId (String id){
        this.id = id;
    }

    public String getType () {
        return type;
    }

    public void setIType (String type){
        this.type = type;
    }

    public String getName () {
        return name;
    }

    public void setName (String name){
        this.name = name;
    }
    public String getAddress () {
        return address;
    }

    public void setAddress (String address){
        this.address = address;
    }
    public String getLat () {
        return lat;
    }

    public void setLat (String lat){
        this.lat = lat;
    }
    public String getLon () {
        return lon;
    }

    public void setLon (String lon){
        this.lon = lon;
    }
}


