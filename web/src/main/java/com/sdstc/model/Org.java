package com.sdstc.model;

import lombok.Data;

@Data
public class Org {
    private String id;
    private String name;

    public Org(String id,String name){
        this.id=id;
        this.name=name;
    }
}
