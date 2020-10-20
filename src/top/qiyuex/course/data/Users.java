package top.qiyuex.course.data;

import top.qiyuex.course.user.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    private static User adminUser = new Admin("admin", "admin");
    private static List<Student> studentUser = new ArrayList<>();
    private static List<Teacher> teacherUser = new ArrayList<>();

    public static void showAllStudent() {
        for (Student it : studentUser) {
            System.out.println(it.show());
        }
    }

    private static Student findStudent(int stuID) {
        for (Student it : studentUser) {
            if (it.getStudentID() == stuID) {
                return it;
            }
        }
        return new Student(null, null, 00000000, null);
    }

    public static void showStudent(int stuID) {
        Student it = findStudent(stuID);
        if (it.getStudentID() != 0) {
            System.out.println(it.show());
        } else {
            System.out.println("查无此学生！");
        }
    }

    public static void showAllTeacher() {
        for (Student it : studentUser) {
            System.out.println(it.show());
        }
    }

    private static Teacher findTeacher(int teaID) {
        for (Teacher it : teacherUser) {
            if (it.getWorkID() == teaID) {
                return it;
            }
        }
        return new Teacher(null, null, 00000000, null);
    }

    public static void showTeacher(int teaID) {
        Teacher it = findTeacher(teaID);
        if (it.getWorkID() != 0) {
            System.out.println(it.show());
        } else {
            System.out.println("查无此教师！");
        }
    }

    // TODO: 登陆菜单
    public static void loginMenu() {
        System.out.println("请选择登录用户类型：");
        System.out.printf("1.管理员\n2.学生\n3.教职工\n");

    }
    // TODO: 登陆函数

}
