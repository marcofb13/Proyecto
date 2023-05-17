package com.example.teachCloud.TeachCloudAPI.modelDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToShow {

    private String name;
    private String description;
    private String province;
    private String town;
    private String subject;
    private String phone;

    public AddToShow() {
    }

    public AddToShow(String name, String description, String province, String town, String subject, String phone) {
        this.name = name;
        this.description = description;
        this.province = province;
        this.town = town;
        this.subject = subject;
        this.phone = phone;
    }
    
}
