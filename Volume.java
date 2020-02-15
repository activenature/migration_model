package com.migrationmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Yu Pan
 */

@Entity
@Table(name = "volume")
public class Volume {
    @Id
    @GeneratedValue
    Long id;
    String mount_point;
    int    size;

    public Volume(String mount_point, int size) {
        this.mount_point = mount_point;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMount_point() {
        return mount_point;
    }

    public void setMount_point(String mount_point) {
        this.mount_point = mount_point;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

