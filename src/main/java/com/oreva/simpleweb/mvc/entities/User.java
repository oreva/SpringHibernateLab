package com.oreva.simpleweb.mvc.entities;

import com.oreva.simpleweb.mvc.entities.enums.Permission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/29/16
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Entity
@Table(name = "USERS")
/* @NamedEntityGraph doesn't work for now. We use @Query for the method of UserRepository instead of @EntityGraph
@NamedEntityGraph(name = "userWithMessagesEntityGraph",
    attributeNodes = {@NamedAttributeNode("messages")})*/
public class User extends Entity implements UserDetails {

    public static String ADMIN_USERNAME = "admin@admin.com"; //username is admin's Email
    public static final User admin = createAdminUser();

    private static User createAdminUser() {
        User user = new User();
        user.setFirstName("admin");
        user.setPassword("admin");
        user.setMail(ADMIN_USERNAME);
        return user;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
    private List<Message> messages = new ArrayList<Message>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<Role>();

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Role> getRoles() { return roles; }

    /**
     * UserDetails implementation
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> permissions = new ArrayList<>();
        for (Role role: getRoles()) {
            for (Permission permission: role.getPermissions()) {
                permissions.add(new PermissionAsGrantedAuthority(permission));
            }
        }
        return permissions;
    }

    class PermissionAsGrantedAuthority implements GrantedAuthority {
        private Permission permission;

        @Override
        public String getAuthority() {
            return permission.name();
        }

        public PermissionAsGrantedAuthority(Permission permission) {
            this.permission = permission;
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    /**
     * end of UserDetails implementation
     */

    /*public void addMessage(Message m) {
        messages.add(m);
        m.setUser(this);
    }

    public void removeMessage(Message m) {
        messages.remove(m);
        m.setUser(null);
    } */

}
