/**
 * 
 */
package com.aia.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.aia.dao.IDaoHelper;
import com.aia.model.AbstractBaseModel;
import com.aia.common.exception.DAOException;
import com.aia.dao.impl.DaoHelperImpl;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * @author verticurl
 *
 */
public class DaoHelperImpl <T extends AbstractBaseModel<T>, PK extends Serializable> 
extends SqlMapClientDaoSupport implements IDaoHelper<T, PK>{
	
	/** The Logger instance */
    private static final Logger LOG = LoggerFactory.getLogger(DaoHelperImpl.class);
    
    /** The possible SQL types */
    private static enum SQL { insert, update, delete, get, list };
    
    //@Override
    public PK save(final T model) throws DAOException {
        return this.save(getSQLName(SQL.insert, model.getClass()), model);
    }
    
    //@Override
    public PK save(final String sqlName, final T model) throws DAOException {
        try {
            // First insert the user details
            PK id = (PK) getSqlMapClient().insert(sqlName, model);
                getSqlMapClient().flushDataCache();
            return id;
        } catch (SQLException se) {
            throw new DAOException(se);
        }
    }
    
    //@Override
    public PK save(final String sqlName, final Map<String, Object> params) throws DAOException {
        try {
            // First insert the user details
            PK id = (PK) getSqlMapClient().insert(sqlName, params);
            return id;
        } catch (SQLException se) {
            throw new DAOException(se);
        }
    }
    
    //@Override
    public int save(final List<T> models) throws DAOException {
        try {
            return getSqlMapClientTemplate().execute(new SqlMapClientCallback<Integer>() {
                //@Override
                public Integer doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                    executor.startBatch();
                    for (T model : models) {
                        executor.insert(getSQLName(SQL.insert, model.getClass()), model);
                    }
                    return executor.executeBatch();
                }
            });
        } catch (DataAccessException se) {
            throw new DAOException(se);
        }
    }
    
    //@Override
    public int update(final T model) throws DAOException {
        try {
            int result = getSqlMapClient().update(getSQLName(SQL.update, model.getClass()), model);
            return result;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    //@Override
    public int update(final String sqlName, final Map<String, Object> params) throws DAOException{
    	try {
    		int i = getSqlMapClient().update(sqlName, params);
    		getSqlMapClient().flushDataCache();
    		return i;
            
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    //@Override
    public int update(final String sqlName, final T model) throws DAOException {
        try {
            // First insert the user details
            int result = getSqlMapClient().update(sqlName, model);
            getSqlMapClient().flushDataCache();
            return result;
        } catch (SQLException se) {
            throw new DAOException(se);
        }
    }
    
    //@Override
    public T get(final Class<T> clazz, final PK id) throws DAOException {
        try {
            return (T) getSqlMapClient().queryForObject(getSQLName(SQL.get, clazz), id);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
   // @Override
    public int delete(final T model) throws DAOException {
        try {
            return getSqlMapClient().delete(
                    getSQLName(SQL.delete, model.getClass()), model);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    //@Override
    public int delete(final String sqlName, final Map<String, Object> param) 
    		throws DAOException {
        try {
            return getSqlMapClient().update(sqlName, param);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    //@Override
    public List<T> find(final Class<T> clazz) throws DAOException {
        try {
            return (List<T>) getSqlMapClient().queryForList(getSQLName(SQL.list, clazz));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    //@Override
    public List<T> find(final Class<T> clazz, final Map<String, Object> params)
            throws DAOException {
        try {
            return (List<T>) getSqlMapClient().queryForList(
                    getSQLName(SQL.list, clazz), params);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    //@Override
    public List<T> find(final String sqlName) throws DAOException {
        try {
            List list = getSqlMapClient().queryForList(sqlName);
            if (null != list) {
                return (List<T>) list;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    //@Override
    public List<T> find(final String sqlName, final Map<String, Object> params)
            throws DAOException {
        try {
            List list = getSqlMapClient().queryForList(sqlName, params);
            if (null != list) {
                return (List<T>) list;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
  //@Override
    public List<T> findList (final String sqlName, final List<String> params) throws DAOException{
    	try {
            List list = getSqlMapClient().queryForList(sqlName, params);
            if (null != list) {
                return (List<T>) list;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    //@Override
    public List findGeneric(final String sqlName, final Map<String, Object> params)
            throws DAOException {
        try {
            return getSqlMapClient().queryForList(sqlName, params);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    //@Override
    public Integer getTotal(final String sqlName, final Map<String, Object> params)
            throws DAOException {
        try {
            Integer total = (Integer)getSqlMapClient().queryForObject(sqlName, params);
            return total;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    //@Override
    public T findObject(final String sqlName, final Map<String, Object> params)
            throws DAOException {
        try {
            Object row = getSqlMapClient().queryForObject(sqlName, params);
            if (null != row) {
                return (T) row;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    /*@Override
    public PK findOrInsert(T model) throws DAOException {
        try {
            String modelName = model.getClass().getSimpleName();
            T row = (T) getSqlMapClient().queryForObject(
                    getSQLName(ISQLNames.FIND_MODEL_BY_TYPE_OR_NAME, model.getClass()),
                    model);
            if (null == row) {
                PK key = this.save(model);
                LOG.info(String.format("Registered a new %s '%d'", modelName, key));
                return key;
            }
            return (PK) row.getId();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }*/
    
    /**
     * Gets the SQL name of the corresponding query type
     * @param type the query type
     * @param clazz the model {@link Class}
     * @return the SQL name to be executed
     */
    private String getSQLName(final SQL type, final Class<? extends Object> clazz) {
        return getSQLName(type.name(), clazz);
    }
    
    /**
     * Gets the SQL name for the model
     * @param sqlName the query name
     * @param clazz the model {@link Class}
     * @return the SQL name to be executed
     */
    private String getSQLName(final String sqlName, final Class<? extends Object> clazz) {
        return clazz.getSimpleName() + "." + sqlName;
    }
    
   /* @Override
    public PK insertOrUpdate(T model) throws DAOException {
        try {
            String modelName = model.getClass().getSimpleName();
            T row = (T) getSqlMapClient().queryForObject(
                    getSQLName(ISQLNames.FIND_MODEL_BY_TYPE_OR_NAME, model.getClass()),
                    model);
            if (null == row) {
                PK key = this.save(model);
                LOG.info(String.format("Registered a new %s '%d'", modelName, key));
                return key;
            }
            else{
            	model.setId(row.getId());
            	int id  = this.update(model);
            	return (PK) row.getId();
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }*/
    
    
    public int processInBatch(final String sqlName, final List<T> models ) throws DAOException {
        try {
            @SuppressWarnings("unchecked")
			Integer updateCount = (Integer) getSqlMapClientTemplate().execute( new SqlMapClientCallback() {
                public Object doInSqlMapClient( SqlMapExecutor executor ) throws SQLException {
                    executor.startBatch();
                    Iterator<T> iter = models.iterator();
                    while( iter.hasNext() ) {
                        executor.insert(sqlName, iter.next() );
                    }
                    return new Integer( executor.executeBatch() );	
                }
            });
            return updateCount.intValue();
        }           
        catch (Exception e ) {
            return -1;
        }
        
    }
    
    @SuppressWarnings("unchecked")
	public void processBatchData(final String batchType, final String methodName, final List dataList) throws DAOException{
        getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
            public Object doInSqlMapClient(SqlMapExecutor sqlMapExecutor) throws SQLException {
                int commitSize = 100;
                boolean commitBatch = false;
                int totalRecordsUpdated = 0;
                int commitBatchUpdated = 0;
                try {
                    sqlMapExecutor.startBatch();
                    for (int i = 0; i < dataList.size(); i++) {
                        if (batchType.equalsIgnoreCase("INSERT")) {
                            sqlMapExecutor.insert(methodName, dataList.get(i));
                        } else if (batchType.equalsIgnoreCase("DELETE")) {
                            sqlMapExecutor.delete(methodName, dataList.get(i));
                        } else if (batchType.equalsIgnoreCase("UPDATE")) {
                            sqlMapExecutor.update(methodName, dataList.get(i));
                        }
 
                        if (((i != 0) && (i % commitSize == 0)) || i == (dataList.size() - 1)) {
                            commitBatch = true;
                        }
 
                        if (commitBatch) {
                            commitBatchUpdated = sqlMapExecutor.executeBatch();
                            totalRecordsUpdated = totalRecordsUpdated + commitBatchUpdated;
                            if (i != (dataList.size() - 1)) {
                                sqlMapExecutor.startBatch();
                            }
                            commitBatch = false;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    LOG.debug("Batch insert/update/delete fail.");
                }
                return new int[]{totalRecordsUpdated};
            }
        });
    }

}
