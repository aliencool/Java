package cn.courtier.admin.Im;

import javax.annotation.Resource;

import cn.courtier.Interf.Crud_Blog;
import cn.courtier.po.BlogContent;
import cn.courtier.po.Bloguser;
import cn.courtier.po.Category;

public class Im_Crub_Service implements Crud_Blog{
    
	@Resource(name="crub_operation")
	private Crud_Blog crudBlog;
	
	
	public boolean delete_Blog(BlogContent blogContent) {
		// TODO Auto-generated method stub
		return crudBlog.delete_Blog(blogContent);
	}

	public boolean insert_Blog(BlogContent blogContent, Category category,
			Bloguser bloguser) {
		// TODO Auto-generated method stub
		return crudBlog.delete_Blog(blogContent);
	}

	public boolean update_Blog(BlogContent blogContent) {
		// TODO Auto-generated method stub
		return crudBlog.update_Blog(blogContent);
	}

	public int update_award(int id, int count) {
		// TODO Auto-generated method stub
		return crudBlog.update_award(id, count);
	}

	public int update_click(int id, int count) {
		// TODO Auto-generated method stub
		return crudBlog.update_click(id, count);
	}

}
