package com.migrationmodel.repository;

import com.migrationmodel.Volume;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

/**
 * @author Yu Pan
 */

public interface VolumeRepository extends CassandraRepository<Volume,Integer> {
    public List<Volume> findByMount_point(String mount_point);

    public List<Volume> insertByMount_point(String mount_point);

    public List<Volume> updateByMount_point(String mount_point);

    public List<Volume> deleteByMount_point(String mount_point);
}