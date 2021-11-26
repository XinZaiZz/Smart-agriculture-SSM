package com.framing.pojo;

import java.util.ArrayList;
import java.util.List;

public class Pages<T> extends Pojo<T>{
	 private static int DEFAULT_PAGE_SIZE = 10;

	  private int pageSize = DEFAULT_PAGE_SIZE;
	  private long total;
	  private int page = 1;
	  private int start;
	  private int limit;
	  private String sortName = "sid";

	  private String sortOrder = "desc";

	  private List<T> rows = new ArrayList();
	  
	  public long getTotal()
	  {
	    return this.total;
	  }

	  public void setTotal(long total)
	  {
	    this.total = total;
	  }

	  public int getPageSize()
	  {
	    return this.pageSize;
	  }

	  public void setPageSize(int pageSize)
	  {
	    this.pageSize = pageSize;
	  }

	  public int getPage()
	  {
	    return this.page;
	  }

	  public void setPage(int page)
	  {
	    this.page = page;
	  }

	  public int getStart()
	  {
	    this.start = ((this.page - 1) * this.pageSize);
	    return this.start;
	  }

	  public void setStart(int start)
	  {
	    this.start = start;
	  }

	  public int getLimit()
	  {
	    this.limit = this.pageSize;
	    return this.limit;
	  }

	  public void setLimit(int limit)
	  {
	    this.limit = limit;
	  }

	  public String getSortName()
	  {
	    return this.sortName;
	  }

	  public void setSortName(String sortName)
	  {
	    this.sortName = sortName;
	  }

	  public String getSortOrder()
	  {
	    return this.sortOrder;
	  }

	  public void setSortorder(String sortOrder)
	  {
	    this.sortOrder = sortOrder;
	  }

	  public List<T> getRows()
	  {
	    return this.rows;
	  }

	  public void setRows(List<T> rows)
	  {
	    this.rows = rows;
	  }
}
