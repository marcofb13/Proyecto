package com.example.teachCloud.TeachCloudAPI.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="adds")
public class Add implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="description")
    private String description;
    @OneToOne
    @JoinColumn(name="province_id")
    private Province province;
    @OneToOne
    @JoinColumn(name="town_id")
    private Town town;
    @OneToOne
    @JoinColumn(name="subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
}
