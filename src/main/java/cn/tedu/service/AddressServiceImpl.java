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
	//����ջ���ַ
	public Integer add(Address addr) {
		addr.setRecvDistrict(this.getRecvDistrict(addr));
		addressMapper.insert(addr);
		return addr.getId();
	}
    //����uid��ȡ�ջ���ַ����
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
	 //����id��ȡ�ջ���ַ������ȫ��
	 public Address getAddressById(Integer id) {
		
		return addressMapper.getAddressById(id);
	}
	 //����id ���û�uid��ȡ�ջ���ַ������ȫ��
	public Address getAddressByUidAndId(Integer id, Integer uid) {
		
		return addressMapper.getAddressByUidAndId(id, uid);
	}
	
	//����idɾ���ջ���ַ������ȫ��
	public Integer delete(Integer id) {
		return addressMapper.delete(id);
	}
  
	//����id���ջ���ַ����Ĭ��
	public Integer setDefault(Integer id) {
		return addressMapper.setDefault(id);
	}
	
	 //��һЩ�ջ���ַ����Ϊ��Ĭ��
	@Transactional
	public Integer setNotDefault(Integer uid,Integer id) {
	     Address addr=this.getAddressById(id);
	     if(addr.getIsDefault()==0) {
	    	 Integer affectedRows=setDefault( id);
	    	 if(affectedRows==0) {
	    		 throw new DataNotFandException("ɾ���������ջ���ַ���ܱ�ɾ��");
	    	 }
	    	 affectedRows=  addressMapper.setNotDefault(addr);
	    	 if(affectedRows==0) {
	    		 throw new DataNotFandException("ɾ�����������µ�¼");
	    	 }
	     }
	    
	     return 1;
	}

	
	
 
	 //����uid��idɾ���ջ���ַ
	public Integer delete2(Integer id, Integer uid) {
	  
		return addressMapper.delete2(id, uid);
	}

	//�޸��ջ���ַ
	public Integer update(Address addr) {
		String  recvDistrict=this.getRecvDistrict(addr);
		addr.setRecvDistrict(recvDistrict);
		return addressMapper.update(addr);
	}

    //��ȡ�ջ���ַ��recvDistrictֵ
      private String getRecvDistrict(Address addr) {
    	  String provinceName=districtMapper.getProvinceNameByCode(addr.getRecvProvince());
  		String cityName=districtMapper.getCityNameByCode(addr.getRecvCity());
  		String areaName=districtMapper.getAreaNameByCode(addr.getRecvArea());
  		return provinceName+cityName+areaName;
      }
      
      //�����û�id��ȡ�û�Ĭ���ջ���ַ
	public Address getDefaultAddress(Integer uid) {
		
		return addressMapper.getDefaultAddress(uid);
	}

}
