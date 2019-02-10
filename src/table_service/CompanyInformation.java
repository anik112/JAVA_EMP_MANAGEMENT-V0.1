/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_service;

import connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vista Soft IT
 */
public class CompanyInformation implements table_dao.CompanyInformation{

    private final Connection connection=DBconnection.getConnection(); // declare connection model for connect with database
    
    // write sql quary  "COMLOGO,HRSIGN_STAFF,"
    private final String qrySave="INSERT INTO TB_COMPANY_INFO "
            + "(COMPANY,ADDRESS,HR_HEAD_NAME,PHONE_NO,PROCESSBY,PROCESSDATE) "
            + "VALUE "
            + "(?,?,?,?,?,?)";
    
    private final String qryUpdate="UPDATE TB_COMPANY_INFO "
            + "SET"
            + " COMPANY=?,ADDRESS=?,HR_HEAD_NAME=?,PHONE_NO=?,PROCESSBY=?,PROCESSDATE=?"
            + " WHERE"
            + " COMID=?";
    
    private final String qryDelete="DELETE FROM TB_COMPANY_INFO "
            + "WHERE "
            + "COMID=?";
    
    private final String qrySelect="SELECT COMID,COMPANY,ADDRESS,HR_HEAD_NAME,PHONE_NO,PROCESSBY,PROCESSDATE FROM TB_COMPANY_INFO";
    
    
    public CompanyInformation() {
    }
    

    
    
    /**
     * save information
     * @param information 
     */
    @Override
    public void information_save(table_model.CompanyInformation information) {
        
        // for hendal exception
         try{
             // check information is not empty and company name is not empty
             if((information != null) && (information.getCompanyName()!="")){
       
                 // prepare qry fro execute
                 PreparedStatement statement=connection.prepareStatement(qrySave);
                 
                 statement.setString(1, information.getCompanyName()); // set company name in database
                 statement.setString(2, information.getAddress()); // set company address in database
                 statement.setString(3, information.getHrHeadName()); // set HR head name in databse
                 statement.setString(4, information.getMobileNumber()); // set Mobile number in database
                 statement.setString(5, information.getProcessBy()); // set Process user name
                 statement.setDate(6, information.getProcessDate()); // set Process date
                 
                 statement.executeUpdate(); // statement execute
                 statement.close(); // close connection
             }
         }catch(SQLException e){
             // Show error massage
             new view_massage.ErrorMessage("Data not insert","Check Company Information into table model "
                     + "# information_save # method");
         }
        
    }

    @Override
    public void information_update(table_model.CompanyInformation information) {
        
         // for hendal exception
         try{
             // check information is not empty and company name is not empty
             if((information != null) && (information.getCompanyName()!="")){
       
                 // prepare qry fro execute
                 PreparedStatement statement=connection.prepareStatement(qryUpdate);
                 
                 statement.setString(1, information.getCompanyName()); // set company name in database
                 statement.setString(2, information.getAddress()); // set company address in database
                 statement.setString(3, information.getHrHeadName()); // set HR head name in databse
                 statement.setString(4, information.getMobileNumber()); // set Mobile number in database
                 statement.setString(5, information.getProcessBy()); // set Process user name
                 statement.setDate(6, information.getProcessDate()); // set Process date
                 
                 statement.setInt(7, information.getComid()); // set company information
                 
                 statement.executeUpdate(); // statement execute
                 statement.close(); // close connection
             }
         }catch(SQLException e){
             // Show error massage
             new view_massage.ErrorMessage("Data not insert","Check Company Information into table model "
                     + "# information_update # method");
         }
         
    }

    @Override
    public void information_delete(int comid) {
        throw new UnsupportedOperationException("Not supported yet. information_delete"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public table_model.CompanyInformation get_company_information(String comName) {
        
        try {
            
            PreparedStatement statement=connection.prepareStatement(qrySelect+" WHERE COMPANY = ?");
            statement.setString(1, comName);
            ResultSet result=statement.executeQuery();
            
            table_model.CompanyInformation information=new table_model.CompanyInformation();
            
            while (result.next()) {
                information.setComid(result.getInt(1));
                information.setCompanyName(result.getString(2));
                information.setAddress(result.getString(3));
                information.setHrHeadName(result.getString(4));
                information.setMobileNumber(result.getString(5));
                information.setProcessBy(result.getString(6));
                information.setProcessDate(result.getDate(7));
            }
            
            return information;
        } catch (SQLException e) {
            new view_massage.ErrorMessage("Data not insert","Check Company Information into table model"
                    + "# get_company_information # method");
        }
        return null;
        
        
    }

    @Override
    public List<table_model.CompanyInformation> get_all_company_information() {
        
        List<table_model.CompanyInformation> getCompanyList=new ArrayList<>();
        
        try {
            
            PreparedStatement statement=connection.prepareStatement(qrySelect);
            ResultSet result=statement.executeQuery();
            
            
            while (result.next()) {
                
                table_model.CompanyInformation information=new table_model.CompanyInformation();
                
                information.setComid(result.getInt(1));
                information.setCompanyName(result.getString(2));
                information.setAddress(result.getString(3));
                information.setHrHeadName(result.getString(4));
                information.setMobileNumber(result.getString(5));
                information.setProcessBy(result.getString(6));
                information.setProcessDate(result.getDate(7));
                
                getCompanyList.add(information);
            }
            
            return getCompanyList;
            
            
        } catch (SQLException e) {
            new view_massage.ErrorMessage("Data not insert","Check Company Information into table model"
                    + "# get_all_company_information # method");
        }
        return null;
    }
    
}
