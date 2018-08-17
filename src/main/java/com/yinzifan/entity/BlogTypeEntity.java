package com.yinzifan.entity;
/**
* @author Cin
* @time 2018/01/26 22:22:31
*/
/*
 * 
create table
CREATE TABLE `t_blogtype` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `typeName` varchar(30) DEFAULT NULL,
   `typeOrder` int(3) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
 */
public class BlogTypeEntity {

	private Integer id;
	private String typeName;
	private Integer typeOrder;
	private Integer blogCounts;
	public BlogTypeEntity() {
		super();
	}
	public BlogTypeEntity(Integer id, String typeName, Integer typeOrder, Integer blogCounts) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.typeOrder = typeOrder;
		this.blogCounts = blogCounts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getTypeOrder() {
		return typeOrder;
	}
	public void setTypeOrder(Integer typeOrder) {
		this.typeOrder = typeOrder;
	}
	public Integer getBlogCounts() {
		return blogCounts;
	}
	public void setBlogCounts(Integer blogCounts) {
		this.blogCounts = blogCounts;
	}
	@Override
	public String toString() {
		return "BlogTypeEntity [id=" + id + ", typeName=" + typeName + ", typeOrder=" + typeOrder + ", blogCounts="
				+ blogCounts + "]";
	}
	
}
