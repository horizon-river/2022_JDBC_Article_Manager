package com.KoreaIT.example.JAM.service;

import java.util.List;

import com.KoreaIT.example.JAM.Article;
import com.KoreaIT.example.JAM.container.Container;
import com.KoreaIT.example.JAM.dao.ArticleDao;

public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int doWrite(String title, String body) {
		return articleDao.doWrite(title, body);
	}

	public void doDelete(int id) {
		articleDao.doDelete(id);
	}

	public void doUpdate(int id, String title, String body) {
		articleDao.doUpdate(title, body, id);
	}

	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}
}
