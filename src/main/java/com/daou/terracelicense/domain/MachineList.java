package com.daou.terracelicense.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2016-11-29.
 */
public class MachineList implements Serializable{
    private int currentPage;
    private int startPage;
    private int endPage;
    private int startNo;
    private int maxNo;
    private int onePageSize;
    private int indexViewSize;
    private int maxIndexNo;
    private int currentIndexPage;
    private String searchItem;
    private String searchType;
    private String sortType;
    private String sortItem;
    private String user;
    private List<Machine> machineList;

    public MachineList() {
        this.currentIndexPage = 1;
        this.endPage = 10;
        this.startPage = 1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getStartNo() {
        return startNo;
    }

    public void setStartNo(int startNo) {
        this.startNo = startNo;
    }

    public int getMaxNo() {
        return maxNo;
    }

    public void setMaxNo(int maxNo) {
        this.maxNo = maxNo;
    }

    public int getOnePageSize() {
        return onePageSize;
    }

    public void setOnePageSize(int onePageSize) {
        this.onePageSize = onePageSize;
    }

    public int getIndexViewSize() {
        return indexViewSize;
    }

    public void setIndexViewSize(int indexViewSize) {
        this.indexViewSize = indexViewSize;
    }

    public int getMaxIndexNo() {
        return maxIndexNo;
    }

    public void setMaxIndexNo(int maxIndexNo) {
        this.maxIndexNo = maxIndexNo;
    }

    public int getCurrentIndexPage() {
        return currentIndexPage;
    }

    public void setCurrentIndexPage(int currentIndexPage) {
        this.currentIndexPage = currentIndexPage;
    }

    public String getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortItem() {
        return sortItem;
    }

    public void setSortItem(String sortItem) {
        this.sortItem = sortItem;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Machine> getMachineList() {
        return machineList;
    }

    public void setMachineList(List<Machine> machineList) {
        this.machineList = machineList;
    }
}
