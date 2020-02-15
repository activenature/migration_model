package com.migrationmodel.repository;

import com.migrationmodel.Migration;
import com.migrationmodel.Workload;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

/**
 * @author Yu Pan
 */

public interface MigrationRepository extends CassandraRepository<Migration,Integer> {
    public List<Migration> findByWorkload(Workload workload);

    public List<Migration> insertByMigration(Migration migration);

    public List<Migration> updateByMigration(Migration migration);

    public List<Migration> deleteByMigration(Migration migration);
}
