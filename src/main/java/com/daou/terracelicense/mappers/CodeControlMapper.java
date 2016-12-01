package com.daou.terracelicense.mappers;

import com.daou.terracelicense.domain.Admin;
import com.daou.terracelicense.domain.CodeControl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by user on 2016-11-30.
 */
@Mapper
public interface CodeControlMapper {
    /**
     * CodeControlMaper-01
     * Get Value By Code
     */
    @Select("SELECT value " +
            "FROM codecontrol " +
            "WHERE category = #{category} " +
            "   AND code = #{code}")
    public String getValueByCode(@Param("category")String category, @Param("code")String code) throws Exception;

    /**
     * CodeControlMaper-02
     * Get All Data By Category
     */
    @Select("SELECT code, value, category " +
            "FROM codecontrol " +
            "WHERE category = #{category}" +
            "ORDER BY code")
    public List<CodeControl> getAllByCategory(@Param("category")String category) throws Exception;

    /**
     * CodeControlMaper-03
     * Get All CodeControl
     */
    @Select("SELECT code, value, category " +
            "FROM codecontrol ")
    public List<CodeControl> getAllCodeControl() throws Exception;
}
