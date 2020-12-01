package com.example.demo.enity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class course {

	@Override
	public String toString() {
		return "course [cid=" + cid + ", cname=" + cname + "]";
	}
	@Id
	private Integer cid;
	private String cname;
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
}
