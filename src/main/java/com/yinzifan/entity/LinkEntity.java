package com.yinzifan.entity;
/**
* @author Cin
* @time 2018/01/25 22:56:16
*/
/*
 * 
create table
CREATE TABLE `t_link` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `linkName` varchar(100) DEFAULT NULL,
   `linkUrl` varchar(200) DEFAULT NULL,
   `linkOrder` int(3) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
 */
public class LinkEntity {
	private Integer id;
	private String linkName;
	private String linkUrl;
	private Integer linkOrder;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public Integer getLinkOrder() {
		return linkOrder;
	}
	public void setLinkOrder(Integer linkOrder) {
		this.linkOrder = linkOrder;
	}
	public LinkEntity() {
		super();
	}
	public LinkEntity(Integer id, String linkName, String linkUrl, Integer linkOrder) {
		super();
		this.id = id;
		this.linkName = linkName;
		this.linkUrl = linkUrl;
		this.linkOrder = linkOrder;
	}
	@Override
	public String toString() {
		return "LinkEntity [id=" + id + ", linkName=" + linkName + ", linkUrl=" + linkUrl + ", linkOrder=" + linkOrder
				+ "]";
	}
	
}
