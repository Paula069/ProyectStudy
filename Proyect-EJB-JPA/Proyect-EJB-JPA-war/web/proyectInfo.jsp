<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información de Entidades</title>
    </head>
    <body>
        <h1>Información de Estudiantes, Cursos y Proyectos</h1>
        
        <!-- Estudiantes -->
        <h2>Estudiantes</h2>
        <form action="./EstudianteServlet" method="POST">
            <table>
                <tr>
                    <td>ID del Estudiante</td>
                    <td><input type="text" name="studentId" value="${student.studentId}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="firstName" value="${student.firstName}" /></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="lastName" value="${student.lastName}" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" value="${student.email}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="ADD" />
                        <input type="submit" name="action" value="EDIT" />
                        <input type="submit" name="action" value="DELETE" />
                        <input type="submit" name="action" value="SEARCH" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <h3>Lista de Estudiantes</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allStudents}" var="stu">
                    <tr>
                        <td>${stu.studentId}</td>
                        <td>${stu.firstName}</td>
                        <td>${stu.lastName}</td>
                        <td>${stu.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Cursos -->
        <h2>Cursos</h2>
        <form action="./CursoServlet" method="POST">
            <table>
                <tr>
                    <td>Código del Curso</td>
                    <td><input type="text" name="codigo" value="${course.codigo}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombreCurso" value="${course.nombreCurso}" /></td>
                </tr>
                <tr>
                    <td>Número de Créditos</td>
                    <td><input type="number" name="numeroCreditos" value="${course.numeroCreditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="levelYear" value="${course.levelYear}" /></td>
                </tr>
                <tr>
                    <td>Número de Estudiantes Admitidos</td>
                    <td><input type="number" name="numeroEstudiantesAdmitidos" value="${course.numeroEstudiantesAdmitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="ADD" />
                        <input type="submit" name="action" value="EDIT" />
                        <input type="submit" name="action" value="DELETE" />
                        <input type="submit" name="action" value="SEARCH" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <h3>Lista de Cursos</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Número de Créditos</th>
                    <th>Semestre</th>
                    <th>Número de Estudiantes Admitidos</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allCourses}" var="crs">
                    <tr>
                        <td>${crs.codigo}</td>
                        <td>${crs.nombreCurso}</td>
                        <td>${crs.numeroCreditos}</td>
                        <td>${crs.levelYear}</td>
                        <td>${crs.numeroEstudiantesAdmitidos}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Proyectos -->
        <h2>Proyectos</h2>
        <form action="./ProyectoServlet" method="POST">
            <table>
                <tr>
                    <td>ID del Proyecto</td>
                    <td><input type="text" name="proyectoId" value="${project.proyectoId}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombreProyecto" value="${project.nombreProyecto}" /></td>
                </tr>
                <tr>
                    <td>Descripción</td>
                    <td><textarea name="descripcion">${project.descripcion}</textarea></td>
                </tr>
                <tr>
                    <td>Localidad</td>
                    <td><input type="text" name="localidad" value="${project.localidad}" /></td>
                </tr>
                <tr>
                    <td>Presupuesto</td>
                    <td><input type="text" step="0.01" name="presupuesto" value="${project.presupuesto}" /></td>
                </tr>
                <tr>
                    <td>Número de Habitantes</td>
                    <td><input type="number" name="numeroHabitantes" value="${project.numeroHabitantes}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="ADD" />
                        <input type="submit" name="action" value="EDIT" />
                        <input type="submit" name="action" value="DELETE" />
                        <input type="submit" name="action" value="SEARCH" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <h3>Lista de Proyectos</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Localidad</th>
                    <th>Presupuesto</th>
                    <th>Número de Habitantes</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allProjects}" var="proj">
                    <tr>
                        <td>${proj.proyectoId}</td>
                        <td>${proj.nombreProyecto}</td>
                        <td>${proj.descripcion}</td>
                        <td>${proj.localidad}</td>
                        <td>${proj.presupuesto}</td>
                        <td>${proj.numeroHabitantes}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
