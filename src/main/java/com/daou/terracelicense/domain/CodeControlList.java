package com.daou.terracelicense.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2016-11-30.
 */
public class CodeControlList implements Serializable{
    private List<CodeControl> modelAll;
    private List<CodeControl> prefixAll;
    private List<CodeControl> virusAll;
    private List<CodeControl> thirdProgramAll;
    private List<CodeControl> thirdDeviceAll;
    private List<CodeControl> producerAll;
    private List<CodeControl> countryAll;
    private List<CodeControl> stateAll;
    private List<Machine> clientCompanyAll;
    private List<Machine> adminCompanyAll;
    private List<Machine> serialNumberAll;

    public List<CodeControl> getModelAll() {
        return modelAll;
    }

    public void setModelAll(List<CodeControl> modelAll) {
        this.modelAll = modelAll;
    }

    public List<CodeControl> getPrefixAll() {
        return prefixAll;
    }

    public void setPrefixAll(List<CodeControl> prefixAll) {
        this.prefixAll = prefixAll;
    }

    public List<CodeControl> getVirusAll() {
        return virusAll;
    }

    public void setVirusAll(List<CodeControl> virusAll) {
        this.virusAll = virusAll;
    }

    public List<CodeControl> getThirdProgramAll() {
        return thirdProgramAll;
    }

    public void setThirdProgramAll(List<CodeControl> thirdProgramAll) {
        this.thirdProgramAll = thirdProgramAll;
    }

    public List<CodeControl> getThirdDeviceAll() {
        return thirdDeviceAll;
    }

    public void setThirdDeviceAll(List<CodeControl> thirdDeviceAll) {
        this.thirdDeviceAll = thirdDeviceAll;
    }

    public List<CodeControl> getProducerAll() {
        return producerAll;
    }

    public void setProducerAll(List<CodeControl> producerAll) {
        this.producerAll = producerAll;
    }

    public List<CodeControl> getCountryAll() {
        return countryAll;
    }

    public void setCountryAll(List<CodeControl> countryAll) {
        this.countryAll = countryAll;
    }

    public List<CodeControl> getStateAll() {
        return stateAll;
    }

    public void setStateAll(List<CodeControl> stateAll) {
        this.stateAll = stateAll;
    }

    public List<Machine> getClientCompanyAll() {
        return clientCompanyAll;
    }

    public void setClientCompanyAll(List<Machine> clientCompanyAll) {
        this.clientCompanyAll = clientCompanyAll;
    }

    public List<Machine> getAdminCompanyAll() {
        return adminCompanyAll;
    }

    public void setAdminCompanyAll(List<Machine> adminCompanyAll) {
        this.adminCompanyAll = adminCompanyAll;
    }

    public List<Machine> getSerialNumberAll() {
        return serialNumberAll;
    }

    public void setSerialNumberAll(List<Machine> serialNumberAll) {
        this.serialNumberAll = serialNumberAll;
    }
}
