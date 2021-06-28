package br.com.sunty.resources;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.models.instructor.Instructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseCSVReader {

    public List<Course> readerCsv(Map<String, SubCategory> subCategoryMap, String path) {

        List<Course> courseList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            String header = bufferedReader.readLine();
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] lineSplit = line.split(",");
                String name = lineSplit[0];
                String urlCode = lineSplit[1];
                int timeToFinishInHours = lineSplit[2].isBlank() ? -1 : Integer.parseInt(lineSplit[2]);
                CourseVisibility visibility = CourseVisibility.valueOf(removerAcentos(lineSplit[3]));
                String targetAudience = lineSplit[4];
                String instructor = lineSplit[5];
                String syllabus = lineSplit[6];
                String developedSkills = lineSplit[7];
                String subCategoryName = lineSplit[8];

                Instructor instr = new Instructor(instructor);
                SubCategory subCategory = subCategoryMap.get(subCategoryName);
                Course course = new Course(name, urlCode, timeToFinishInHours, visibility, targetAudience, instr, syllabus, developedSkills, subCategory);
                subCategory.addCourse(course);

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return courseList;
    }

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
