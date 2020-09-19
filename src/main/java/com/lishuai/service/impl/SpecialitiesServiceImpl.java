package com.lishuai.service.impl;

import com.lishuai.mapper.SpecialitiesMapper;
import com.lishuai.service.SpecialitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialitiesServiceImpl implements SpecialitiesService {

   @Autowired
   private SpecialitiesMapper specialitiesMapper;

    @Override
    public String select(int specialitiesId) {
        return specialitiesMapper.select(specialitiesId);
    }
}
