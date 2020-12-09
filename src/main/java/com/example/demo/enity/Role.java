package com.example.demo.enity;

public class Role {

	@Override
	public String toString() {
		return "Role [rid=" + rid + ", name=" + name + ", namezh=" + namezh + "]";
	}

	private Integer rid;

    private String name;

    private String namezh;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamezh() {
		return namezh;
	}

	public void setNamezh(String namezh) {
		this.namezh = namezh;
	}
}
