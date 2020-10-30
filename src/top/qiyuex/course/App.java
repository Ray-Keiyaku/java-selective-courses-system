package top.qiyuex.course;

import top.qiyuex.course.data.Users;
import top.qiyuex.course.io.IO;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("""
                *******
                选课系统
                *******""");
        IO.loadAll();
        Users.loginMenu();
        IO.saveAll();
    }
}
