package com.lishuai.mapper;

import com.lishuai.entity.Specialities;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SpecialitiesMapper {

    String select(int specialitiesId);

}
