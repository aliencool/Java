package cn.courtier.Interf;

import cn.courtier.po.BlogContent;
import cn.courtier.po.Bloguser;
import cn.courtier.po.Category;

/**
 * @�๦��˵��������Աר����
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @˵����CRUD
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-8 ����01:00:26
 * @�汾��V1.0
 */
public interface Crud_Blog {
	
	   /**
	 * ��������˵��:��������
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @param blogContent
	 * @������ @param category �����ض����
	 * @������ @param bloguser �����ض����û���
	 * @������ @return    
	 * @return boolean   
	 * @throws
	 */
	public boolean insert_Blog(BlogContent blogContent,Category category,Bloguser bloguser);
	
	/**
	 * ��������˵��:���µ�ǰ
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @param blogContent ����
	 * @������ @return    
	 * @return boolean   
	 * @throws
	 */
	public boolean update_Blog(BlogContent blogContent);
	
	
	
	/**
	 * ��������˵��:ɾ�����id������
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @param id
	 * @������ @return    
	 * @return boolean   
	 * @throws
	 */
	public boolean delete_Blog(BlogContent blogContent);
	
	/**
	 * ��������˵��:���µ������
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @param id
	 * @������ @param count
	 * @������ @return    
	 * @return int   
	 * @throws
	 */
	public int update_click(int id,int count);
	public int update_award(int id,int count);
	
}