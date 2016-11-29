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
    private String driver = "com.mysql.jdbc.Driver";
    private String pgDriver = "org.postgresql.Driver";

    public void getInitSetting() {
        try {
            Class.forName(driver);
            Class.forName(pgDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if (mysqlConn == null) {
                mysqlConn = DriverManager.getConnection("jdbc:mysql://27.102.82.128:3306/license", "mailadm", "secret");
            }

            if (pgsqlConn == null) {
                pgsqlConn = DriverManager.getConnection("jdbc:postgresql://27.102.82.218:5432/license", "postgres", "apdlf!@");
            }

            pgsqlConn.setAutoCommit(false);//비활성화

            if (mysqlConn != null) {
                System.out.println("MYSQL Connect Success!");
            } else {
                System.out.println("MYSQL Connect Fail!");
            }

            if (pgsqlConn != null) {
                System.out.println("PostgreSQL Connect Success!");
            } else {
                System.out.println("PostgreSQL Connect Fail!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }

            if (mysqlPsmt != null) {
                mysqlPsmt.close();
            }

            //connection close
            if (mysqlConn != null) {
                mysqlConn.close();
            }

            if (pgsqlConn != null) {
                mysqlConn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLicenseFile() {
        ResultSet rs = null;
        try {
            mysqlConn = DriverManager.getConnection("jdbc:mysql://27.102.82.128:3306/license", "mailadm", "secret");
            pgsqlConn = DriverManager.getConnection("jdbc:postgresql://172.22.1.103:5432/license", "mailadm", "secret");


            int max = 48231;    //select count(no) from License; query reslut!
            int count = 0;

            for (int i = 0; i < max + 1000; i = i + 1000) {
                mysqlPsmt = mysqlConn.prepareStatement("select * from admin where ? < no and no < ?");
                mysqlPsmt.setInt(1, i);
                mysqlPsmt.setInt(2, i + 1000);
                rs = mysqlPsmt.executeQuery();

                while (rs.next()) {
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
                    } catch (Exception e) {
                        System.out.println("ERR - line : " + count);
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setAdminTable() {
        getInitSetting();
        try {
            int max;// = 113;	//select count(no) from License; query reslut!
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from Admin");
            rs = mysqlPsmt.executeQuery();

            while (rs.next()) {
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
                } catch (Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setCodeControllTable() {
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from CodeControl");
            rs = mysqlPsmt.executeQuery();

            while (rs.next()) {
                //System.out.println("Insert start - line : " + count++);
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into codecontrol values(?, ?, ?, ?)");
                    pgsqlPsmt.setString(1, rs.getString(1));
                    pgsqlPsmt.setString(2, rs.getString(2));
                    pgsqlPsmt.setString(3, rs.getString(3));
                    pgsqlPsmt.setString(4, rs.getString(4));
                    int i = pgsqlPsmt.executeUpdate();
                    count = count + i;
                } catch (Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setPartnerGroupTable() {
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from PartnerGroup");
            rs = mysqlPsmt.executeQuery();

            while (rs.next()) {
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
                } catch (Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setClientTable() {
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from Client");
            rs = mysqlPsmt.executeQuery();

            while (rs.next()) {
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
                } catch (Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setGradeTable() {
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from Grade");
            rs = mysqlPsmt.executeQuery();

            while (rs.next()) {
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into grade values(?, ?, ?, ?)");
                    pgsqlPsmt.setInt(1, rs.getInt(1));
                    pgsqlPsmt.setString(2, rs.getString(2));
                    pgsqlPsmt.setString(3, rs.getString(3));
                    pgsqlPsmt.setString(4, rs.getString(4));
                    int i = pgsqlPsmt.executeUpdate();
                    count = count + i;
                } catch (Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setPartTable() {
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from Part");
            rs = mysqlPsmt.executeQuery();

            while (rs.next()) {
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
                } catch (Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setMachineTable() {
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from Machine");
            rs = mysqlPsmt.executeQuery();

            while (rs.next()) {
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into machine values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                                                                                    " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                                                                                    " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                                                                                    " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                                                                                    " ?, ?, ?" +
                                                                                    ")");
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
                    pgsqlPsmt.setString(11, rs.getString(11));
                    pgsqlPsmt.setString(12, rs.getString(12));
                    pgsqlPsmt.setString(13, rs.getString(13));
                    pgsqlPsmt.setString(14, rs.getString(14));
                    pgsqlPsmt.setString(15, rs.getString(15));
                    pgsqlPsmt.setString(16, rs.getString(16));
                    pgsqlPsmt.setString(17, rs.getString(17));
                    pgsqlPsmt.setString(18, rs.getString(18));
                    pgsqlPsmt.setString(19, rs.getString(19));
                    pgsqlPsmt.setString(20, rs.getString(20));
                    pgsqlPsmt.setString(21, rs.getString(21));
                    pgsqlPsmt.setString(22, rs.getString(22));
                    pgsqlPsmt.setString(23, rs.getString(23));
                    pgsqlPsmt.setString(24, rs.getString(24));
                    pgsqlPsmt.setString(25, rs.getString(25));
                    pgsqlPsmt.setString(26, rs.getString(26));
                    pgsqlPsmt.setString(27, rs.getString(27));
                    pgsqlPsmt.setString(28, rs.getString(28));
                    pgsqlPsmt.setString(29, rs.getString(29));
                    pgsqlPsmt.setString(30, rs.getString(30));
                    pgsqlPsmt.setString(31, rs.getString(31));
                    pgsqlPsmt.setString(32, rs.getString(32));
                    pgsqlPsmt.setString(33, rs.getString(33));
                    pgsqlPsmt.setString(34, rs.getString(34));
                    pgsqlPsmt.setString(35, rs.getString(35));
                    pgsqlPsmt.setString(36, rs.getString(36));
                    pgsqlPsmt.setString(37, rs.getString(37));
                    pgsqlPsmt.setString(38, rs.getString(38));
                    pgsqlPsmt.setString(39, rs.getString(39));
                    pgsqlPsmt.setString(40, rs.getString(40));
                    pgsqlPsmt.setString(41, rs.getString(41));
                    pgsqlPsmt.setString(42, rs.getString(42));
                    pgsqlPsmt.setString(43, rs.getString(43));
                    int i = pgsqlPsmt.executeUpdate();
                    count = count + i;
                } catch (Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
            System.out.println("line : " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setMachineStateTable() {
        getInitSetting();
        try {
            int count = 0;

            mysqlPsmt = mysqlConn.prepareStatement("select * from (select * from MachineState order by inputDate desc) m group by m.serialKey");
            rs = mysqlPsmt.executeQuery();

            while (rs.next()) {
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("insert into machinestate values(?, ?, ?, ?, ?, ?)");
                    pgsqlPsmt.setString(1, rs.getString(2));
                    pgsqlPsmt.setString(2, rs.getString(3));
                    pgsqlPsmt.setString(3, rs.getString(4));
                    pgsqlPsmt.setString(4, rs.getString(5));
                    pgsqlPsmt.setString(5, rs.getString(6));
                    pgsqlPsmt.setString(6, rs.getString(7));
                    int j = pgsqlPsmt.executeUpdate();
                    count = count + j;
                } catch (Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
                pgsqlConn.commit();
                System.out.println("line : " + count);
            } catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
    }

    public void deleteLicenseTableAllData() {
        getInitSetting();
        try {
            int count = 0;
            pgsqlPsmt = pgsqlConn.prepareStatement("select * from license");
            rs = pgsqlPsmt.executeQuery();

            while(rs.next()) {
                System.out.println("Delete start - line : " + count++);
                try {
                    pgsqlPsmt = pgsqlConn.prepareStatement("DELETE FROM license where no = ?");
                    pgsqlPsmt.setInt(1, rs.getInt(10));
                    pgsqlPsmt.executeUpdate();
                } catch(Exception e) {
                    System.out.println("ERR - line : " + count);
                    e.printStackTrace();
                }
            }
            pgsqlConn.commit();
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
    }

    public void setLicenseTable() {
        getInitSetting();
        try {
            int count = 0;
            int max = 48231;

            for(int i = 40000; i<max + 10000; i =  i+10000) {
                mysqlPsmt = mysqlConn.prepareStatement("select * from License where ? < no and no < ?");
                mysqlPsmt.setInt(1, i);
                mysqlPsmt.setInt(2, i+10000);
                rs = mysqlPsmt.executeQuery();

                while(rs.next()) {
                    System.out.println("Insert start - line : " + count++);
                    try {
                        ResultSet condition;
                        mysqlPsmt = mysqlConn.prepareStatement("select max(licenseStartDate) from License where serialKey = ?");
                        mysqlPsmt .setString(1, rs.getString(2));
                        condition = mysqlPsmt.executeQuery();

                        if(condition.next()){
                            if(condition.getString(1).equals(rs.getString(5))){
                                pgsqlPsmt = pgsqlConn.prepareStatement("insert into license values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
                            }
                        }
                    } catch(Exception e) {
                        System.out.println("ERR - line : " + count);
                        e.printStackTrace();
                    } finally {
                        mysqlPsmt.close();
                        if(pgsqlPsmt != null){
                            pgsqlPsmt.close();
                        }
                    }
                }
                pgsqlConn.commit();
            }

            //System.out.println("line : " + count);
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
    }
}