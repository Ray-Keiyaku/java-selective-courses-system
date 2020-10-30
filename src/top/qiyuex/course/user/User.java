package top.qiyuex.course.user;

import java.util.Scanner;

// 用户类
public abstract class User {
    private String name;
    private String password;
    protected Scanner stdIn = new Scanner(System.in);

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // 返回格式化的用户信息，用于在终端输出
    public String show() {
        return String.format("%6s ", this.name);
    }

    // 重写toString方法，用于数据持久化
    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.password);
    }

    // 重置用户密码
    public void resetPassword() {
        this.password = "123456";
    }

    // 修改（设置）用户密码
    public void setPassword() {
        String passInputFirst, passInputTwice;
        do {
            System.out.println("请输入新密码（16位以内）：");
            passInputFirst = stdIn.next();
            System.out.println("请再次输入密码：");
            passInputTwice = stdIn.next();
        } while (!passInputFirst.equals(passInputTwice) || passInputFirst.length() > 16);
        this.password = passInputFirst;
    }

    // 用户登录方法
    public abstract boolean login(String password);

    // 用户菜单
    public abstract void userMenu();

    // 返回当前用户密码
    protected String getPassword() {
        return this.password;
    }

    // 返回当前用户姓名
    public String getName() {
        return this.name;
    }
}
