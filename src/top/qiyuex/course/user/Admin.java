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
                3.批量添加课程
                4.批量删除课程
                5.按照选课人数排序
                6.显示课程清单
                7.修改授课教师
                8.显示学生列表
                9.显示教师列表
                10.恢复学生初始密码（初始密码为：123456）
                11.恢复教师初始密码（初始密码为：123456）
                12.添加老师
                13.添加学生
                14.删除老师
                15.删除学生""");
        int choice = stdIn.nextInt();
        // TODO: 完成管理员菜单功能
        switch (choice) {
            case 1 -> Courses.addCourse();
            case 2 -> Courses.delCourse();
            case 3 -> Courses.addCourses();
            case 4 -> Courses.delCourses();
            case 6 -> Courses.showCourses();
            case 8 -> Users.showAllStudent();
            case 9 -> Users.showAllTeacher();
            case 10 -> {
                System.out.println("请输入学号：");
                int stuID = stdIn.nextInt();
                Users.showStudent(stuID);
                User tmp = Users.findStudent(stuID);
                if (tmp != null) {
                    tmp.resetPassword();
                }
                System.out.println("密码重置成功！");
            }
            case 11 -> {
                System.out.println("请输入工号：");
                int workID = stdIn.nextInt();
                Users.showTeacher(workID);
                User tmp = Users.findTeacher(workID);
                if (tmp != null) {
                    tmp.resetPassword();
                }
                System.out.println("密码重置成功！");
            }
        }

    }
}
