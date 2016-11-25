package com.daou.terracelicense.service;

import com.daou.terracelicense.domain.Admin;
import com.daou.terracelicense.mappers.AdminMapper;
import com.daou.terracelicense.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by user on 2016-11-25.
 */
@Service
public class AdminService implements UserDetailsService{
    @Autowired
    AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Admin admin = new Admin();
        try{
            admin = adminMapper.getAdminById(id);
            if (BaseUtil.stringNullOrEmpty(admin.getId())){
                throw new UsernameNotFoundException("no admin");
            }
            admin.setAuthority(new SimpleGrantedAuthority("ADMIN"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return admin;
    }
}
