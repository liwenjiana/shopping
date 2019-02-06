package cn.tedu.service;

import java.util.List;

import cn.tedu.bean.Area;
import cn.tedu.bean.City;
import cn.tedu.bean.Province;

public interface IDistrictService {
	/**获取省列表
     * @return           省列表
     */
    public  List<Province>  getProvince();
    
      /**获取市列表
     * @return             市列表
     */
    public  List<City>  getCity(String provinceCode );
    
      /**获取区列表
     * @return              区列表
     */
    public  List<Area>  getArea(String cityCode );
}
