package cn.tedu.service;

import java.util.List;

import cn.tedu.bean.Address;

public interface IAddressService {
	
         /**����ջ���ַ��Ϣ
         * @param addr       �ջ���ַ��Ϣ
         * @return                �����ջ���ַid
         */
        public Integer add(Address addr);
        
        /**�����û�uid��ѯ���û����ջ���ַ
         * @param uid          �û�id
         * @return                �û��ջ���ַ�б�
         */
        public List<Address> getAddressByUid(Integer uid);
        
        /**�����û�id��ѯ���û����ջ���ַ
         * @param id          ����ַid
         * @return                �û��ջ���ַ�б�
         */
        public Address getAddressById(Integer id);
        
        /**�����û�uid���ջ���ַid��ѯ���û����ջ���ַ
         * @param id        �ջ���ַid
         * @param uid     �û�uid
         * @return
         */
        public Address getAddressByUidAndId(Integer id,Integer uid);
        
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
         * @return              ɾ���ɹ�����1
         */
        public Integer setNotDefault(Integer uid,Integer id);
        
        /**����uid ��id ɾ���ջ���ַ  ����ȫ��
         * @param id
         * @param uid
         * @return
         */
        public Integer delete2(Integer id,Integer uid) ;
        
        /**�޸��ջ���ַ
         * @param addr      �ջ���ַ��Ϣ
         * @return              ��Ӱ�������
         */
        public Integer update(Address addr);
        
        /**�����û�id ��ȡĬ���ջ���ַ
         * param uid         �û�id
         * @return    �ջ���ַ
         */
        public Address getDefaultAddress(Integer uid);
        

}
