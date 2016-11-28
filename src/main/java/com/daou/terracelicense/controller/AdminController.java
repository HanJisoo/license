package com.daou.terracelicense.controller;

import com.daou.terracelicense.domain.Admin;
import com.daou.terracelicense.domain.Response;
import com.daou.terracelicense.mappers.AdminMapper;
import com.daou.terracelicense.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by user on 2016-11-24.
 */
@Controller
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
                                  @RequestParam(value = "logout",	required = false) String logout){
        ModelAndView mav = new ModelAndView();
        if (error != null) {
            mav.addObject("error", "Invalid Credentials provided.");
        }

        if (logout != null) {
            mav.addObject("message", "Logged out successfully.");
            mav.setViewName("/");
            return mav;
        }

        mav.setViewName("header");
        return mav;
    }

    /**
     * Login - Check ID/PW
     *
     * @param admin
     * @return result message
     */
    @ResponseBody
    @RequestMapping(value = "/login/ex", method = RequestMethod.POST)
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
