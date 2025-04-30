package com.bcts.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Teams")
public class Team {
    @Id
    private String id; 
    private String name;
    private String location;
    private String arena;
    private int num_championships;
    private int capacity;

    public Team() {}

    public Team(String name, String location, String arena, int num_championships, int capacity) {
        this.name = name;
        this.location = location;
        this.arena = arena;
        this.num_championships = num_championships;
        this.capacity = capacity;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public int getNum_championships() {
        return num_championships;
    }

    public void setNum_championships(int num_championships) {
        this.num_championships = num_championships;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}