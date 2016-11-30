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

    String GET_MACHINE_LIST_QUERY = "SELECT m.serialkey, m.serialnumber, m.hostid, m.country AS countryCode, coalesce(m.admincompany,'noData') AS adminCompanyId, coalesce(m.clientcompany,'noData') AS clientCompanyId, m.model, m.password, s.state AS stateCode, s.grade , l.licenseenddate, s.inputdate , m.appliancetype, m.createdate " +
                                    "FROM machine m " +
                                    "LEFT JOIN machinestate s ON m.serialkey = s.serialkey " +
                                    "LEFT JOIN " +
                                    "(SELECT temp.no, temp.serialkey, temp.licenseenddate, temp.licensetype " +
                                    "FROM (SELECT max(no) AS no FROM license GROUP BY serialkey) max " +
                                    "LEFT JOIN license temp ON temp.no = max.no) l " +
                                    "ON m.serialkey = l.serialkey " +
                                    "WHERE 1=1 and (m.createDate > s.inputDate or m.createDate < s.inputDate) " +
                                    "ORDER BY m.createdate DESC " +
                                    "LIMIT #{limit} " +
                                    "OFFSET #{offset}";

    /**
     * MachineMapper-01
     * Get Machine List
     */
    @Select(GET_MACHINE_LIST_QUERY)
    public List<Machine> getMachineList(
            @Param("offset") int offset,
            @Param("limit") int limit) throws Exception;

    /**
     * MachineMapper-02
     * Insert Machine
     */
    @Insert("SELECT * " +
            "FROM Machine "
    )
    public int insertMachine(
            Machine machine) throws Exception;

    /**
     * MachineMapper-03
     * Update Machine
     */
    @Update("SELECT * " +
            "FROM Machine "
    )
    public int updateMachine(
            Machine machine) throws Exception;

    /**
     * MachineMapper-04
     * Get All Machine Count
     */
    @Select("SELECT count(1) " +
            "FROM machine")
    public int getMachineCount() throws Exception;


}
