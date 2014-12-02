package com.rbena.closet;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Id;

import com.google.appengine.datanucleus.annotations.Unowned;
import com.rbena.ImageDetail;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class Costume {

	@Id
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	/**
	 * https://answers.yahoo.com/question/index?qid=2110729084522AAJM8Kz
	 * 
	 * @author iRock
	 * 
	 */
	public enum LEGEND {
		CONTEMPORARY, VINTAGE, POLISHED, SPORTY
	}

	public enum Material {
		COTTON, VELVET, SILK, WOOL, REXIN, LEATHER
	}

	public enum PART {
		TOP, BOTTOM, SCARF, HIP
	}

	public enum OCCASSION {
		DATING, BIRTHDAY, INTERVIEW, CASUAL, BUSINESS, HIGH_LIMIT
	}

	enum SIZE {
		XS, S,
	}

	enum GENDER {
		MALE, FEMALE, UNISEX
	}

	enum AGE {

	}

	@Persistent
	private Material material;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public PART getPart() {
		return part;
	}

	public void setPart(PART part) {
		this.part = part;
	}

	public Set<OCCASSION> getOccassion() {
		return occassion;
	}

	public void setOccassion(Set<OCCASSION> occassion) {
		this.occassion = occassion;
	}

	@Persistent
	private PART part;

	@Persistent
	private Set<OCCASSION> occassion;

	@Persistent
	@Unowned
	private Set<ImageDetail> imageDetails = new HashSet<ImageDetail>();

	public Set<ImageDetail> getImageDetails() {
		return imageDetails;
	}

	public void setImageDetails(Set<ImageDetail> imageDetails) {
		this.imageDetails = imageDetails;
	}

}
