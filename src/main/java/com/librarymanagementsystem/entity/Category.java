package com.librarymanagementsystem.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer Id;
	private String name;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id")
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		Id = id;
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

}
