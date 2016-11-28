package com.daou.terracelicense.util;

import java.sql.*;

/**
 * Created by user on 2016-11-28.
 */
public class DataBaseMigration {
    private Connection mysqlConn = null;
    private PreparedStatement mysqlPsmt = null;
    private Connection pgsqlConn = null;
    private PreparedStatement pgsqlPsmt = null;
    ResultSet rs = null;
    private String driver="com.mysql.jdbc.Driver";
    private String pgDriver="org.postgresql.Driver";

    public void getInitSetting(){
        try{
            Class.forName(driver);
            Class.forName(pgDriver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            if(mysqlConn == null){
                mysqlConn = DriverManager.getConnection("jdbc:mysql://27.102.82.128:3306/license","mailadm", "secret");
            }

            if(pgsqlConn == null){
                pgsqlConn = DriverManager.getConnection("jdbc:postgresql://27.102.82.218:5432/license","postgres", "apdlf!@");
            }

            pgsqlConn.setAutoCommit(false);//비활성화

            if(mysqlConn != null){
                System.out.println("MYSQL Connect Success!");
            }else{
                System.out.println("MYSQL Connect Fail!");
            }

            if(pgsqlConn != null){
                System.out.println("PostgreSQL Connect Success!");
            }else{
                System.out.println("PostgreSQL Connect Fail!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try{
            if(rs != null) {
                rs.close();
            }

            if(mysqlPsmt != null) {
                mysqlPsmt.close();
            }

            //connection close
            if(mysqlConn != null){
                mysqlConn.close();
            }

            if(pgsqlConn != null){
                mysqlConn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setLicenseFile(){
        ResultSet rs = null;
        try {
            mysqlConn = DriverManager.getConnection("jdbc:mysql://27.102.82.128:3306/license","mailadm", "secret");
            pgsqlConn = DriverManager.getConnection("jdbc:postgresql://172.22.1.103:5432/license","mailadm", "secret");


            int max = 48231;	//select count(no) from License; query reslut!
            int count = 0;

            for(int i = 0; i<max + 1000; i =  i+1000) {
                mysqlPsmt = mysqlConn.prepareStatement("select * from admin where ? < no and no < ?");
                mysqlPsmt.setInt(1, i);
                mysqlPsmt.setInt(2, i+1000);
                rs = mysqlPsmt.executeQuery();

                while(rs.next()) {
                    System.out.println("Insert start - line : " + count++);
                    try {
                        pgsqlPsmt = pgsqlConn.prepareStatement("insert into admin values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        pgsqlPsmt.setInt(1, rs.getInt(1));
                        pgsqlPsmt.setString(2, rs.getString(2));
                        pgsqlPsmt.setString(3, rs.getString(3));
                        pgsqlPsmt.setString(4, rs.getString(4));
                        pgsqlPsmt.setString(5, rs.getString(5));
                        pgsqlPsmt.setString(6, rs.getString(6));
                        pgsqlPsmt.setString(7, rs.getString(7));
                        pgsqlPsmt.setBinaryStream(8, rs.getBlob(8).getBinaryStream());
                        pgsqlPsmt.setString(9, rs.getString(9));
                        pgsqlPsmt.setString(10, rs.getString(10));
                        pgsqlPsmt.executeUpdate();
                    } catch(Exception e) {
                        System.out.println("ERR - line : " + count);
                        e.printStackTrace();
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
    }

    public void setAdminTable(){
        getInitSetting();
        try {
            int max;// = 113;	//select count(no) from License; query reslut!
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from Admin");
            rs = mysqlPsmt.executeQuery();

            while(rs.next()) {
                System.out.println("Insert start - line : " + count++);
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into admin values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    pgsqlPsmt.setString(1, rs.getString(1));
                    pgsqlPsmt.setString(2, rs.getString(2));
                    pgsqlPsmt.setString(3, rs.getString(3));
                    pgsqlPsmt.setString(4, rs.getString(4));
                    pgsqlPsmt.setString(5, rs.getString(5));
                    pgsqlPsmt.setString(6, rs.getString(6));
                    pgsqlPsmt.setString(7, rs.getString(7));
                    pgsqlPsmt.setString(8, rs.getString(8));
                    pgsqlPsmt.setString(9, rs.getString(9));
                    pgsqlPsmt.setString(10, rs.getString(10));
                    pgsqlPsmt.executeUpdate();
                } catch(Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
    }

    public void setCodeControllTable(){
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from CodeControl");
            rs = mysqlPsmt.executeQuery();

            while(rs.next()) {
                //System.out.println("Insert start - line : " + count++);
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into codecontrol values(?, ?, ?, ?)");
                    pgsqlPsmt.setString(1, rs.getString(1));
                    pgsqlPsmt.setString(2, rs.getString(2));
                    pgsqlPsmt.setString(3, rs.getString(3));
                    pgsqlPsmt.setString(4, rs.getString(4));
                    int i = pgsqlPsmt.executeUpdate();
                    count = count + i;
                } catch(Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
    }

    public void setPartnerGroupTable(){
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from PartnerGroup");
            rs = mysqlPsmt.executeQuery();

            while(rs.next()) {
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into partnergroup values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    pgsqlPsmt.setString(1, rs.getString(1));
                    pgsqlPsmt.setString(2, rs.getString(2));
                    pgsqlPsmt.setString(3, rs.getString(3));
                    pgsqlPsmt.setString(4, rs.getString(4));
                    pgsqlPsmt.setString(5, rs.getString(5));
                    pgsqlPsmt.setString(6, rs.getString(6));
                    pgsqlPsmt.setString(7, rs.getString(7));
                    pgsqlPsmt.setString(8, rs.getString(8));
                    pgsqlPsmt.setString(9, rs.getString(9));
                    pgsqlPsmt.setString(10, rs.getString(10));
                    int i = pgsqlPsmt.executeUpdate();
                    count = count + i;
                } catch(Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
    }

    public void setClientTable(){
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from Client");
            rs = mysqlPsmt.executeQuery();

            while(rs.next()) {
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into client values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    pgsqlPsmt.setString(1, rs.getString(1));
                    pgsqlPsmt.setString(2, rs.getString(2));
                    pgsqlPsmt.setString(3, rs.getString(3));
                    pgsqlPsmt.setString(4, rs.getString(4));
                    pgsqlPsmt.setString(5, rs.getString(5));
                    pgsqlPsmt.setString(6, rs.getString(6));
                    pgsqlPsmt.setString(7, rs.getString(7));
                    pgsqlPsmt.setString(8, rs.getString(8));
                    pgsqlPsmt.setString(9, rs.getString(9));
                    pgsqlPsmt.setString(10, rs.getString(10));
                    int i = pgsqlPsmt.executeUpdate();
                    count = count + i;
                } catch(Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
    }

    public void setGradeTable(){
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from Grade");
            rs = mysqlPsmt.executeQuery();

            while(rs.next()) {
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into grade values(?, ?, ?, ?)");
                    pgsqlPsmt.setInt(1, rs.getInt(1));
                    pgsqlPsmt.setString(2, rs.getString(2));
                    pgsqlPsmt.setString(3, rs.getString(3));
                    pgsqlPsmt.setString(4, rs.getString(4));
                    int i = pgsqlPsmt.executeUpdate();
                    count = count + i;
                } catch(Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
    }

    public void setPartTable(){
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from Part");
            rs = mysqlPsmt.executeQuery();

            while(rs.next()) {
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into part values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    pgsqlPsmt.setInt(1, rs.getInt(1));
                    pgsqlPsmt.setString(2, rs.getString(2));
                    pgsqlPsmt.setString(3, rs.getString(3));
                    pgsqlPsmt.setString(4, rs.getString(4));
                    pgsqlPsmt.setString(5, rs.getString(5));
                    pgsqlPsmt.setString(6, rs.getString(6));
                    pgsqlPsmt.setString(7, rs.getString(7));
                    pgsqlPsmt.setString(8, rs.getString(8));
                    pgsqlPsmt.setString(9, rs.getString(9));
                    pgsqlPsmt.setString(10, rs.getString(10));
                    pgsqlPsmt.setString(11, rs.getString(11));
                    pgsqlPsmt.setString(12, rs.getString(12));
                    pgsqlPsmt.setString(13, rs.getString(13));
                    int i = pgsqlPsmt.executeUpdate();
                    count = count + i;
                } catch(Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
    }

    public void setMachineStateTable(){
        /*getInitSetting();
        try {
            int max = 48231;	//select count(no) from License; query reslut!
            int count = 0;

            for(int i = 0; i<max + 1000; i =  i+1000) {
                mysqlPsmt = mysqlConn.prepareStatement("select * from admin where ? < no and no < ?");
                mysqlPsmt.setInt(1, i);
                mysqlPsmt.setInt(2, i+1000);
                rs = mysqlPsmt.executeQuery();

            mysqlPsmt = mysqlConn.prepareStatement("select * from MachineState");
            rs = mysqlPsmt.executeQuery();

            while(rs.next()) {
                try {
                    if()
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into part values(?, ?, ?, ?, ?, ?)");
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into part values(?, ?, ?, ?, ?, ?)");
                    pgsqlPsmt.setInt(1, rs.getInt(1));
                    pgsqlPsmt.setString(2, rs.getString(2));
                    pgsqlPsmt.setString(3, rs.getString(3));
                    pgsqlPsmt.setString(4, rs.getString(4));
                    pgsqlPsmt.setString(5, rs.getString(5));
                    pgsqlPsmt.setString(6, rs.getString(6));
                    int i = pgsqlPsmt.executeUpdate();
                    count = count + i;
                } catch(Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
    }*/
}
