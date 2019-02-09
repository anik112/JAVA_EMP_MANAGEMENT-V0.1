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
            + "(COMPANY,ADDRESS,HR_HEAD_NAME,PHONE_NO,PROCESSBY,PROCESSDATE)"
            + "VALUE"
            + "(?,?,?,?,?,?)";
    
    private final String qryUpdate="UPDATE TB_COMPANY_INFO "
            + "SET"
            + "COMPANY=?,ADDRESS=?,HR_HEAD_NAME=?,PHONE_NO=?,COMLOGO=?,HRSIGN_STAFF=?,PROCESSBY=?,PROCESSDATE=?"
            + "WHERE"
            + "COMID=?";
    
    private final String qryDelete="DELETE FROM TB_COMPANY_INFO"
            + "WHERE"
            + "COMID=?";
    
    private final String qrySelect="SELECT * FROM TB_COMPANY_INFO";
    
    public CompanyInformation() {
    }
    

    /**
     * save information
     * @param information 
     */
    @Override
    public void information_save(table_model.CompanyInformation information) {
        
         try{
             
             if((information != null) && (information.getCompanyName()!="")){
                 
                
                 
                 PreparedStatement statement=connection.prepareStatement(qrySave);
                 
                 statement.setString(1, information.getCompanyName());
                 statement.setString(2, information.getAddress());
                 statement.setString(3, information.getHrHeadName());
                 statement.setString(4, information.getMobileNumber());
                 statement.setString(5, information.getProcessBy());
                 statement.setDate(6, information.getProcessDate());
                 
                 statement.executeUpdate();
                 statement.close();
             }
         }catch(SQLException e){
             new view_massage.ErrorMessage("Data not insert","Check Company Information into table model "
                     + "# information_save # method");
         }
        
        
        
        
       // throw new UnsupportedOperationException("Not supported yet. information_save"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void information_update(table_model.CompanyInformation information) {
        throw new UnsupportedOperationException("Not supported yet. information_update"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void information_delete(int comid) {
        throw new UnsupportedOperationException("Not supported yet. information_delete"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<table_model.CompanyInformation> get_company_information(int comid) {
        throw new UnsupportedOperationException("Not supported yet. get_company_information"); //To change body of generated methods, choose Tools | Templates.
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
                information.setAddress(result.getString(2));
                information.setHrHeadName(result.getString(3));
                information.setMobileNumber(result.getString(4));
                information.setProcessBy(result.getString(5));
                information.setProcessDate(result.getDate(6));
                
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
