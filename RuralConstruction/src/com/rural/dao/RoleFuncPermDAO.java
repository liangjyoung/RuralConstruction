package com.rural.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.RoleFuncPerm;
import com.rural.usermanager.action.SysFuncAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * RoleFuncPerm entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.RoleFuncPerm
 * @author MyEclipse Persistence Tools
 */

public class RoleFuncPermDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RoleFuncPermDAO.class);
	// property constants
	public static final String ROLE_FUNC_PERM_NOTE = "roleFuncPermNote";

	protected void initDao() {
		// do nothing
	}
	
	//带返回值的存储过程
	//根据userid返回roleid列表
	public List<String> chooseFunc(int roleid) throws SQLException{
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Connection conn=session.connection();
		String procedure = "{call proc_RoleFuncPermBySysRoleIDSel(?)}";
		CallableStatement proc =conn.prepareCall(procedure);
		proc.setInt(1, roleid); //将参数传入存储过程中
		ResultSet rs =proc.executeQuery();
		
		List<String> rolelist=new ArrayList<String>();
		//将sql返回的roleID赋给一个list
//		int rolenum=0;
		while (rs != null && rs.next()) { 
			 rolelist.add(rs.getString(1));
//			 rolenum++;
		} 
		rs.close();
		proc.close();
		conn.close();
		session.close();
		sf.close();
		return rolelist;
		
	}

	public void save(RoleFuncPerm transientInstance) {
		log.debug("saving RoleFuncPerm instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoleFuncPerm persistentInstance) {
		log.debug("deleting RoleFuncPerm instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoleFuncPerm findById(java.lang.Integer id) {
		log.debug("getting RoleFuncPerm instance with id: " + id);
		try {
			RoleFuncPerm instance = (RoleFuncPerm) getHibernateTemplate().get(
					"com.rural.bean.RoleFuncPerm", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RoleFuncPerm instance) {
		log.debug("finding RoleFuncPerm instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RoleFuncPerm instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RoleFuncPerm as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			System.out.println("----------->"+re);
			throw re;
		}
	}
	
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding RoleFuncPerm instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RoleFuncPerm as model where model."
					+ propertyName +"='"+value+"'";

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleFuncPermNote(Object roleFuncPermNote) {
		return findByProperty(ROLE_FUNC_PERM_NOTE, roleFuncPermNote);
	}

	public List findAll() {
		log.debug("finding all RoleFuncPerm instances");
		try {
			String queryString = "from RoleFuncPerm";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoleFuncPerm merge(RoleFuncPerm detachedInstance) {
		log.debug("merging RoleFuncPerm instance");
		try {
			RoleFuncPerm result = (RoleFuncPerm) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RoleFuncPerm instance) {
		log.debug("attaching dirty RoleFuncPerm instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoleFuncPerm instance) {
		log.debug("attaching clean RoleFuncPerm instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoleFuncPermDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (RoleFuncPermDAO) ctx.getBean("RoleFuncPermDAO");
	}
	
public List findFather(String parentId) {
        
        try {
        	int s = SysFuncAction.getIDS();
           String queryString = "from RoleFuncPerm where FuncNum = '"+parentId+"' and sysroleID = "+s;
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
}