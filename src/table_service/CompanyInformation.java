/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_service;

import connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Vista Soft IT
 */
public class CompanyInformation implements table_dao.CompanyInformation{

    private final Connection connection=DBconnection.getConnection(); // declare connection model for connect with database
    
    // write sql quary  "COMLOGO,HRSIGN_STAFF,"
    private final String qrySave="INSERT INTO TB_COMPANY_INFO "
            + "(COMPANY,ADDRESS,HR_HEAD_NAME,PHONE_NO,PROCESSBY)"
            + "VALUE"
            + "(?,?,?,?,?)";
    
    private final String qryUpdate="UPDATE TB_COMPANY_INFO "
            + "SET"
            + "COMPANY=?,ADDRESS=?,HR_HEAD_NAME=?,PHONE_NO=?,COMLOGO=?,HRSIGN_STAFF=?,PROCESSBY=?,PROCESSDATE=?"
            + "WHERE"
            + "COMID=?";
    
    private final String qryDelete="DELETE FROM TB_COMPANY_INFO"
            + "WHERE"
            + "COMID=?";
    
    
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
                 
                 statement.setString(0, information.getCompanyName());
                 statement.setString(1, information.getAddress());
                 statement.setString(2, information.getHrHeadName());
                 statement.setString(3, information.getMobileNumber());
                 statement.setString(4, information.getProcessBy());
                 //statement.setDate(5, information.getProcessDate());
                 
                 statement.executeUpdate();
                 statement.close();
             }
         }catch(SQLException e){
             new view_massage.ErrorMessage("Data not insert","Check Company Information into table model");
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
    public List<table_dao.CompanyInformation> get_company_information(int comid) {
        throw new UnsupportedOperationException("Not supported yet. get_company_information"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
