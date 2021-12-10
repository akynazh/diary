package cn.jzh.akynazh.dao.impl;

import cn.jzh.akynazh.bean.Diary;
import cn.jzh.akynazh.dao.DiaryDao;

import java.util.List;

public class DiaryDaoImpl extends BaseDao implements DiaryDao {
    BaseDao baseDao = new BaseDao();
    @Override
    public List<Diary> queryDiariesById(String user_id) {
        String sql = "select diary_text, create_date from t_diary where user_id = ?";
        return baseDao.queryForList(Diary.class, sql, user_id);
    }

    @Override
    public void saveDiary(Diary diary) {
        String sql = "insert into t_diary(diary_text, create_date, user_id) values(?, ?, ?)";
        baseDao.update(sql, diary.getDiary_text(), diary.getCreate_date(), diary.getUser_id());
    }

    @Override
    public void deleteDiary(Diary diary) {
        String sql = "delete from t_diary where create_date = ?";
        baseDao.update(sql, diary.getCreate_date());
    }
}