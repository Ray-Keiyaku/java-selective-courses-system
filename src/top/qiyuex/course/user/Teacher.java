package top.qiyuex.course.user;

// 教师实体类
public class Teacher extends User {
    private int workID;
    private String level;

    public Teacher(String name, String password, int workID, String level) {
        super(name, password);
        this.workID = workID;
        this.level = level;
    }

    public int getWorkID() {
        return workID;
    }

    @Override
    public boolean login(String password) {
        if (this.getPassword().equals(password)) {
            System.out.printf("你好，%s %s，欢迎访问本系统！\n", this.getName(), this.level);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String show() {
        return String.format("%6d", this.workID) + super.show() + String.format("%6s", this.level);
    }

    @Override
    public void userMenu() {
        System.out.println("""
                菜单：
                1.修改登录密码
                2.查看所授课程
                3.查看所授课程的学生列表""");
        int choice = stdIn.nextInt();
        switch (choice) {
            // TODO: 完成教师菜单功能
        }
    }
}
