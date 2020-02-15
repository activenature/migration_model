package com.migrationmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Yu Pan
 */

@Entity
@Table(name = "target_cloud")
public class TargetCloud {

    @Id
    @GeneratedValue
    Long id;
    final String[] cloud_type={"aws","azure","vsphere","vcloud"};
    Credentials cloud_credentials;
    Workload target_vm;

    public TargetCloud(Credentials cloud_credentials, Workload target_vm) {
        this.cloud_credentials = cloud_credentials;
        this.target_vm = target_vm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getCloud_type() {
        return cloud_type;
    }

    public Credentials getCloud_credentials() {
        return cloud_credentials;
    }

    public void setCloud_credentials(Credentials cloud_credentials) {
        this.cloud_credentials = cloud_credentials;
    }

    public Workload getTarget_vm() {
        return target_vm;
    }

    public void setTarget_vm(Workload target_vm) {
        this.target_vm = target_vm;
    }
}
