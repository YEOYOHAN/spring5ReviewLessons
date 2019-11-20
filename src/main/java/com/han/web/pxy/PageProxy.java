package com.han.web.pxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Lazy
@Component("pagep")
public class PageProxy extends Proxy{
	@Autowired CrawlingProxy crawler;
	
	private int rowCount, startRow, endRow,
				pageCount, pageSize, startPage, endPage, nowPage,
				blockCount, blockSize, prevBlock, nextBlock, nowBlock;
	
	private boolean existPrev, existNext;
	private String search;

	public void paging() {
		pageSize = 5;
		blockSize = 5;
		printer("크롤링 사이즈 : " + rowCount);
		pageCount = (rowCount % pageSize == 0) ? rowCount / pageSize : (rowCount / pageSize) + 1;
		blockCount = (pageCount % blockSize == 0) ? pageCount / blockSize : (pageCount / blockSize) + 1;
		startRow = 0;
		endRow = 0;
	}
}
