package P_Impl;

import P_I.Person;

public class Person_Service {
	private Person person;

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void say(String name)
	{
		person.say(name);
	}
	
}
