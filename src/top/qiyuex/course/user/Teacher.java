package top.qiyuex.course.user;

import top.qiyuex.course.data.Courses;

// 教师实体类
public class Teacher extends User {
    private int workID;
    private String level;

    public Teacher(String name, String password, int workID, String level) {
        super(name, password);
        this.workID = workID;
        this.level = level;
    }

    // 返回教师工号
    public int getWorkID() {
        return workID;
    }

    // 教师登录
    @Override
    public boolean login(String password) {
        if (this.getPassword().equals(password)) {
            System.out.printf("你好，%s %s，欢迎访问本系统！\n", this.getName(), this.level);
            return true;
        } else {
            return false;
        }
    }

    // 返回格式化的教师信息，用于在终端输出
    @Override
    public String show() {
        return String.format("%6d", this.workID) + super.show() + String.format("%6s", this.level);
    }

    // 教师菜单
    @Override
    public void userMenu() {
        while (true) {
            System.out.println("""
                    菜单：
                    1.修改登录密码
                    2.查看所授课程
                    3.查看所授课程的学生列表
                    4.退出系统""");
            int choice = stdIn.nextInt();
            switch (choice) {
                case 1 -> this.setPassword();
                case 2 -> Courses.showCourseByTeacher(this.workID);
                case 3 -> Courses.showCourseStusByTeacher(this.workID);
                case 4 -> {
                    return;
                }
                default -> System.out.println("输入错误，请重新输入！");
            }
        }
    }
}
