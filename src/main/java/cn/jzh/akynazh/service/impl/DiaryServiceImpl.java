package cn.jzh.akynazh.service.impl;

import cn.jzh.akynazh.bean.Diary;
import cn.jzh.akynazh.dao.DiaryDao;
import cn.jzh.akynazh.dao.impl.DiaryDaoImpl;
import cn.jzh.akynazh.service.DiaryService;

import java.util.List;

public class DiaryServiceImpl implements DiaryService {
    DiaryDao diaryDao = new DiaryDaoImpl();
    @Override
    public List<Diary> getDiaries(String user_id) {
        return diaryDao.queryDiariesById(user_id);
    }

    @Override
    public void writeDiary(Diary diary) {
        diaryDao.saveDiary(diary);
    }

    @Override
    public void deleteDiary(Diary diary) {
        diaryDao.deleteDiary(diary);
    }
}
