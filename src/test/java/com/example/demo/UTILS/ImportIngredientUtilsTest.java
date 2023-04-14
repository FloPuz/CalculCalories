package com.example.demo.UTILS;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportIngredientUtilsTest {

    @Autowired
    private ImportIngredientUtils _imImportIngredientUtils;


    @Test
    public void testImport(){
        _imImportIngredientUtils.importCSVIngredient();
    }

}