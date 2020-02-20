package com.example.lovecode.service;

import com.example.lovecode.annotation.SetFieldValue;
import com.example.lovecode.jdbc.jpa.InformationDTO;
import com.example.lovecode.jdbc.jpa.InformationDao;
import com.example.lovecode.jdbc.jpa.entity.InformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuiyaocy
 */
@Service
public class InformationService {

    @Autowired
    private InformationDao informationDao;

    public InformationEntity getByUserId(Integer userId) {
        return informationDao.getByUserId(userId);
    }


    @SetFieldValue
    public List<InformationDTO> findAll() {
        Iterable<InformationEntity> list = informationDao.findAll();
        List<InformationDTO> list1 = new ArrayList<>();
        for (InformationEntity i : list) {
            list1.add(new InformationDTO(i));
        }
        return list1;
    }
}
