/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.daosuper;

import edu.ijse.gdse37.examsuccess.model.Admin;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SuperDaoAdmin {
      public boolean addAdmin(Admin admin) throws IOException;
      public boolean deleteAdmin(String id) throws IOException;
      public Admin SearchAdmin(String type, String key) throws FileNotFoundException, IOException ;
      public boolean updateAdmin(Admin admin) throws ClassNotFoundException, IOException ;
      public ArrayList<Admin> getAllAdmin() throws FileNotFoundException, IOException;
      public boolean searchId(String id) throws FileNotFoundException, IOException ;
      public boolean checkPassword(String id, String pass) throws FileNotFoundException, IOException;
      public String getName(String id) throws FileNotFoundException, IOException;
      public String getEmail(String id) throws FileNotFoundException, IOException;
      public boolean updateInstituteEmail(String email, String password) throws IOException;
      public String getInstitueEmailPassword() throws FileNotFoundException, IOException;
      public String getPasword(String id) throws FileNotFoundException, IOException; 
}
