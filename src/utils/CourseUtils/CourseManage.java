package utils.CourseUtils;


import data.Course;
import data.Student;
import mapper.Course.CourseMapper;
import org.apache.ibatis.session.SqlSession;
import utils.base.MybatisUtil;
import views.CourseView.CourseForm;

import java.util.ArrayList;

/**
 * @author 24794
 */
public class CourseManage {


    private CourseMapper courseMapper;
    public CourseManage() {

    }

    //     搜索数据
    public void getCourses() {
        try (SqlSession session = MybatisUtil.getSession(true)){
            courseMapper =session.getMapper(CourseMapper.class);
            CourseForm.courses =courseMapper.getAllCourse();
        }

    }
    public void getCourseByNum(String num) {
        num="%" + num + "%";
        try (SqlSession session = MybatisUtil.getSession(true)){
            courseMapper =session.getMapper(CourseMapper.class);
            CourseForm.courses=courseMapper.getCourseByNum(num);
        }
    }
    public void getCourseByName(String name) {

        try (SqlSession session = MybatisUtil.getSession(true)){
            courseMapper =session.getMapper(CourseMapper.class);
            CourseForm.courses=courseMapper.getCourseByName(name);
        }
    }
    public void getCourseByHour(String hour) {
        hour="%" + hour + "%";
        try (SqlSession session = MybatisUtil.getSession(true)){
            courseMapper =session.getMapper(CourseMapper.class);
            CourseForm.courses=courseMapper.getCourseByHour(hour);
        }
    }
    public void getCourseByType(String type) {
        type="%" + type + "%";
        try (SqlSession session = MybatisUtil.getSession(true)){
            courseMapper =session.getMapper(CourseMapper.class);
            CourseForm.courses=courseMapper.getCourseByType(type);
        }
    }
    public void getCourseByTeacher(String teacher) {
        teacher="%" + teacher + "%";
        try (SqlSession session = MybatisUtil.getSession(true)){
            courseMapper =session.getMapper(CourseMapper.class);
            CourseForm.courses=courseMapper.getCourseByTeacher(teacher);
        }
    }


    //      删除数据
    public void deleteCourse(int index) {
        try (SqlSession session = MybatisUtil.getSession(true)){
            courseMapper =session.getMapper(CourseMapper.class);
            courseMapper.deleteCourse(index);
        }
    }

    //    修改数据
    public void modifyCourse(Course course) {
        try (SqlSession session = MybatisUtil.getSession(true)){
            courseMapper =session.getMapper(CourseMapper.class);
            courseMapper.updateCourse(course);
        }
    }

    public void addCourse(Course course) {
        try (SqlSession session = MybatisUtil.getSession(true)){
            courseMapper =session.getMapper(CourseMapper.class);
            courseMapper.addCourse(course);
        }
    }
}
