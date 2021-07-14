/*os nomes das subcategorias ativas e quem tem algum curso, na ordem*/
SELECT DISTINCT sc.name, sc.orderToShow
FROM sub_category sc
         JOIN course c on sc.id = c.sub_category_id
WHERE sc.isActive = 1
ORDER BY sc.orderToShow;

/*o nome e a quantidade de cursos do instrutor que tem mais cursos*/
select i.name, COUNT(*) as quantidade_cursos
from course as c
         join instructor i on c.instructor_id = i.id
group by i.name;

/*os nomes de todas as categorias ativas com a respectiva
  quantidade de cursos públicos e total de horas estimados
  dos cursos públicos associados (sendo 0 se não existir nenhum curso público)*/
select category.name, COUNT(course.id) as quantity
from category
         left join sub_category sc on category.id = sc.category_id
         left join course on sc.id = course.sub_category_id
where category.isActive = 1
group by category.id;