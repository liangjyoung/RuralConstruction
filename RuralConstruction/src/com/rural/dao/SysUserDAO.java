package com.rural.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.SysUser;
import com.rural.usermanager.action.SysUserAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.SysUser
 * @author MyEclipse Persistence Tools
 */

public class SysUserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SysUserDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PAS = "userPas";
	public static final String USER_NOTE = "userNote";
	public static final String USER_BELO_DIVI_CODE = "userBeloDiviCode";

	protected void initDao() {
		// do nothing
	}
	
	//带返回值的存储过程
	public String[] NameCheck(String username, String password) throws SQLException{
		
		String[] idandcode=new String[2];
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Connection conn=session.connection();
		CallableStatement proc = conn.prepareCall("{call proc_SysUserByNamPasOut(?,?,?,?)}");
		//注意：这里是传入输入参数
		proc.setString(1,username); 
		proc.setString(2, password);
		//注意：这里是注册输出参数
		proc.registerOutParameter(3,java.sql.Types.INTEGER);
		proc.registerOutParameter(4,java.sql.Types.NVARCHAR);
		//执行存储过程
		proc.execute();
		//获取执行完的存储过程的返回值
		idandcode[0] =proc.getString(3);
		idandcode[1] =proc.getString(4);
//		System.out.println("---------"+idandcode[0]);
//		System.out.println("---------"+idandcode[0]);
		proc.close();
		conn.close();
		session.close();
		sf.close();
//		this.dataMap.put("ss",s);
//		this.dataMap.put("tt",t);
		return idandcode;
	}

	public void save(SysUser transientInstance) {
		log.debug("saving SysUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SysUser persistentInstance) {
		log.debug("deleting SysUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SysUser findById(java.lang.Integer id) {
		log.debug("getting SysUser instance with id: " + id);
		try {
			SysUser instance = (SysUser) getHibernateTemplate().get(
					"com.rural.bean.SysUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SysUser instance) {
		log.debug("finding SysUser instance by example");
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
		log.debug("finding SysUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysUser as model where model."
					+ propertyName + "='"+value+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByUserPas(Object userPas) {
		return findByProperty(USER_PAS, userPas);
	}

	public List findByUserNote(Object userNote) {
		return findByProperty(USER_NOTE, userNote);
	}

	public List findByUserBeloDiviCode(Object userBeloDiviCode) {
		return findByProperty(USER_BELO_DIVI_CODE, userBeloDiviCode);
	}

	public List findAll() {
		log.debug("finding all SysUser instances");
		try {
			String queryString = "from SysUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SysUser merge(SysUser detachedInstance) {
		log.debug("merging SysUser instance");
		try {
			SysUser result = (SysUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SysUser instance) {
		log.debug("attaching dirty SysUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SysUser instance) {
		log.debug("attaching clean SysUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SysUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SysUserDAO) ctx.getBean("SysUserDAO");
	}
	
	public List<SysUser> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding SysUser instance with conditon: " );
		try {
			List<SysUser> result = null;
			String s = SysUserAction.getJQS();
			String queryString = "select model from SysUser as model ,SysRoleUser as sr where model.sysUserId = sr.sysUser.sysUserId and sr.sysRole.sysRoleId = '"+s+"'";
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
			log.error("finding SysUser instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding SysUser number with conditon: " );
		try {
			String s = SysUserAction.getJQS();
			String queryString = "from SysUser as model where SysRoleID ='"+s+"'";
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
			log.error("finding SysUser number with conditon name failed", re);
			throw re;
		}
	}
	
}