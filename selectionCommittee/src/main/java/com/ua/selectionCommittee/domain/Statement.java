package com.ua.selectionCommittee.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "statement")
public class Statement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(targetEntity = Enrollee.class)
	@JoinColumn(name = "enrollee", referencedColumnName = "id")
	private Enrollee enrollee;

	@ManyToOne(targetEntity = University.class)
	@JoinColumn(name = "university", referencedColumnName = "id")
	private University university;

	@Column(name = "receipt_date")
	private Date receiptDate;

	public Statement() {
	}


	public Statement(Integer id) {
		this.id = id;
	}

	
	public Statement(Enrollee enrollee, University university, Date receiptDate) {
		this.enrollee = enrollee;
		this.university = university;
		this.receiptDate = receiptDate;
	}

	public Statement(Integer id, Enrollee enrollee, University university, Date receiptDate) {
		this.id = id;
		this.enrollee = enrollee;
		this.university = university;
		this.receiptDate = receiptDate;
	}
	
	public Statement(Statement statement) {
		this.id = statement.id;
		this.enrollee = statement.enrollee;
		this.university = statement.university;
		this.receiptDate = statement.receiptDate;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Enrollee getEnrollee() {
		return enrollee;
	}

	public void setEnrollee(Enrollee enrollee) {
		this.enrollee = enrollee;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enrollee == null) ? 0 : enrollee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((receiptDate == null) ? 0 : receiptDate.hashCode());
		result = prime * result + ((university == null) ? 0 : university.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statement other = (Statement) obj;
		if (enrollee == null) {
			if (other.enrollee != null)
				return false;
		} else if (!enrollee.equals(other.enrollee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (receiptDate == null) {
			if (other.receiptDate != null)
				return false;
		} else if (!receiptDate.equals(other.receiptDate))
			return false;
		if (university == null) {
			if (other.university != null)
				return false;
		} else if (!university.equals(other.university))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Statement [id=" + id + ", enrollee=" + enrollee + ", university=" + university + ", receiptDate="
				+ receiptDate + "]";
	}

}
