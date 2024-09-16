package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.proyect.entity.Curso;
import co.edu.unipiloto.arquitectura.proyect.session.CursoFacadeLocal;
import co.edu.unipiloto.arquitectura.proyect.session.StudentFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;
    

    enum Accion {
        ADD, EDIT, DELETE, SEARCH
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Obtener la acción del usuario
        Accion eleccion = Accion.valueOf(request.getParameter("action"));

        // Obtener parámetros del request
        Integer codigo = Integer.parseInt(request.getParameter("codigoCurso"));
        String nombreCurso = request.getParameter("nombreCurso");
        Integer numeroCreditos = Integer.parseInt(request.getParameter("creditos"));
        String levelyear = request.getParameter("semestre");
        Integer numeroEstudiantesAdmitidos = Integer.parseInt(request.getParameter("totalEstudiantes"));

        // Crear el objeto Curso
        Curso curso = new Curso(codigo, nombreCurso, numeroCreditos, levelyear, numeroEstudiantesAdmitidos);
        boolean flag = false;

        // Procesar la acción
        switch (eleccion) {
            case ADD:
                flag = cursoFacade.addCurso(curso);
                break;
            case EDIT:
                flag = cursoFacade.editCurso(curso);
                break;
            case DELETE:
                flag = cursoFacade.deleteCurso(codigo);
                break;
            case SEARCH:
                curso = cursoFacade.getCurso(codigo);
                flag = (curso != null);
                break;
        }

        // Mensaje de resultado
        if (flag) {
            request.setAttribute("mensajeCurso", "La operación se completó exitosamente");
        } else {
            request.setAttribute("mensajeCurso", "La operación no se pudo realizar");
        }

        // Enviar datos a la vista
        request.setAttribute("curso", curso);
        request.setAttribute("allCourses", cursoFacade.getAllCursos());
        request.getRequestDispatcher("cursoInfo.jsp").forward(request, response);
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
        return "CursoServlet";
    }
    
}
