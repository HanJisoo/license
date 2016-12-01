package com.daou.terracelicense.mappers;

import com.daou.terracelicense.domain.Admin;
import com.daou.terracelicense.domain.Machine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by user on 2016-11-24.
 */
@Mapper
public interface AdminMapper {
    /**
     * AdminMaper-01
     *
     */
    @Select("SELECT id, name, country, password " +
            "FROM Admin " +
            "WHERE id = #{id}")
    public Admin getAdminById(@Param("id")String id) throws Exception;

    /**
     * AdminMapper-02
     * Get All Admin Company Info
     */
    @Select("SELECT id AS adminCompanyId, name AS adminCompanyName " +
            "FROM admin")
    public List<Machine> getAdminCompanyList() throws Exception;

    /**
     * AdminMapper-03
     * Get Admin Company Name By Id
     */
    @Select("SELECT name " +
            "FROM admin " +
            "WHERE id = #{id}")
    public String getAdminCompanyNameById(@Param("id")String id) throws Exception;
}
