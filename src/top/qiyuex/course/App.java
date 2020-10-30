package top.qiyuex.course;

import top.qiyuex.course.data.Users;
import top.qiyuex.course.io.IO;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        IO.loadAll();
        Users.loginMenu();
        IO.saveAll();
    }
}
