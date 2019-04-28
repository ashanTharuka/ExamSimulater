/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.dao;

import edu.ijse.gdse37.examsuccess.daosuper.SuperDaoAdmin;
import edu.ijse.gdse37.examsuccess.other.Encrypt;
import edu.ijse.gdse37.examsuccess.model.Admin;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Ashan Tharuka
 */
public class AdminDaoFile extends Encrypt implements SuperDaoAdmin{

    //File Path
    private final File F1 = new File("./Database/Admin/admin.txt");
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String readLine = null;
    private final static ReentrantReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();

    /**
     *
     * @param admin
     * @return
     * @throws IOException
     */
    @Override
    public boolean addAdmin(Admin admin) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();

            fileWriter = new FileWriter(F1, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String row = admin.getId() + ":" + admin.getName() + ":" + admin.getPhoneNumber() + ":" + admin.getPassword() + ":" + admin.getEmail() + ":";
            String line = cipher(row);
            if (bufferedWriter.append(line) != null) {
                bufferedWriter.flush();
                bufferedWriter.close();
                return true;
            } else {
                return false;
            }
        } finally {
            READWRITELOCK.writeLock().unlock();
        }

    }

    /**
     *
     * @param id
     * @return
     * @throws IOException
     */
    @Override
    public boolean deleteAdmin(String id) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();

            String[] adminList = null;
            if (F1.exists()) {
                FileReader fileReader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    adminList = line.split(":");
                }
            }
            String[] newAdminList = new String[adminList.length - 5];// what we want to delete line substract from list//model has 5 item
            for (int i = 0, x = 0; i < adminList.length; i++) {
                if (adminList[i].equals(id)) {
                    i += 4;//miss 5 item//
                } else {
                    newAdminList[x] = adminList[i];//store other vlues in array for write
                    x++;
                }
            }
            FileWriter writer = new FileWriter(F1, false);
            for (int i = 0; i < newAdminList.length; i++) {
                writer.write(cipher(newAdminList[i] + ":"));
                writer.flush();
            }

            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            newAdminList = line.split(":");
            if (adminList.length != newAdminList.length) {
                return true;
            } else {
                return false;
            }
        } finally {
            READWRITELOCK.writeLock().unlock();
        }

    }

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public Admin SearchAdmin(String type, String key) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Admin admin = null;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] AdminList = line.split(":");

                    if ("id".equals(type)) {
                        for (int i = 0; i < AdminList.length; i++) {
                            if (AdminList[i].equals(key)) {
                                System.out.println(AdminList[i] + "," + AdminList[i + 1] + "," + AdminList[i + 2] + "," + AdminList[i + 3]);
                                admin = new Admin(AdminList[i], AdminList[i + 1], AdminList[i + 2], AdminList[i + 3], AdminList[i + 4]);
                            }
                        }
                    }
                    if ("name".equals(type)) {
                        for (int i = 0; i < AdminList.length - 1; i++) {
                            if (AdminList[i + 1].equals(key)) {
                                admin = new Admin(AdminList[i], AdminList[i + 1], AdminList[i + 2], AdminList[i + 3], AdminList[i + 4]);
                            }
                        }
                    }
                    if ("number".equals(type)) {
                        for (int i = 0; i < AdminList.length - 2; i++) {
                            if (AdminList[i + 2].equals(key)) {
                                admin = new Admin(AdminList[i], AdminList[i + 1], AdminList[i + 2], AdminList[i + 3], AdminList[i + 4]);
                            }
                        }
                    }

                }
            }

            return admin;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param admin
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Override
    public boolean updateAdmin(Admin admin) throws ClassNotFoundException, IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] adminList = null;
            //first : read all data of file
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    adminList = line.split(":");
                }
            }

            //update 
            int updated = 0;
            for (int i = 0; i < adminList.length; i++) {
                if (adminList[i].equals(admin.getId())) {
                    updated = i;
                    adminList[i] = admin.getId();
                    adminList[i + 1] = admin.getName();
                    adminList[i + 2] = admin.getPhoneNumber();
                    adminList[i + 3] = admin.getPassword();
                    adminList[i + 4] = admin.getEmail();

                    i += 4;
                }
            }
            //write update data
            FileWriter fileWriter = new FileWriter(F1, false);
            for (int i = 0; i < adminList.length; i++) {
                fileWriter.write(cipher(adminList[i] + ":"));
                fileWriter.flush();
            }
            //read all data again and check wheather update or not
            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            String[] newAdminList = line.split(":");
            if (adminList.length == newAdminList.length) {//check array list size equal or not

                if (newAdminList[updated].equals(admin.getId())) {
                    if (newAdminList[updated + 1].equals(admin.getName())) {
                        if (newAdminList[updated + 2].equals(admin.getPhoneNumber())) {
                            if (newAdminList[updated + 3].equals(admin.getPassword())) {
                                if (newAdminList[updated + 4].equals(admin.getEmail())) {
                                    return true;
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } finally {
            READWRITELOCK.writeLock().unlock();
        }
    }

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<Admin> getAllAdmin() throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();

            Admin admin = null;
            FileReader reader = new FileReader(F1);
            ArrayList<Admin> adminList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);

            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (i % 5 == 0) {
                        admin = new Admin(split[i], split[i + 1], split[i + 2], split[i + 3], split[i + 4]);
                        adminList.add(admin);
                    }
                }
            }
            return adminList;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean searchId(String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            boolean ans = false;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] AdminList = line.split(":");

                    for (int i = 0; i < AdminList.length; i++) {
                        if (AdminList[i].equals(id)) {
                            ans = true;
                        }
                    }

                }
            }

            return ans;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param id
     * @param pass
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean checkPassword(String id, String pass) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            boolean ans = false;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] AdminList = line.split(":");

                    for (int i = 0; i < AdminList.length; i++) {
                        if (AdminList[i].equals(id)) {
                            if (AdminList[i + 3].equals(pass)) {
                                ans = true;
                            } else {
                                ans = false;
                            }
                        }
                    }

                }

            }
            return ans;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String getName(String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            String name = null;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] StudentList = line.split(":");

                    for (int i = 0; i < StudentList.length; i++) {
                        if (StudentList[i].equals(id)) {
                            name = StudentList[i + 1];
                        }
                    }
                }

            }

            return name;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String getEmail(String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            String email = null;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] StudentList = line.split(":");

                    for (int i = 0; i < StudentList.length; i++) {
                        if (StudentList[i].equals(id)) {
                            email = StudentList[i + 4];
                        }
                    }
                }

            }

            return email;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws IOException
     */
    @Override
    public boolean updateInstituteEmail(String email, String password) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            boolean ans = false;
            File f5 = new File("C:\\Users\\Ashan Tharuka\\Desktop\\NetBean 8.0.2\\ExamSimulater_Server\\Database\\Admin\\Email\\email.txt");
            fileWriter = new FileWriter(f5);

            String line = cipher(email + ":" + password);

            fileWriter.write(line);

            fileWriter.flush();

            FileReader reader = new FileReader(f5);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line1 = decipher(readLine);
            try {
                String[] split = line1.split(":");
                if (split[0].equals(email)) {
                    if (split[1].equals(password)) {
                        ans = true;
                    } else {
                        ans = false;
                    }
                } else {
                    ans = false;
                }

            } catch (NullPointerException ex) {
            }

            return ans;
        } finally {
            READWRITELOCK.writeLock().unlock();
        }

    }

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String getInstitueEmailPassword() throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            File f5 = new File("C:\\Users\\Ashan Tharuka\\Desktop\\NetBean 8.0.2\\ExamSimulater_Server\\Database\\Admin\\Email\\email.txt");

            String email = null;

            String line1 = null;
            if (f5.exists()) {
                FileReader reader = new FileReader(f5);
                BufferedReader bufferedReader = new BufferedReader(reader);
                try {
                    String readLine = bufferedReader.readLine();
                    line1 = decipher(readLine);
                } catch (NullPointerException ex) {
                }
                if (line1 != null) {
                    String[] emailList = line1.split(":");

                    email = emailList[0] + ":" + emailList[1];

                }

            }

            return email;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String getPasword(String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            String password = null;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] StudentList = line.split(":");

                    for (int i = 0; i < StudentList.length; i++) {
                        if (StudentList[i].equals(id)) {
                            password = StudentList[i + 3];
                        }
                    }
                }

            }

            return password;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

}
