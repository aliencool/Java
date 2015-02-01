package cn.courtier.ActionBean;

/**
 * @类功能说明：分页实体
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-8 上午08:29:50
 * @版本：V1.0
 */
public class ActionPage {


	

		// 总页数(totalPage)
		private int totalPage;
		// 当前页(currentPage)
		private int currentPage;
		// 每个页面最大数(MAXCOUNT)
		public final static int MAXCOUNT=8;
		// 是否有上一页(hasPrePage)
		private boolean hasPrePage;
		// 是否有下一页(hasNextPage)
		private boolean hasNextPage;

		public int getTotalPage() {
			return totalPage;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		
		public boolean isHasPrePage() {
			return hasPrePage;
		}
		public boolean isHasNextPage() {
			return hasNextPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		
		public void setHasPrePage(boolean hasPrePage) {
			this.hasPrePage = hasPrePage;
		}
		public void setHasNextPage(boolean hasNextPage) {
			this.hasNextPage = hasNextPage;
		}
		public ActionPage(int everyPage, int totalPage, int currentPage,
				int beginIndex, boolean hasPrePage, boolean hasNextPage) {
			super();
			this.totalPage = totalPage;
			this.currentPage = currentPage;
			this.hasPrePage = hasPrePage;
			this.hasNextPage = hasNextPage;
		}
		public ActionPage(){}
		
		

	

	}

