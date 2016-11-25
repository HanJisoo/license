package com.daou.terracelicense.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by user on 2016-11-24.
 */
public class Admin implements UserDetails{
    private String id;
    private String password;
    private String name;
    private String email;
    private String telephone;
    private String fax;
    private String homepage;
    private String country;
    private String createDate;
    private String note;
    private SimpleGrantedAuthority authority;

    public void setAuthority(SimpleGrantedAuthority authority) {
        this.authority = authority;
    }

    public SimpleGrantedAuthority getAuthority() {
        return authority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(this.getAuthority());
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Admin(String id, String password, String name, String email, String telephone, String fax, String homepage, String country, String createDate, String note) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.fax = fax;
        this.homepage = homepage;
        this.country = country;
        this.createDate = createDate;
        this.note = note;
    }

    public Admin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                ", homepage='" + homepage + '\'' +
                ", country='" + country + '\'' +
                ", createDate='" + createDate + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
