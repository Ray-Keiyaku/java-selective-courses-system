package top.qiyuex.course.data;

import java.util.ArrayList;
import java.util.List;

import top.qiyuex.course.relation.*;
//import top.qiyuex.course.data.Courses;

public class StudentCourses {
    // 选课信息列表
    private static List<StudentCourse> list = new ArrayList<>();

    // 选课
    public static void selectCourse(int studentID, int courseID) {
        var tmp = new StudentCourse(studentID, courseID);
        if (!Courses.isOptionalCourse(courseID)) {
            System.out.println("该课程编号输入不存在或不是选修课！");
        } else if (list.contains(tmp)) {
            System.out.println("你已选修该课程！");
        } else if (!Courses.canSelectCourse(courseID)) {
            System.out.println("该课程人数已满！");
        } else {
            list.add(tmp);
            System.out.println("选课成功！");
        }
    }

    // 打印该课程的学生列表
    public static void showCourseStus(int courseID) {
        Users.showStudentHeader();
        for (StudentCourse it : list) {
            if (it.getCourseID() == courseID) {
                Users.showStudent(it.getStudentID(), false);
            }
        }
    }

    // 打印该学生选课列表
    public static void showStuCourses(int studentID) {
        Courses.showCourseHeader();
        for (StudentCourse it : list) {
            if (it.getStudentID() == studentID) {
                Courses.showCourse(it.getCourseID(), false);
            }
        }
    }
}
