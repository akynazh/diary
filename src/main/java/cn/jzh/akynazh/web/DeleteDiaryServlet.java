package cn.jzh.akynazh.web;

import cn.jzh.akynazh.bean.Diary;
import cn.jzh.akynazh.service.impl.DiaryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteDiaryServlet")
public class DeleteDiaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String create_date = req.getParameter("create_date");
        Diary diary = new Diary(0, create_date, "");
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        diaryService.deleteDiary(diary);
        resp.sendRedirect("frames/diary.html");
    }
}
