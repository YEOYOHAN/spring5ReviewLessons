package com.han.web.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.han.web.pxy.CrawlingProxy;
import com.han.web.pxy.PageProxy;

@RestController
@RequestMapping("/roro")
public class CrawlingCtrl {
	@Autowired CrawlingProxy crawler;
	@Autowired PageProxy pagep;
	
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
	@GetMapping("/bugs")
	public Map<?,?> bugs() {
		System.out.println("BUGS");
		ArrayList<HashMap<String, String>> list = crawler.bugsCrawling();
		pagep.setRowCount(list.size());
		pagep.setPageSize(5);
		pagep.setBlockSize(5);
		pagep.setNowPage(1);
		pagep.paging();
		int startRow = pagep.getStartRow();
		int pageSize = pagep.getPageSize();
		
		return null;
	}

}
