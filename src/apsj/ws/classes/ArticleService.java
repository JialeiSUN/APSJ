package apsj.ws.classes;

import java.util.ArrayList;

import classes.Article;
import classes.Categorie;
import javax.ejb.Stateless;
import javax.jws.WebService;


@WebService(targetNamespace="http://apsj.ws.classes/article",endpointInterface="apsj.ws.classes.ArticleServiceRemote")
public class ArticleService implements ArticleServiceRemote {

	@Override
	public boolean insertArticle(Article Article) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateArticle(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Article> viewArticle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteArticle(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Article> viewArticleCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

}
