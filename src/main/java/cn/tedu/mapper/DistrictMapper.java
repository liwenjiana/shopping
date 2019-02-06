package cn.tedu.mapper;

import java.util.List;

import cn.tedu.bean.Area;
import cn.tedu.bean.City;
import cn.tedu.bean.Province;

public interface DistrictMapper {
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
        
        /**根据编码获取省名称
         * @param code
         * @return
         */
        public String getProvinceNameByCode(String code);
        
        /**根据编码获取市名称
         * @param code
         * @return
         */
        public String getCityNameByCode(String code);
        
        /**根据编码获取区名称
         * @param code
         * @return
         */
        public String getAreaNameByCode(String code);
}
