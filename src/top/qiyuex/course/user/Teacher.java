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
    public boolean login() {
        return true;
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
