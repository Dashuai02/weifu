package com.weifu.biz;

import com.weifu.mapper.WeifuMapper;
import com.weifu.spring.entity.Wef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeifuBiz {

    @Autowired
    private WeifuMapper weifuMapper;

    public List<Wef> select() {
        return weifuMapper.checkTheBase();
    }

//    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<Wef> pushCenter() {
        List<Wef> lastMonth = weifuMapper.selectLastMonth();
        int listSize = lastMonth.size();
        int toIndex = 300;
        //用map存起来新的分组后数据
        Map map = new HashMap();
        int keyToken = 0;
        for (int i = 0; i < lastMonth.size(); i += 300) {
            //作用为toIndex最后没有100条数据则剩余几条newList中就装几条
            if (i + 300 > listSize) {
                toIndex = listSize - i;
            }
            List newList = lastMonth.subList(i, i + toIndex);
            System.out.println(newList.size());
            map.put("keyName" + keyToken, newList);
            keyToken++;
        }
        return lastMonth;
    }
}
