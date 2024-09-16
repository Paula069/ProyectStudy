package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.proyect.entity.Proyecto;
import co.edu.unipiloto.arquitectura.proyect.session.ProyectoFacadeLocal;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProyectoServlet", urlPatterns = {"/ProyectoServlet"})
public class ProyectoServlet extends HttpServlet {

    @EJB
    private ProyectoFacadeLocal proyectoFacade;

    enum Accion {
        ADD, EDIT, DELETE, SEARCH
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        Accion eleccion = Accion.valueOf(request.getParameter("action"));

        Integer proyectoid = Integer.valueOf(request.getParameter("proyectoid"));
        String nombreProyecto = request.getParameter("nombreProyecto");
        String description = request.getParameter("description");
        String localidad = request.getParameter("localidad");
        BigDecimal presupuesto = new BigDecimal(request.getParameter("presupuesto"));
        Integer numeroHabitantes = Integer.valueOf(request.getParameter("numeroHabitantes"));

        Proyecto proyecto = new Proyecto(proyectoid, nombreProyecto, description, localidad, presupuesto, numeroHabitantes);
        boolean flag = false;

        switch (eleccion) {
            case ADD:
                flag = proyectoFacade.addProyect(proyecto);
                break;
            case EDIT:
                flag = proyectoFacade.editProyect(proyecto);
                break;
            case DELETE:
                flag = proyectoFacade.deleteProyect(proyectoid);
                break;
            case SEARCH:
                proyecto = proyectoFacade.getProyect(proyectoid);
                flag = (proyecto != null);
                break;
        }

        if (flag) {
            request.setAttribute("mensaje", "La operación se completó exitosamente");
        } else {
            request.setAttribute("mensaje", "La operación no se pudo realizar");
        }

        request.setAttribute("proyecto", proyecto);
        request.setAttribute("allProyectos", proyectoFacade.getAllProyects());
        request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
        
        
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
        return "ProyectoServlet maneja las acciones para la entidad Proyecto";
    }

}
