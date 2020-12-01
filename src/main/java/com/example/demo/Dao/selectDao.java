package com.example.demo.Dao;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.enity.couSelect;
import java.lang.Integer;

public interface selectDao extends JpaRepository<couSelect, Integer> {
/**
 * 
 * @param sid
 * @param cid
 * @return 
 
	@Transactional
	@Modifying
	@Query(value = "insert into select(sid,cid) values (:sid,:cid)",nativeQuery = true)
    void insert(Integer sid,Integer cid);
    */
	//按照id查学生选的所有课程
    List<couSelect> findAllBySid(Integer sid);
}
