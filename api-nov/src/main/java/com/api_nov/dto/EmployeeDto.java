package com.api_nov.dto;

import jakarta.persistence.*;
//POJO clasess

public class EmployeeDto {
    private Long id;
    private String name;
    private String emailId;
    private String mobile;

    public String getMobile() {

        return mobile;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public String getEmailId()
    {

        return emailId;
    }

    public void setEmailId(String emailId) {

        this.emailId = emailId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    //TODO [Reverse Engineering] generate columns from DB
}