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
import com.rbena.ImageDetail;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class Costume {

	@Id
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	public enum Fabricare {
		/*
		 * Refer
		 * http://www.cleanipedia.me/en/laundry-and-washing1/what-do-the-washing
		 * -symbols-on-clothing-labels-mean
		 */
	}

	/**
	 * https://answers.yahoo.com/question/index?qid=2110729084522AAJM8Kz
	 * 
	 * @author iRock
	 * 
	 */
	public enum Legend {
		CONTEMPORARY, VINTAGE, POLISHED, SPORTY
	}

	public enum PURCHASE_YEAR{
		WITHIN_TWO, TWO_FIVE, FIVE_EIGHT, EIGHT_TEN, OLDER, UNKNOWN
	}
	
	
	public enum Material {
		COTTON, VELVET, SILK, WOOL, REXIN, LEATHER
	}

	public enum Part {
		TOP, BOTTOM, SCARF, HIP
	}

	public enum Occassion {
		DATING, BIRTHDAY, INTERVIEW, CASUAL, BUSINESS, HIGH_LIMIT
	}

	public enum SIZE {
		XS, S, M, L
	}

	public enum SEASON {
		SUMMER, FALL, SPRING, WNTER, AUTUMN
	}

	public enum GENDER {
		MALE, FEMALE, UNISEX
	}

	public enum AGE {
		UNDER_12, TWELVE_SEVENTEEN, EIGHTEEN_TWENTY_FOUR, TWENTYFIVE_THIRTYFOUR, THIRTYFIVE_FOTYFOUR, FORTYFIVE_FIFTYFOUR, FIFTYFIVE_SIXTYFOUR, SIXTYFIVE_SEVENTYFOUR, YOUNG_AT_HEART
	}

	@Persistent
	private GENDER gender;

	@Persistent
	private AGE age;

	public AGE getAge() {
		return age;
	}

	public void setAge(AGE age) {
		this.age = age;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	@Persistent
	private SIZE size;

	public SIZE getSize() {
		return size;
	}

	public void setSize(SIZE size) {
		this.size = size;
	}

	@Persistent
	private Material material;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Set<Occassion> getOccassion() {
		return occassion;
	}

	public void setOccassion(Set<Occassion> occassion) {
		this.occassion = occassion;
	}

	@Persistent
	private Legend legend;

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	@Persistent
	private Part part;

	@Persistent
	private Set<Occassion> occassion;

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
