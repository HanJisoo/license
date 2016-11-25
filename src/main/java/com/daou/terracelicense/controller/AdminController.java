package com.daou.terracelicense.controller;

import com.daou.terracelicense.domain.Admin;
import com.daou.terracelicense.domain.Response;
import com.daou.terracelicense.mappers.AdminMapper;
import com.daou.terracelicense.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by user on 2016-11-24.
 */
@Controller
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginPage(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    /**
     * Login - Check ID/PW
     *
     * @param admin
     * @return result message
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@ModelAttribute Admin admin){
        Admin result;
        String id = admin.getId();
        String password = admin.getPassword();
        try {
            result = adminMapper.getAdminById(id);

            if(result == null){
                return new Response("error", "id");
            }
            if(!result.getPassword().equals(password)){
                return new Response("error", "password");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Response("success", "login");
    }
}
