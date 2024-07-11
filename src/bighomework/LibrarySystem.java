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
    static Connection conn=null;
    static Statement stmt=null;
    static ResultSet rs=null;
    static CallableStatement cstmt=null;
    static PreparedStatement state=null;

//jjknjkbjbh

    public static void main(String[] args) throws SQLException {

        System.out.println("系统开始初始化****");
        Map<String, readers> readersMap=new HashMap<String,readers>();
        Map<String, books> booksMap=new HashMap<String,books>();

//        try{
//            Class.forName(JDBC_DRIVER);
//            conn= DriverManager.getConnection(DB_URL,USER,PASS);
//            stmt=conn.createStatement();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        readersMap=readermaps(readersMap);
        booksMap=bookmaps(booksMap);
//        序列化和反序列化知识点的展现
        try{
            File file=new File("D:\\Java\\readersMap.dat");
            FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(readersMap);
            oos.flush();
            oos.close();
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            File file=new File("D:\\Java\\readersMap.dat");
            FileInputStream fis=new FileInputStream(file);
            ObjectInputStream iis=new ObjectInputStream(fis);
            readersMap= (Map<String, readers>) iis.readObject();
//            System.out.println(readersMap);
            iis.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("系统初始化完成！");


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎使用图书馆系统：");
            System.out.println("1. 用户登录");
            System.out.println("2. 操作员登录");
            System.out.println("0. 退出");
            System.out.print("请选择（1/2/0）: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除换行符

            switch (choice) {
                case 1:
                    System.out.println("请输入用户账号：");
                    int userzh=scanner.nextInt();
                    System.out.println("请输入用户密码：");
                    int userpassword=scanner.nextInt();
                    if (userzh==666&&userpassword==123123)
                        userLogin(scanner,booksMap);
                    else System.out.println("账号或密码错误，请从新选择！");
                    break;
                case 2:
                    System.out.println("请输入操作员账号：");
                    int opzh=scanner.nextInt();
                    System.out.println("请输入操作员密码：");
                    int oppassword=scanner.nextInt();
                    if (opzh==666&&oppassword==123123)
                        operatorLogin(scanner,readersMap);
                    else System.out.println("账号或密码错误，请从新选择！");
                    break;
                case 0:
                    System.out.println("退出图书馆系统。");
                    System.exit(0);
                default:
                    System.out.println("无效输入，请重新选择。");
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

    private static void userLogin(Scanner scanner,Map<String, books> booksMap) {
        System.out.println("用户登录成功！");
        while (true) {
            System.out.println("请选择操作：");
            System.out.println("1. 查找图书");
            System.out.println("2. 借书");
            System.out.println("3. 还书");
            System.out.println("0. 退出");
            System.out.print("请输入选择（1/2/3/0）：");

            int userChoice = scanner.nextInt();
            scanner.nextLine(); // 清除换行符

            switch (userChoice) {
                case 1:
                    // 查找图书
                    selectbook(scanner,booksMap);
                    break;
                case 2:
                    // 借书
                    System.out.println("借书...");
                    lendbook(scanner);
                    break;
                case 3:
                    // 还书
                    stillbook(scanner);
                    break;
                case 0:
                    System.out.println("退出用户界面。");
                    return;
                default:
                    System.out.println("无效输入，请重新选择。");
                    break;
            }
        }
    }

    private static void selectbook(Scanner scanner,Map<String, books> booksMap){

        while (true) {
            System.out.println("请选择操作：");
            System.out.println("1、查看全部图书");
            System.out.println("2、根据出版社进行查找");
            System.out.println("3、根据价格进行查找");
            System.out.println("0. 退出");
            System.out.print("请输入选择（1/2/3/0）：");

            int userChoice = scanner.nextInt();
            scanner.nextLine(); // 清除换行符

            switch (userChoice) {
                case 1:
                    // 查看全部图书
                    for(String i:booksMap.keySet()){
                        System.out.println("编号："+i+
                                ",详细信息"+booksMap.get(i));
                    }
                    System.out.println("查找完成！");
                    break;
                case 2:
                    // 根据出版社进行查找
                    System.out.println("请输入出版社名称：");
                    String cbsname=scanner.nextLine();
                    for(String i:booksMap.keySet()){
                        if(cbsname.equals( booksMap.get(i).getBookcbs()))
                            System.out.println("编号："+i+
                                    ",详细信息"+booksMap.get(i));
                    }
                    System.out.println("查找完成！");
                    break;
                case 3:
                    // 根据价格进行查找
                    System.out.println("请输入最小价格：");
                    int min=scanner.nextInt();
                    System.out.println("请输入最大价格：");
                    int max=scanner.nextInt();
                    for(String i:booksMap.keySet()){
                        if(booksMap.get(i).getBookprice()>=min
                                &&booksMap.get(i).getBookprice()<=max)
                            System.out.println("编号："+i+
                                    ",详细信息"+booksMap.get(i));
                    }
                    System.out.println("查找完成！");
                    break;
                case 0:
                    System.out.println("退出查找界面。");
                    return;
                default:
                    System.out.println("无效输入，请重新选择。");
                    break;
            }
        }

    }

    private static void lendbook(Scanner scanner){
        String id;
        String ewm;
        System.out.println("请输入读者ID：");
        id=scanner.nextLine();
        System.out.println("请输入图书二维码号：");
        ewm=scanner.nextLine();
        try{
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);

            String sql="{ call p5(?,?)}";

            try{
                cstmt=conn.prepareCall(sql);
                cstmt.setString(1,id);
                cstmt.setString(2,ewm);
                cstmt.execute();
                //rs=cstmt.getResultSet();
                Date date=new Date();
                System.out.println("借书成功，时间为："+date);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        catch (SQLException se){
            se.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(cstmt!=null) stmt.close();
            }
            catch(SQLException se2){}// 什么都不做
            try{
                if(conn!=null) conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    private static void stillbook(Scanner scanner){
        try{

            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            String sql="update 借阅 set 实际归还时间=? where 读者ID = ? and 二维码号=?;";

            System.out.println("请输入读者编号：");
            String readerid=scanner.nextLine();
            System.out.println("请输入图书二维码：");
            String ewm=scanner.nextLine();
            //        获取当前的时间，并转化为MySQL中的date
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String dateStr=sdf.format(date);

            state=conn.prepareStatement(sql);
            state.setString(1,dateStr);
            state.setString(2,readerid);
            state.setString(3,ewm);

            System.out.println("还书成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void operatorLogin(Scanner scanner,Map<String, readers> readersMap) {
        System.out.println("操作员登录成功！");
        while (true) {
            System.out.println("请选择操作：");
            System.out.println("1. 添加图书");
            System.out.println("2. 删除图书");
            System.out.println("3. 更改图书价格");
            System.out.println("4. 展示全部读者信息");
            System.out.println("5. 添加读者");
            System.out.println("6. 更改读者信息（只能更改类别编号和读者电话）");
            System.out.println("7. 删除读者");
            System.out.println("0. 退出（及返回上一个界面）");
            System.out.print("请输入选择（0-7）：");

            int operatorChoice = scanner.nextInt();
            scanner.nextLine(); // 清除换行符

            switch (operatorChoice) {
                case 1:
                    insertbook(scanner);
                    System.out.println("添加图书...");
                    break;
                case 2:
                    // 删除图书
                    deletebook(scanner);
                    break;
                case 3:
                    // 更改图书
                    updatebook(scanner);
                    break;
                case 4:
                    // 展示全部读者信息
                    for(String i:readersMap.keySet()){
                        System.out.println("编号："+i+",详细信息"+readersMap.get(i));
                    }
                    break;
                case 5:
                    // 添加读者
                    insertreader(scanner);
                    break;
                case 6:
                    // 更改读者信息
                    updatareader(scanner);
                    break;
                case 7:
                    //   删除读者
                    deletereader(scanner);
                    break;
                case 0:
                    // 退出
                    System.out.println("退出操作员操作。");
                    return;
                default:
                    System.out.println("无效输入，请重新选择。");
                    break;
            }
        }
    }

    private static void insertbook(Scanner scanner){
        try{
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            String sql="insert into 图书 (图书名称, 图书编号, 作者, 出版社, 价格, 总数量, 剩余数量)" +
                    " VALUES(?,?,?,?,?,?,?);";
            state=conn.prepareStatement(sql);

            String x;
            int y;
            System.out.println("请输入图书名称：");
            x= scanner.nextLine();
            state.setString(1,x);
            System.out.println("请输入图书编号：");
            x= scanner.nextLine();
            state.setString(2,x);
            System.out.println("请输入作者：");
            x= scanner.nextLine();
            state.setString(3,x);
            System.out.println("请输入出版社：");
            x= scanner.nextLine();
            state.setString(4,x);
            System.out.println("请输入价格：");
            y= scanner.nextInt();
            state.setInt(5,y);
            System.out.println("请输入总数量：");
            y= scanner.nextInt();
            state.setInt(6,y);
            System.out.println("请输入剩余数量：");
            y= scanner.nextInt();
            state.setInt(7,y);

            state.executeUpdate();
//            System.out.println(state.executeUpdate());
            System.out.println("插入成功！");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void deletebook(Scanner scanner){
        try{
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            String sql="delete from 图书 where 图书编号=?;";
            state=conn.prepareStatement(sql);
            System.out.println("请输入需要删除的图书编号：");
            String x;
            x=scanner.nextLine();
            state.setString(1,x);
            state.executeUpdate();
            System.out.println("删除成功！");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void updatebook(Scanner scanner){
        try{
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            String sql="update 图书 set 价格=? where 图书编号=?;";
            state=conn.prepareStatement(sql);

            System.out.println("请输入需要修改的图书编号：");
            String x;
            x=scanner.nextLine();
            state.setString(2,x);
            System.out.println("请输入新的价格：");
            x=scanner.nextLine();
            state.setString(1,x);

            state.executeUpdate();
            System.out.println("修改成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void insertreader(Scanner scanner){
        try{
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            String sql="insert into 读者 (读者ID, 类别编号, 读者姓名, 读者电话, 性别, 借阅图书数量, 超时还书次数)" +
                    " VALUES(?,?,?,?,?,?,?);";
            state=conn.prepareStatement(sql);

            String x;
            int y;
            System.out.println("请输入读者ID：");
            x= scanner.nextLine();
            state.setString(1,x);
            System.out.println("请输入类别编号：");
            x= scanner.nextLine();
            state.setString(2,x);
            System.out.println("请输入读者姓名：");
            x= scanner.nextLine();
            state.setString(3,x);
            System.out.println("请输入读者电话：");
            x= scanner.nextLine();
            state.setString(4,x);
            System.out.println("请输入性别：");
            x= scanner.nextLine();
            state.setString(5,x);
            System.out.println("请输入借阅图书数量：");
            y= scanner.nextInt();
            state.setInt(6,y);
            System.out.println("请输入超时还书次数：");
            y= scanner.nextInt();
            state.setInt(7,y);

            state.executeUpdate();
//            System.out.println(state.executeUpdate(););
            System.out.println("插入成功！");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void updatareader(Scanner scanner){
        try{
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            String sql="update 读者 set 类别编号=?,读者电话=? where 读者ID=?;";
            state=conn.prepareStatement(sql);

            System.out.println("请输入需要修改的读者ID：");
            String x;
            x=scanner.nextLine();
            state.setString(3,x);
            System.out.println("请输入新的类别编号：");
            x=scanner.nextLine();
            state.setString(1,x);
            System.out.println("请输入新的电话号码：");
            x=scanner.nextLine();
            state.setString(2,x);

            state.executeUpdate();
            System.out.println("修改成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void deletereader(Scanner scanner){
        try{
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            String sql="delete from 读者 where 读者ID=?;";
            state=conn.prepareStatement(sql);
            System.out.println("请输入需要删除的读者ID：");
            String x;
            x=scanner.nextLine();
            state.setString(1,x);
            state.executeUpdate();
            System.out.println("删除成功！");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
