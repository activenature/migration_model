package com.migrationmodel;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * @author Yu Pan
 */

@Entity
@Table(name = "migration")
public class Migration {

    @Id
    @GeneratedValue
    Long id;
    ArrayList<Volume> selected_mount_points;
    Workload source;
    TargetCloud targetCloud;
    String migration_state;

    public Migration(ArrayList<Volume> selected_mount_points, Workload source, TargetCloud targetCloud) {
        this.selected_mount_points = selected_mount_points;
        this.source = source;
        this.targetCloud = targetCloud;
        this.migration_state="not started";
    }

    public String run() throws InterruptedException {
        migration_state="running";
        ArrayList<Volume> st=null;
        for(Volume v:selected_mount_points) {
            st.add(v);
        }
        int flag=0;
        for(Volume vo:st){
            if(vo.mount_point == "c:\\"){
                flag++;
            }
        }
        if(flag>0){
            targetCloud.target_vm=new Workload(source.getIP(),source.credentials,st);
            Thread.sleep(3000000);
            migration_state="success";
            return migration_state;
        }else{
            migration_state="error";
            return migration_state;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Volume> getSelected_mount_points() {
        return selected_mount_points;
    }

    public void setSelected_mount_points(ArrayList<Volume> selected_mount_points) {
        this.selected_mount_points = selected_mount_points;
    }

    public Workload getSource() {
        return source;
    }

    public void setSource(Workload source) {
        this.source = source;
    }

    public TargetCloud getTargetCloud() {
        return targetCloud;
    }

    public void setTargetCloud(TargetCloud targetCloud) {
        this.targetCloud = targetCloud;
    }

    public String getMigration_state() {
        return migration_state;
    }

    public void setMigration_state(String migration_state) {
        this.migration_state = migration_state;
    }
}
