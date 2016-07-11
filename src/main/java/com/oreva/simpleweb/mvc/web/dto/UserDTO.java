package com.oreva.simpleweb.mvc.web.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/29/16
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDTO extends DTO {
    @Digits(integer = 5, fraction = 0)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100,
            message = "First name must be between 1 and 100 character long.")
    @Pattern(regexp = "([a-zA-Z])+", message = "First name must contain only letters.")
    private String firstName;

    @Size(min = 1, max = 100,
            message = "Last name must be between 1 and 100 character long.")
    @Pattern(regexp = "([a-zA-Z])+", message = "Last name must contain only letters.")
    private String lastName;

    @NotNull
    @Size(min = 2, max = 10,
            message = "User phone must be between 2 and 10 characters long.")
    @Pattern(regexp = "[0-9]+",
            message = "User phone must contain only digit characters.")
    private String phone;

    @NotNull
    @Size(min = 5, max = 50,
            message = "User email must be between 5 and 50 character long.")
    @Pattern(regexp = "(\\w)+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+",
            message = "Invalid email format.")
    private String mail;

    @NotNull
    @Size(min = 5, max = 20,
            message = "Password must be 5 to 20 characters long")
    private String password;

    @NotNull
    @Size(min = 5, max = 20,
            message = "Enter you password again")
    private String confirmPassword;

    public List<String> roles;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
