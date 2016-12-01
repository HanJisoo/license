package com.daou.terracelicense.util;

import com.daou.terracelicense.domain.Machine;
import com.daou.terracelicense.domain.MachineList;

import java.util.ArrayList;
import java.util.StringTokenizer;

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

    public static String serialKeyAutoIncrement(String sn) {
        StringTokenizer st = new StringTokenizer(sn, "-");
        String firstSn = st.nextToken(); //first
        firstSn = firstSn.substring(6);
        String endSn = st.nextToken(); //end
        StringBuffer firstBuffer = new StringBuffer(firstSn);
        int indexSn = Integer.parseInt(endSn); //index

        String oneSimbol = "0";
        String twoSimbol = "00";
        String lineSimbol = "-";

        if (indexSn != 999){
            indexSn++;
            //===========================index
            String tmp = String.valueOf(indexSn);
            if (tmp.length() == 1) {
                endSn = twoSimbol + tmp;
            } else if (tmp.length() == 2) {
                endSn = oneSimbol + tmp;
            } else {
                endSn = tmp;
            }
        } else {
            firstBuffer.reverse();
            for (int i = 0; i < firstBuffer.length(); i++) {
                char one = firstBuffer.charAt(i);
                char two = firstBuffer.charAt(i + 1);

                if (one != 'Z'){
                    firstBuffer.replace(i, i + 1, String.valueOf(++one));
                    System.out.println(firstBuffer);
                    break;
                }else{
                    if (two != 'Z'){
                        if (two != '0') {
                            two++;
                        } else {
                            two = 'A';
                        }
                        firstBuffer.replace(i, i + 1, "A");
                        firstBuffer.replace(i + 1, i + 2, String.valueOf(two));
                        break;
                    }
                    else{
                        two = 'A';
                        firstBuffer.replace(i, i + 1, String.valueOf(two));
                    }
                }
            }
            firstSn = firstBuffer.reverse().toString();
            endSn = "001";
        }
        return firstSn + lineSimbol + endSn;
    }
}
