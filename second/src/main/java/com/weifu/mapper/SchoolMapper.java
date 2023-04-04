package com.weifu.mapper;

import com.weifu.entity.School;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolMapper {

    List<School> selectStudent();

}
