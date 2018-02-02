package com.yinzifan.lucene;
/**
* @author Cin
* @time 2018/02/01 21:00:18
*/

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.yinzifan.entity.BlogInfoEntity;

public class BlogIndex {
	
	private Directory directory;
	
	private IndexWriter getWriter() throws IOException {
		directory = FSDirectory.open(Paths.get(""));
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		return new IndexWriter(directory, config);
	}
	
	public void addIndex(BlogInfoEntity BlogInfo) throws IOException {
		IndexWriter writer = getWriter();
		Document docoment = new Document();
	}
}
