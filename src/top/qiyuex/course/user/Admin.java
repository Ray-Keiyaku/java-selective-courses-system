package top.qiyuex.course.user;

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
            System.out.printf("你好，管理员 %s，欢迎访问本系统！", this.getName());
            return true;
        } else {
            return false;
        }
    }

    // TODO: 管理员用户菜单
    @Override
    public void userMenu() {

    }
}
