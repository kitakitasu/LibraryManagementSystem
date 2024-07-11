/**
 * 数据初始化
 */
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

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/大作业?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "123456";
    static Connection conn=null;
    static Statement stmt=null;
    static ResultSet rs=null;
    static CallableStatement cstmt=null;
    static PreparedStatement state=null;


    public static void main(String[] args) throws SQLException{
        System.out.println("系统开始初始化****");
        Map<String, readers> readersMap=new HashMap<String,readers>();
        Map<String, books> booksMap=new HashMap<String,books>();

        readersMap=readermaps(readersMap);
        booksMap=bookmaps(booksMap);



        System.out.println("系统初始化完成！");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("欢迎使用图书馆系统：");
            System.out.println("1. 用户登录");
            System.out.println("2. 操作员登录");
            System.out.println("3. 退出");
            System.out.print("请选择（1/2/3）: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除换行符  

            switch (choice) {
                case 1:
                    userLogin(scanner);
                    break;
                case 2:
                    operatorLogin(scanner);
                    break;
                case 3:
                    System.out.println("退出图书馆系统。");
                    System.exit(0);
                default:
                    System.out.println("无效输入，请重新选择。");
            }
        }
    }

    private static void userLogin(Scanner scanner) {
        System.out.println("用户登录成功！");
        while (true) {
            System.out.println("请选择操作：");
            System.out.println("1. 查找相关图书");
            System.out.println("2. 借书");
            System.out.println("3. 还书");
            System.out.print("请输入选择（1/2/3），输入其他退出：");

            int userChoice = scanner.nextInt();
            scanner.nextLine(); // 清除换行符  

            switch (userChoice) {
                case 1:
                    // 查找图书  
                    System.out.println("查找图书...");
                    break;
                case 2:
                    // 借书  
                    System.out.println("借书...");
                    break;
                case 3:
                    // 还书  
                    System.out.println("还书...");
                    break;
                default:
                    System.out.println("退出用户操作。");
                    return;
            }
        }
    }

    private static void operatorLogin(Scanner scanner) {
        System.out.println("操作员登录成功！");
        while (true) {
            System.out.println("请选择操作：");
            System.out.println("1. 添加图书");
            System.out.println("2. 删除图书");
            System.out.println("3. 更改图书");
            System.out.println("4. 添加读者");
            System.out.println("5. 更改读者信息");
            System.out.println("6. 删除读者");
            System.out.println("7. 退出（及返回上一个界面）");
            System.out.print("请输入选择（1-7），输入其他退出：");

            int operatorChoice = scanner.nextInt();
            scanner.nextLine(); // 清除换行符  

            switch (operatorChoice) {
                case 1:
                    // 添加图书  
                    System.out.println("添加图书...");
                    break;
                case 2:
                    // 删除图书  
                    System.out.println("删除图书...");
                    break;
                case 3:
                    // 更改图书  
                    System.out.println("更改图书...");
                    break;
                case 4:
                    // 添加读者  
                    System.out.println("添加读者...");
                    break;
                case 5:
                    // 更改读者信息  
                    System.out.println("更改读者信息...");
                    break;
                case 6:
                    // 删除读者  
                    System.out.println("删除读者...");
                    break;
                case 7:
                    // 退出  
                    System.out.println("退出操作员操作。");
                    return;
                default:
                    System.out.println("退出操作员操作。");
                    return;
            }
        }
    }



    public static Map<String, readers> readermaps(Map<String, readers> readersMap) throws SQLException {
        try{
            Class.forName(JDBC_DRIVER);
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            stmt=conn.createStatement();
            String sql1="select * from 读者;";
            String sql2="select * from 图书;";
            rs=stmt.executeQuery(sql1);
            while(rs.next()){
                readers reader=new readers(rs.getString("类别编号"),
                        rs.getString("读者姓名"),
                        rs.getString("读者电话"),
                        rs.getString("性别"),
                        rs.getInt("借阅图书数量"),
                        rs.getInt("超时还书次数"));
                readersMap.put(rs.getString("读者ID"),reader);
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
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
            rs.close();
        }

        System.out.println("读者初始化完成！");
        return readersMap;
    }

    public static Map<String, books> bookmaps(Map<String, books> booksMap) throws SQLException {
        try{
            Class.forName(JDBC_DRIVER);
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            stmt=conn.createStatement();
            String sql1="select * from 读者;";
            String sql2="select * from 图书;";
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
            rs=stmt.executeQuery(sql2);
            while(rs.next()){
                books book=new books(rs.getString("图书名称"),
                        rs.getString("作者"),
                        rs.getString("出版社"),
                        rs.getInt("价格"),
                        rs.getInt("总数量"),
                        rs.getInt("剩余数量"));
                booksMap.put(rs.getString("图书编号"),book);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
            rs.close();
        }

        System.out.println("图书初始化完成！");
        return booksMap;
    }
}