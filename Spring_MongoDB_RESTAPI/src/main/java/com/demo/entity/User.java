package com.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
// annotation of MongoDB and it shows that it is a collection (ex. User Collection)
@Document
public class User
{
    //@Id is primary key definition as Spring Data
    @Id
    private String ID;
    private String name;
    private String surname;
    private HashMap properties;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setProperties(HashMap properties) {
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public HashMap getProperties() {
        return properties;
    }
}
