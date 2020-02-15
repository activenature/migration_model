package com.migrationmodel.repository;


import com.migrationmodel.Credentials;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.List;

/**
 * @author Yu Pan
 */

public interface CredentialsRepository extends CassandraRepository<Credentials,Integer> {
    public List<Credentials> findByUsernameAndPassword(String username, String password);

    public List<Credentials> insertByUsernameAndPassword(String username, String password);

    public List<Credentials> updateByUsernameAndPassword(String username, String password);

    public List<Credentials> deleteByByUsernameAndPassword(String username, String password);
}


