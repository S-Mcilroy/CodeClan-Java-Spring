package com.example.codeclan.pirateservice.models;

//POJO (Plain Old Java Object)
//All attributes to be saved to the db should be private and have getters and setters.
//Need a default constructor.
//Need Long id.

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pirates")
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;

    @JsonIgnoreProperties("pirates")
    @ManyToOne
    @JoinColumn(name = "ship_id", nullable = false)
    private Ship ship;

    @JsonIgnoreProperties(value = "pirates")
    @ManyToMany
    @JoinTable(name = "pirates_raids", joinColumns = { @JoinColumn(name = "pirate_id", nullable = false, updatable = false)}, inverseJoinColumns = { @JoinColumn(name = "raid_id", nullable = false, updatable = false)})
    private List<Raid> raids;

    public Pirate(String firstName, String lastName, int age, Ship ship){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ship = ship;
        this.raids = new ArrayList<>();
    }

    // Default constructor
    public Pirate(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public List<Raid> getRaids() {
        return raids;
    }

    public void setRaids(List<Raid> raids) {
        this.raids = raids;
    }

    public void addRaid(Raid raid){
        this.raids.add(raid);
    }


}
