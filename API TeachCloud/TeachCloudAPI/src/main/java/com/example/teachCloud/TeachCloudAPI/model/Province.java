package com.example.teachCloud.TeachCloudAPI.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="provinces")
public class Province implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "name")
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "province", cascade = CascadeType.REMOVE)
    private List<Town> townsList;


    public Province(){

    }


    public Province(int id, String name){

        this.id=id;
        this.name=name;
    }
    
}
