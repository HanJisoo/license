package com.daou.terracelicense.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by user on 2016-11-30.
 */
@Mapper
public interface ClientMapper {
    /**
     * ClientMapper-01
     * Get Client Company Name By Id
     */
    @Select("SELECT name " +
            "FROM client " +
            "WHERE id = #{id}")
    public String getClientCompanyNameById(@Param("id")String id) throws Exception;
}
