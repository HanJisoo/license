package com.daou.terracelicense.controller;

import com.daou.terracelicense.domain.CodeControlList;
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
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2016-11-26.
 */
@Controller
@RequestMapping(value = "/machine")
public class MachineController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MachineService machineService;

    private final String INIT_PAGE = "1";
    private final String INIT_SORT_TYPE = "createdate";

    /**
     * Machine-Controller-01
     * Get Machine List View
     */
    @RequestMapping(value = "/view/list", method = RequestMethod.GET)
    public ModelAndView getMachineListView(Model model){
        MachineList machineList = new MachineList();
        try{
            machineList = machineService.getMachineList(INIT_PAGE, INIT_SORT_TYPE);
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        ModelAndView mav = new ModelAndView("machine/list", model.asMap());
        mav.addObject("machineList", machineList);
        return mav;
    }

    /**
     * Machine-Controller-02
     * Get Machine Add View
     */
    @RequestMapping(value = "/view/add", method = RequestMethod.GET)
    public ModelAndView getMachineAddView(Model model){
        CodeControlList codeControlList = new CodeControlList();
        try{
            codeControlList = machineService.getCodeControlList();
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        ModelAndView mav = new ModelAndView("machine/add", model.asMap());
        mav.addObject("codeControlList", codeControlList);
        return mav;
    }

    /**
     * Machine-Controller-03
     * Get Machine List Data
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public MachineList getMachineList(@RequestParam(value = "page", defaultValue = "1") String page, @RequestParam(value = "sortType", defaultValue = "createdate") String sortType){
        MachineList machineList = new MachineList();
        try{
            machineList = machineService.getMachineList(page, sortType);
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }

        return machineList;
    }

    /**
     * Machine-Controller-04
     * Add Machine
     */
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

    /**
     * Machine-Controller-05
     * Update Machine
     */
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
}
