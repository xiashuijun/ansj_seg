package org.ansj.splitWord.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import love.cq.util.IOUtil;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.util.newWordFind.LearnTool;
import org.ansj.util.newWordFind.NewTerm;
import org.ansj.util.newWordFind.NewWordFind;

/**
 * 这是一个新词发现的简单例子.
 * 
 * @author ansj
 * 
 */
public class NewWordFindDemo {
	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		BufferedReader reader = IOUtil.getReader("/Users/ansj/Downloads/冒死记录中国神秘事件（真全本）.txt", "GBK");
		LearnTool learn = new LearnTool();
long start = System.currentTimeMillis()  ;
		NlpAnalysis nlpAnalysis = new NlpAnalysis(reader, learn) ;
		Term term = null ;
		while((term=nlpAnalysis.next())!=null){
			if(hm.containsKey(term.getName())){
				hm.put(term.getName(), hm.get(term.getName())+1) ;
			}else{
				hm.put(term.getName(), 1) ;
			}
		}
System.out.println(System.currentTimeMillis()-start);
		Set<Entry<String, Integer>> entrySet = hm.entrySet() ;
		StringBuilder sb = new StringBuilder() ;
		for (Entry<String, Integer> entry : entrySet) {
			sb.append(entry.getKey()+"\t"+entry.getValue()+"\n") ;
		}
		
		IOUtil.Writer("/Users/ansj/Desktop/result.txt", "UTF-8", sb.toString()) ;
	}
}