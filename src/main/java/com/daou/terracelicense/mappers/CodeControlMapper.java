package com.daou.terracelicense.mappers;

import com.daou.terracelicense.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by user on 2016-11-30.
 */
@Mapper
public interface CodeControlMapper {
    /**
     * CodeControlMaper-01
     *
     */
    @Select("SELECT value " +
            "FROM codecontrol " +
            "WHERE category = #{category} " +
            "   AND code = #{code}")
    public String getValueByCode(@Param("category")String category, @Param("code")String code) throws Exception;
}
