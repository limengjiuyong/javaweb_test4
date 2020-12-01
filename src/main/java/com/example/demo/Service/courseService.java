package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.courseDao;
import com.example.demo.enity.couSelect;
import com.example.demo.enity.course;

@Service
public class courseService {

	@Autowired
	courseDao coursedao;
	public List<course> findAll(){
		return coursedao.findAll();
	}
	public course findByCid(Integer cid) {
		return coursedao.findByCid(cid);
	}
}
