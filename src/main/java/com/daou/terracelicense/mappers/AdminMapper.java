package com.daou.terracelicense.mappers;

import com.daou.terracelicense.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by user on 2016-11-24.
 */
@Mapper
public interface AdminMapper {
    /**
     * Get Admin info by ID
     *
     * @param id
     * @return
     */
    @Select("SELECT id, name, country, password " +
            "FROM Admin " +
            "WHERE id = #{id}")
    public Admin getAdminById(@Param("id")String id) throws Exception;
}
