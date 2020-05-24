package com.ccamacho.marketstore.model;

import java.io.Serializable;
import java.util.List;

public class Purchase implements Serializable {

    private List<String> nameList;

    public Purchase(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> getNameList() {
        return nameList;
    }
}
