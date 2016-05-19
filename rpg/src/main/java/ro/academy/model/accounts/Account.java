package ro.academy.model.accounts;

import ro.academy.model.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Gustavo on 14/05/2016.
 */
@Entity
public class Account extends BaseEntity{
    @NotNull
    @Size(min = 5, max = 20, message = "username must be between 5 and 20 characters")
    private String username;

    @NotNull
    @Size(min = 5, max = 20, message = "password must be between 5 and 20 characters")
    private String password;

    @NotNull
    @Size(min = 5, max = 20, message = "email must be between 5 and 20 characters")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@\"\n" +
            "+\"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "email must contain an @ sign")
    private String email;

    @NotNull
    @Size(min = 5, max = 20, message = "name must be between 5 and 20 characters")
    private String name;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
