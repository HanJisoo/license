package com.daou.terracelicense.service;

import com.daou.terracelicense.domain.Machine;
import com.daou.terracelicense.mappers.MachineMapper;
import com.daou.terracelicense.util.PageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2016-11-26.
 */
@Service
public class MachineService {
    @Autowired
    private MachineMapper machineMapper;

    public List<Machine> getMachineList(String page) throws Exception{
        List<Machine> machineList;
        int limit = PageManager.MACHINE_PAGE_LIMIT;
        int offset = PageManager.getOffsetByPage(page, limit);
        machineList = machineMapper.getMachineList(offset, limit);
        return machineList;
    }

    public int addMachine(Machine machine) throws Exception{
        int result = 0;
        result = machineMapper.insertMachine(machine);
        return result;
    }

    public int updateMachine(Machine machine) throws Exception{
        int result = 0;
        result = machineMapper.updateMachine(machine);
        return result;
    }
/*
    public int deleteMachine(String id) throws Exception{

    }*/
}
