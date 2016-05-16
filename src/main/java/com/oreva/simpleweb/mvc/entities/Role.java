package com.oreva.simpleweb.mvc.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Olga on 5/5/2016.
 */
@javax.persistence.Entity
@Table(name = "ROLES")
public class Role extends Entity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }
}
