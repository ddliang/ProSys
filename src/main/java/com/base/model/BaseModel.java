package com.base.model;

import java.io.Serializable;

/**
 * Created by DaiLiang on 2018/1/11.
 */
public class BaseModel implements Serializable{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
