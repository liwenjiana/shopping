package cn.tedu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.bean.Area;
import cn.tedu.bean.City;
import cn.tedu.bean.Province;
import cn.tedu.bean.ResponseResult;
import cn.tedu.service.IDistrictService;

@Controller
@RequestMapping("/dist")
public class DistController extends BaseController{
     
	@Resource(name="districtService")
	 private IDistrictService districtService;
	
	@RequestMapping("/province.do")
	@ResponseBody
	public ResponseResult<List<Province>> getProvince(){
		List<Province> list=districtService.getProvince();
		return  new ResponseResult<List<Province>>(1,list);
	}

	@RequestMapping("/cities.do")
	@ResponseBody
	public ResponseResult<List<City>> getCities(String provinceCode){
		List<City> list=districtService.getCity(provinceCode);
		return  new ResponseResult<List<City>>(1,list);
	}
	
	@RequestMapping("/areas.do")
	@ResponseBody
	public ResponseResult<List<Area>> getAreas(String cityCode){
		List<Area> list=districtService.getArea(cityCode);
		return  new ResponseResult<List<Area>>(1,list);
	}
}
