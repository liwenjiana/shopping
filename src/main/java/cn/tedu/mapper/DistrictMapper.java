package cn.tedu.mapper;

import java.util.List;

import cn.tedu.bean.Area;
import cn.tedu.bean.City;
import cn.tedu.bean.Province;

public interface DistrictMapper {
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
        
        /**���ݱ����ȡʡ����
         * @param code
         * @return
         */
        public String getProvinceNameByCode(String code);
        
        /**���ݱ����ȡ������
         * @param code
         * @return
         */
        public String getCityNameByCode(String code);
        
        /**���ݱ����ȡ������
         * @param code
         * @return
         */
        public String getAreaNameByCode(String code);
}
