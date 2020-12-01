package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.enity.student;

public interface studentDao extends JpaRepository<student, Integer> {

	List<student> findByXuehao(Integer xuehao);
}
