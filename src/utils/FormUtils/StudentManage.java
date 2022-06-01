package utils.FormUtils;



import data.Student;
import mapper.Stu.StuMapper;
import org.apache.ibatis.session.SqlSession;
import utils.base.MybatisUtil;
import views.FormView.TableForm;

import java.util.ArrayList;

/**
 * @author 24794
 */
public class StudentManage {


    private  StuMapper stuMapper;
     public StudentManage(){

     }

//     搜索数据
    public void getStudents() {
        StuMapper stuMapper;
        try (SqlSession session = MybatisUtil.getSession(true)){
            stuMapper =session.getMapper(StuMapper.class);
            TableForm.students =stuMapper.getAllStudent();
        }

    }
    public void getStudentByName(String name) {
        StuMapper stuMapper;
        name="%" + name + "%";
        ArrayList<Student> students=null;
        try (SqlSession session = MybatisUtil.getSession(true)){
            stuMapper =session.getMapper(StuMapper.class);
            TableForm.students=stuMapper.getStudentByName(name);
        }
    }
    public void getStudentByGender(String Gender) {
        StuMapper stuMapper;
        ArrayList<Student> students=null;
        try (SqlSession session = MybatisUtil.getSession(true)){
            stuMapper =session.getMapper(StuMapper.class);
            TableForm.students=stuMapper.getStudentByGender(Gender);
        }
    }
    public void getStudentByNumber(String Number) {
        StuMapper stuMapper;
        Number="%" + Number + "%";
        ArrayList<Student> students=null;
        try (SqlSession session = MybatisUtil.getSession(true)){
            stuMapper =session.getMapper(StuMapper.class);
            TableForm.students=stuMapper.getStudentByNumber(Number);
        }
    }
    public void getStudentByAge(String Age) {
        StuMapper stuMapper;
        Age="%" + Age + "%";
        ArrayList<Student> students=null;
        try (SqlSession session = MybatisUtil.getSession(true)){
            stuMapper =session.getMapper(StuMapper.class);
            TableForm.students=stuMapper.getStudentByAge(Age);
        }
    }



//      删除数据
    public void deletestudent(int index) {
        try (SqlSession session = MybatisUtil.getSession(true)){
            stuMapper =session.getMapper(StuMapper.class);
            stuMapper.deleteStu(index);
        }
    }

//    修改数据
    public void modifyStu(Student student) {
        try (SqlSession session = MybatisUtil.getSession(true)){
            stuMapper =session.getMapper(StuMapper.class);
            stuMapper.updateStu(student);
        }
    }

    public void addstudent(Student stu) {
        try (SqlSession session = MybatisUtil.getSession(true)){
            stuMapper =session.getMapper(StuMapper.class);
            stuMapper.addStudent(stu);
        }
    }
}
