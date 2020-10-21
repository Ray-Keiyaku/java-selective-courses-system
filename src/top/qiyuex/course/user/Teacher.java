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
            System.out.printf("你好，%s %s，欢迎访问本系统！", this.getName(), this.level);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String show() {
        return String.format("%6d", this.workID) + super.show() + String.format("%6s", this.level);
    }

    // TODO: 教师用户菜单
    @Override
    public void userMenu() {

    }
}
