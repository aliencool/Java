package Dao;

import java.util.List;

public interface I_operation {
	public void insert_stu(student stu);
	public void update_stu(student stu);
	public void delete_stu(student stu);
	public List<student> get_stu();
}
