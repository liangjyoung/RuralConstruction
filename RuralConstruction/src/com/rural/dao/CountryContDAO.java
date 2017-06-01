package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.CountryCont;

/**
 * A data access object (DAO) providing persistence and search support for
 * CountryCont entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.CountryCont
 * @author MyEclipse Persistence Tools
 */

public class CountryContDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CountryContDAO.class);
	// property constants
	public static final String COUNTRY_CONT_NUM = "countryContNum";
	public static final String COUNTRY_CONT_NAME = "countryContName";
	public static final String COUNTRY_CONT_WORK_TEL = "countryContWorkTel";
	public static final String COUNTRY_CONT_MOB_TEL = "countryContMobTel";
	public static final String COUNTRY_CONT_COMP = "countryContComp";
	public static final String COUNTRY_CONT_POST = "countryContPost";
	public static final String COUNTRY_CONT_NOTE = "countryContNote";

	protected void initDao() {
		// do nothing
	}

	public void save(CountryCont transientInstance) {
		log.debug("saving CountryCont instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CountryCont persistentInstance) {
		log.debug("deleting CountryCont instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CountryCont findById(java.lang.Integer id) {
		log.debug("getting CountryCont instance with id: " + id);
		try {
			CountryCont instance = (CountryCont) getHibernateTemplate().get(
					"com.rural.bean.CountryCont", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CountryCont instance) {
		log.debug("finding CountryCont instance by example");
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
		log.debug("finding CountryCont instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CountryCont as model where model."
					+ propertyName + "="+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding CountryCont instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CountryCont as model where model."
					+ propertyName + "= '"+value+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCountryContNum(Object countryContNum) {
		return findByProperty(COUNTRY_CONT_NUM, countryContNum);
	}

	public List findByCountryContName(Object countryContName) {
		return findByProperty(COUNTRY_CONT_NAME, countryContName);
	}

	public List findByCountryContWorkTel(Object countryContWorkTel) {
		return findByProperty(COUNTRY_CONT_WORK_TEL, countryContWorkTel);
	}

	public List findByCountryContMobTel(Object countryContMobTel) {
		return findByProperty(COUNTRY_CONT_MOB_TEL, countryContMobTel);
	}

	public List findByCountryContComp(Object countryContComp) {
		return findByProperty(COUNTRY_CONT_COMP, countryContComp);
	}

	public List findByCountryContPost(Object countryContPost) {
		return findByProperty(COUNTRY_CONT_POST, countryContPost);
	}

	public List findByCountryContNote(Object countryContNote) {
		return findByProperty(COUNTRY_CONT_NOTE, countryContNote);
	}

	public List findAll() {
		log.debug("finding all CountryCont instances");
		try {
			String queryString = "from CountryCont";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CountryCont merge(CountryCont detachedInstance) {
		log.debug("merging CountryCont instance");
		try {
			CountryCont result = (CountryCont) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CountryCont instance) {
		log.debug("attaching dirty CountryCont instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CountryCont instance) {
		log.debug("attaching clean CountryCont instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CountryContDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CountryContDAO) ctx.getBean("CountryContDAO");
	}
	
	public List<CountryCont> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding CountryCont instance with conditon: " );
		try {
			List<CountryCont> result = null;
			String queryString = "from CountryCont as model ";
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
			log.error("finding CountryCont instance with conditon failed", re);
			throw re;
		}
	}
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding CountryCont number with conditon: " );
		try {
			String queryString = "from CountryCont as model ";
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
			log.error("finding CountryCont number with conditon name failed", re);
		}
		return 0;
	}
	
	
	public List<CountryCont> findByConditionAndPager(int countryBasicInfoID,String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding CountryCont instance with conditon: " );
		try {
			//System.out.println(VillageCompartmentAction.townNo);
			
			List<CountryCont> result = null;
			String queryString = "from CountryCont as model where CountryBasicInfoID ="+countryBasicInfoID;
			String orderRule = "order by countryContNum";
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
			log.error("finding CountryCont instance with conditon failed", re);
			throw re;
		}
	}
	public int getCounts(int countryBasicInfoID,String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding CountryCont number with conditon: " );
		try {
			String queryString = "from CountryCont as model where CountryBasicInfoID ="+countryBasicInfoID;
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
			log.error("finding CountryCont number with conditon name failed", re);
		}
		return 0;
	}
}