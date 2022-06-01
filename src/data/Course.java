package data;



public class Course {
    private int id;
    private String courseNum;
    private String courseName;
    private String courseHour;
    private String courseType;
    private String teacher;

    public String getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(String courseHour) {
        this.courseHour = courseHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Course(String courseNum, String courseType, String courseHour,  String courseName,String teacher) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.courseHour = courseHour;
        this.courseType = courseType;
        this.teacher = teacher;
    }

    public Object[] getAllData(){
        Object[] ret=new Object[]{courseNum,courseName,courseHour,courseType,teacher};
        return ret ;
    }
}
