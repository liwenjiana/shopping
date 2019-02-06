package cn.tedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.bean.Address;
import cn.tedu.mapper.AddressMapper;
import cn.tedu.mapper.DistrictMapper;
import cn.tedu.service.ex.DataNotFandException;
@Service("addressService")
public class AddressServiceImpl implements IAddressService{
	
	@Resource(name="addressMapper")
    private AddressMapper addressMapper;
	
	@Resource(name="districtMapper")
	private DistrictMapper districtMapper;
	//添加收货地址
	public Integer add(Address addr) {
		addr.setRecvDistrict(this.getRecvDistrict(addr));
		addressMapper.insert(addr);
		return addr.getId();
	}
    //根据uid获取收货地址集合
	public List<Address> getAddressByUid(Integer uid) {
		
		List<Address> list=addressMapper.getAddressByUid(uid);
		if(list.size()==0) {
			return list;
		}else {
			Address addr=list.get(0);
			if(addr.getIsDefault()==0) {
				   addr.setIsDefault(1);
			}
			return  list;
		}
		
	}
	 //根据id获取收货地址（不安全）
	 public Address getAddressById(Integer id) {
		
		return addressMapper.getAddressById(id);
	}
	 //根据id 和用户uid获取收货地址（不安全）
	public Address getAddressByUidAndId(Integer id, Integer uid) {
		
		return addressMapper.getAddressByUidAndId(id, uid);
	}
	
	//根据id删除收货地址（不安全）
	public Integer delete(Integer id) {
		return addressMapper.delete(id);
	}
  
	//根据id把收货地址设置默认
	public Integer setDefault(Integer id) {
		return addressMapper.setDefault(id);
	}
	
	 //把一些收货地址设置为不默认
	@Transactional
	public Integer setNotDefault(Integer uid,Integer id) {
	     Address addr=this.getAddressById(id);
	     if(addr.getIsDefault()==0) {
	    	 Integer affectedRows=setDefault( id);
	    	 if(affectedRows==0) {
	    		 throw new DataNotFandException("删除出错，该收货地址可能被删除");
	    	 }
	    	 affectedRows=  addressMapper.setNotDefault(addr);
	    	 if(affectedRows==0) {
	    		 throw new DataNotFandException("删除出错，请重新登录");
	    	 }
	     }
	    
	     return 1;
	}

	
	
 
	 //根据uid和id删除收货地址
	public Integer delete2(Integer id, Integer uid) {
	  
		return addressMapper.delete2(id, uid);
	}

	//修改收货地址
	public Integer update(Address addr) {
		String  recvDistrict=this.getRecvDistrict(addr);
		addr.setRecvDistrict(recvDistrict);
		return addressMapper.update(addr);
	}

    //获取收货地址的recvDistrict值
      private String getRecvDistrict(Address addr) {
    	  String provinceName=districtMapper.getProvinceNameByCode(addr.getRecvProvince());
  		String cityName=districtMapper.getCityNameByCode(addr.getRecvCity());
  		String areaName=districtMapper.getAreaNameByCode(addr.getRecvArea());
  		return provinceName+cityName+areaName;
      }
      
      //根据用户id获取用户默认收货地址
	public Address getDefaultAddress(Integer uid) {
		
		return addressMapper.getDefaultAddress(uid);
	}

}
