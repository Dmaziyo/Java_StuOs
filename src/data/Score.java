package data;

public class Score {
    private int id;
    private int s_id;
    private int c_id;
    private String courseName;
    private String score;
    private String courseType;



    public Score(int s_id, int c_id, String courseName, String score) {
        this.s_id = s_id;
        this.c_id = c_id;
        this.courseName = courseName;
        this.score = score;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public Object[] getAllData(){
        Object[] ret=new Object[]{courseName,courseType,score};
        return ret ;
    }
}
