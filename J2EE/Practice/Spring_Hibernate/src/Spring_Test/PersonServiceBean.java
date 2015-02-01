package Spring_Test;

public class PersonServiceBean implements PersonService {

	@Override
	public String getName(Integer integer) {
		// TODO Auto-generated method stub
		
		return integer.toString();
	}

	@Override
	public void insert(String name, Integer integer) {
		// TODO Auto-generated method stub
		System.out.println("²åÈëÎª:"+name+"id:"+integer);
	}

	@Override
	public void save(String name) {
		// TODO Auto-generated method stub
		System.out.println("»¶Ó­Äú");
		System.out.println("Ãû³Æ:"+name);
	}

}
