package cn.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.bean.Address;


public interface AddressMapper {
	
       /**����ջ���ַ
     * @param address     �ջ���ַ��Ϣ
     * @return                  ��ӳɹ�����1��ʧ�ܷ���0
     */
    public Integer insert(Address address);

    /**�����û�id��ѯ���û����ջ���ַ      
     * @param uid          �û�id
     * @return                �û��ջ���ַ�б�
     */
    public List<Address> getAddressByUid(Integer uid);
    
    /**�����û�id��ѯ���û����ջ���ַ      ������ȫ��
     * @param id          ����ַid
     * @return                �û��ջ���ַ�б�
     */
    public Address getAddressById(Integer id);
    
    /**�����û�uid,�ջ���ַid��ѯ���û����ջ���ַ
     * @param id           �ջ���ַid
     * @param uid         �û�uid,
     * @return               �ջ���ַѧϰ��Ϣ
     */
    public Address getAddressByUidAndId(@Param("id")Integer id,@Param("uid")Integer uid);
    
    /**����idɾ���ջ���ַ
     * @param id        �ջ���ַid
     * @return            ��Ӱ�������
     */
    public Integer delete(Integer id);
    
    /**���ø�id���ջ���ַΪĬ�ϣ�is_defualut==1��
     * @param addr      �ջ���ַ��Ϣ
     * @return             ��Ӱ�������
     */
    public Integer setDefault(Integer id);
    
    /**����ָ���û���һЩ�ջ���ַ��ΪĬ�ϣ�
     * @param uid       �û�id
     * @return              ��Ӱ�������
     */
    public Integer setNotDefault(Address addr);
    
    /**����uid ��id ɾ���ջ���ַ  ����ȫ��
     * @param id
     * @param uid
     * @return
     */
    public Integer delete2(@Param("id")Integer id,@Param("uid")Integer uid) ;
    
 
    /**�޸��ջ���ַ
     * @param addr       �����޸ĵ�ַ����Ϣ���������id ��uid��
     * @return                ��Ӱ�������
     */
    public Integer update(Address addr);
    
    /**�����û�id ��ȡĬ���ջ���ַ
     * param uid         �û�id
     * @return    �ջ���ַ
     */
    public Address getDefaultAddress(Integer uid);
    
}
