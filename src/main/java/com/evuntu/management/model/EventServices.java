package com.evuntu.management.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Entity bean
 * @author umaa maheswari
 *
 */
@Entity
@Table(name="EVENT_SERVICES")
public class EventServices implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EVENT_SERVICE_ID")
	@GeneratedValue
	private Long eventServiceId;

	@Column(name="CITY")
	private String city;

	@Column(name="COMPANY_ID")
	private Long companyId;

	@Column(name="CONTACT_NUMBER")
	private String contactNumber;

	@Column(name="CONTACT_PERSON")
	private String contactPerson;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_TIME")
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_TIME")
	private Date updatedTime;

	@Column(name="YOUTUBE_LINK")
	private String youtubeLink;

	//bi-directional one-to-many association to FileDetail
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="eventServices")
	private Set<FileDetails> fileDetails= new HashSet<>();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FACILITY_ID",nullable=false) 
	private Facility facility;

	

	public Long getEventServiceId() {
		return this.eventServiceId;
	}

	public void setEventServiceId(Long eventServiceId) {
		this.eventServiceId = eventServiceId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getYoutubeLink() {
		return this.youtubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}
	
	public Set<FileDetails> getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(Set<FileDetails> fileDetails) {
		this.fileDetails = fileDetails;
	}

	/**
	 * @return the facility
	 */
	public Facility getFacility() {
		return facility;
	}

	/**
	 * @param facility the facility to set
	 */
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	
	/*
	public FileDetails addFileDetail(FileDetails fileDetails) {
		getFileDetails().add(fileDetails);
		fileDetails.setEventServices(this);

		return fileDetails;
	}

	public FileDetails removeFileDetail(FileDetails fileDetails) {
		getFileDetails().remove(fileDetails);
		fileDetails.setEventServices(null);

		return fileDetails;
	}*/

}
