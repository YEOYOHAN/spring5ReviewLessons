package com.han.web.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.han.web.pxy.Box;
import com.han.web.pxy.CrawlingProxy;
import com.han.web.pxy.PageProxy;

@RestController
@RequestMapping("/roro")
public class CrawlingCtrl {
	@Autowired CrawlingProxy crawler;
	@Autowired PageProxy pagep;
	@Autowired Box<Object> box;
	
	@GetMapping("/naver")
	public ArrayList<HashMap<String, String>> naver(){
		System.out.println("NAVER");
		return crawler.engCrawling("https://endic.naver.com/?sLn=kr");
		
	}
		
	@GetMapping("/cgv")
	public ArrayList<HashMap<String, String>> cgv() {
		System.out.println("CGV");
		return crawler.cgvCrawling();
		
	}
	@GetMapping("/bugs/page/{page}")
	public Map<?,?> bugs(@PathVariable String page) {
		System.out.println("넘어온 페이지"+page);
		ArrayList<HashMap<String, String>> list = crawler.bugsCrawling();
		pagep.setRowCount(list.size());
		pagep.setPageSize(10);
		pagep.setBlockSize(5);
		pagep.setNowPage(pagep.integer(page));
		pagep.paging();
		ArrayList<HashMap<String, String>> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i >= pagep.getStartRow() && i <= pagep.getEndRow()) {
				temp.add(list.get(i));
			}
			if(i>pagep.getEndRow()) {break;}
		}
		box.put("pagep", pagep);
		box.put("list", temp);
		System.out.println("페이피 "+pagep.toString());
		return box.get();
	}

}
