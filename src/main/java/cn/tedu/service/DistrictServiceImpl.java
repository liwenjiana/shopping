package cn.tedu.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.tedu.bean.Area;
import cn.tedu.bean.City;
import cn.tedu.bean.Province;
import cn.tedu.mapper.DistrictMapper;
@Service("districtService")
public class DistrictServiceImpl implements IDistrictService{
	
	@Resource(name="districtMapper")
	private DistrictMapper  districtMapper;
	@Resource
	 private   RedisTemplate<String,Object>  redisTemplate;

	public List<Province> getProvince() {
	    List<Province> provinces=(List<Province>)redisTemplate.opsForValue().get("provines-list");
	    if(provinces==null) {
	    	System.err.println("redis»º´æ³É¹¦");
	    	provinces=districtMapper.getProvince();
	    	redisTemplate.opsForValue().set("provines-list", provinces,1,TimeUnit.DAYS);
	    }
		return  provinces ;
	}

	public List<City> getCity(String provinceCode) {
		return districtMapper.getCity(provinceCode);
	}

	public List<Area> getArea(String cityCode) {
		return districtMapper.getArea(cityCode);
	}

}
