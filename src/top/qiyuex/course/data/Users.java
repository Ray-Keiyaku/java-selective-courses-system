package top.qiyuex.course.data;

import top.qiyuex.course.user.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    private static Admin adminUser = new Admin("admin", "admin");
    private static List<Student> studentUser = new ArrayList<>();
    private static List<Teacher> teacherUser = new ArrayList<>();
    private static User currentUser = null;
    private static Scanner stdIn = new Scanner(System.in);

    public static void showAllStudent() {
        System.out.printf("%6s %6s %6s\n", "学号", "姓名", "班级");
        for (Student it : studentUser) {
            System.out.println(it.show());
        }
    }

    public static Student findStudent(int stuID) {
        for (Student it : studentUser) {
            if (it.getStudentID() == stuID) {
                return it;
            }
        }
        return null;
    }

    public static void showStudent(int stuID) {
        Student it = findStudent(stuID);
        if (it != null) {
            System.out.printf("%6s %6s %6s\n", "学号", "姓名", "班级");
            System.out.println(it.show());
        } else {
            System.out.println("查无此学生！");
        }
    }

    // TODO: 增加提示符
    public static void showAllTeacher() {
        for (Student it : studentUser) {
            System.out.println(it.show());
        }
    }

    public static Teacher findTeacher(int workID) {
        for (Teacher it : teacherUser) {
            if (it.getWorkID() == workID) {
                return it;
            }
        }
        return null;
    }

    // TODO: 增加提示符
    public static void showTeacher(int teaID) {
        Teacher it = findTeacher(teaID);
        if (it != null) {
            System.out.println(it.show());
        } else {
            System.out.println("查无此教师！");
        }
    }

    // 恢复学生初始密码（初始密码为：123456）
    public static void resetStuPass() {
        System.out.println("请输入学号：");
        int stuID = stdIn.nextInt();
        Users.showStudent(stuID);
        User tmp = Users.findStudent(stuID);
        if (tmp != null) {
            tmp.resetPassword();
            System.out.println("密码重置成功！");
        }
    }

    // 恢复教师初始密码（初始密码为：123456）
    public static void resetTeaPass() {
        System.out.println("请输入工号：");
        int workID = stdIn.nextInt();
        Users.showTeacher(workID);
        User tmp = Users.findTeacher(workID);
        if (tmp != null) {
            tmp.resetPassword();
            System.out.println("密码重置成功！");
        }
    }

    // TODO: 添加教师
    // TODO：添加学生
    // TODO: 删除教师
    // TODO：删除学生

    public static void loginMenu() {
        System.out.println("请选择登录用户类型：");
        System.out.printf("1.管理员\n2.学生\n3.教职工\n");
        do {
            int choice = stdIn.nextInt();
            currentUser = switch (choice) {
                case 1 -> adminLogin();
                case 2 -> studentLogin();
                case 3 -> teacherLogin();
                default -> {
                    System.out.println("输入错误，请重新输入！");
                    yield null;
                }
            };
        } while (currentUser == null);
        currentUser.userMenu();
    }

    private static User adminLogin() {
        System.out.println("请输入管理员用户名：");
        String adminName = stdIn.next();
        System.out.println("请输入管理员密码：");
        String adminPass = stdIn.next();
        if (adminUser.authName(adminName) && adminUser.login(adminPass)) {
            return adminUser;
        } else {
            System.out.println("管理员用户名或密码错误，请重新输入");
            return null;
        }
    }

    private static User studentLogin() {
        System.out.println("请输入学号：");
        int stuID = stdIn.nextInt();
        System.out.println("请输入密码：");
        String stuPass = stdIn.next();
        User tmp = findStudent(stuID);
        if (tmp != null) {
            if (tmp.login(stuPass)) {
                return tmp;
            } else {
                return null;
            }
        } else {
            System.out.println("学号不存在，请重新输入");
            return null;
        }

    }

    private static User teacherLogin() {
        System.out.println("请输入工号：");
        int workID = stdIn.nextInt();
        System.out.println("请输入密码：");
        String teaPass = stdIn.next();
        User tmp = findStudent(workID);
        if (tmp != null) {
            if (tmp.login(teaPass)) {
                return tmp;
            } else {
                return null;
            }
        } else {
            System.out.println("工号不存在，请重新输入");
            return null;
        }
    }
}
