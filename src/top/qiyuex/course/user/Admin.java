package top.qiyuex.course.user;

import top.qiyuex.course.data.Courses;
import top.qiyuex.course.data.Users;

// 管理员实体类
public class Admin extends User {
    public Admin(String name, String password) {
        super(name, password);
    }

    public boolean authName(String name) {
        if (this.getName().equals(name)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean login(String password) {
        if (this.getPassword().equals(password)) {
            System.out.printf("你好，管理员 %s，欢迎访问本系统！\n", this.getName());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void userMenu() {
        System.out.println("""
                菜单：
                1.添加课程
                2.删除课程
                3.按照选课人数排序
                4.显示课程清单
                5.修改授课教师
                6.显示学生列表
                7.显示教师列表
                8.恢复学生初始密码（初始密码为：123456）
                9.恢复教师初始密码（初始密码为：123456）
                10.添加老师
                11.添加学生
                12.删除老师
                13.删除学生""");
        int choice = stdIn.nextInt();
        switch (choice) {
            case 1 -> Courses.addCourses();
            case 2 -> Courses.delCourses();
            case 3 -> Courses.sortByNum();
            case 4 -> Courses.showCourses();
            case 5 -> Courses.changeTeacher();
            case 6 -> Users.showAllStudent();
            case 7 -> Users.showAllTeacher();
            case 8 -> Users.resetStuPass();
            case 9 -> Users.resetTeaPass();
            case 10 -> Users.addTeachers();
            case 11 -> Users.addStudents();
            case 12 -> Users.delTeacher();
            case 13 -> Users.delStudent();
        }

    }
}
