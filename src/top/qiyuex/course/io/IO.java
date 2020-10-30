package top.qiyuex.course.io;

import top.qiyuex.course.data.Courses;
import top.qiyuex.course.data.StudentCourses;
import top.qiyuex.course.data.Users;

public class IO {
    // 保存所有数据到文件
    public static void saveAll() {
        Users.studentSave();
        Users.teacherSave();
        Courses.save();
        StudentCourses.save();
    }

    // 从文件读取所有数据
    public static void loadAll() {
        Users.studentLoad();
        Users.teacherLoad();
        Courses.load();
        StudentCourses.load();
    }
}
