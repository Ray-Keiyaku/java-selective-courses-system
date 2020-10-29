package top.qiyuex.course.data;

import top.qiyuex.course.course.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Courses {
    // 课程列表
    private static List<Course> list = new ArrayList<>();
    private static Scanner stdIn = new Scanner(System.in);

    // 从流中读取课程信息并返回对象
    private static Course createCourse(Scanner input) {
        int ID = list.size() + 1;
        String name, teacherName;
        boolean isElective;
        int studentNum = 0, maxStudentNum, credit;
        Course ele;
        // 从标准输入流输入
        if (stdIn.equals(input)) {
            System.out.println("请输入课程名：");
            name = input.next();
            System.out.println("请输入任课老师：");
            teacherName = input.next();
            System.out.println("请输入课程是否为选修（true/false）：");
            isElective = input.nextBoolean();
            System.out.println("请输入当前选课人数：");
            studentNum = input.nextInt();
            if (isElective) {
                System.out.println("请输入最大选课人数：");
                maxStudentNum = input.nextInt();
                ele = new OptionalCourse(ID, name, teacherName, isElective, studentNum, maxStudentNum);
            } else {
                System.out.println("请输入学分：");
                credit = input.nextInt();
                ele = new RequiredCourse(ID, name, teacherName, isElective, studentNum, credit);
            }
        } else {
            // 从其他流输入
            name = input.next();
            isElective = input.nextBoolean();
            teacherName = input.next();
            studentNum = input.nextInt();
            if (isElective) {
                maxStudentNum = input.nextInt();
                ele = new OptionalCourse(ID, name, teacherName, isElective, studentNum, maxStudentNum);
            } else {
                credit = input.nextInt();
                ele = new RequiredCourse(ID, name, teacherName, isElective, studentNum, credit);
            }
        }
        return ele;
    }

    // 手动输入，添加一节课
    private static void addCourse() {
        Course ele = createCourse(stdIn);
        list.add(ele);
    }

    // 手动输入，添加多节课
    public static void addCourses() {
        int i = 1;
        String choice = "n";
        do {
            System.out.printf("请输入第%d门课程信息\n", i++);
            addCourse();
            System.out.println("是否继续？（y/n）");
            choice = stdIn.next();
        } while ("y".equals(choice));
    }

    // TODO: 删除一节课
    private static void delCourse() {
    }

    // TODO: 删除多节课
    public static void delCourses() {
        delCourse();
    }

    // TODO: 修改授课教师
    public static void changeTeacher() {
    }

    // 格式化输出课程列表
    public static void showCourses() {
        System.out.printf("%-6s\t%-10s\t%-6s\t%-6s\t%-4s\t\n", "编号", "课程", "类型", "教师", "选课人数");
        for (Course item : list) {
            item.show();
        }
    }

    // 用教师姓名查找所授课信息
    public static void searchCourseByTeacher() {
        System.out.println("请输入需要查找的教师名称：");
        String name = stdIn.next();
        for (Course item : list) {
            if (item.getTeacherName().equals(name)) {
                System.out.println(item.show());
            }
        }
    }

    // 按照选课人数排序
    public static void sortByNum() {
        list.sort(null);
    }
}
