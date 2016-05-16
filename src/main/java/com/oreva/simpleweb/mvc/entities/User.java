package com.oreva.simpleweb.mvc.entities;

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
public class User extends Entity implements UserDetails {
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Role> roles = new ArrayList<Role>();

    /*
    TODO: remove this constructor. Added here only for test user roles
     */
    /*@Inject
    private RoleRepository roleRepository;

    public User() {
        Role adminRole;
        if (0 == roles.size()) {
            adminRole = roleRepository.findByName("ROLE_ADMIN");
            if (null == adminRole) {
                adminRole = new Role();
                adminRole.setName("ROLE_ADMIN");
                roleRepository.save(adminRole);
            }
            getRoles().add(adminRole);
        }
    }*/

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
        return null;
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
