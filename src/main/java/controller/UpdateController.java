package controller;

import model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String country = req.getParameter("country");
            String dob = req.getParameter("dob");
            StudentModel studentModel = new StudentModel();
            int rs = studentModel.update(Integer.parseInt(id),name, Integer.parseInt(gender), email, phone, country, dob);
            if (rs > 0) {
                out.print("Success");
            }else {
                out.print("Fail");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
