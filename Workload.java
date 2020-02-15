package com.migrationmodel;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * @author Yu Pan
 */

@Entity
@Table(name = "workload")
public class Workload {

    @Id
    @GeneratedValue
    Long id;
    @NonNull
    final String IP;
    @NonNull
    Credentials credentials;
    ArrayList<Volume> storage;

    public Workload(@NonNull String IP, @NonNull Credentials credentials, ArrayList<Volume> storage) {
        this.IP = IP;
        this.credentials = credentials;
        this.storage = storage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getIP() {
        return IP;
    }

    @NonNull
    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(@NonNull Credentials credentials) {
        this.credentials = credentials;
    }

    public ArrayList<Volume> getStorage() {
        return storage;
    }

    public void setStorage(ArrayList<Volume> storage) {
        this.storage = storage;
    }
}
