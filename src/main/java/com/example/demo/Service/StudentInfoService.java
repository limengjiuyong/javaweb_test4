package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.StudentInfoMapper;
import com.example.demo.enity.CouSelect;
import com.example.demo.enity.Course;
import com.example.demo.enity.UserRole;
import com.example.demo.enity.StudentInfo;

@Service
public class StudentInfoService implements UserDetailsService {

	@Autowired
	StudentInfoMapper studentMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		StudentInfo seudentinfo=studentMapper.loadSeudentInfoByName(username);
		if (seudentinfo ==null) {
			throw new UsernameNotFoundException("账户不存在！");		 
		}
		seudentinfo.setRoles(studentMapper.getseudentInfoRolesById(seudentinfo.getUserid()));
		return seudentinfo;
	}

	public void insert(StudentInfo seudentInfo) {
		studentMapper.insert(seudentInfo);
	}
	
	public void insertUserRole(UserRole sRole) {
		studentMapper.insertUserRole(sRole);
	}
	
	public StudentInfo selectByPrimaryKey(Integer userid) {
		
		
			return studentMapper.selectByPrimaryKey(userid);
		
	}
	public List<Course> selectAllRestUserCourseByUid(Integer userid){
		return studentMapper.selectAllRestUserCourseByUid(userid);
	}
	
	public void insertUserCourse(Integer sid,Integer cid)
	{
		studentMapper.insertUserCourse(sid, cid);
	}
	public List<CouSelect> selectSelectedCourse(Integer userid)
	{
		return studentMapper.selectSelectedCourse(userid);
	}
}
