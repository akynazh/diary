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
import java.util.List;

@WebServlet("/getDiaryServlet")
public class GetDiaryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("id");
        DiaryService diaryService = new DiaryServiceImpl();
        List<Diary> diaries = diaryService.getDiaries(user_id);

        Gson gson = new Gson();
        String jsonString = gson.toJson(diaries);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
