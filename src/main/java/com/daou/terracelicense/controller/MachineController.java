package com.daou.terracelicense.controller;

import com.daou.terracelicense.domain.Machine;
import com.daou.terracelicense.domain.MachineList;
import com.daou.terracelicense.mappers.MachineMapper;
import com.daou.terracelicense.service.MachineService;
import com.daou.terracelicense.util.PageManager;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016-11-26.
 */
@Controller
@RequestMapping(value = "/machine")
public class MachineController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MachineService machineService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getMachineView(Model model){
        List<Machine> list = new ArrayList<>();
        MachineList machineList = new MachineList();
        try{
            list = machineService.getMachineList("1");
            machineList.setMachineList(list);
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        ModelAndView mav = new ModelAndView("machine/list", model.asMap());
        mav.addObject("machineList", machineList);
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Machine> getMachineList(@RequestParam(value = "page", defaultValue = "1") String page){
        List<Machine> machineList = new ArrayList<>();
        try{
            machineList = machineService.getMachineList(page);
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }

        return machineList;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int addMachine(@RequestBody Machine machine) {
        int result = 0;
        try {
            result = machineService.addMachine(machine);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public int updateMachine(@RequestBody Machine machine) {
        int result = 0;
        try {
            result = machineService.updateMachine(machine);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }

        return result;
    }

    /*@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteMachine(@PathVariable(value = "id") String id) {

        int result = 0;
        try {
            result = machineService.deleteArticle(id);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }*/
}
