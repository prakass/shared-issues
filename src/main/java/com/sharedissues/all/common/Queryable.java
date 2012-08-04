package com.sharedissues.all.common;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Queryable 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void persist(Object o){
		Session s =sessionFactory.openSession();
		s.beginTransaction();
		try{
			s.save(o);
			s.getTransaction().commit();
		}catch(Exception e){
			s.getTransaction().rollback();
		}finally{
			s.close();
		}
	}
	public void saveOrUpdate(Object o){
		Session s =sessionFactory.openSession();
		s.beginTransaction();
		try{
			s.saveOrUpdate(o);
			s.getTransaction().commit();
		}catch(Exception e){
			s.getTransaction().rollback();
		}finally{
			s.close();
		}
	}
	public void update(Object o){
		Session s =sessionFactory.openSession();
		s.beginTransaction();
		try{
			s.update(o);
			s.getTransaction().commit();
		}catch(Exception e){
			s.getTransaction().rollback();
		}finally{
			s.close();
		}
	}
	public void remove(String table,String column,String id){
		getJdbcTemplate().update("delete from "+table+" where "+column+" =?",id);
	}
	
	public List<Object> getObjects(Object o,String table){
		List<Object> objects = new ArrayList<Object>();
		Session s =sessionFactory.openSession();
		
		s.beginTransaction();
			try{
				objects=s.createSQLQuery("select * from "+table).addEntity(o.getClass()).list();
				s.getTransaction().commit();
			}catch(Exception e){
				s.getTransaction().rollback();
			}finally{
				s.close();
			}
		
		return objects;
	}
	
	public List<Object> getObjectsForQuery(String sql,Object o){
		List<Object> objects = new ArrayList<Object>();
		Session s =sessionFactory.openSession();
		
		s.beginTransaction();
			try{
				objects=s.createSQLQuery(sql).addEntity(o.getClass()).list();
				s.getTransaction().commit();
			}catch(Exception e){
				s.getTransaction().rollback();
			}finally{
				s.close();
			}
		
		return objects;
	}
	
	public Object getObject(Object o,String id){
		Object object = new Object();
		Session s =sessionFactory.openSession();
		s.beginTransaction();
		try{
			object = s.load(o.getClass(),id);
			object.toString();
			s.getTransaction().commit();
			return object;
		}catch(Exception e){
			s.getTransaction().rollback();
			return null;
		}finally{
			s.close();
		}
	}
	
}
