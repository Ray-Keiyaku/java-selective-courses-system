package top.qiyuex.course.user;

// 管理员实体类
public class Admin extends User {
    public Admin(String name, String password) {
        super(name, password);
    }

    @Override
    public boolean login() {
        return true;
    }

    // TODO: 管理员用户菜单
    @Override
    public void userMenu() {

    }
}
