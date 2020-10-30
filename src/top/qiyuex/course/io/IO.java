package top.qiyuex.course.io;

import top.qiyuex.course.data.Courses;
import top.qiyuex.course.data.StudentCourses;
import top.qiyuex.course.data.Users;

public class IO {
    public static void saveAll() {
        Users.studentSave();
        Users.teacherSave();
        Courses.save();
        StudentCourses.save();
    }

    public static void loadAll() {
        Users.studentLoad();
        Users.teacherLoad();
        Courses.load();
        StudentCourses.load();
    }
}
