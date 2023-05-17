package com.example.teachCloud.TeachCloudAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teachCloud.TeachCloudAPI.model.User;
import com.example.teachCloud.TeachCloudAPI.modelDto.UserDto;
import com.example.teachCloud.TeachCloudAPI.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;


    @PostMapping("/add")
    public UserDto addUser(@RequestBody UserDto userDto){

        User userToSave = new User();
        userToSave.setName(userDto.getName());
        userToSave.setEmail(userDto.getEmail());
        userToSave.setPhoneNumber(userDto.getPhoneNumber());

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        userToSave.setPassword(bcrypt.encode(userDto.getPwd()));

        userServiceImpl.saveUser(userToSave);

        userDto.setId(userToSave.getId());
        return userDto;
    }


    @GetMapping("/login")
    public UserDto loginUser(@RequestParam String email, @RequestParam String pwd){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User loggedUser = userServiceImpl.findUserByEmail(email);

        if(loggedUser==null){
            return null;
        }else if(bcrypt.matches(pwd, loggedUser.getPassword())){
            UserDto userdto = new UserDto();
            userdto.setId(loggedUser.getId());
            userdto.setEmail(loggedUser.getEmail());
            userdto.setPwd(loggedUser.getPassword());
            userdto.setName(loggedUser.getName());
            userdto.setPhoneNumber(loggedUser.getPhoneNumber());

            return userdto;
        }else{
            UserDto userNotAllowed = new UserDto();
            userNotAllowed.setEmail(email);
            userNotAllowed.setPwd(null);
            return userNotAllowed;
        }
    }


    @GetMapping("/allUsers")
    public List<UserDto> getAllUsers(){
        List<UserDto> responseList = new ArrayList<>();
        List<User> users = userServiceImpl.getAllUsers();

        for(User u:users){
            UserDto userDto = new UserDto();
            userDto.setId(u.getId());
            userDto.setEmail(u.getEmail());
            userDto.setName(u.getName());
            userDto.setPhoneNumber(u.getPhoneNumber());
            responseList.add(userDto);
        }
        
        return responseList;
    }

    @GetMapping("byId")
    public UserDto getUserById(@RequestParam int id){
        User u =userServiceImpl.getUserById(id);
        UserDto userDto = new UserDto(u.getId(), u.getName(), u.getEmail(), null, u.getPhoneNumber());
        return userDto;
    }

    @PutMapping("updateUser")
    public String updateUserById(@RequestBody UserDto user, @RequestParam int id){

        User u = userServiceImpl.getUserById(id);
        u.setName(user.getName());
        u.setPhoneNumber(user.getPhoneNumber());

        userServiceImpl.saveUser(u);

        return "Usuario actualizado";

    }
    
}
