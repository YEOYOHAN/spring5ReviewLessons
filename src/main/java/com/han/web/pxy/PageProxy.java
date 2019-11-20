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
				pageCount, pageSize, startPage, endPage, pageNum,
				blockCount, blockSize, prevBlock, nextBlock, blockNum;
	
	private boolean existPrev, existNext;
	private String search;
	
	public void paging(int rowCount) {
		
	}
}
