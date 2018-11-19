package cn.itcast.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import cn.itcast.entity.AvShop;
import cn.itcast.util.PageResult;

@Repository("avshopDao")
public class AvShopDao {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(AvShop avshop){
		sqlSessionTemplate.insert("avshopNamespace.dynaInsert", avshop);
	}
	

	public List<AvShop> findAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("avshopNamespace.findAll");
	}
	
	public List<AvShop> findByLike(String like_name) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new LinkedHashMap<>();
		if(like_name!=null){
			map.put("pname", "%"+like_name+"%");
		}else{
			map.put("pname", like_name);
		}
		return sqlSessionTemplate.selectList("avshopNamespace.findByLike",map);
	}
	
	
	
	public AvShop findOne(int eid){
		AvShop avshop = null;
		avshop = sqlSessionTemplate.selectOne("avshopNamespace.findOne", eid);
		return avshop;
	}
	
	public void updateOne(AvShop avshop){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pid", avshop.getAvid());
		map.put("pname", avshop.getAvname());
		map.put("ptitle", avshop.getAvtitle());
		map.put("pdesc", avshop.getAvdesc());
		map.put("pimgsrc", avshop.getAvimgsrc());
		map.put("pcreatetime", avshop.getAvcreatetime());
		map.put("pvideosrc", avshop.getAvvideosrc());
		map.put("pstatus", avshop.isAvstatus());
		sqlSessionTemplate.update("avshopNamespace.updateOne", map);
	}
	
	public void dynaDeleteArray(int... ids){
		sqlSessionTemplate.delete("avshopNamespace.dynaDeleteArray", ids);
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
		List<AvShop> pageList = sqlSessionTemplate.selectList("avshopNamespace.findByPageResult", map);
		int totalCount = findByLike(like_name).size();
		PageResult pageResult = new PageResult(pageNo, pageSize, totalCount, pageList);
		return pageResult;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*public void dynaInsert(AvShop avshop){
		
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert("avshopNamespace.dynaInsert", avshop);
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
				sqlSession.delete("avshopNamespace.dynaDeleteList", ids);
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
			sqlSession.delete("avshopNamespace.dynaDeleteArray", ids);
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
			sqlSession.update("avshopNamespace.dynaUpdate",map);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	public List<AvShop> findAll(Integer id,String name,String sex) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
				
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("pid",id);
			map.put("pname",name);
			map.put("psex",sex);
			
			return sqlSession.selectList("avshopNamespace.findAll",map);
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
	/*public List<AvShop> findAllByNameWithFy(String name,int start,int size) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			Map<String,Object> map = new LinkedHashMap<String, Object>();
			map.put("pname","%"+name+"%");
			map.put("pstart",start);
			map.put("psize",size);			
			return sqlSession.selectList("avshopNamespace.findAllByNameWithFy",map);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}*/
	
	
	public static void main(String[] args) throws Exception {
		//EmpDao avshopDao = new EmpDao();
		//avshopDao.dynaInsert(new AvShop(14, "hahaha", "不男不女"));
		
		/*List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		avshopDao.dynaDeleteList(ids);*/
		
		/*int[] ids = new int[]{3,4,5};
		avshopDao.dynaDeleteArray(ids);*/
		
		//avshopDao.dynaUpdate(12, "jack", "不男不女");
		
		/*List<AvShop> avshops = avshopDao.findAll(null, "jack", "");
		for (AvShop avshop : avshops) {
			System.out.println(avshop.getId()+"："+avshop.getName()+":"+avshop.getSex());
		}*/
		
		/*System.out.println("--------------------第一页");
		List<AvShop> studentList1 = avshopDao.findAllByNameWithFy("jac",0,3);
		for(AvShop s : studentList1){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSex());
		}
		System.out.println("--------------------第二页");
		List<AvShop> studentList2 = avshopDao.findAllByNameWithFy("jac",3,3);
		for(AvShop s : studentList2){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSex());
		}*/
	}



















}
