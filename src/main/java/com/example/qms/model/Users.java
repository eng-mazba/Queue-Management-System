package com.example.qms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String password;
    private String userName;
    private int userType;
    private String userStatus;
    private Date lastLogin;
    private Date logOut;
    private Integer noOfLogin;
    private String validityDate;
    private String branchId;
    private String loginDevice;
    private String companyId;

    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLogOut() {
        return logOut;
    }

    public void setLogOut(Date logOut) {
        this.logOut = logOut;
    }

    public Integer getNoOfLogin() {
        return noOfLogin;
    }

    public void setNoOfLogin(Integer noOfLogin) {
        this.noOfLogin = noOfLogin;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
