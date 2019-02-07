/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_model;

import java.sql.Date;
import java.io.FileInputStream;

/**
 *
 * @author Vista Soft IT
 */
public class CompanyInformation {
    
    
    private int comid;
    private String companyName;
    private String address;
    private String hrHeadName;
    private String mobileNumber;
    private FileInputStream companyLogo;
    private FileInputStream hrSignature;
    private String processBy;
    private Date processDate;
    

    public CompanyInformation() {
    }

    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHrHeadName() {
        return hrHeadName;
    }

    public void setHrHeadName(String hrHeadName) {
        this.hrHeadName = hrHeadName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public FileInputStream getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(FileInputStream companyLogo) {
        this.companyLogo = companyLogo;
    }

    public FileInputStream getHrSignature() {
        return hrSignature;
    }

    public void setHrSignature(FileInputStream hrSignature) {
        this.hrSignature = hrSignature;
    }

    public String getProcessBy() {
        return processBy;
    }

    public void setProcessBy(String processBy) {
        this.processBy = processBy;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }


    
    
    
    
}
