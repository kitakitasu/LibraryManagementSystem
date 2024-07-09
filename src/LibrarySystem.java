import java.util.Scanner;  
  
public class LibrarySystem {  
  
    public static void main(String[] args) {  
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
}
