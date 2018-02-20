package com.yinzifan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author Cin
* @time 2018/01/26 22:18:34
*/
/*
 * 
create table
CREATE TABLE `t_bloginfo` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `title` varchar(200) DEFAULT NULL,
   `summary` varchar(400) DEFAULT NULL,
   `releaseDate` datetime DEFAULT NULL,
   `clickCount` int(11) DEFAULT NULL,
   `replyCount` int(11) DEFAULT NULL,
   `content` text,
   `typeId` int(11) DEFAULT NULL,
   `keyword` varchar(200) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8
 */
public class BlogInfoEntity {

	private Integer id;
	private String title;
	private String summary;
	private Date releaseDate;
	private Integer clickCount;
	private Integer replyCount;
	private String content;
	private BlogTypeEntity blogType;
	private UserInfoEntity userInfo;
	// private Integer typeId;
	private String keyword;

	private String countByDate;
	private String formatDate;
	private List<String> images = new ArrayList<String>();
	
	public BlogInfoEntity(Integer id) {
		super();
		this.id = id;
	}
	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public BlogInfoEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCountByDate() {
		return countByDate;
	}

	public void setCountByDate(String countByDate) {
		this.countByDate = countByDate;
	}

	public BlogTypeEntity getBlogType() {
		return blogType;
	}

	public void setBlogType(BlogTypeEntity blogType) {
		this.blogType = blogType;
	}

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	public UserInfoEntity getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoEntity userInfo) {
		this.userInfo = userInfo;
	}

}
