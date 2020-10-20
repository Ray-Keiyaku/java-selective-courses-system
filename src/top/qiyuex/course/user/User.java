package top.qiyuex.course.user;

import java.util.Scanner;

// 用户类
public abstract class User {
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String show() {
        return String.format("%6s ", this.name);
    }

    public void setPassWord() {
        Scanner scanner = new Scanner(System.in);
        String passInputFirst, passInputTwice;
        do {
            System.out.println("请输入新密码（16位以内）：");
            passInputFirst = scanner.next();
            System.out.println("请再次输入密码：");
            passInputTwice = scanner.next();
        } while (!passInputFirst.equals(passInputTwice) || passInputFirst.length() > 16);
        scanner.close();
        this.password = passInputFirst;
    }

    public abstract boolean login();

    public abstract void userMenu();

    protected String getPassword() {
        return this.password;
    }

    protected String getName() {
        return this.name;
    }
}
