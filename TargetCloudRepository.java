package com.migrationmodel.repository;


import com.migrationmodel.TargetCloud;
import com.migrationmodel.Workload;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

/**
 * @author Yu Pan
 */

public interface TargetCloudRepository extends CassandraRepository<TargetCloud,Integer> {
    public List<TargetCloud> findByWorkload(Workload workload);

    public List<TargetCloud> insertByTargetCloud(TargetCloud targetCloud);

    public List<TargetCloud> updateByTargetCloud(TargetCloud targetCloud);

    public List<TargetCloud> deleteByTargetCloud(TargetCloud targetCloud);
}