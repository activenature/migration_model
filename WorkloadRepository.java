package com.migrationmodel.repository;

import com.migrationmodel.Workload;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

/**
 * @author Yu Pan
 */

public interface WorkloadRepository extends CassandraRepository<Workload,Integer> {


    public List<Workload> findByIP(String IP);

    public List<Workload> insertByWorkload(Workload workload);

    public List<Workload> updateByWorkload(Workload workload);

    public List<Workload> deleteByWorkload(Workload workload);
}