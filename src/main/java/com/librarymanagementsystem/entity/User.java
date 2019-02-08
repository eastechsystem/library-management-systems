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
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String cnic;
	private String mobile;
	private String address;

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
	 * @return the cnic
	 */
	@Column(name = "CNIC")
	public String getCnic() {
		return cnic;
	}

	/**
	 * @param cnic
	 *            the cnic to set
	 */
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

	/**
	 * @return the mobile
	 */
	@Column(name = "Mobile")
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the address
	 */
	@Column(name = "Address")
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
