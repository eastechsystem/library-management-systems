package com.librarymanagementsystem.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
@Entity
@Table(name = "books")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Category category;
	private String name;
	private String autherName;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id")
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the category
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Category_id")
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the name
	 */
	@Column(name = "Name")
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the autherName
	 */
	@Column(name = "Auther_name")
	public String getAutherName() {
		return autherName;
	}

	/**
	 * @param autherName
	 *            the autherName to set
	 */
	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}

}
