/**
 * 
 */
package com.weixin.bean;

/**
 * ��ҳ��Ϣ��װ
 * @author jpgong
 *
 */
public class PageBean {
	private int currentPage;
	private int pageSize;
	private int pageCount;
	private int totalCount;
	//��ҳʱ����ת���ӵ�ַ
	private String prefixUrl;
	//currentPage��prefixUrl����ʱ��ʹ�õ���?����&
	//���Ϊtrue����&;����ʹ��?
	private boolean isAnd;
	
	public PageBean() {
	}
	
	/**
	 * ���ι��캯��
	 * @param currentPage
	 * @param pageSize
	 * @param totalPage
	 * @param totalCount
	 */
	public PageBean(int currentPage, int pageSize, int totalCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		if (totalCount%pageSize == 0) {
			this.pageCount = totalCount/pageSize;
		}else {
			this.pageCount = totalCount/pageSize + 1;
		}
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getPrefixUrl() {
		return prefixUrl;
	}

	public void setPrefixUrl(String prefixUrl) {
		this.prefixUrl = prefixUrl;
	}

	public boolean isAnd() {
		return isAnd;
	}

	public void setAnd(boolean isAnd) {
		this.isAnd = isAnd;
	}
}