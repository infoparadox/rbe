package com.rbena.closet;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Id;

import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class Closet {
	public enum CLOSET_TYPE {
		SUMMER, WINTER, FALL, SPRING, ANYTIME
	}

	@PrimaryKey
	@Id
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Override
	public String toString() {
		return "Closet [type=" + type + ", costumes=" + costumes + "]";
	}

	@Persistent
	private CLOSET_TYPE type;

	public CLOSET_TYPE getType() {
		return type;
	}

	public void setType(CLOSET_TYPE type) {
		this.type = type;
	}

	@Persistent
	@Unowned
	private Set<Costume> costumes;

	public void addCostume(Costume c) {
		if (costumes == null) {
			costumes = new HashSet<Costume>();
		}
		costumes.add(c);
	}

	public Set<Costume> getCostumes() {
		return costumes;
	}

	public void setCostumes(Set<Costume> costumes) {
		this.costumes = costumes;
	}

}
