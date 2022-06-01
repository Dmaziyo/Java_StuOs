package mapper.Stu;


import data.Student;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.Map;

public interface StuMapper {
//    获取所有数据
    ArrayList<Student> getAllStudent();
//    搜索数据
    Student getStudentByid(int id);
    ArrayList<Student> getStudentByName(String name);
    ArrayList<Student> getStudentByGender(String gender);
    ArrayList<Student> getStudentByNumber(String number);
    ArrayList<Student> getStudentByAge(String age);
//    添加数据
    void addStudent(Student student);
//    删除数据
    void deleteStu(int id);
//    更新数据
    void updateStu(Student student);
}
