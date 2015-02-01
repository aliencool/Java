package Set_Contructor.copy;
/*2014��5��16��15:49:14
 * 1:Resource: name��ʾ ����xml��bean�ļ������name���� ע�� û��ֱ��Ϊnull
 *   Autowired:��ʾʹ�����Ͳ���xmlע��
 * 2:�Զ�ɨ�����: ɨ�����������bean���ҵ������ע�� 
 *   ֱ��("")��������ȡbean
 *   socpe һ��ʹ��scope����ȡbean
 * */
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service

public class PersonService {
	
	
	private Person_Imp personImp;

	public PersonService(Person_Imp personImp) {
		super();
		this.personImp = personImp;
	}
	
	
	//@Resource
	//@Autowired
	public void setPersonImp(Person_Imp personImp) {
		this.personImp = personImp;
	}



	public PersonService() {
		super();
	}



	public void execute()
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Applicationcontext.xml");
		personImp=(Person_Imp) applicationContext.getBean(("person_Imp"));
		personImp.speak();
	}
}
