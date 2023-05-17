package com.example.teachCloud.TeachCloudAPI.modelDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddDto {
    

    private int id;
    private String description;
    private int province_id;
    private int  town_id;
    private int subject_id;
    private int user_id;
    
}
