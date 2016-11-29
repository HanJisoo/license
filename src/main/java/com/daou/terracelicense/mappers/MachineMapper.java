package com.daou.terracelicense.mappers;

import com.daou.terracelicense.domain.Admin;
import com.daou.terracelicense.domain.Machine;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by user on 2016-11-26.
 */
@Mapper
public interface MachineMapper {
    /**
     * MachineMapper-01
     * Get Machine List
     */
    @Select("SELECT * " +
            "FROM machine " +
            "ORDER BY createdate " +
            "LIMIT #{limit} " +
            "OFFSET #{limit}"
            )
    public List<Machine> getMachineList(
            @Param("offset") int offset,
            @Param("limit") int limit) throws Exception;

    /**
     * MachineMapper-02
     * Insert Machine
     */
    @Insert("SELECT *" +
            "FROM Machine "
    )
    public int insertMachine(
            Machine machine) throws Exception;

    /**
     * MachineMapper-03
     * Update Machine
     */
    @Update("SELECT *" +
            "FROM Machine "
    )
    public int updateMachine(
            Machine machine) throws Exception;
}
