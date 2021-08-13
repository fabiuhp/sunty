package br.com.sunty.repository.instructor;

import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.models.instructor.InstructorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @Query(value = """
            select i.name, COUNT(c.instructor_id) as coursesquantity
            from instructor i
            inner join course c on i.id = c.instructor_id
            group by i.name
            order by coursesquantity desc
            limit 1
            """, nativeQuery = true)
    List<InstructorProjection> instructorWithMoreCourses();
}
