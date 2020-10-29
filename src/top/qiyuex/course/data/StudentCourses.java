package top.qiyuex.course.data;

import java.util.ArrayList;
import java.util.List;

import top.qiyuex.course.relation.*;

public class StudentCourses {
    private static List<StudentCourse> list = new ArrayList<>();

    // 选课
    public static void selectCourse(int studentID, int courseID) {
        var tmp = new StudentCourse(studentID, courseID);
        if (list.contains(tmp)) {
            System.out.println("你已选修该课程！");
        } else {
            list.add(tmp);
        }
    }

    // 打印该课程的学生列表
    public static void showCourseStu(int courseID) {
        Users.showStudentHeader();
        for (StudentCourse it : list) {
            if (it.getCourseID() == courseID) {
                Users.showStudent(it.getStudentID(), false);
            }
        }
    }
}
