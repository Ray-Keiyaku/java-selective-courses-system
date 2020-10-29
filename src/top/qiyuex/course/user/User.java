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

    public String show() {
        return String.format("%6s ", this.name);
    }

    public void resetPassword() {
        this.password = "123456";
    }

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

    public abstract boolean login(String password);

    public abstract void userMenu();

    protected String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }
}
