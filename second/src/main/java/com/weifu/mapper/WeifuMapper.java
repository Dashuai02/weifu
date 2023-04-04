package com.weifu.mapper;

import com.weifu.spring.entity.Wef;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WeifuMapper {


    /**
     * 查询所有
     *
     * @return
     */
    List<Wef> checkTheBase();

    List<Wef> selectLastMonth();
}
