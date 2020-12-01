package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Dao.selectDao;
import com.example.demo.enity.couSelect;


@Service
public class selectService {

	@Autowired
	selectDao sDao;
	public void saveSelect(couSelect select) {
		sDao.save(select);
		//System.out.println("成功");
	}
	
	public List<couSelect> findBySid(Integer sid) {
		return sDao.findAllBySid(sid);
		
	}
}
