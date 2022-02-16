package apsj.ws.dao;

import java.util.HashMap;
import java.util.Map;

import classes.Article;

public enum ArticleDao {
	instance;
	
	private Map<String, Article> contentProvider = new HashMap<>();

    private ArticleDao() {

        Todo todo = new Todo("1", "Prendre un bon petit déj");
        todo.setDescription("il est important de commencer la journée par un repas équilibré");
        contentProvider.put("1", todo);
        todo = new Todo("2", "Faire 10000 pas");
        todo.setDescription("afin de garder une bonne santé");
        contentProvider.put("2", todo);

    }
    public Map<String, Todo> getModel(){
        return contentProvider;
    }
}
