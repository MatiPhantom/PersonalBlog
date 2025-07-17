package com.personalblog.persistence.storage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.personalblog.persistence.model.Article;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonStorage {

    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void save(List<Article> articles) {
        try(FileWriter writer = new FileWriter("articles.json")) {
            mapper.writeValue(writer, articles);
            writer.flush();
            writer.close();
            log.info("Articles saved to JSON file successfully.");
        }catch(Exception e){
            log.error("Error saving articles to JSON file", e);
        }
    }

    public static List<Article> load(){
        File file = new File("articles.json");
        if(file.exists()){
            try{
                FileReader reader = new FileReader(file);
                log.info("Articles loaded from JSON file successfully.");
                return mapper.readValue(reader,new TypeReference<List<Article>>(){});
            }catch(Exception e){
                log.error("Error loading articles from JSON file", e);
                return new ArrayList<>();
            }
        }else{
            return new ArrayList<>();
        }
    }

}
