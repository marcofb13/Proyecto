package com.example.teachCloud.TeachCloudAPI.modelDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private int id;
    private String name;
    private String email;
    private String pwd;
    private String phoneNumber;
    
}
