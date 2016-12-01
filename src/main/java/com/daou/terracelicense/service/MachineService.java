package com.daou.terracelicense.service;

import com.daou.terracelicense.domain.CodeControl;
import com.daou.terracelicense.domain.CodeControlList;
import com.daou.terracelicense.domain.Machine;
import com.daou.terracelicense.domain.MachineList;
import com.daou.terracelicense.mappers.AdminMapper;
import com.daou.terracelicense.mappers.ClientMapper;
import com.daou.terracelicense.mappers.CodeControlMapper;
import com.daou.terracelicense.mappers.MachineMapper;
import com.daou.terracelicense.util.BaseUtil;
import com.daou.terracelicense.util.CodeControlConst;
import com.daou.terracelicense.util.MachineManager;
import com.daou.terracelicense.util.PageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public MachineList getMachineList(String page, String sortType) throws Exception{
        MachineList machineList = new MachineList();
        MachineManager manager = MachineManager.getInstance();
        List<Machine> machines;
        List<CodeControl> codeControls;

        int limit = PageManager.MACHINE_PAGE_LIMIT;
        int offset = PageManager.getOffsetByPage(page, limit);
        int machineCount;

        machineCount = machineMapper.getMachineCount();     // All Machine Count for pagination
        machines = machineMapper.getMachineList(offset, limit, sortType);
        codeControls = codeControlMapper.getAllCodeControl();

        machineList.setMachineList(machines);
        ///// Pagination Info
        machineList.setMaxIndexNo(machineCount);
        machineList.setCurrentIndexPage(Integer.parseInt(page));    // Current Seleced Page
        ///// About Machine Info
        setNameAndValueFromIdAndCode(machineList, codeControls);
        manager.setMachineNo(machineList);

        return machineList;
    }

    public CodeControlList getCodeControlList() throws Exception{
        CodeControlList codeControlList = new CodeControlList();
        List<CodeControl> modelAll, countryAll, stateAll, prefixAll, producerAll, deviceAll, programAll, virusAll;
        List<Machine> serialNumberAll, clientCompanyAll, adminCompanyAll;

        countryAll = codeControlMapper.getAllByCategory(CodeControlConst.CODE_CATEGORY_COUNTRY);
        stateAll = codeControlMapper.getAllByCategory(CodeControlConst.CODE_CATEGORY_MACHINESTATE);
        modelAll = codeControlMapper.getAllByCategory(CodeControlConst.CODE_CATEGORY_MODEL);
        prefixAll = codeControlMapper.getAllByCategory(CodeControlConst.CODE_CATEGORY_PREFIX);
        producerAll = codeControlMapper.getAllByCategory(CodeControlConst.CODE_CATEGORY_PRODUCER);
        deviceAll = codeControlMapper.getAllByCategory(CodeControlConst.CODE_CATEGORY_THIRDDEVICE);
        programAll = codeControlMapper.getAllByCategory(CodeControlConst.CODE_CATEGORY_THIRDPROGRAM);
        virusAll = codeControlMapper.getAllByCategory(CodeControlConst.CODE_CATEGORY_VIRUS);
        serialNumberAll = getSerialInfo(modelAll);
        clientCompanyAll = clientMapper.getClientCompanyList();
        adminCompanyAll = adminMapper.getAdminCompanyList();

        codeControlList.setCountryAll(countryAll);
        codeControlList.setModelAll(modelAll);
        codeControlList.setThirdDeviceAll(deviceAll);
        codeControlList.setProducerAll(producerAll);
        codeControlList.setThirdProgramAll(programAll);
        codeControlList.setVirusAll(virusAll);
        codeControlList.setPrefixAll(prefixAll);
        codeControlList.setStateAll(stateAll);
        codeControlList.setSerialNumberAll(serialNumberAll);
        codeControlList.setClientCompanyAll(clientCompanyAll);
        codeControlList.setAdminCompanyAll(adminCompanyAll);

        return codeControlList;
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

    public String getValueByCode(List<CodeControl> codeControlList, String category, String code){
        String value = "";
        for(CodeControl codeControl : codeControlList){
            if(category.equals(codeControl.getCategory())){
                if(code.equals(codeControl.getCode())){
                    value = codeControl.getValue();
                    break;
                }
            }
        }
        return value;
    }

    public void setNameAndValueFromIdAndCode(MachineList machineList, List<CodeControl> codeControlList) throws Exception{
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
            }else{
                machine.setAdminCompanyName("");
            }
            if(!BaseUtil.stringNullOrEmpty(clientId) && !"noData".equals(clientId)){
                clientName = clientMapper.getClientCompanyNameById(clientId);
                machine.setClientCompanyName(clientName);
            }else{
                machine.setClientCompanyName("");
            }
            if(!BaseUtil.stringNullOrEmpty(countryCode)){
                countryVal = getValueByCode(codeControlList, CodeControlConst.CODE_CATEGORY_COUNTRY, countryCode);
                machine.setCountryValue(countryVal);
            }else{
                machine.setCountryValue("");
            }
            if(!BaseUtil.stringNullOrEmpty(modelCode)){
                modelVal = getValueByCode(codeControlList, CodeControlConst.CODE_CATEGORY_MODEL, modelCode);
                machine.setModelValue(modelVal);
            }else{
                machine.setModelValue("");
            }
            if(!BaseUtil.stringNullOrEmpty(stateCode)){
                stateVal = getValueByCode(codeControlList, CodeControlConst.CODE_CATEGORY_MACHINESTATE, stateCode);
                machine.setStateValue(stateVal);
            }else{
                machine.setStateValue("");
            }
        }
    }

    public List<Machine> getSerialInfo(List<CodeControl> modelAll) throws Exception{
        String serialKey;
        String snDefault = "000A-001";
        List<Machine> serialNumberAll = new ArrayList<>();
        MachineManager manager = MachineManager.getInstance();

        for(CodeControl modelCodeCon : modelAll){
            Machine machine = new Machine();
            String modelValue = modelCodeCon.getValue();

            serialKey = machineMapper.getMaxSerialKey(modelCodeCon.getCode());

            if (!serialKey.equals("noSerialKey") && serialKey.substring(0, 6).equals(modelValue)) {
                String sn = manager.serialKeyAutoIncrement(serialKey);
                machine.setModelValue(modelValue);
                machine.setSerialNumber(sn);
                machine.setSerialKey(modelValue + sn);
            } else {
                machine.setModelValue(modelValue);
                machine.setSerialNumber(snDefault);
                machine.setSerialKey(modelValue + snDefault);
            }
            serialNumberAll.add(machine);
        }
        return serialNumberAll;
    }
}
