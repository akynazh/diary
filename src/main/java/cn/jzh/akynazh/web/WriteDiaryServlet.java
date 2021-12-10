package cn.jzh.akynazh.web;

import cn.jzh.akynazh.bean.Diary;
import cn.jzh.akynazh.service.DiaryService;
import cn.jzh.akynazh.service.impl.DiaryServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/writeDiaryServlet")
public class WriteDiaryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String diary_text = req.getParameter("diary_text");
        String user_id = req.getParameter("id");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String create_date = sdf.format(new Date());

        Diary diary = new Diary(Integer.parseInt(user_id), create_date, diary_text);
        DiaryService diaryService = new DiaryServiceImpl();
        diaryService.writeDiary(diary);

        Gson gson = new Gson();
        String jsonString = gson.toJson(diary);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
