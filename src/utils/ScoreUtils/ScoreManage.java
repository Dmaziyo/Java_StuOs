package utils.ScoreUtils;


import data.Course;
import data.Score;
import data.Student;
import mapper.Course.CourseMapper;
import mapper.Score.ScoreMapper;
import org.apache.ibatis.session.SqlSession;
import utils.base.MybatisUtil;
import views.CourseView.CourseForm;
import views.ScoreView.ScoreForm;

import java.util.ArrayList;

/**
 * @author 24794
 */
public class ScoreManage {


    private ScoreMapper scoreMapper;
    public ScoreManage() {

    }

    //     搜索数据
    public void getAllScore(int s_id) {
        try (SqlSession session = MybatisUtil.getSession(true)){
            scoreMapper =session.getMapper(ScoreMapper.class);
            ScoreForm.scores = scoreMapper.getAllScore(s_id);
        }

    }
    public void getScoreByScore(int s_id,String score) {

        score="%" + score + "%";
        try (SqlSession session = MybatisUtil.getSession(true)){
            scoreMapper =session.getMapper(ScoreMapper.class);
            ScoreForm.scores= scoreMapper.getScoreByScore(s_id,score);
        }
    }
    public void getScoreByName(int s_id,String name) {
        name="%" + name + "%";
        try (SqlSession session = MybatisUtil.getSession(true)){
            scoreMapper =session.getMapper(ScoreMapper.class);
            ScoreForm.scores= scoreMapper.getScoreByName(s_id,name);
        }
    }
    public void getScoreByType(int s_id,String type) {
        type="%" + type + "%";
        try (SqlSession session = MybatisUtil.getSession(true)){
            scoreMapper =session.getMapper(ScoreMapper.class);
            ScoreForm.scores= scoreMapper.getScoreByType(s_id,type);
        }
    }
//添加数据
    public void addScore(Score score) {
        try (SqlSession session = MybatisUtil.getSession(true)){
            scoreMapper =session.getMapper(ScoreMapper.class);
            scoreMapper.addScore(score);
        }
    }

    //      删除数据
    public void deleteScore(int index) {
        try (SqlSession session = MybatisUtil.getSession(true)){
            scoreMapper =session.getMapper(ScoreMapper.class);
            scoreMapper.deleteScore(index);
        }
    }

    //    修改数据
    public void modifyScore(Score score) {
        try (SqlSession session = MybatisUtil.getSession(true)){
            scoreMapper =session.getMapper(ScoreMapper.class);
            scoreMapper.updateScore(score);
        }
    }


}
