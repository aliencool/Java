package cn.courtier.blog.Im;

import java.util.List;

import javax.annotation.Resource;

import cn.courtier.ActionBean.ActionBlog;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Interf.Show_Operation;
import cn.courtier.Until.SectionPage;
import cn.courtier.po.BlogContent;
import cn.courtier.po.Category;

public class Im_Show_Service implements Show_Operation{
	
	@Resource(name="show_operation")
	private Show_Operation imoperation;
	

	public SectionPage get_All_BlogContent(ActionPage actionPageBean) {
		
		return imoperation.get_All_BlogContent(actionPageBean);
	}

	public BlogContent get_BlogContent(int id) {
		// TODO Auto-generated method stub
		return imoperation.get_BlogContent(id);
	}

	public SectionPage get_Category_BlogContent(String categoryName,
			ActionPage actionPageBean) {
		// TODO Auto-generated method stub
		return imoperation.get_Category_BlogContent(categoryName, actionPageBean);
	}

	public String get_Category_Name(String blogName) {
		// TODO Auto-generated method stub
		return imoperation.get_Category_Name(blogName);
	}

	public List<Category> get_Category_All_Name() {
		// TODO Auto-generated method stub
		return imoperation.get_Category_All_Name();
	}

	public List<ActionBlog> get_Recommend_BlogContent() {
		// TODO Auto-generated method stub
		
		return imoperation.get_Recommend_BlogContent();
	}
	
}
