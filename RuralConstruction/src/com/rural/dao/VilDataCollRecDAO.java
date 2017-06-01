package com.rural.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

import com.rural.bean.VilDataCollRec;

/**
 	* A data access object (DAO) providing persistence and search support for VilDataCollRec entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.test.VilDataCollRec
  * @author MyEclipse Persistence Tools 
 */

public class VilDataCollRecDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(VilDataCollRecDAO.class);
		//property constants
	public static final String VIL_BASIC_INFO_ID = "vilBasicInfoId";
	public static final String INVGAT_ID = "invgatId";
	public static final String VIL_DATA_COLL_REC_NOTE = "vilDataCollRecNote";
	public static final String COLL_EQPT_CODE = "collEqptCode";



	protected void initDao() {
		//do nothing
	}
    
    public void save(VilDataCollRec transientInstance) {
        log.debug("saving VilDataCollRec instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(VilDataCollRec persistentInstance) {
        log.debug("deleting VilDataCollRec instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public VilDataCollRec findById( java.lang.Integer id) {
        log.debug("getting VilDataCollRec instance with id: " + id);
        try {
            VilDataCollRec instance = (VilDataCollRec) getHibernateTemplate()
                    .get("com.rural.bean.VilDataCollRec", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(VilDataCollRec instance) {
        log.debug("finding VilDataCollRec instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding VilDataCollRec instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from VilDataCollRec as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByVilBasicInfoId(Object vilBasicInfoId
	) {
		return findByProperty(VIL_BASIC_INFO_ID, vilBasicInfoId
		);
	}
	
	public List findByInvgatId(Object invgatId
	) {
		return findByProperty(INVGAT_ID, invgatId
		);
	}
	
	public List findByVilDataCollRecNote(Object vilDataCollRecNote
	) {
		return findByProperty(VIL_DATA_COLL_REC_NOTE, vilDataCollRecNote
		);
	}
	
	public List findByCollEqptCode(Object collEqptCode
	) {
		return findByProperty(COLL_EQPT_CODE, collEqptCode
		);
	}
	

	public List findAll() {
		log.debug("finding all VilDataCollRec instances");
		try {
			String queryString = "from VilDataCollRec";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public VilDataCollRec merge(VilDataCollRec detachedInstance) {
        log.debug("merging VilDataCollRec instance");
        try {
            VilDataCollRec result = (VilDataCollRec) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(VilDataCollRec instance) {
        log.debug("attaching dirty VilDataCollRec instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(VilDataCollRec instance) {
        log.debug("attaching clean VilDataCollRec instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static VilDataCollRecDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (VilDataCollRecDAO) ctx.getBean("VilDataCollRecDAO");
	}
	
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding VilDataCollRec instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from VilDataCollRec as model where model."
					+ propertyName + "="+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public int getCounts(String sql , List<Object> values){
		log.debug("finding VilDataCollRec number with conditon: " );
		try {
			String queryString = "from VilDataCollRec as model ";
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
			log.error("finding VilDataCollRec number with conditon name failed", re);
			throw re;
		}
	}
	
	
	
	
	public List<VilDataCollRec> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding VilDataCollRec instance with conditon: " );
	
		try {
			List<VilDataCollRec> result = null;
			String queryString = "from VilDataCollRec as model ";
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
			log.error("finding VilDataCollRec instance with conditon failed", re);
			throw re;
		}
	}

	
	public List findNewRec(int vilID, int InvId, Date time) {
		log.debug("finding VilDataCollRec instance with property: ");
		try {
			String queryString = "from VilDataCollRec as model where vilBasicInfo.vilBasicInfoId = "+vilID+" and invgat.invgatId = "+InvId+" and collTim = "+time;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findNewRec1(int vilID,String time) {
		log.debug("finding VilDataCollRec instance with property: ");
		try {
			String queryString = "from VilDataCollRec as model where vilBasicInfo.vilBasicInfoId = "+vilID+" and year(collTim) = '"+time+"' order by CollTim";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
	
	public List<VilDataCollRec> findVilDataCollRec(int vilId, int collTime) {
		
		VilDataCollRec vilDataCollRec = new  VilDataCollRec();
		
		
		try {
			String queryString = "from VilDataCollRec as model where vilBasicInfo.vilBasicInfoId ="+vilId+" and collTim like'%"+collTime+"%'";
			Query query = this.getSession().createQuery(queryString);  
	        return query.list(); 
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
public List<VilDataCollRec> findVilDataCollRec( int collTime) {
		
		VilDataCollRec vilDataCollRec = new  VilDataCollRec();
		
		
		try {
			String queryString = "from VilDataCollRec as model where collTim like'%"+collTime+"%'";
			Query query = this.getSession().createQuery(queryString);  
	        return query.list(); 
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	@SuppressWarnings("deprecation")
	public List<Integer> findYears(String sql)throws Exception{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Connection conn = session.connection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			List<Integer> records = new ArrayList<Integer>();
			while(rs.next())
				records.add(rs.getInt("Year"));
			return records;
		} finally {
			// TODO Auto-generated catch block
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		}
	}
	
	@SuppressWarnings("deprecation")
	public List<Integer> findCollRecs(String sql) throws SQLException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Connection conn = session.connection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			List<Integer> records = new ArrayList<Integer>();
			while(rs.next())
				records.add(rs.getInt("VilDataCollRecID"));
			return records;
		} finally {
			// TODO Auto-generated catch block
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		}
	}



public List findVillRecByVillID(int VillID) {
    log.debug("finding VilDataCollRec instance with property: ");
    try {
       String queryString = "from VilDataCollRec as model where vilBasicInfo.vilBasicInfoId = " +VillID+"order by CollTim DESC";
		 return getHibernateTemplate().find(queryString);
    } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
    }
	}
public List findFather() {
    
    try {
       String queryString = "from VilDataCollRec order by CollTim";
		 return getHibernateTemplate().find(queryString);
    } catch (RuntimeException re) {
       log.error("find by property name failed", re);
       throw re;
    }
	}




}