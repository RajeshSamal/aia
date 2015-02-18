/**
 * 
 */
package com.aia.model;

/**
 * @author verticurl
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aia.common.utils.Constants;



public class User extends AbstractBaseModel<User> implements UserDetails, Serializable{

	
	/** The roles associated with the user */
//	private List<Role> roles;
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private Date lastLoginDate;
	private boolean enabled;
	private String new_password;

	public String getPassword() {		
		return password;
	}
	
	public String getUsername() {		
		return email;
	}

	public boolean isAccountNonExpired() {	
		return true;
	}

	public boolean isAccountNonLocked() {		
		return true;
	}

	public boolean isCredentialsNonExpired() {		
		return true;
	}

	public boolean isEnabled() {		
		return enabled;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();	
		
		Role adminRole = new Role();
		adminRole.setType(Constants.ROLE_ADMIN);
		authorities.add(adminRole);		
		return authorities;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	
}