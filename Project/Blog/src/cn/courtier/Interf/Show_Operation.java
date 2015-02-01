package cn.courtier.Interf;

import java.util.List;

import com.opensymphony.xwork2.Action;

import cn.courtier.ActionBean.ActionBlog;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Until.SectionPage;
import cn.courtier.po.BlogContent;
import cn.courtier.po.Category;

/**
 * @类功能说明：显示操作接口
 * @类修改者：
 * @修改日期：
 * @说明：各类方法功能，查看单词
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-7 下午11:29:32
 * @版本：V1.0
 */
public interface Show_Operation {
	/**
	 * 函数功能说明:查询全部
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @param actionPageBean 分页
	 * @参数： @return    
	 * @return List<BlogContent>   
	 * @throws
	 */
	public SectionPage get_All_BlogContent(ActionPage actionPageBean);
	/**
	 * 函数功能说明:查询类别下面文章
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @param category_name
	 * @参数： @param actionPageBean 分页
	 * @参数： @return    
	 * @return List<BlogContent>   
	 * @throws
	 */
	public  SectionPage get_Category_BlogContent(String category_name,ActionPage actionPageBean);
	
	
	/**
	 * 函数功能说明:推荐文章
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @return    
	 * @return List<BlogContent>   
	 * @throws
	 */
	public   List<ActionBlog> get_Recommend_BlogContent();
	
	
	
	/**
	 * 函数功能说明:根据文章得到类别
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @param blog_Name
	 * @参数： @return    
	 * @return String   
	 * @throws
	 */
	public   String get_Category_Name(String blog_Name);
	
	
	/**
	 * 函数功能说明:类别的所有名称
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @return    
	 * @return List<BlogContent>   
	 * @throws
	 */
	public List<Category> get_Category_All_Name();
	/**
	 * 函数功能说明:查找单个文章
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @param id
	 * @参数： @return    
	 * @return BlogContent   
	 * @throws
	 */
	public BlogContent get_BlogContent(int id);
}
