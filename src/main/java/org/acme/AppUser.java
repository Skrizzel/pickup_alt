package org.acme;

import jakarta.annotation.Nullable;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class AppUser extends PanacheEntity {
    private String userName;
    private String password;
    private byte[] salt;
    private String email;
    @Nullable
    private byte[] image;


    public AppUser(String userName, String password, String email, byte[] image) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.image = image;
    }

    public AppUser() {

    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Nullable
    public byte[] getImage() {
        return image;
    }

    public void setImage(@Nullable byte[] image) {
        this.image = image;
    }
}
