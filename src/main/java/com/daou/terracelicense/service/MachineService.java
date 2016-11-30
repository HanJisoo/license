package com.daou.terracelicense.service;

import com.daou.terracelicense.domain.Machine;
import com.daou.terracelicense.domain.MachineList;
import com.daou.terracelicense.mappers.AdminMapper;
import com.daou.terracelicense.mappers.ClientMapper;
import com.daou.terracelicense.mappers.CodeControlMapper;
import com.daou.terracelicense.mappers.MachineMapper;
import com.daou.terracelicense.util.BaseUtil;
import com.daou.terracelicense.util.CodeControlManager;
import com.daou.terracelicense.util.MachineManager;
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
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private CodeControlMapper codeControlMapper;
    @Autowired
    private ClientMapper clientMapper;

    public MachineList getMachineList(String page) throws Exception{
        MachineList machineList = new MachineList();
        List<Machine> list;
        int limit = PageManager.MACHINE_PAGE_LIMIT;
        int offset = PageManager.getOffsetByPage(page, limit);
        int machineCount;

        machineCount = machineMapper.getMachineCount();     // All Machine Count for pagination
        list = machineMapper.getMachineList(offset, limit);

        machineList.setMachineList(list);
        ///// Pagination Info
        machineList.setMaxIndexNo(machineCount);
        machineList.setCurrentIndexPage(Integer.parseInt(page));    // Current Seleced Page
        ///// About Machine Info
        setNameAndValueFromIdAndCode(machineList);
        MachineManager.setMachineNo(machineList);

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

    public void setNameAndValueFromIdAndCode(MachineList machineList) throws Exception{
        for(Machine machine : machineList.getMachineList()){
            String adminId = machine.getAdminCompanyId();
            String clientId = machine.getClientCompanyId();
            String countryCode = machine.getCountryCode();
            String modelCode = machine.getModelCode();
            String stateCode = machine.getStateCode();
            String adminName, clientName, countryVal, modelVal, stateVal;

            if(!BaseUtil.stringNullOrEmpty(adminId) && !"noData".equals(adminId)){
                adminName = adminMapper.getAdminCompanyNameById(adminId);
                machine.setAdminCompanyName(adminName);
            }
            if(!BaseUtil.stringNullOrEmpty(clientId) && !"noData".equals(clientId)){
                clientName = clientMapper.getClientCompanyNameById(clientId);
                machine.setClientCompanyName(clientName);
            }
            if(!BaseUtil.stringNullOrEmpty(countryCode)){
                countryVal = codeControlMapper.getValueByCode(CodeControlManager.CODE_CATEGORY_COUNTRY, countryCode);
                machine.setCountryValue(countryVal);
            }
            if(!BaseUtil.stringNullOrEmpty(modelCode)){
                modelVal = codeControlMapper.getValueByCode(CodeControlManager.CODE_CATEGORY_MODEL, modelCode);
                machine.setModelValue(modelVal);
            }
            if(!BaseUtil.stringNullOrEmpty(stateCode)){
                stateVal = codeControlMapper.getValueByCode(CodeControlManager.CODE_CATEGORY_MACHINESTATE, stateCode);
                machine.setModelValue(stateVal);
            }
        }
    }
/*
    public int deleteMachine(String id) throws Exception{

    }*/
}
