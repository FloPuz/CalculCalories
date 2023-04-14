package com.example.demo.UTILS;

import com.example.demo.entity.Ingredients;
import com.example.demo.repository.IngredientsRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImportIngredientUtils {

    @Autowired
    private IngredientsRepository _ingredientsRepository;

    @Transactional
    public void importCSVIngredient() {
        String csvFilePath = "./src/main/resources/static/fr.openfoodfacts.org.products (1).csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String> headers = Arrays.stream(reader.readNext()).toList();
            List<String> headersFormated = new ArrayList<>();
            for (int i = 0; i < headers.size(); i++) {
                if (headers.get(i).contains("\t")){

                    headersFormated.addAll(List.of(headers.get(i).split("\t")));
                }else{
                    headersFormated.add(headers.get(i));
                }

            }
            List<String> line;

            // Find the index of the header you want to retrieve
            int headerNom = -1;
            int headerCalorie = -1;
            for (int i = 0; i < headersFormated.size(); i++) {
                if (headersFormated.get(i).equals("generic_name")) {
                    headerNom = i;
                }else if (headersFormated.get(i).equals("energy-kj_100g")){
                    headerCalorie = i;
                }
            }

            while ((line = Arrays.stream(reader.readNext()).limit(500).collect(Collectors.toList())) != null) {
                List<String> lineFormated = new ArrayList<String>();
                for (int i = 0; i < line.size(); i++) {
                    if (line.get(i).contains("\t")){
                        /**
                         * TODO
                         * Réfléchir à comment faire pour que tout les \t sois pris en compte et renseigné dans un tableau avec les bons champs
                         */
                        lineFormated.addAll(List.of(line.get(i).split("\t")));
                    }else{
                        lineFormated.add(line.get(i));
                    }
                }
                Ingredients ingredient = new Ingredients();
                ingredient.setNomIngredient(lineFormated.get(headerNom));
                ingredient.setCalories(Double.parseDouble(lineFormated.get(headerCalorie)));
                //_ingredientsRepository.save(ingredient);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}