package com.rbena;

import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Id;

import com.google.appengine.datanucleus.annotations.Unowned;
import com.rbena.closet.Closet;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class UserProfile {

	@PrimaryKey
	@Id
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;

	@Persistent
	private String userEmail;

	@Persistent
	private String userName;

	@Override
	public String toString() {
		return "UserProfile [userEmail=" + userEmail + ", userName=" + userName
				+ ", closet=" + closet + "]";
	}

	@Persistent
	@Unowned
	private Set<Closet> closet;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String uName) {
		this.userName = uName;
	}

	public UserProfile(String email) {
		this.userEmail = email;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public Set<Closet> getCloset() {
		return closet;
	}

	public void setCloset(Set<Closet> closet) {
		/*
		 * Find closet for user and append to it.
		 */
		this.closet = closet;
	}
}
