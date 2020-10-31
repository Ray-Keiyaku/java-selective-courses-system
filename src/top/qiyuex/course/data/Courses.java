package top.qiyuex.course.data;

import top.qiyuex.course.course.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Courses {
    // 课程列表
    private static List<Course> list = new ArrayList<>();
    private static Scanner stdIn = new Scanner(System.in);

    // 从流中读取课程信息并返回对象
    private static Course createCourse(Scanner input) {
        int ID, teacherID, studentNum = 0, maxStudentNum, credit;
        boolean isElective;
        String name;
        Course ele;
        // 从标准输入流输入
        if (stdIn.equals(input)) {
            System.out.println("请输入课程编号：");
            ID = input.nextInt();
            System.out.println("请输入课程名：");
            name = input.next();
            while (true) {
                System.out.println("请输入任课教师工号：");
                teacherID = input.nextInt();
                if (Users.findTeacher(teacherID) == null) {
                    System.out.println("该教师不存在，是否重新输入？（y/n）");
                    String yn = input.next();
                    if (yn.equals("n")) {
                        return null;
                    }
                } else {
                    break;
                }
            }
            System.out.println("请输入课程是否为选修（true/false）：");
            isElective = input.nextBoolean();
            if (isElective) {
                System.out.println("请输入最大选课人数：");
                maxStudentNum = input.nextInt();
                ele = new OptionalCourse(ID, name, teacherID, isElective, studentNum, maxStudentNum);
            } else {
                System.out.println("请输入学分：");
                credit = input.nextInt();
                ele = new RequiredCourse(ID, name, teacherID, isElective, studentNum, credit);
            }
        } else {
            // 从其他流输入
            ID = input.nextInt();
            name = input.next();
            teacherID = input.nextInt();
            isElective = input.nextBoolean();
            studentNum = input.nextInt();
            if (isElective) {
                maxStudentNum = input.nextInt();
                ele = new OptionalCourse(ID, name, teacherID, isElective, studentNum, maxStudentNum);
            } else {
                credit = input.nextInt();
                ele = new RequiredCourse(ID, name, teacherID, isElective, studentNum, credit);
            }
        }
        return ele;
    }

    // 添加一节课
    private static void addCourse() {
        Course ele = createCourse(stdIn);
        if (ele != null) {
            list.add(ele);
            if (ele instanceof RequiredCourse) {
                Users.allSelectRequiredCourse(ele.getCourseID());
            }
        }
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
        save();
    }

    // 删除一节课
    private static void delCourse() {
        System.out.println("请输入课程编号：");
        int id = stdIn.nextInt();
        StudentCourses.delAllRelationByCourse(id);
        list.remove(findCourse(id));
    }

    // 删除多节课
    public static void delCourses() {
        int i = 1;
        String choice = "n";
        do {
            System.out.printf("正在删除第%d个课程\n", i++);
            delCourse();
            System.out.println("是否继续？（y/n）");
            choice = stdIn.next();
        } while ("y".equals(choice));
        save();
    }

    // 修改授课教师
    public static void changeTeacher() {
        System.out.println("请输入课程编号：");
        int courseID = stdIn.nextInt();
        showCourse(courseID);
        Course tmp = findCourse(courseID);
        if (tmp != null) {
            System.out.println("请输入要修改的教师工号：");
            int teacherID = stdIn.nextInt();
            tmp.changeTeacher(teacherID);
            ;
            System.out.println("教师修改成功！");
        }
        save();
    }

    // 打印课程表头
    public static void showCourseHeader() {
        System.out.printf("%4s %10s %6s %3s %4s %4s\n", "编号", "课程", "教师", "类型", "选课人数", "学分/最大人数");
    }

    // 打印一节课
    public static void showCourse(int courseID) {
        Course tmp = findCourse(courseID);
        if (tmp != null) {
            showCourseHeader();
            System.out.println(tmp.show());
        } else {
            System.out.println("查无此课程！");
        }
    }

    // 打印一节课，header为false时不输出表头
    public static void showCourse(int courseID, boolean header) {
        Course tmp = findCourse(courseID);
        if (tmp != null) {
            if (header) {
                showCourseHeader();
            }
            System.out.println(tmp.show());
        } else {
            System.out.println("查无此课程！");
        }
    }

    // 打印所有课程列表
    public static void showCourses() {
        showCourseHeader();
        for (Course it : list) {
            System.out.println(it.show());
        }
    }

    // 打印选修课程列表
    public static void showOptionalCourses() {
        showCourseHeader();
        for (Course it : list) {
            if (it instanceof OptionalCourse) {
                System.out.println(it.show());
            }
        }
    }

    // 用教师工号查找所授课信息并打印
    public static void showCourseByTeacher(int workID) {
        showCourseHeader();
        for (Course it : list) {
            if (it.getTeacherID() == workID) {
                System.out.println(it.show());
            }
        }
    }

    // 用教师工号查找所授课并删除
    public static void delAllCourseByTeacher(int workID) {
        for (Course it : list) {
            if (it.getTeacherID() == workID) {
                StudentCourses.delAllRelationByCourse(it.getCourseID());
            }
        }
        list.removeIf(it -> it.getTeacherID() == workID);
    }

    // 用教师姓名查找所授课信息并打印学生列表
    public static void showCourseStusByTeacher(int workID) {
        for (Course it : list) {
            if (it.getTeacherID() == workID) {
                showCourseHeader();
                System.out.println(it.show());
                StudentCourses.showCourseStus(it.getCourseID());
            }
        }
    }

    // 按照选课人数排序
    public static void sortByNum() {
        list.sort(null);
    }

    // 用课程ID寻找课程，返回对象
    public static Course findCourse(int courseID) {
        for (Course it : list) {
            if (it.getCourseID() == courseID) {
                return it;
            }
        }
        return null;
    }

    // 判断该课程是否可以选修
    public static boolean canSelectCourse(int courseID) {
        Course tmp = findCourse(courseID);
        if (tmp != null) {
            if (tmp instanceof OptionalCourse) {
                OptionalCourse tmp2 = (OptionalCourse) tmp;
                return tmp2.canSelect();
            }
        }
        return false;
    }

    // 为学生添加所有必修课
    public static void selectAllRequiredCourse(int studentID) {
        for (Course it : list) {
            if (it instanceof RequiredCourse) {
                StudentCourses.selectRequiredCourse(studentID, it.getCourseID());
                it.addStudentNum();
            }
        }
    }

    // 判断该课程是否为选修课
    public static boolean isOptionalCourse(int courseID) {
        Course tmp = findCourse(courseID);
        if (tmp != null) {
            if (tmp instanceof OptionalCourse) {
                return true;
            }
        }
        return false;
    }

    // 课程文件输入
    public static void load() {
        try {
            String usrHome = System.getProperty("user.home");
            File course = new File(usrHome + "/.selective-courses/course.txt");
            if (course.exists()) {
                Scanner fileIn = new Scanner(course);
                while (fileIn.hasNext()) {
                    Course tmp = createCourse(fileIn);
                    list.add(tmp);
                }
                fileIn.close();
            }
        } catch (Exception e) {
            System.out.println("从文件读取课程列表时出现异常！" + e);
        }
    }

    // 课程文件输出
    public static void save() {
        try {
            String usrHome = System.getProperty("user.home");
            File course = new File(usrHome + "/.selective-courses/course.txt");
            if (!course.exists()) {
                course.getParentFile().mkdirs();
                course.createNewFile();
            }
            FileWriter courseWriter = new FileWriter(course);
            for (Course it : list) {
                courseWriter.write(it.toString() + "\n");
            }
            courseWriter.close();
        } catch (Exception e) {
            System.out.println("保存课程列表到文件时出现异常！");
        }
    }
}
