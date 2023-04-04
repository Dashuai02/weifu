package com.weifu.biz;

import com.weifu.entity.School;
import com.weifu.mapper.SchoolMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SchoolBiz {

    @Resource
    private SchoolMapper schoolMapper;

    public List<School> select() {

        List<School> student = schoolMapper.selectStudent();

        return student;
    }
}
