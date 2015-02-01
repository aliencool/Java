package Set_Contructor;

import javax.annotation.Resource;

public class PersonService {
	@Resource(name="personImp")
	private Person_Imp personImp;

	public PersonService(Person_Imp personImp) {
		super();
		this.personImp = personImp;
	}
	
	public void execute()
	{
		personImp.speak();
	}
}
