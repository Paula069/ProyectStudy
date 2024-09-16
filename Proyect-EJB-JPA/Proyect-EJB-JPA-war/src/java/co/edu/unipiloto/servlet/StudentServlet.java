package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.proyect.entity.Curso;
import co.edu.unipiloto.arquitectura.proyect.entity.Student;
import co.edu.unipiloto.arquitectura.proyect.session.StudentFacadeLocal;
import co.edu.unipiloto.arquitectura.proyect.session.CursoFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;
    
    @EJB
    private CursoFacadeLocal cursoFacade;

    enum Accion {
        ADD, EDIT, DELETE, SEARCH
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

            Accion eleccion = Accion.valueOf(request.getParameter("action").toUpperCase());

            String studentidStr = request.getParameter("studentid");
            int studentid = (studentidStr.equals("")) ? 0 : Integer.parseInt(studentidStr);
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");

            // Obtener la lista de cursos seleccionados
            String[] cursoIds = request.getParameterValues("cursoid");
            Collection<Curso> cursoCollection = new ArrayList<>();
            if (cursoIds != null) {
                for (String cursoIdStr : cursoIds) {
                    int cursoid = Integer.parseInt(cursoIdStr);
                    Curso curso = cursoFacade.find(cursoid);
                    if (curso != null) {
                        cursoCollection.add(curso);
                    }
                }
            }

            Student student = new Student(studentid, firstname, lastname, email, cursoCollection);
            boolean flag = false;

            switch (eleccion) {
                case ADD:
                    flag = studentFacade.addStudent(student);
                    break;
                case EDIT:
                    flag = studentFacade.editStudent(student);
                    break;
                case DELETE:
                    flag = studentFacade.deleteStudent(student.getStudentid());
                    break;
                case SEARCH:
                    student = studentFacade.getStudent(student.getStudentid());
                    flag = (student != null);
                    break;
            }

            if (flag) {
                request.setAttribute("mensaje", "La operación se completó exitosamente");
            } else {
                request.setAttribute("mensaje", "La operación no se pudo realizar");
            }

            request.setAttribute("student", student);
            request.setAttribute("allStudents", studentFacade.getAllStudents());
            request.getRequestDispatcher("estudianteInfo.jsp").forward(request, response);
        
    }
    

  
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "StudentServlet maneja las acciones para la entidad Student";
    }

}

