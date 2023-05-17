package com.example.teachCloud.TeachCloudAPI.modelDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TownDto {

    private int id;
    private String name;
    private int province_id;
    
}
