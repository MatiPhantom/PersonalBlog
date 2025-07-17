package com.personalblog.persistence.storage;

import java.io.FileWriter;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalblog.persistence.model.Article;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JsonStorage {

    private static final ObjectMapper mapper = new ObjectMapper();

    private static List<Article> articles;

    public static List<Article> getArticles() {
        return articles;
    }

    public static void save(){

        try(FileWriter writer = new FileWriter("articles.json")) {
            mapper.writeValue(writer, articles);
            writer.flush();
            writer.close();
            log.info("Articles saved to JSON file successfully.");
        }catch(Exception e){
            log.error("Error saving articles to JSON file", e);
        }

    }

}
