package top.qiyuex.course.data;

import top.qiyuex.course.user.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Users {
    // 管理员用户
    private static Admin adminUser = new Admin("admin", "admin");
    // 学生用户列表
    private static List<Student> studentUser = new ArrayList<>();
    // 教师用户列表
    private static List<Teacher> teacherUser = new ArrayList<>();
    // 当前用户
    private static User currentUser = null;
    private static Scanner stdIn = new Scanner(System.in);

    // 打印学生表头
    public static void showStudentHeader() {
        System.out.printf("%6s %6s %6s\n", "学号", "姓名", "班级");
    }

    // 打印教师表头
    public static void showSTeacherHeader() {
        System.out.printf("%6s %6s %6s\n", "工号", "姓名", "职称");
    }

    // 打印所有学生
    public static void showAllStudent() {
        showStudentHeader();
        for (Student it : studentUser) {
            System.out.println(it.show());
        }
    }

    // 用学号寻找学生，返回对象
    private static Student findStudent(int stuID) {
        for (Student it : studentUser) {
            if (it.getStudentID() == stuID) {
                return it;
            }
        }
        return null;
    }

    // 打印一个学生
    public static void showStudent(int stuID) {
        Student it = findStudent(stuID);
        if (it != null) {
            showStudentHeader();
            System.out.println(it.show());
        } else {
            System.out.println("查无此学生！");
        }
    }

    // 打印一个学生，header为false时不输出表头
    public static void showStudent(int stuID, boolean header) {
        Student it = findStudent(stuID);
        if (it != null) {
            if (header) {
                showStudentHeader();
            }
            System.out.println(it.show());
        } else {
            System.out.println("查无此学生！");
        }
    }

    // 打印所有教师
    public static void showAllTeacher() {
        showSTeacherHeader();
        for (Teacher it : teacherUser) {
            System.out.println(it.show());
        }
    }

    // 用工号寻找教师，返回对象
    public static Teacher findTeacher(int workID) {
        for (Teacher it : teacherUser) {
            if (it.getWorkID() == workID) {
                return it;
            }
        }
        return null;
    }

    // 打印一个教师
    public static void showTeacher(int teaID) {
        Teacher it = findTeacher(teaID);
        if (it != null) {
            showSTeacherHeader();
            System.out.println(it.show());
        } else {
            System.out.println("查无此教师！");
        }
    }

    // 恢复学生初始密码（初始密码为：123456）
    public static void resetStuPass() {
        System.out.println("请输入学号：");
        int stuID = stdIn.nextInt();
        showStudent(stuID);
        User tmp = Users.findStudent(stuID);
        if (tmp != null) {
            tmp.resetPassword();
            System.out.println("密码重置成功！");
        }
    }

    // 恢复教师初始密码（初始密码为：123456）
    public static void resetTeaPass() {
        System.out.println("请输入工号：");
        int workID = stdIn.nextInt();
        showTeacher(workID);
        User tmp = Users.findTeacher(workID);
        if (tmp != null) {
            tmp.resetPassword();
            System.out.println("密码重置成功！");
        }
    }

    // 从流中读取教师信息并返回对象
    private static Teacher createTeacher(Scanner input) {
        int workID;
        String name;
        String level;
        Teacher ele;
        if (stdIn.equals(input)) {
            System.out.println("请输入工号：");
            workID = input.nextInt();
            System.out.println("请输入姓名：");
            name = input.next();
            System.out.println("请输入职称：");
            level = input.next();
            ele = new Teacher(name, "123456", workID, level);
        } else {
            name = input.next();
            String pass = input.next();
            workID = input.nextInt();
            level = input.next();
            ele = new Teacher(name, pass, workID, level);
        }
        return ele;

    }

    // 添加多个教师
    public static void addTeachers() {
        int i = 1;
        String choice = "n";
        do {
            System.out.printf("请输入第%d个教师信息\n", i++);
            Teacher ele = createTeacher(stdIn);
            teacherUser.add(ele);
            System.out.println("是否继续？（y/n）");
            choice = stdIn.next();
        } while ("y".equals(choice));
        teacherSave();
    }

    // 从流中读取学生信息并返回对象
    private static Student createStudent(Scanner input) {
        int studentID;
        String name;
        String className;
        Student ele;
        if (stdIn.equals(input)) {
            System.out.println("请输入学号：");
            studentID = input.nextInt();
            System.out.println("请输入姓名：");
            name = input.next();
            System.out.println("请输入班级：");
            className = input.next();
            ele = new Student(name, "123456", studentID, className);
            Courses.selectAllRequiredCourse(studentID);
        } else {
            name = input.next();
            String pass = input.next();
            studentID = input.nextInt();
            className = input.next();
            ele = new Student(name, pass, studentID, className);
        }
        return ele;

    }

    // 添加多个学生
    public static void addStudents() {
        int i = 1;
        String choice = "n";
        do {
            System.out.printf("请输入第%d个学生信息\n", i++);
            Student ele = createStudent(stdIn);
            studentUser.add(ele);
            System.out.println("是否继续？（y/n）");
            choice = stdIn.next();
        } while ("y".equals(choice));
        studentSave();
    }

    // 删除多个教师
    public static void delTeacher() {
        String choice = "y";
        do {
            System.out.println("请输入工号：");
            int workID = stdIn.nextInt();
            Users.showTeacher(workID);
            User tmp = Users.findTeacher(workID);
            if (tmp != null) {
                teacherUser.remove(tmp);
                System.out.println("教师删除成功！");
            }
            System.out.println("是否继续？（y/n）");
            choice = stdIn.next();
        } while ("y".equals(choice));
        teacherSave();
    }

    // 删除多个学生
    public static void delStudent() {
        String choice = "y";
        do {
            System.out.println("请输入学号：");
            int studentID = stdIn.nextInt();
            Users.showStudent(studentID);
            User tmp = Users.findStudent(studentID);
            if (tmp != null) {
                studentUser.remove(tmp);
                System.out.println("学生删除成功！");
            }
            System.out.println("是否继续？（y/n）");
            choice = stdIn.next();
        } while ("y".equals(choice));
        studentSave();
    }

    // 登陆菜单
    public static void loginMenu() {
        do {
            System.out.println("请选择登录用户类型：");
            System.out.printf("1.管理员\n2.学生\n3.教职工\n");
            int choice = stdIn.nextInt();
            currentUser = switch (choice) {
                case 1 -> adminLogin();
                case 2 -> studentLogin();
                case 3 -> teacherLogin();
                default -> {
                    System.out.println("输入错误，请重新输入！");
                    yield null;
                }
            };
        } while (currentUser == null);
        currentUser.userMenu();
    }

    // 为所有学生添加必修课
    public static void allSelectRequiredCourse(int courseID) {
        Courses.findCourse(courseID).addStudentNum(studentUser.size());
        for (Student it : studentUser) {
            StudentCourses.selectRequiredCourse(it.getStudentID(), courseID);
        }
    }

    // 管理员登陆
    private static User adminLogin() {
        System.out.println("请输入管理员用户名：");
        String adminName = stdIn.next();
        System.out.println("请输入管理员密码：");
        String adminPass = stdIn.next();
        if (adminUser.authName(adminName) && adminUser.login(adminPass)) {
            return adminUser;
        } else {
            System.out.println("管理员用户名或密码错误，请重新输入");
            return null;
        }
    }

    // 学生登陆
    private static User studentLogin() {
        System.out.println("请输入学号：");
        int stuID = stdIn.nextInt();
        System.out.println("请输入密码：");
        String stuPass = stdIn.next();
        User tmp = findStudent(stuID);
        if (tmp != null) {
            if (tmp.login(stuPass)) {
                return tmp;
            } else {
                return null;
            }
        } else {
            System.out.println("学号不存在，请重新输入");
            return null;
        }

    }

    // 教师登录
    private static User teacherLogin() {
        System.out.println("请输入工号：");
        int workID = stdIn.nextInt();
        System.out.println("请输入密码：");
        String teaPass = stdIn.next();
        User tmp = findTeacher(workID);
        if (tmp != null) {
            if (tmp.login(teaPass)) {
                return tmp;
            } else {
                return null;
            }
        } else {
            System.out.println("工号不存在，请重新输入");
            return null;
        }
    }

    // 教师文件输入
    public static void teacherLoad() {
        try {
            String usrHome = System.getProperty("user.home");
            File teacher = new File(usrHome + "/.selective-courses/teacher.txt");
            if (teacher.exists()) {
                Scanner fileIn = new Scanner(teacher);
                while (fileIn.hasNextLine()) {
                    Teacher tmp = createTeacher(fileIn);
                    teacherUser.add(tmp);
                }
            }
        } catch (Exception e) {
            System.out.println("从文件读取教师列表时出现异常！" + e);
        }
    }

    // 教师文件输出
    public static void teacherSave() {
        try {
            String usrHome = System.getProperty("user.home");
            File teacher = new File(usrHome + "/.selective-courses/teacher.txt");
            if (!teacher.exists()) {
                teacher.getParentFile().mkdirs();
                teacher.createNewFile();
            }
            FileWriter teacherWriter = new FileWriter(teacher);
            for (Teacher it : teacherUser) {
                teacherWriter.write(it.toString() + "\n");
            }
            teacherWriter.close();
        } catch (Exception e) {
            System.out.println("保存教师列表到文件时出现异常！");
        }
    }

    // 学生文件输入
    public static void studentLoad() {
        try {
            String usrHome = System.getProperty("user.home");
            File student = new File(usrHome + "/.selective-courses/student.txt");
            if (student.exists()) {
                Scanner fileIn = new Scanner(student);
                while (fileIn.hasNextLine()) {
                    Student tmp = createStudent(fileIn);
                    studentUser.add(tmp);
                }
            }
        } catch (Exception e) {
            System.out.println("从文件读取学生列表时出现异常！" + e);
        }
    }

    // 学生文件输出
    public static void studentSave() {
        try {
            String usrHome = System.getProperty("user.home");
            File student = new File(usrHome + "/.selective-courses/student.txt");
            if (!student.exists()) {
                student.getParentFile().mkdirs();
                student.createNewFile();
            }
            FileWriter studentWriter = new FileWriter(student);
            for (Student it : studentUser) {
                studentWriter.write(it.toString() + "\n");
            }
            studentWriter.close();
        } catch (Exception e) {
            System.out.println("保存学生列表到文件时出现异常！");
        }
    }
}
