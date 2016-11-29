package com.daou.terracelicense.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2016-11-26.
 */
public class Machine implements Serializable{
    private int machineNo;
    private String serialKey;
    private String prefix;
    private String serialNumber;
    private String hostId;
    private String password;
    private String modelValue;
    private String modelCode;
    private String machineKind;
    private String stateCode;
    private String stateValue;
    private String adminCompanyId;
    private String clientCompanyId;
    private String adminCompanyName;
    private String clientCompanyName;
    private String partnerGroupId;
    private String partnerGroupName;
    private String partnerGrade;
    private String virusCode;
    private String virusValue;
    private String thirdProgram;
    private String thirdDevice;
    private String producerCode;
    private String producerValue;
    private String countryCode;
    private String countryValue;
    private String createDate;
    private String productionDate;
    private String deliveryDate;
    private String salesDate;
    private String licenseEndDate;
    private String installMode;
    private String networkMode;
    private String fqdn;
    private String ip;
    private String netmask;
    private String gateway;
    private String dns1;
    private String dns2;
    private String defaultDomain;
    private String routingHost;
    private String osVersion;
    private String shassis;
    private String board;
    private String cpu;
    private String cpuFan;
    private String memory;
    private String hdd;
    private String powerSupply;
    private String systemFan;
    private String pciEthernet;
    private String bypassCard;
    private String noteOne;
    private String noteTwo;
    private String user;
    private String softwareversion;
    private String customerperson;
    private String applianceType;
    private String userlicenseEndDate;
    private String spamlicneseEndDate;
    private String viruslicenseEndDate;
    private String spamEngEndDate;
    private String damagalicenseEndDate;

    private String localMailLicense = "false";
    private String secureMailLicense = "false";
    private String orgLicense = "false";
    private String smsLicense = "false";
    private String faxRLicense = "false";
    private String faxTLicense = "false";
    private String mobileLicense = "false";
    private String noteLicense = "false";
    private String mailinglistLicense = "false";
    private String aspLicense = "false";
    private String personalInformationLicense = "false";
    private String socialLicense = "false";
    private String otpLicense = "false";
    private String collaborationLicense = "false";
    private String attachmentPreViewLicense = "false";
    private String approvalLicense = "false";

    private String isTmse = "false";

    private String suspicionLicense = "false";
    private String sandboxLicense = "false";
    private String inspectorLicense = "false";
    private String previewLicense = "false";

    private String macAddress;

    public int getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(int machineNo) {
        this.machineNo = machineNo;
    }

    public String getSerialKey() {
        return serialKey;
    }

    public void setSerialKey(String serialKey) {
        this.serialKey = serialKey;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModelValue() {
        return modelValue;
    }

    public void setModelValue(String modelValue) {
        this.modelValue = modelValue;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getMachineKind() {
        return machineKind;
    }

    public void setMachineKind(String machineKind) {
        this.machineKind = machineKind;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateValue() {
        return stateValue;
    }

    public void setStateValue(String stateValue) {
        this.stateValue = stateValue;
    }

    public String getAdminCompanyId() {
        return adminCompanyId;
    }

    public void setAdminCompanyId(String adminCompanyId) {
        this.adminCompanyId = adminCompanyId;
    }

    public String getClientCompanyId() {
        return clientCompanyId;
    }

    public void setClientCompanyId(String clientCompanyId) {
        this.clientCompanyId = clientCompanyId;
    }

    public String getAdminCompanyName() {
        return adminCompanyName;
    }

    public void setAdminCompanyName(String adminCompanyName) {
        this.adminCompanyName = adminCompanyName;
    }

    public String getClientCompanyName() {
        return clientCompanyName;
    }

    public void setClientCompanyName(String clientCompanyName) {
        this.clientCompanyName = clientCompanyName;
    }

    public String getPartnerGroupId() {
        return partnerGroupId;
    }

    public void setPartnerGroupId(String partnerGroupId) {
        this.partnerGroupId = partnerGroupId;
    }

    public String getPartnerGroupName() {
        return partnerGroupName;
    }

    public void setPartnerGroupName(String partnerGroupName) {
        this.partnerGroupName = partnerGroupName;
    }

    public String getPartnerGrade() {
        return partnerGrade;
    }

    public void setPartnerGrade(String partnerGrade) {
        this.partnerGrade = partnerGrade;
    }

    public String getVirusCode() {
        return virusCode;
    }

    public void setVirusCode(String virusCode) {
        this.virusCode = virusCode;
    }

    public String getVirusValue() {
        return virusValue;
    }

    public void setVirusValue(String virusValue) {
        this.virusValue = virusValue;
    }

    public String getThirdProgram() {
        return thirdProgram;
    }

    public void setThirdProgram(String thirdProgram) {
        this.thirdProgram = thirdProgram;
    }

    public String getThirdDevice() {
        return thirdDevice;
    }

    public void setThirdDevice(String thirdDevice) {
        this.thirdDevice = thirdDevice;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getProducerValue() {
        return producerValue;
    }

    public void setProducerValue(String producerValue) {
        this.producerValue = producerValue;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryValue() {
        return countryValue;
    }

    public void setCountryValue(String countryValue) {
        this.countryValue = countryValue;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public String getLicenseEndDate() {
        return licenseEndDate;
    }

    public void setLicenseEndDate(String licenseEndDate) {
        this.licenseEndDate = licenseEndDate;
    }

    public String getInstallMode() {
        return installMode;
    }

    public void setInstallMode(String installMode) {
        this.installMode = installMode;
    }

    public String getNetworkMode() {
        return networkMode;
    }

    public void setNetworkMode(String networkMode) {
        this.networkMode = networkMode;
    }

    public String getFqdn() {
        return fqdn;
    }

    public void setFqdn(String fqdn) {
        this.fqdn = fqdn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getDns1() {
        return dns1;
    }

    public void setDns1(String dns1) {
        this.dns1 = dns1;
    }

    public String getDns2() {
        return dns2;
    }

    public void setDns2(String dns2) {
        this.dns2 = dns2;
    }

    public String getDefaultDomain() {
        return defaultDomain;
    }

    public void setDefaultDomain(String defaultDomain) {
        this.defaultDomain = defaultDomain;
    }

    public String getRoutingHost() {
        return routingHost;
    }

    public void setRoutingHost(String routingHost) {
        this.routingHost = routingHost;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getShassis() {
        return shassis;
    }

    public void setShassis(String shassis) {
        this.shassis = shassis;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpuFan() {
        return cpuFan;
    }

    public void setCpuFan(String cpuFan) {
        this.cpuFan = cpuFan;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public String getSystemFan() {
        return systemFan;
    }

    public void setSystemFan(String systemFan) {
        this.systemFan = systemFan;
    }

    public String getPciEthernet() {
        return pciEthernet;
    }

    public void setPciEthernet(String pciEthernet) {
        this.pciEthernet = pciEthernet;
    }

    public String getBypassCard() {
        return bypassCard;
    }

    public void setBypassCard(String bypassCard) {
        this.bypassCard = bypassCard;
    }

    public String getNoteOne() {
        return noteOne;
    }

    public void setNoteOne(String noteOne) {
        this.noteOne = noteOne;
    }

    public String getNoteTwo() {
        return noteTwo;
    }

    public void setNoteTwo(String noteTwo) {
        this.noteTwo = noteTwo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSoftwareversion() {
        return softwareversion;
    }

    public void setSoftwareversion(String softwareversion) {
        this.softwareversion = softwareversion;
    }

    public String getCustomerperson() {
        return customerperson;
    }

    public void setCustomerperson(String customerperson) {
        this.customerperson = customerperson;
    }

    public String getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(String applianceType) {
        this.applianceType = applianceType;
    }

    public String getUserlicenseEndDate() {
        return userlicenseEndDate;
    }

    public void setUserlicenseEndDate(String userlicenseEndDate) {
        this.userlicenseEndDate = userlicenseEndDate;
    }

    public String getSpamlicneseEndDate() {
        return spamlicneseEndDate;
    }

    public void setSpamlicneseEndDate(String spamlicneseEndDate) {
        this.spamlicneseEndDate = spamlicneseEndDate;
    }

    public String getViruslicenseEndDate() {
        return viruslicenseEndDate;
    }

    public void setViruslicenseEndDate(String viruslicenseEndDate) {
        this.viruslicenseEndDate = viruslicenseEndDate;
    }

    public String getSpamEngEndDate() {
        return spamEngEndDate;
    }

    public void setSpamEngEndDate(String spamEngEndDate) {
        this.spamEngEndDate = spamEngEndDate;
    }

    public String getDamagalicenseEndDate() {
        return damagalicenseEndDate;
    }

    public void setDamagalicenseEndDate(String damagalicenseEndDate) {
        this.damagalicenseEndDate = damagalicenseEndDate;
    }

    public String getLocalMailLicense() {
        return localMailLicense;
    }

    public void setLocalMailLicense(String localMailLicense) {
        this.localMailLicense = localMailLicense;
    }

    public String getSecureMailLicense() {
        return secureMailLicense;
    }

    public void setSecureMailLicense(String secureMailLicense) {
        this.secureMailLicense = secureMailLicense;
    }

    public String getOrgLicense() {
        return orgLicense;
    }

    public void setOrgLicense(String orgLicense) {
        this.orgLicense = orgLicense;
    }

    public String getSmsLicense() {
        return smsLicense;
    }

    public void setSmsLicense(String smsLicense) {
        this.smsLicense = smsLicense;
    }

    public String getFaxRLicense() {
        return faxRLicense;
    }

    public void setFaxRLicense(String faxRLicense) {
        this.faxRLicense = faxRLicense;
    }

    public String getFaxTLicense() {
        return faxTLicense;
    }

    public void setFaxTLicense(String faxTLicense) {
        this.faxTLicense = faxTLicense;
    }

    public String getMobileLicense() {
        return mobileLicense;
    }

    public void setMobileLicense(String mobileLicense) {
        this.mobileLicense = mobileLicense;
    }

    public String getNoteLicense() {
        return noteLicense;
    }

    public void setNoteLicense(String noteLicense) {
        this.noteLicense = noteLicense;
    }

    public String getMailinglistLicense() {
        return mailinglistLicense;
    }

    public void setMailinglistLicense(String mailinglistLicense) {
        this.mailinglistLicense = mailinglistLicense;
    }

    public String getAspLicense() {
        return aspLicense;
    }

    public void setAspLicense(String aspLicense) {
        this.aspLicense = aspLicense;
    }

    public String getPersonalInformationLicense() {
        return personalInformationLicense;
    }

    public void setPersonalInformationLicense(String personalInformationLicense) {
        this.personalInformationLicense = personalInformationLicense;
    }

    public String getSocialLicense() {
        return socialLicense;
    }

    public void setSocialLicense(String socialLicense) {
        this.socialLicense = socialLicense;
    }

    public String getOtpLicense() {
        return otpLicense;
    }

    public void setOtpLicense(String otpLicense) {
        this.otpLicense = otpLicense;
    }

    public String getCollaborationLicense() {
        return collaborationLicense;
    }

    public void setCollaborationLicense(String collaborationLicense) {
        this.collaborationLicense = collaborationLicense;
    }

    public String getAttachmentPreViewLicense() {
        return attachmentPreViewLicense;
    }

    public void setAttachmentPreViewLicense(String attachmentPreViewLicense) {
        this.attachmentPreViewLicense = attachmentPreViewLicense;
    }

    public String getApprovalLicense() {
        return approvalLicense;
    }

    public void setApprovalLicense(String approvalLicense) {
        this.approvalLicense = approvalLicense;
    }

    public String getIsTmse() {
        return isTmse;
    }

    public void setIsTmse(String isTmse) {
        this.isTmse = isTmse;
    }

    public String getSuspicionLicense() {
        return suspicionLicense;
    }

    public void setSuspicionLicense(String suspicionLicense) {
        this.suspicionLicense = suspicionLicense;
    }

    public String getSandboxLicense() {
        return sandboxLicense;
    }

    public void setSandboxLicense(String sandboxLicense) {
        this.sandboxLicense = sandboxLicense;
    }

    public String getInspectorLicense() {
        return inspectorLicense;
    }

    public void setInspectorLicense(String inspectorLicense) {
        this.inspectorLicense = inspectorLicense;
    }

    public String getPreviewLicense() {
        return previewLicense;
    }

    public void setPreviewLicense(String previewLicense) {
        this.previewLicense = previewLicense;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
