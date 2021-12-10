package cn.jzh.akynazh.dao;

import cn.jzh.akynazh.bean.Diary;
import java.util.List;

public interface DiaryDao {
    public List<Diary> queryDiariesById(String user_id);
    public void saveDiary(Diary diary);
    public void deleteDiary(Diary diary);
}
