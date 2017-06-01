package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.CitysCont;

/**
 * A data access object (DAO) providing persistence and search support for
 * CitysCont entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.CitysCont
 * @author MyEclipse Persistence Tools
 */

public class CitysContDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CitysContDAO.class);
	// property constants
	public static final String CITYS_CONT_NUM = "citysContNum";
	public static final String CITYS_CONT_NAME = "citysContName";
	public static final String CITYS_CONT_WORK_TEL = "citysContWorkTel";
	public static final String CITYS_CONT_MOB_TEL = "citysContMobTel";
	public static final String CITYS_CONT_COMP = "citysContComp";
	public static final String CITYS_CONT_POST = "citysContPost";
	public static final String CITYS_CONT_NOTE = "citysContNote";

	protected void initDao() {
		// do nothing
	}

	public void save(CitysCont transientInstance) {
		log.debug("saving CitysCont instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CitysCont persistentInstance) {
		log.debug("deleting CitysCont instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CitysCont findById(java.lang.Integer id) {
		log.debug("getting CitysCont instance with id: " + id);
		try {
			CitysCont instance = (CitysCont) getHibernateTemplate().get(
					"com.rural.bean.CitysCont", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CitysCont instance) {
		log.debug("finding CitysCont instance by example");
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
		log.debug("finding CitysCont instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CitysCont as model where model."
					+ propertyName + "="+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding CitysCont instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CitysCont as model where model."
					+ propertyName + "= '"+value+"'";

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCitysContNum(Object citysContNum) {
		return findByProperty(CITYS_CONT_NUM, citysContNum);
	}

	public List findByCitysContName(Object citysContName) {
		return findByProperty(CITYS_CONT_NAME, citysContName);
	}

	public List findByCitysContWorkTel(Object citysContWorkTel) {
		return findByProperty(CITYS_CONT_WORK_TEL, citysContWorkTel);
	}

	public List findByCitysContMobTel(Object citysContMobTel) {
		return findByProperty(CITYS_CONT_MOB_TEL, citysContMobTel);
	}

	public List findByCitysContComp(Object citysContComp) {
		return findByProperty(CITYS_CONT_COMP, citysContComp);
	}

	public List findByCitysContPost(Object citysContPost) {
		return findByProperty(CITYS_CONT_POST, citysContPost);
	}

	public List findByCitysContNote(Object citysContNote) {
		return findByProperty(CITYS_CONT_NOTE, citysContNote);
	}

	public List findAll() {
		log.debug("finding all CitysCont instances");
		try {
			String queryString = "from CitysCont";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CitysCont merge(CitysCont detachedInstance) {
		log.debug("merging CitysCont instance");
		try {
			CitysCont result = (CitysCont) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CitysCont instance) {
		log.debug("attaching dirty CitysCont instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CitysCont instance) {
		log.debug("attaching clean CitysCont instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CitysContDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CitysContDAO) ctx.getBean("CitysContDAO");
	}
	
	public List<CitysCont> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding CitysCont instance with conditon: " );
		try {
			List<CitysCont> result = null;
			String queryString = "from CitysCont as model ";
			//String orderRule = getOrderRule();
			if (sql != null) {
				queryString += " where " + sql;
			}
			Query query = this.getSession().createQuery(queryString);  
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
			log.error("finding CitysCont instance with conditon failed", re);
			throw re;
		}
	}
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding CitysCont number with conditon: " );
		try {
			String queryString = "from CitysCont as model ";
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
			log.error("finding CitysCont number with conditon name failed", re);
		}
		return 0;
	}
	
	public List<CitysCont> findByConditionAndPager(int cityBasicInfoID,String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding CitysCont instance with conditon: " );
		try {
			//System.out.println(VillageCompartmentAction.townNo);
			
			List<CitysCont> result = null;
			String queryString = "from CitysCont as model where cityBasicInfoID ="+cityBasicInfoID;
			String orderRule ="order by citysContNum";
			if (sql != null) {
				queryString += " and " + sql;
			}
			Query query = this.getSession().createQuery(queryString + orderRule);  
			if (values != null) {
				for (int i = 0; i < values.size(); i++) {
					query.setParameter(i, values.get(i));
				}
			}
	        query.setFirstResult(from);  
	        query.setMaxResults(length);  
	        query.list();
	  
	        result = query.list();  
	        
	       
	        return result;
		} catch (RuntimeException re) {
			log.error("finding CitysCont instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(int cityBasicInfoID,String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding CitysCont number with conditon: " );
		try {
			String queryString = "from CitysCont as model where CityBasicInfoID ="+cityBasicInfoID;
			if (sql != null) {
				queryString += " and " + sql;
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
			log.error("finding CitysCont number with conditon name failed", re);
		}
		return 0;
	}
}