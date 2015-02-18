/**
 * 
 */
package com.aia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.aia.common.exception.DAOException;

/**
 * @author verticurl
 *
 */
public interface IDaoHelper <T, PK extends Serializable> {

	 /**
    * Saves the given model to the DB
    * @param model the {@link Serializable} model
    * @return the new primary key returned after save
    * @throws DAOException on error to save to DB
    */
   PK save(final T model) throws DAOException;

   PK save(final String sqlName, final T model) throws DAOException;
   
   /**
    * Saves the given model to the DB
    * @param sqlName the sql name to be executed
    * @param params the list of parameters used for insert
    * @return the new primary key returned after save
    * @throws DAOException on error to save to DB
    */
   PK save(String sqlName, Map<String, Object> params) throws DAOException;
   
   /**
    * Saves a list of models to the DB in a batch
    * @param models the list of models to be inserted
    * @return number of models or rows affected
    * @throws DAOException when failed to insert models
    */
   int save(List<T> models) throws DAOException;
   
   /**
    * Updates the given model to the DB
    * @param model the {@link Serializable} model
    * @return the number of rows affected
    * @throws DAOException on error to update DB
    */
   int update(final T model) throws DAOException;
   
   int update(final String sqlName, final T model) throws DAOException;
   
   /**
    * Updates the given model to the DB
    * @param sqlName the sql name to be executed
    * @param params the parameter map to the sql
    * @return number of models or rows affected
    * @throws DAOException when failed to update
    */
   int update(final String sqlName, final Map<String, Object> params) throws DAOException;
   
   /**
    * Gets the model for the given key
    * @param clazz the model {@link Class}
    * @param id the primary key
    * @return the model object
    * @throws DAOException on error to get the model
    */
   T get(final Class<T> clazz, final PK id) throws DAOException;
   
   /**
    * Delete the given model from the DB
    * @param model the {@link Serializable} model
    * @return the number of rows affected
    * @throws DAOException on error to delete from DB
    */
   int delete(final T model) throws DAOException;
   
   /**
    * Delete the model from the DB
    * @param sqlName the sql to be executed
    * @param param the sql name values
    * @return the number of rows affected
    * @throws DAOException on error to delete from DB
    */
   int delete(final String sqlName, final Map<String, Object> param) 
   		throws DAOException;
   
   /**
    * Finds all the entries of the specified model type.
    * This method will use the "list" sql of the SQL configuration file.
    * @param clazz the model class for which we need to find entries in DB
    * @return the the list of model object
    * @throws DAOException on error to get the model
    */
   List<T> find(final Class<T> clazz) throws DAOException;
   
   /**
    * Finds all the entries of the specified model type and the parameters.
    * This method will use "list" sql from the sql-config file and applies params if any
    * @param clazz the model class for which we need to find entries in DB
    * @param params the parameters map
    * @return the the list of model object
    * @throws DAOException on error to get the model
    */
   List<T> find(final Class<T> clazz, final Map<String, Object> params) throws DAOException;
   
   /**
    * Finds all the entries using the specified sql name.
    * The sql name will be use to locate its entry in the sql config file and execute query.
    * @param sqlName the sql name to be executed
    * @return the the list of model object
    * @throws DAOException on error to get the model
    */
   List<T> find(final String sqlName) throws DAOException;
   
   /**
    * Finds all the entries using the specified sql name and the parameters.
    * The sql name will be use to locate its entry in the sql config file and execute query.
    * @param sqlName the sql name to be executed
    * @param params the parameter map to the sql
    * @return the the list of model object
    * @throws DAOException on error to get the model
    */
   List<T> find(final String sqlName, final Map<String, Object> params) throws DAOException;
   
   /**
    * Finds all the entries using the specified sql name and the parameters.
    * The sql name will be use to locate its entry in the sql config file and execute query.
    * @param sqlName the sql name to be executed
    * @param params the parameter list to the sql
    * @return the the list of model object
    * @throws DAOException on error to get the model
    */
   List<T> findList(final String sqlName, final List<String> params) throws DAOException;
   
   /**
    * Finds all the entries using the specified sql name and the parameters.
    * The sql name will be use to locate its entry in the sql config file and execute query.
    * @param sqlName the sql name to be executed
    * @param params the parameter map to the sql
    * @return the the list of model object
    * @throws DAOException on error to get the model
    */
   List findGeneric(final String sqlName, final Map<String, Object> params)
           throws DAOException;
   
   /**
    * Finds a unique model from the DB using the specified sql name.
    * @param sqlName the sql name to be executed
    * @param params the parameter map to the sql
    * @return the the model object
    * @throws DAOException on error to get the model
    */
   T findObject(final String sqlName, final Map<String, Object> params) throws DAOException;
   
   /**
    * Finds the model and if not exists inserts a new record
    * @param model the model to be found or inserted
    * @return the primary key inserted
    * @throws DAOException on failure to find or insert new
    */
   //PK findOrInsert(T model) throws DAOException;
   
   /**
    * Gets the total number of rows.
    * @param sqlName the sql name to be executed
    * @param params the parameter map to the sql
    * @return the the model object
    * @throws DAOException on error to get the total
    */
   Integer getTotal(final String sqlName, final Map<String, Object> params) throws DAOException;
   
   /**
    * 
    * @param models
    * @return
    */
   public int processInBatch(final String sqlName, List<T> models ) throws DAOException;
   
   public void processBatchData(final String batchType, final String methodName, final List dataList) throws DAOException;


}

