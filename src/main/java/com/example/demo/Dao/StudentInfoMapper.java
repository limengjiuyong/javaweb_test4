package com.example.demo.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.enity.CouSelect;
import com.example.demo.enity.Course;
import com.example.demo.enity.Role;
import com.example.demo.enity.UserRole;
import com.example.demo.enity.StudentInfo;



@Mapper
public interface StudentInfoMapper {

	StudentInfo loadSeudentInfoByName(String username);
	List<Role> getseudentInfoRolesById(Integer userid);
	void insert(StudentInfo seudentInfo);
	void insertUserRole(UserRole sRole);
	StudentInfo selectByPrimaryKey(Integer userid);
	List<Course> selectUserCourse();
	void insertUserCourse(Integer sid,Integer cid);
	List<Course> selectAllRestUserCourseByUid(Integer userid);
	List<CouSelect> selectSelectedCourse(Integer userid);
   
}
