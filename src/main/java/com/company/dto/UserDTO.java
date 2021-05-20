package com.company.dto;

import com.company.entity.User;

public class UserDTO {
    private long id;
    private String name;
    private String surname;
    private String email;

    public UserDTO() {
    }
    public UserDTO(User u){
        this.id=u.getId();
        this.name =u.getName();
        this.surname=u.getSurname();
        this.email=u.getEmail();
    }

    public UserDTO(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
