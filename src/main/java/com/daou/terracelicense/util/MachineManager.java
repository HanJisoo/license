package com.daou.terracelicense.util;

import com.daou.terracelicense.domain.Machine;
import com.daou.terracelicense.domain.MachineList;

import java.util.ArrayList;

/**
 * Created by user on 2016-11-30.
 */
public class MachineManager {
    public static void setMachineNo(MachineList machineList){
        ArrayList<Machine> list = (ArrayList)machineList.getMachineList();
        int machineCount = machineList.getMaxIndexNo();
        int currentIndex = machineList.getCurrentIndexPage();
        int offset = PageManager.getOffsetByPage(String.valueOf(currentIndex), PageManager.MACHINE_PAGE_LIMIT);
        for(int i = 0; i < list.size(); i++){
            Machine machine = list.get(i);
            machine.setMachineNo(machineCount - (offset + i));
        }
    }

}
