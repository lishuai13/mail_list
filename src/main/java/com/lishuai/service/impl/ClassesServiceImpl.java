package com.lishuai.service.impl;

import com.lishuai.mapper.ClassesMapper;
import com.lishuai.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public String select(int classesId) {
        return classesMapper.select(classesId);
    }
}
