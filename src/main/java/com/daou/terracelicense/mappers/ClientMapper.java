package com.daou.terracelicense.mappers;

import com.daou.terracelicense.domain.Machine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * ClientMapper-02
     * Get All Client Company
     */
    @Select("SELECT  a.id AS adminCompanyId, a.name AS adminCompanyName, c.id AS clientCompanyId, c.name AS clientCompanyName " +
            "FROM admin a, client c " +
            "WHERE a.id = c.position")
    public List<Machine> getClientCompanyList() throws Exception;
}
