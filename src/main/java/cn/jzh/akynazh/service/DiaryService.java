package cn.jzh.akynazh.service;

import cn.jzh.akynazh.bean.Diary;
import java.util.List;

public interface DiaryService {
    public List<Diary> getDiaries(String user_id);
    public void writeDiary(Diary diary);
    public void deleteDiary(Diary diary);
}
