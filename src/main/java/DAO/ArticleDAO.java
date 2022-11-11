/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITES.Article;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dell
 */
public class ArticleDAO {
    
    //private static List<Article> listArticles = new ArrayList<Article>();
    
    private static Session session;
    private static Transaction transaction;
    
    public static void create(Article article)
    {
        session =HibernateUtil.getSessionFactory().openSession();
         
        transaction = session.beginTransaction();
        session.save(article);
        transaction.commit();
       
      
    }
    
    public static void delete(Article article)
    {
        session =HibernateUtil.getSessionFactory().openSession();
         
        transaction = session.beginTransaction();
        session.delete(article);
        transaction.commit();
       
      
    }
    
    public static void update(Article article)
    {
        session =HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Article a = session.load(Article.class,article.getCode());
         a.setDesignation(article.getDesignation());
        a.setPrix(article.getPrix());
        session.update(a);
        transaction.commit();
       
    }
    
    public Article findById(String code) {
        Article d,art;
        //art = new Article(code);
        System.out.println("in findById before");
        session =HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        d = (Article)session.load(Article.class,code );
        
        System.out.println("in findById after");
        transaction.commit();
        return d;
    }
    
    public static List<Article> getAll()
    {
        session =HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Article> articles = new ArrayList<Article>();
        try
        {
            articles = session.createQuery("from Article").list();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return articles;
    }
   /* public static void create(Article a)
    {
        listArticles.add(a);
    }
    public static void delete(Article a)
    {
        listArticles.remove(a);
    }
    public static void update(Article a)
    {
        int position = listArticles.indexOf(a);
        listArticles.get(position).setDesignation(a.getDesignation());
        listArticles.get(position).setPrix(a.getPrix());
    }
    public static List<Article> getAll()
    {
        return listArticles;
    }
    
    public static Article getItem(Article a)
    {
        int position = listArticles.lastIndexOf(a);
        return listArticles.get(position);
    }*/
}
