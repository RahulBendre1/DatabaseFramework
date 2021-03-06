package com.iamtek.hibernate.valueobject.dto;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails3 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @ElementCollection
    private Set<Address> listOfAddress = new HashSet<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName + " from getter";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Set<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

}
