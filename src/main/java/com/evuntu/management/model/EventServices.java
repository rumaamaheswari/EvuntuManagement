package com.evuntu.management.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


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

	@Column(name="EVENT_NAME")
	private String eventName;

	@Column(name="FACEBOOK_LINK")
	private String facebookLink;

	/*@Column(name="FILE_ID")
	private Long fileId;*/

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_TIME")
	private Date updatedTime;

	@Column(name="WEBSITE_LINK")
	private String websiteLink;

	@Column(name="YOUTUBE_LINK")
	private String youtubeLink;

	//bi-directional many-to-one association to FileDetail
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="eventServices")
	@Transient
	private List<FileDetails> fileDetails;



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

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getFacebookLink() {
		return this.facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	/*public Long getFileId() {
		return this.fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}*/

	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getWebsiteLink() {
		return this.websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public String getYoutubeLink() {
		return this.youtubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	public List<FileDetails> getFileDetails() {
		return this.fileDetails;
	}

	public void setFileDetails(List<FileDetails> fileDetails) {
		this.fileDetails = fileDetails;
	}

	/*public FileDetails addFileDetail(FileDetails fileDetails) {
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
