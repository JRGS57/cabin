package com.usa.project.model.custom;

import com.usa.project.model.Cabin;

public class CountCabin {
    private Long total;
    private Cabin cabin;

    public CountCabin(Long total, Cabin cabin) {
        this.total = total;
        this.cabin = cabin;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cabin getCar() {
        return cabin;
    }

    public void setCar(Cabin cabin) {
        this.cabin = cabin;
    }
}
