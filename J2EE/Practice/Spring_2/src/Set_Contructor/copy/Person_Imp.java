package Set_Contructor.copy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository
public class Person_Imp implements Person{
	
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Hello word");
	}
	
}
