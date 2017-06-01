package com.rural.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.SysRole;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysRole entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.SysRole
 * @author MyEclipse Persistence Tools
 */

public class SysRoleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SysRoleDAO.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String ROLE_NOTE = "roleNote";

	protected void initDao() {
		// do nothing
	}
	
	//带返回值的存储过程
	//根据roleid	返回rolename列表
	public String checkRoleName(int roleid) throws SQLException{
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Connection conn=session.connection();
		CallableStatement proc = conn.prepareCall("{call proc_SysRoleBySysRoleIDOut(?,?)}");
		//注意：这里是传入输入参数
		proc.setInt(1,roleid); 
		//注意：这里是注册输出参数
		proc.registerOutParameter(2,java.sql.Types.NVARCHAR);
		//执行存储过程
		proc.execute();
		//获取执行完的存储过程的返回值
		String rolename =proc.getString(2);
//		System.out.println("---------"+rolename);
		proc.close();
		conn.close();
		session.close();
		sf.close();
		return rolename;
		
	}

	public void save(SysRole transientInstance) {
		log.debug("saving SysRole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SysRole persistentInstance) {
		log.debug("deleting SysRole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SysRole findById(java.lang.Integer id) {
		log.debug("getting SysRole instance with id: " + id);
		try {
			SysRole instance = (SysRole) getHibernateTemplate().get(
					"com.rural.bean.SysRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SysRole instance) {
		log.debug("finding SysRole instance by example");
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
		log.debug("finding SysRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysRole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	public List findByRoleNote(Object roleNote) {
		return findByProperty(ROLE_NOTE, roleNote);
	}

	public List findAll() {
		log.debug("finding all SysRole instances");
		try {
			String queryString = "from SysRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SysRole merge(SysRole detachedInstance) {
		log.debug("merging SysRole instance");
		try {
			SysRole result = (SysRole) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SysRole instance) {
		log.debug("attaching dirty SysRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SysRole instance) {
		log.debug("attaching clean SysRole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SysRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SysRoleDAO) ctx.getBean("SysRoleDAO");
	}
	
	public List findChild(String value) {
	       
        try {
           String queryString = "from SysRole where UpSysRoleNum ='"+value+"'";
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
    
    public List findFather() {
        
        try {
           String queryString = "from SysRole where UpSysRoleNum is null";
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
}