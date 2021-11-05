package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message = "username blank")
    @Size(min = 5, max = 15, message = "username size wrong")
    private String username;

    @Email(message = "email")
    private String email;

    @NotBlank(message = "pword blank")
    @NotNull
    @Size(min = 6, message = "pword must be 6")
    private String password;

    @NotBlank
    @NotNull(message = "Passwords do not match")
    private String verify;

    private void checkPassword() {
        if(this.password != this.verify) {
            verify = null;
        }
    }

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
        checkPassword();
    }
}
