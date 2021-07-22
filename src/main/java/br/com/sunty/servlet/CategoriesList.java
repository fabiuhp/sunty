package br.com.sunty.servlet;

import br.com.sunty.dao.CategoryDao;
import br.com.sunty.models.category.Category;
import br.com.sunty.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listaCategorias", value = "/listaCategorias")
public class CategoriesList extends HttpServlet {
    EntityManager entityManager = JPAUtil.getEntityManager();
    CategoryDao categoryDao = new CategoryDao(entityManager);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        List<Category> categories = categoryDao.findAll();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<ul>");

        categories.forEach(category -> writer.println("<li>" + category.getName() + " | " +
                category.getUrlCode() + " | " +
                category.getShortDescription() + " | " +
                category.getHexHtmlColor() + "</li>"));

        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
