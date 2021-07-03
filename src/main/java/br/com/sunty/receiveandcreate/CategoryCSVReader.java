package br.com.sunty.receiveandcreate;

import br.com.sunty.models.category.Category;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryCSVReader {

    public List<Category> readerCsv(String path) {

        List<Category> categoryList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            String header = bufferedReader.readLine();
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] lineSplit = line.split(",");
                String name = lineSplit[0].toLowerCase();
                String urlCode = lineSplit[1];
                Integer order = lineSplit[2].equals("") ? 0 : Integer.parseInt(lineSplit[2]);
                String shortDescription = lineSplit[3];
                boolean isActive = lineSplit[4].equals("ATIVA");
                String pathImg = lineSplit[5];
                String hexHtmlColor = lineSplit[6];

                Category category = new Category(name, urlCode, shortDescription, isActive, order, pathImg, hexHtmlColor);
                categoryList.add(category);

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        for (Category category : categoryList) {
            System.out.println(category);
        }

        return categoryList;
    }
}
