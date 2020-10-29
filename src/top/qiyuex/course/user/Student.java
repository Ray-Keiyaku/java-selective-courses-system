package top.qiyuex.course.user;

// 学生实体类
public class Student extends User {
    private int studentID;
    private String className;

    public Student(String name, String password, int studentID, String className) {
        super(name, password);
        this.studentID = studentID;
        this.className = className;
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public boolean login(String password) {
        if (this.getPassword().equals(password)) {
            System.out.printf("你好，%s %s，欢迎访问本系统！\n", this.className, this.getName());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String show() {
        return String.format("%6d", this.studentID) + super.show() + String.format("%6s", this.className);
    }

    @Override
    public void userMenu() {
        System.out.println("""
                菜单：
                1.修改登录密码
                2.查看自己所上课程
                3.选修课选课""");
        int choice = stdIn.nextInt();
        switch (choice) {
            // TODO: 完成学生菜单功能
        }
    }

}
