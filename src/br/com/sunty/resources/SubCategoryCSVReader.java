package br.com.sunty.resources;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubCategoryCSVReader {

    public List<SubCategory> readerCsv(Map<String, Category> mapCategory, String path) {

        List<SubCategory> subCategoryList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            String header = bufferedReader.readLine();
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] lineSplit = line.split(",");
                String name = lineSplit[0];
                String urlCode = lineSplit[1];
                Integer order = lineSplit[2].equals("") ? -1 : Integer.parseInt(lineSplit[2]);
                String shortDescription = lineSplit[3];
                boolean isActive = lineSplit[4].equals("ATIVA");
                String categoryName = lineSplit[5];

                Category category = mapCategory.get(categoryName);
                SubCategory subCategory = new SubCategory(name, urlCode, shortDescription, isActive, order, category);
                subCategoryList.add(subCategory);
                category.addSubCategory(subCategory);

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return subCategoryList;
    }
}
