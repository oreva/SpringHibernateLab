package com.oreva.simpleweb.mvc.entities;

import com.oreva.simpleweb.mvc.entities.enums.Permission;

import javax.persistence.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;

/**
 * Created by Olga on 5/5/2016.
 */
@javax.persistence.Entity
@Table(name = "ROLES")
public class Role extends Entity {

    public static String ADMIN_ROLE = "admin";
    public static String CAN_VIEW_ALL = "canViewAll";
    public static String CAN_EDIT_ROLE = "canEdit";
    public static String CAN_DELETE_ROLE = "canDelete";

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @ElementCollection(targetClass = Permission.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "role_permissions",
        joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "permissions")
    private List<Permission> permissions;

    public Role() {}

    public Role(String name, List<Permission> permissions) {
        this.setName(name);
        this.setPermissions(permissions);
    }

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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }


    /* Methods to construct predefined roles */

    public static final Map<String, Role> roleByNamesMap = createRolesByNamesMap();

    public static Map<String, Role> createRolesByNamesMap() {
        Map<String, Role> map = new HashMap<>();
        map.put(ADMIN_ROLE, createRoleAdmin());
        map.put(CAN_VIEW_ALL, createRoleCanViewAll());
        map.put(CAN_EDIT_ROLE, createRoleCanEdit());
        map.put(CAN_DELETE_ROLE, createRoleCanDelete());
        return map;
    }

    public static Role createRoleCanViewAll() {
        return new Role(CAN_VIEW_ALL, Arrays.asList(
                Permission.VIEW_ALL_MESSAGES,
                Permission.VIEW_ALL_USERS
        ));
    }

    public static Role createRoleCanEdit() {
        return new Role(CAN_EDIT_ROLE, Arrays.asList(
                Permission.EDIT_MESSAGES,
                Permission.EDIT_USERS,
                Permission.EDIT_TAGS
        ));
    }

    public static Role createRoleCanDelete() {
        // This user will have all "delete" permissions except "delete user",
        // because its administrative permission only
        return new Role(CAN_DELETE_ROLE, Arrays.asList(
                Permission.DELETE_MESSAGES,
                Permission.DELETE_TAGS
        ));
    }

    public static Role createRoleAdmin() {
        return new Role(ADMIN_ROLE, Arrays.asList(
                Permission.values()
        ));
    }
}
