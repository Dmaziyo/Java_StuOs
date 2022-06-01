package mapper.Course;


import data.Course;
import data.Student;

import java.util.ArrayList;

public interface CourseMapper {
//    获取所有数据
    ArrayList<Course> getAllCourse();
//    搜索数据
    Course getCourseById(int id);
    ArrayList<Course> getCourseByNum(String num);
    ArrayList<Course> getCourseByName(String name);
    ArrayList<Course> getCourseByHour(String hour);
    ArrayList<Course> getCourseByType(String type);
    ArrayList<Course> getCourseByTeacher(String teacher);
    //    添加数据
    void addCourse(Course course);
//    删除数据
    void deleteCourse(int id);
//    更新数据
    void updateCourse(Course course);
}
