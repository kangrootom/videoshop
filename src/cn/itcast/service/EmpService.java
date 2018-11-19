package cn.itcast.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.dao.EmpDao;
import cn.itcast.entity.Employee;
import cn.itcast.util.PageResult;

@Service("empService")
public class EmpService {
	
	@Resource
	private EmpDao empDao;
	
	public void insert(Employee emp){
		empDao.insert(emp);
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	public Employee findOne(int eid) {
		// TODO Auto-generated method stub
		return empDao.findOne(eid);
	}
	
	public void updateOne(Employee emp){
		empDao.updateOne(emp);
	}
	
	public void dynaDeleteArray(int...ids ){
		empDao.dynaDeleteArray(ids);
	}
	
	public PageResult findByPageResult(Integer pageNo,Integer pageSize, String like_name){
		System.out.println(pageNo);
		return empDao.findByPageResult(pageNo, pageSize, like_name);
	}
}
