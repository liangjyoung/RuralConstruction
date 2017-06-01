package com.rural.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.CitysFil;
import com.rural.bean.SysRoleUser;
import com.rural.govfile.action.CitysFilAction;
import com.rural.usermanager.action.SysUserAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysRoleUser entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.SysRoleUser
 * @author MyEclipse Persistence Tools
 */

public class SysRoleUserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SysRoleUserDAO.class);
	// property constants
	public static final String SYS_ROLE_USER_NOTE = "sysRoleUserNote";

	protected void initDao() {
		// do nothing
	}
	
	//带返回值的存储过程
	//根据userid返回roleid列表
	public List<String> checkRoleID(int userid) throws SQLException{
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Connection conn=session.connection();
		String procedure = "{call proc_SysRoleUserBySysUserIDSel(?)}";
		CallableStatement proc =conn.prepareCall(procedure);
		proc.setInt(1, userid); //将参数传入存储过程中
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

	public void save(SysRoleUser transientInstance) {
		log.debug("saving SysRoleUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SysRoleUser persistentInstance) {
		log.debug("deleting SysRoleUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SysRoleUser findById(java.lang.Integer id) {
		log.debug("getting SysRoleUser instance with id: " + id);
		try {
			SysRoleUser instance = (SysRoleUser) getHibernateTemplate().get(
					"com.rural.bean.SysRoleUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SysRoleUser instance) {
		log.debug("finding SysRoleUser instance by example");
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
		log.debug("finding SysRoleUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysRoleUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySysRoleUserNote(Object sysRoleUserNote) {
		return findByProperty(SYS_ROLE_USER_NOTE, sysRoleUserNote);
	}

	public List findAll() {
		log.debug("finding all SysRoleUser instances");
		try {
			String queryString = "from SysRoleUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SysRoleUser merge(SysRoleUser detachedInstance) {
		log.debug("merging SysRoleUser instance");
		try {
			SysRoleUser result = (SysRoleUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SysRoleUser instance) {
		log.debug("attaching dirty SysRoleUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SysRoleUser instance) {
		log.debug("attaching clean SysRoleUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SysRoleUserDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SysRoleUserDAO) ctx.getBean("SysRoleUserDAO");
	}
	
	public List<SysRoleUser> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding SysRoleUser instance with conditon: " );
		try {
			List<SysRoleUser> result = null;
			String s = SysUserAction.getJQS();
			String queryString = "from SysRoleUser as model where SysRoleID = '"+s+"'";
			//String orderRule = getOrderRule();
			if (sql != null) {
				queryString += " and " + sql;
			}
			Query query = this.getSession().createQuery(queryString);//+orderRule);  
			if (values != null) {
				for (int i = 0; i < values.size(); i++) {
					query.setParameter(i, values.get(i));
				}
			}
	        query.setFirstResult(from);  
	        query.setMaxResults(length);  
	  
	        result = query.list();  
	        return result;
		} catch (RuntimeException re) {
			log.error("finding SysRoleUser instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding SysRoleUser number with conditon: " );
		try {
			String s = SysUserAction.getJQS();
			String queryString = "from SysRoleUser as model where SysRoleID ='"+s+"'";
			if (sql != null) {
				queryString += " and " + sql;
			}
			Query query = this.getSession().createQuery(queryString);  
			if (values != null) {
				 for (int i = 0; i < values.size(); i++) {
						query.setParameter(i, values.get(i));
					}
			}
			int rows = query.list().size();  
	        return rows;
		} catch (RuntimeException re) {
			log.error("finding SysRoleUser number with conditon name failed", re);
			throw re;
		}
	}
	
	
	
	public List findDoiubleSearch(int userID, int roleID) {
		log.debug("finding SysRoleUser instance with property: userID:"+userID+", roleID: " + roleID);
		try {
			String queryString = "from SysRoleUser as model where model.sysUser.sysUserId = "+userID+" and model.sysRole.sysRoleId = "+roleID;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	
}