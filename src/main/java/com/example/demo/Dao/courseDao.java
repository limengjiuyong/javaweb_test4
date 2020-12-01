package com.example.demo.Dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.enity.couSelect;
import com.example.demo.enity.course;

public interface courseDao extends JpaRepository<course, Integer> {

	//选课列表，所有可选课程
	 List<course> findAll();
	 //按照课程号查课程
	 course findByCid(Integer cid);
}
