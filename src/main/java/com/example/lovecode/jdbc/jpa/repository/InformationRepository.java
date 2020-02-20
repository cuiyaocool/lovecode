package com.example.lovecode.jdbc.jpa.repository;

import com.example.lovecode.jdbc.jpa.entity.InformationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author cuiyaocy
 */
@Repository
public interface InformationRepository extends CrudRepository<InformationEntity, Integer> {
    /**
     * @param userId
     * @return
     */
    InformationEntity getByUserId(Integer userId);
}
