package Dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class Impl_operation implements I_operation{
	//����session����
	//ֱ��ʹ�����ֶ���ע��
	@Resource(name="sessionFactory")
	private SessionFactory factory;
	
	@Override
	public void delete_stu(student stu) {
		factory.getCurrentSession().delete(stu);
	}

	//��ѯ����Ҫ����
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<student> get_stu() {
		System.out.println(factory);
		// TODO Auto-generated method stub
		
		List<student> beanStus=factory.openSession().createQuery("from student").list();
		
		return beanStus;
	}

	@Override
	public void insert_stu(student stu) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().persist(stu);
	}

	@Override
	public void update_stu(student stu) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().merge(stu);
	}

}
