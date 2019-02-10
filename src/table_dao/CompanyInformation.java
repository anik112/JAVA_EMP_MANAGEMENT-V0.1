/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_dao;

import java.util.List;

/**
 *
 * @author Vista Soft IT
 */
public interface CompanyInformation {
    
    /**
     * Function name: information save
     * this function work for save company information.
     * @param information 
     */
    public void information_save(table_model.CompanyInformation information);
    
    /**
     * Function name: information_update.
     * this function work for update company information.
     * @param information 
     */
    public void information_update(table_model.CompanyInformation information);
    
    /**
     * Function name: information_delete.
     * this function work for delete company data
     * @param comid 
     */
    public void information_delete(int comid);
    
    
    /**
     * Function name: get_company_information
     * this function work for get company information from database and throw into view
     * @param comid
     * @return
     */
    public table_model.CompanyInformation get_company_information(String comName);
    
    
    /**
     * Function name: get_company_information
     * this function work for get company information from database and throw into view
     * @param comid
     * @return
     */
    List<table_model.CompanyInformation> get_all_company_information();
}
