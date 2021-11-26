package com.framing.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Pojo<T>  implements Serializable{
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	  private Date created;
	  private String createdBy;

	  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	  private Date lastUpdated;
	  private String lastUpdatedBy;
	  private boolean success;
	  private String message;
	  private String history;
	  private Set<Object> errors = new HashSet();
	  
	  public Date getCreated()
	  {
	    return this.created;
	  }

	  public void setCreated(Date created)
	  {
	    this.created = created;
	  }

	  public String getCreatedBy()
	  {
	    return this.createdBy;
	  }

	  public void setCreatedBy(String createdBy)
	  {
	    this.createdBy = createdBy;
	  }

	  public Date getLastUpdated()
	  {
	    return this.lastUpdated;
	  }

	  public void setLastUpdated(Date lastUpdated)
	  {
	    this.lastUpdated = lastUpdated;
	  }

	  public String getLastUpdatedBy()
	  {
	    return this.lastUpdatedBy;
	  }

	  public void setLastUpdatedBy(String lastUpdatedBy)
	  {
	    this.lastUpdatedBy = lastUpdatedBy;
	  }

	  public boolean isSuccess()
	  {
	    return this.success;
	  }

	  public void setSuccess(boolean success)
	  {
	    this.success = success;
	  }

	  public String getMessage()
	  {
	    return this.message;
	  }

	  public void setMessage(String message)
	  {
	    this.message = message;
	  }

	  public String getHistory()
	  {
	    return this.history;
	  }

	  public void setHistory(String history)
	  {
	    this.history = history;
	  }

	  public Set<Object> getErrors()
	  {
	    return this.errors;
	  }

	  public void setErrors(Set<Object> errors)
	  {
	    this.errors = errors;
	  }

	  public String toString()
	  {
	    return super.toString();
	  }
	}