package cn.itcast.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import cn.itcast.entity.Employee;
import cn.itcast.util.PageResult;

@Repository("empDao")
public class EmpDao {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(Employee emp){
		sqlSessionTemplate.insert("employeeNamespace.dynaInsert", emp);
	}
	

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("employeeNamespace.findAll");
	}
	
	public List<Employee> findByLike(String like_name) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new LinkedHashMap<>();
		if(like_name!=null){
			map.put("pname", "%"+like_name+"%");
		}else{
			map.put("pname", like_name);
		}
		return sqlSessionTemplate.selectList("employeeNamespace.findByLike",map);
	}
	
	
	
	public Employee findOne(int eid){
		Employee emp = null;
		emp = sqlSessionTemplate.selectOne("employeeNamespace.findOne", eid);
		return emp;
	}
	
	public void updateOne(Employee emp){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pname", emp.getName());
		map.put("psex", emp.getSex());
		map.put("pid", emp.getId());
		map.put("phiredate", emp.getHiredate());
		sqlSessionTemplate.update("employeeNamespace.updateOne", map);
	}
	
	public void dynaDeleteArray(int... ids){
		sqlSessionTemplate.delete("employeeNamespace.dynaDeleteArray", ids);
	}
	
	public PageResult findByPageResult(Integer pageNo,Integer pageSize, String like_name){
		Map<String,Object> map = new LinkedHashMap<>();
		int startIndex = (pageNo-1)*pageSize;
		map.put("startIndex", startIndex);
		map.put("pageSize", pageSize);
		if(like_name!=null){
			map.put("pname", "%"+like_name+"%");
		}else{
			map.put("pname", like_name);
		}
		List<Employee> pageList = sqlSessionTemplate.selectList("employeeNamespace.findByPageResult", map);
		int totalCount = findByLike(like_name).size();
		PageResult pageResult = new PageResult(pageNo, pageSize, totalCount, pageList);
		return pageResult;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*public void dynaInsert(Employee emp){
		
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert("employeeNamespace.dynaInsert", emp);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MybatisUtil.closeSqlSession();
		}
	}
	
	public void dynaDeleteList(List<Integer> ids){
			
			SqlSession sqlSession = null;
			try{
				sqlSession = MybatisUtil.getSqlSession();
				sqlSession.delete("employeeNamespace.dynaDeleteList", ids);
				sqlSession.commit();
			}catch(Exception e){
				e.printStackTrace();
				sqlSession.rollback();
				throw new RuntimeException(e);
			}finally {
				MybatisUtil.closeSqlSession();
			}
	}
	
	public void dynaDeleteArray(int... ids){
		
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.delete("employeeNamespace.dynaDeleteArray", ids);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MybatisUtil.closeSqlSession();
		}
	}
	
	public void dynaUpdate(Integer id,String name,String sex) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("pid",id);
			map.put("pname",name);
			map.put("psex",sex);
			sqlSession.update("employeeNamespace.dynaUpdate",map);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	public List<Employee> findAll(Integer id,String name,String sex) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
				
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("pid",id);
			map.put("pname",name);
			map.put("psex",sex);
			
			return sqlSession.selectList("employeeNamespace.findAll",map);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}*/
	
	/**
	 * 有条件分页
	 */
	/*public List<Employee> findAllByNameWithFy(String name,int start,int size) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			Map<String,Object> map = new LinkedHashMap<String, Object>();
			map.put("pname","%"+name+"%");
			map.put("pstart",start);
			map.put("psize",size);			
			return sqlSession.selectList("employeeNamespace.findAllByNameWithFy",map);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}*/
	
	
	public static void main(String[] args) throws Exception {
		//EmpDao empDao = new EmpDao();
		//empDao.dynaInsert(new Employee(14, "hahaha", "不男不女"));
		
		/*List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		empDao.dynaDeleteList(ids);*/
		
		/*int[] ids = new int[]{3,4,5};
		empDao.dynaDeleteArray(ids);*/
		
		//empDao.dynaUpdate(12, "jack", "不男不女");
		
		/*List<Employee> emps = empDao.findAll(null, "jack", "");
		for (Employee employee : emps) {
			System.out.println(employee.getId()+"："+employee.getName()+":"+employee.getSex());
		}*/
		
		/*System.out.println("--------------------第一页");
		List<Employee> studentList1 = empDao.findAllByNameWithFy("jac",0,3);
		for(Employee s : studentList1){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSex());
		}
		System.out.println("--------------------第二页");
		List<Employee> studentList2 = empDao.findAllByNameWithFy("jac",3,3);
		for(Employee s : studentList2){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSex());
		}*/
	}



















}
