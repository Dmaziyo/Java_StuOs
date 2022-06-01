package mapper.Score;


import data.Course;
import data.Score;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface ScoreMapper {
//    获取某学生所有成绩
    @Select("    select sc.id, sc.s_id, sc.c_id,stu.name, cr.courseName,cr.courseType,sc.score FROM score sc  " +
            "    INNER JOIN student stu ON stu.id=sc.s_id" +
            "    INNER JOIN course cr   ON cr.id = sc.c_id WHERE sc.s_id=#{s_id}")
    ArrayList<Score> getAllScore(int s_id);
//    搜索数据
//    Course getScoreById(int id);
    @Select("select sc.id, sc.s_id, sc.c_id,stu.name, cr.courseName,cr.courseType,sc.score FROM score sc  " +
            "INNER JOIN student stu ON stu.id=sc.s_id" +
            "INNER JOIN course cr   ON cr.id = sc.c_id WHERE sc.s_id=#{s_id} AND courseName=#{courseName}")
    ArrayList<Score> getScoreByName(@Param("s_id") int s_id,@Param("courseName") String courseName);
    @Select("select sc.id, sc.s_id, sc.c_id,stu.name, cr.courseName,cr.courseType,sc.score FROM score sc  " +
            "INNER JOIN student stu ON stu.id=sc.s_id" +
            "INNER JOIN course cr   ON cr.id = sc.c_id WHERE sc.s_id=#{s_id} AND score=#{score}")
    ArrayList<Score> getScoreByScore(@Param("s_id") int s_id,@Param("score") String score);
    @Select("select sc.id, sc.s_id, sc.c_id,stu.name, cr.courseName,cr.courseType,sc.score FROM score sc  " +
            "INNER JOIN student stu ON stu.id=sc.s_id" +
            "INNER JOIN course cr   ON cr.id = sc.c_id WHERE sc.s_id=#{s_id} AND cr.courseType=#{courseType}")
    ArrayList<Score> getScoreByType(@Param("s_id") int s_id,@Param("courseType") String courseType);
    //    添加数据
    @Insert("INSERT INTO score(s_id, c_id,score) values(#{s_id}, #{c_id},#{score})")
    void addScore(Score Score);
//    删除数据
    @Delete("DELETE FROM score where id=#{id}")
    void deleteScore(int id);
//    更新数据
    @Update("  update score" +
            "    set s_id = #{s_id}, c_id=#{c_id} ,score=#{score}" +
            "    where id = #{id}")
    void updateScore(Score Score);
}
