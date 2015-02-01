package cn.courtier.ActionBean;

/**
 * @�๦��˵������ҳʵ��
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-8 ����08:29:50
 * @�汾��V1.0
 */
public class ActionPage {


	

		// ��ҳ��(totalPage)
		private int totalPage;
		// ��ǰҳ(currentPage)
		private int currentPage;
		// ÿ��ҳ�������(MAXCOUNT)
		public final static int MAXCOUNT=8;
		// �Ƿ�����һҳ(hasPrePage)
		private boolean hasPrePage;
		// �Ƿ�����һҳ(hasNextPage)
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

