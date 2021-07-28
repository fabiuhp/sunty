package br.com.sunty.servlet;

import br.com.sunty.dao.CategoryDao;
import br.com.sunty.models.category.Category;
import br.com.sunty.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "novaCategoria", value = "/novaCategoria")
public class NewCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/newCategoryForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        String urlCode = req.getParameter("urlCode");
        String name = req.getParameter("name");

        Category category = new Category(name, urlCode);
        entityManager.getTransaction().begin();
        categoryDao.create(category);
        entityManager.getTransaction().commit();
        entityManager.close();

        resp.sendRedirect("/listaCategorias");
    }
}
