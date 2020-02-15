
package com.migrationmodel.controller;

import com.alibaba.fastjson.JSONArray;
import com.migrationmodel.Migration;
import com.migrationmodel.TargetCloud;
import com.migrationmodel.Workload;
import com.migrationmodel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Yu Pan
 */

@RestController
public class MainController {

    @Autowired
    private VolumeRepository volumeRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private WorkloadRepository workloadRepository;

    @Autowired
    private TargetCloudRepository targetCloudRepository;

    @Autowired
    private MigrationRepository migrationRepository;


    @PostMapping(value = "/source")
    public List<Workload> source_add(@RequestParam("source") String str){
        Workload source = (Workload) JSONArray.parseObject(str, Workload.class);
        if(null != source){

                workloadRepository.insertByWorkload(source);
            }
        return workloadRepository.findAll();
    }

    @PutMapping(value = "/source")
    public String source_modify(@RequestParam("source") String str){
        Workload source = (Workload) JSONArray.parseObject(str, Workload.class);
        if(source.getIP()!=null){
            return "When you want to modify source, the IP field should be set to null. " +
                    "Because IP address could not be modified!";
        }
        if(null != source){
            workloadRepository.updateByWorkload(source);
        }
        return "success";
    }

    @DeleteMapping(value = "/source")
    public String source_remove(@RequestParam("source") String str){
        Workload source = (Workload) JSONArray.parseObject(str, Workload.class);
        if(null != source){
            workloadRepository.deleteByWorkload(source);
        }
        return "success";
    }

    @PostMapping(value = "/target")
    public String target_add(@RequestParam("target") String str){
        TargetCloud target = (TargetCloud) JSONArray.parseObject(str, TargetCloud.class);
        if(null != target){

            targetCloudRepository.insertByTargetCloud(target);
        }
        return "success";
    }

    @PutMapping(value = "/target")
    public String target_modify(@RequestParam("target") String str){
            TargetCloud target = (TargetCloud) JSONArray.parseObject(str, TargetCloud.class);
            if(null != target){

                targetCloudRepository.updateByTargetCloud(target);
            }
            return "success";
        }

    @DeleteMapping(value = "/target")
    public String target_remove(@RequestParam("target") String str){
        TargetCloud target = (TargetCloud) JSONArray.parseObject(str, TargetCloud.class);
        if(null != target){
            targetCloudRepository.deleteByTargetCloud(target);
        }
        return "success";
    }

    @PostMapping(value = "/migration")
    public String migration_add(@RequestParam("migration") String str){
        Migration migration = (Migration) JSONArray.parseObject(str, Migration.class);
        if(null != migration){

            migrationRepository.insertByMigration(migration);
        }
        return "success";
    }

    @PutMapping(value = "/migration")
    public String migration_modify(@RequestParam("migration") String str){
        Migration migration = (Migration) JSONArray.parseObject(str, Migration.class);
        if(null != migration){
            migrationRepository.updateByMigration(migration);
        }
        return "success";
    }

    @DeleteMapping(value = "/migration")
    public String migration_remove(@RequestParam("migration") String str){
        Migration migration = (Migration) JSONArray.parseObject(str, Migration.class);
        if(null != migration){
            migrationRepository.updateByMigration(migration);
        }
        return "success";
    }


    @RequestMapping(value = "/run_migration")
    public String run_migration(@RequestParam("migration") String str) throws InterruptedException {
        String migration_state=null;
        Migration migration = (Migration) JSONArray.parseObject(str, Migration.class);
        if(null != migration){

            migration_state=migration.run();
        }
        return migration_state;
    }


}