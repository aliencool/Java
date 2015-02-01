package Set_Contructor.copy;
/*2014年5月16日15:49:14
 * 1:Resource: name表示 查找xml的bean文件里面的name进入 注入 没有直接为null
 *   Autowired:表示使用类型查找xml注入
 * 2:自动扫描机制: 扫描包下面所有bean，找到标记来注入 
 *   直接("")命名来获取bean
 *   socpe 一样使用scope来获取bean
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
