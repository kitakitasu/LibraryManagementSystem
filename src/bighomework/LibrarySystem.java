package bighomework;

import test7.readers;
import test7.books;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


public class LibrarySystem {
    //            初始化连接数据库
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/大作业?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "123456";
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static CallableStatement cstmt = null;
    static PreparedStatement state = null;


    public static void main(String[] args) throws SQLException {

        System.out.println("系统开始初始化****");
        Map<String, readers> readersMap = new HashMap<String, readers>();
        Map<String, books> booksMap = new HashMap<String, books>();

//        try{
//            Class.forName(JDBC_DRIVER);
//            conn= DriverManager.getConnection(DB_URL,USER,PASS);
//            stmt=conn.createStatement();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        readersMap = readermaps(readersMap);
        booksMap = bookmaps(booksMap);
//        序列化和反序列化知识点的展现
        try {
            File file = new File("D:\\Java\\readersMap.dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(readersMap);
            oos.flush();
            oos.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File file = new File("D:\\Java\\readersMap.dat");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream iis = new ObjectInputStream(fis);
            readersMap = (Map<String, readers>) iis.readObject();
//            System.out.println(readersMap);
            iis.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, readers> readermaps(Map<String, readers> readersMap) throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql1 = "select * from 读者;";
            String sql2 = "select * from 图书;";
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                readers reader = new readers(rs.getString("类别编号"),
                        rs.getString("读者姓名"),
                        rs.getString("读者电话"),
                        rs.getString("性别"),
                        rs.getInt("借阅图书数量"),
                        rs.getInt("超时还书次数"));
                readersMap.put(rs.getString("读者ID"), reader);
            }
//            rs=stmt.executeQuery(sql2);
//            while(rs.next()){
//                books book=new books(rs.getString("图书名称"),
//                        rs.getString("作者"),
//                        rs.getString("出版社"),
//                        rs.getInt("价格"),
//                        rs.getInt("总数量"),
//                        rs.getInt("剩余数量"));
//                booksMap.put(rs.getString("图书编号"),book);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            rs.close();
        }

        System.out.println("读者初始化完成！");
        return readersMap;
    }

    public static Map<String, books> bookmaps(Map<String, books> booksMap) throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql1 = "select * from 读者;";
            String sql2 = "select * from 图书;";
//            rs=stmt.executeQuery(sql1);
//            while(rs.next()){
//                readers reader=new readers(rs.getString("类别编号"),
//                        rs.getString("读者姓名"),
//                        rs.getString("读者电话"),
//                        rs.getString("性别"),
//                        rs.getInt("借阅图书数量"),
//                        rs.getInt("超时还书次数"));
//                readersMap.put(rs.getString("读者ID"),reader);
//            }
            rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                books book = new books(rs.getString("图书名称"),
                        rs.getString("作者"),
                        rs.getString("出版社"),
                        rs.getInt("价格"),
                        rs.getInt("总数量"),
                        rs.getInt("剩余数量"));
                booksMap.put(rs.getString("图书编号"), book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            rs.close();
        }

        System.out.println("图书初始化完成！");
        return booksMap;
    }

}
