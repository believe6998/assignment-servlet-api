package controller;

import com.google.gson.Gson;
import entity.Student;
import model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet("/students")
public class StudentController extends HttpServlet {
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentModel studentModel = new StudentModel();
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String sid= req.getParameter("id");
        String name = req.getParameter("name");
        if(sid != null){
            int id= Integer.parseInt(sid);
            Student student;
            try {
                student = studentModel.getById(id);
                out.print(gson.toJson(student));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (name != null){
            List<Student> studentList;
            try {
                studentList = studentModel.getByName(name);
                out.print(gson.toJson(studentList));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else {
            List<Student> studentList;
            try {
                studentList = studentModel.getAll();
                out.print(gson.toJson(studentList));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String country = req.getParameter("country");
            String dob = req.getParameter("dob");
            StudentModel studentModel = new StudentModel();
            int rs = studentModel.create(name, Integer.parseInt(gender), email, phone, country, dob);
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
