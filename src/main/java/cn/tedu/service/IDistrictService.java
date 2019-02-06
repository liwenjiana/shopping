package cn.tedu.service;

import java.util.List;

import cn.tedu.bean.Area;
import cn.tedu.bean.City;
import cn.tedu.bean.Province;

public interface IDistrictService {
	/**��ȡʡ�б�
     * @return           ʡ�б�
     */
    public  List<Province>  getProvince();
    
      /**��ȡ���б�
     * @return             ���б�
     */
    public  List<City>  getCity(String provinceCode );
    
      /**��ȡ���б�
     * @return              ���б�
     */
    public  List<Area>  getArea(String cityCode );
}
