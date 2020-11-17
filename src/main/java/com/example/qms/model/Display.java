package com.example.qms.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Display {

    @Id
    @Column(name = "id", columnDefinition = "bigint constraint DF_disid default next value for displayid_generator")
    @Generated(GenerationTime.INSERT)
    private Integer id;
    private Integer userId;
    private String displayName;
    private String Hight;
    private String Width;
    private String displayIp;
    private String bannarImage;
    private String branchId;
    private String CompanyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHight() {
        return Hight;
    }

    public void setHight(String hight) {
        Hight = hight;
    }

    public String getWidth() {
        return Width;
    }

    public void setWidth(String width) {
        Width = width;
    }

    public String getDisplayIp() {
        return displayIp;
    }

    public void setDisplayIp(String displayIp) {
        this.displayIp = displayIp;
    }

    public String getBannarImage() {
        return bannarImage;
    }

    public void setBannarImage(String bannarImage) {
        this.bannarImage = bannarImage;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }
}
