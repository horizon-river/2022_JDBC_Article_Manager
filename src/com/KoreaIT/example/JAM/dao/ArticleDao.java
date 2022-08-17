package com.KoreaIT.example.JAM.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.KoreaIT.example.JAM.Article;
import com.KoreaIT.example.JAM.container.Container;
import com.KoreaIT.example.JAM.util.DBUtil;
import com.KoreaIT.example.JAM.util.SecSql;

public class ArticleDao {
	
	
	public ArticleDao() {
		
	}

	public int doWrite(String title, String body) {
		SecSql sql = new SecSql();
		sql.append("INSERT INTO article ");
		sql.append("SET regDate = NOW()");
		sql.append(",updateDate = NOW()");
		sql.append(",title = ?", title);
		sql.append(",`body` = ?", body);
		
		int id = DBUtil.insert(Container.conn, sql);
		
		return id;
	}

	public void doDelete(int id) {
		SecSql sql = new SecSql();
		sql.append("DELETE FROM article");
		sql.append("WHERE id = ?", id);
		
		DBUtil.delete(Container.conn, sql);
	}

	public void doUpdate(String title, String body, int id) {
		SecSql sql = new SecSql();
		
		sql.append("UPDATE article ");
		sql.append("SET updateDate = NOW()");
		sql.append(",title = ?", title);
		sql.append(",`body` = ?", body);
		sql.append("WHERE id = ?", id);
		
		DBUtil.update(Container.conn, sql);
	}
	
	public Article getArticleById(int id) {
		
		SecSql sql = new SecSql();

		sql.append("SELECT *");
		sql.append("FROM article");
		sql.append("WHERE id = ?", id);
		
		Map<String, Object> articleMap = DBUtil.selectRow(Container.conn, sql);
			
		if(articleMap.isEmpty()) {
			return null;
		}
		
		return new Article(articleMap);
	}

	public List<Article> getArticles() {
		SecSql sql = new SecSql();
		
		sql.append("SELECT *");
		sql.append("FROM article");
		sql.append("ORDER BY id DESC");
		
		List<Map<String, Object>> articlesListMap = DBUtil.selectRows(Container.conn, sql);
		
		List<Article> articles = new ArrayList<>();
		
		for(Map<String, Object> articleMap : articlesListMap) {
			articles.add(new Article(articleMap));
		}
		
		return articles;
	}

}