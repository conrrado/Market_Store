package com.ccamacho.marketstore.model;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private String shortDescription;
    private String longDescription;
    private boolean isChecked;

    public Product(String name, String shortDescription, String longDescription) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.isChecked = false;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
