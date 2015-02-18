package com.aia.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Role extends AbstractBaseModel<Role> implements GrantedAuthority, Serializable {

	/** Auto generated UID */
	private static final long serialVersionUID = -3738221295135273871L;
	
	/** Type of the role */
	private String type;

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the authority or role associated with a user.
	 * This implementation is mandated by {@link GrantedAuthority} of spring security.
	 * @return The authority type
	 */
	public String getAuthority() {
		return getType();
	}
	
	/**
	 * Returns the role type and associated id
	 * @return the string representation of the {@link Role} object.
	 */
	public String toString() {
		return super.toString() + ", type=" + getType();
	}
}
