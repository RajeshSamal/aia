package com.aia.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.aia.common.exception.DAOException;
import com.aia.dao.IDaoHelper;
import com.aia.dao.impl.ISQLNames;
import com.aia.model.User;

public class UserService implements UserDetailsService {
	
	/** The Logger instance */
    private static final Logger LOG = Logger.getLogger(UserService.class);
	
	private IDaoHelper<User, Long> userDao;
	
	public void setUserDao(IDaoHelper<User, Long> userDao) {
		this.userDao = userDao;
	}
	
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User loginUser = null;
		LOG.debug("Retrieving user information for authentication with email=" + username);
		try {
		    Map<String, Object> params = new HashMap<String, Object>(1);
		   
	        params.put("userName", username);
	        loginUser = userDao.findObject(ISQLNames.GET_USER_DETAILS, params);
	        
			if (null == loginUser) {
			    throw new UsernameNotFoundException("User not found, user_name=" + username);
			}
		} catch (DAOException error) {
			LOG.error(error.getMessage(), error);
			throw new DataAccessException(error.getMessage(), error) {};
		}
		LOG.debug("Successfully retrieved user detail, user=" + loginUser);
		return loginUser;
	}
    

    public int changePassword(final User userToUpdate){
	    try {
             
	       Map<String, Object> params = new HashMap<String, Object>(2);
	       
	       
	       LOG.debug("password :::: " + userToUpdate.getPassword());
	       LOG.debug("newPassword ::: " + userToUpdate.getNew_password());
	     	        
	       	params.put("email", userToUpdate.getEmail());
	        params.put("password", userToUpdate.getPassword());
	        		
	        User user = userDao.findObject(ISQLNames.VERIFY_USER_OLD_PASSWORD, params);
	        int rowAffected = 0;
	        if(null != user){        	
	        	
	        	params.put("id", user.getId());
		        params.put("newPassword", userToUpdate.getNew_password());
	        	rowAffected = userDao.update(ISQLNames.CHANGE_USER_PASSWORD, params);
	        	
	        }	        
	        
	        return rowAffected;
	        
	    } catch (DAOException e) {
	    	LOG.error("Failed to update change password, email=" +userToUpdate.getEmail(),  e);
	    	return 0;
	    }
	}






	

}
