package com.example.lovecode.jdbc.jpa;

import com.example.lovecode.jdbc.jpa.entity.InformationEntity;
import com.example.lovecode.jdbc.jpa.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author cuiyaocy
 */
@Repository
public class InformationDao {
    @Autowired
    private InformationRepository repository;

    public InformationEntity getByUserId(Integer userId) {
        return repository.getByUserId(userId);
    }

    public Iterable<InformationEntity> findAll() {
        return repository.findAll();
    }
}
