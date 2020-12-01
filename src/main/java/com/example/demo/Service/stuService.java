package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.studentDao;
import com.example.demo.enity.student;

@Service
public class stuService {

	@Autowired
	studentDao sDao;
	
	public List<student> findByXuehao(Integer xuehao) {
		return sDao.findByXuehao(xuehao);
	}
}
