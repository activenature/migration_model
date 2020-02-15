package com.migrationmodel;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

/**
 * @author Yu Pan
 */
@Entity
@Table(name = "credentials")
public class Credentials {

    @Id
    @GeneratedValue
    Long id;
    @NonNull
    String username;
    @NonNull
    String password;
    @NonNull
    String domain;

    public Credentials(@NonNull String username, @NonNull String password, @NonNull String domain) {
        this.username = username;
        this.password = password;
        this.domain = domain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getDomain() {
        return domain;
    }

    public void setDomain(@NonNull String domain) {
        this.domain = domain;
    }
}

