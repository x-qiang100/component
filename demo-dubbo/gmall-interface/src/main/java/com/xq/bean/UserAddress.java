package com.xq.bean;

import java.io.Serializable;

public class UserAddress implements Serializable {
    Integer id;
    String userId;
    String address;

    public UserAddress() {
        super();
        // TODO Auto-generated constructor stub
    }



    public UserAddress(Integer id, String userId, String address) {
        this.id = id;
        this.userId = userId;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
