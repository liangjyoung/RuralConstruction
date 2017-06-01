package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.DataCollDataDic;

/**
 * A data access object (DAO) providing persistence and search support for
 * DataCollDataDic entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.DataCollDataDic
 * @author MyEclipse Persistence Tools
 */

public class DataCollDataDicDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(DataCollDataDicDAO.class);
	// property constants
	public static final String DATA_DIC_CODE = "dataDicCode";
	public static final String DATA_DIC_NAME = "dataDicName";
	public static final String ISD_CHO_DIC = "isdChoDic";

	protected void initDao() {
		// do nothing
	}

	public void save(DataCollDataDic transientInstance) {
		log.debug("saving DataCollDataDic instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DataCollDataDic persistentInstance) {
		log.debug("deleting DataCollDataDic instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DataCollDataDic findById(java.lang.Integer id) {
		log.debug("getting DataCollDataDic instance with id: " + id);
		try {
			DataCollDataDic instance = (DataCollDataDic) getHibernateTemplate()
					.get("com.rural.bean.DataCollDataDic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(DataCollDataDic instance) {
		log.debug("finding DataCollDataDic instance by example");
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
		log.debug("finding DataCollDataDic instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DataCollDataDic as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDataDicCode(Object dataDicCode) {
		return findByProperty(DATA_DIC_CODE, dataDicCode);
	}

	public List findByDataDicName(Object dataDicName) {
		return findByProperty(DATA_DIC_NAME, dataDicName);
	}

	public List findByIsdChoDic(Object isdChoDic) {
		return findByProperty(ISD_CHO_DIC, isdChoDic);
	}

	public List findAll() {
		log.debug("finding all DataCollDataDic instances");
		try {
			String queryString = "from DataCollDataDic";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DataCollDataDic merge(DataCollDataDic detachedInstance) {
		log.debug("merging DataCollDataDic instance");
		try {
			DataCollDataDic result = (DataCollDataDic) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DataCollDataDic instance) {
		log.debug("attaching dirty DataCollDataDic instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DataCollDataDic instance) {
		log.debug("attaching clean DataCollDataDic instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DataCollDataDicDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (DataCollDataDicDAO) ctx.getBean("DataCollDataDicDAO");
	}
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding DataCollDataDic number with conditon: " );
		try {
			String queryString = "from DataCollDataDic as model ";
			if (sql != null) {
				queryString += " where " + sql;
			}
			Query query = this.getSession().createQuery(queryString);  
			if (values != null) {
				 for (int i = 0; i < values.size(); i++) {
						query.setParameter(i, values.get(i));
					}
			}
			List<?> list = query.list();
			int rows = query.list().size();  
	        return rows;
		} catch (RuntimeException re) {
			re.printStackTrace();
			log.error("finding DataCollDataDic number with conditon name failed", re);
		}
		return 0;
	}
	public List<DataCollDataDic> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding DataCollDataDic instance with conditon: " );
		try {
			List<DataCollDataDic> result = null;
			String queryString = "from DataCollDataDic as model ";
			String orderRule =" order by dataDicCode";
			if (sql != null) {
				queryString += " where " + sql;
			}
			
			Query query = this.getSession().createQuery(queryString + orderRule);  
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
			log.error("finding DataCollDataDic instance with conditon failed", re);
			throw re;
		}
	}
	
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding DataCollDataDic instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DataCollDataDic as model where model."
					+ propertyName +"= '"+value+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}