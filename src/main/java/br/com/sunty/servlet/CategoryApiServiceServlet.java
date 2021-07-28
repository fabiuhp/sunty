package br.com.sunty.servlet;

import br.com.sunty.dao.CategoryDao;
import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.CategoryDto;
import br.com.sunty.utils.JPAUtil;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/api/categories")
public class CategoryApiServiceServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);
        List<Category> categories = categoryDao.findAll();
        List<CategoryDto> categoryDtoList = categories.stream().map(CategoryDto::new).collect(Collectors.toList());

        String valor = req.getHeader("accept");

        if (valor.contains("xml")) {
            XStream xstream = new XStream();
            xstream.alias("category", CategoryDto.class);
            String xml = xstream.toXML(categoryDtoList);

            resp.setContentType("application/xml");
            resp.getWriter().print(xml);

        } else if (valor.contains("json")) {
            Gson gson = new Gson();
            String json = gson.toJson(categoryDtoList);

            resp.setContentType("application/json");
            resp.getWriter().print(json);

        } else {
            resp.setStatus(406);
        }
    }
}
