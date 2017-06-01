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
import com.rural.bean.DataCollDicEntry;
import com.rural.datacolldatadic.action.DataCollDicEntryAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * DataCollDicEntry entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.DataCollDicEntry
 * @author MyEclipse Persistence Tools
 */

public class DataCollDicEntryDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(DataCollDicEntryDAO.class);
	// property constants
	public static final String DIC_ENTRY_CODE = "dicEntryCode";
	public static final String DIC_ENTRY_NAME = "dicEntryName";

	protected void initDao() {
		// do nothing
	}

	public void save(DataCollDicEntry transientInstance) {
		log.debug("saving DataCollDicEntry instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DataCollDicEntry persistentInstance) {
		log.debug("deleting DataCollDicEntry instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DataCollDicEntry findById(java.lang.Integer id) {
		log.debug("getting DataCollDicEntry instance with id: " + id);
		try {
			DataCollDicEntry instance = (DataCollDicEntry) getHibernateTemplate()
					.get("com.rural.bean.DataCollDicEntry", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(DataCollDicEntry instance) {
		log.debug("finding DataCollDicEntry instance by example");
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
		log.debug("finding DataCollDicEntry instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DataCollDicEntry as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDicEntryCode(Object dicEntryCode) {
		return findByProperty(DIC_ENTRY_CODE, dicEntryCode);
	}

	public List findByDicEntryName(Object dicEntryName) {
		return findByProperty(DIC_ENTRY_NAME, dicEntryName);
	}

	public List findAll() {
		log.debug("finding all DataCollDicEntry instances");
		try {
			String queryString = "from DataCollDicEntry";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DataCollDicEntry merge(DataCollDicEntry detachedInstance) {
		log.debug("merging DataCollDicEntry instance");
		try {
			DataCollDicEntry result = (DataCollDicEntry) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DataCollDicEntry instance) {
		log.debug("attaching dirty DataCollDicEntry instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DataCollDicEntry instance) {
		log.debug("attaching clean DataCollDicEntry instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DataCollDicEntryDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (DataCollDicEntryDAO) ctx.getBean("DataCollDicEntryDAO");
	}
	public int getCounts(String sql , List<Object> values){
		log.debug("finding DataCollDicEntry number with conditon: " );
		
		try {
			
			String queryString = "from DataCollDicEntry as model ";
			if (sql != null) {
				queryString += " where " + sql;
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
			log.error("finding DataCollDicEntry number with conditon name failed", re);
			throw re;
		}
	}
	
	public List<DataCollDicEntry> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding DataCollDicEntry instance with conditon: " );
		try {
			List<DataCollDicEntry> result = null;
			//int s = Integer.parseInt(DataCollDicEntryAction.getJQS());
			String queryString = "from DataCollDicEntry as model ";
			String orderRule = " "+"order by dicEntryCode";
			if (sql != null) {
				queryString += " where " + sql;
			}
			Query query = this.getSession().createQuery(queryString +orderRule);//+orderRule);  
			System.out.println(query);
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
			log.error("finding DataCollDicEntry instance with conditon failed", re);
			throw re;
		}
	}
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding DataCollDicEntry instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DataCollDicEntry as model where model."
					+ propertyName +"= '"+value+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDataCollDataDicId(int DataCollDataDicId){
		log.debug("finding DataCollDicEntry list with DataCollDicEntryID: " );
		try {
			//List<Invgat> result = null;
			//String s = InvgatDworkAction.getJQI();
			//String queryString = "from Invgat as model where InvgatNum = '"+s+"'";
			String queryString = "from DataCollDicEntry as model where DataCollDataDicID ="+DataCollDataDicId;
			Query query = this.getSession().createQuery(queryString);  
	        return query.list(); 
		} catch (RuntimeException re) {
			log.error("finding DataCollDicEntry instance with conditon failed", re);
			throw re;
		}
	}

}