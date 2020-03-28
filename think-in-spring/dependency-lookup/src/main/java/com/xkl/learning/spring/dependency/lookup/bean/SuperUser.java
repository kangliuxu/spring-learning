package com.xkl.learning.spring.dependency.lookup.bean;

import com.xkl.learning.spring.dependency.lookup.annotation.Super;

/**
 * @author xkl
 * @date 2020/3/28
 * @description
 **/
@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
