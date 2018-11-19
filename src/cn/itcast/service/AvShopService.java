package cn.itcast.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.dao.AvShopDao;
import cn.itcast.entity.AvShop;
import cn.itcast.util.PageResult;

@Service("avshopService")
public class AvShopService {
	
	@Resource
	private AvShopDao avshopDao;
	
	public void insert(AvShop avshop){
		avshopDao.insert(avshop);
	}

	public List<AvShop> findAll() {
		// TODO Auto-generated method stub
		return avshopDao.findAll();
	}

	public AvShop findOne(int eid) {
		// TODO Auto-generated method stub
		return avshopDao.findOne(eid);
	}
	
	public void updateOne(AvShop avshop){
		avshopDao.updateOne(avshop);
	}
	
	public void dynaDeleteArray(int...ids ){
		avshopDao.dynaDeleteArray(ids);
	}
	
	public PageResult findByPageResult(Integer pageNo,Integer pageSize, String like_name){
		System.out.println(pageNo);
		return avshopDao.findByPageResult(pageNo, pageSize, like_name);
	}
}
