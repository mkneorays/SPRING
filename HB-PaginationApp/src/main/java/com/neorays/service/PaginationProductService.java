package com.neorays.service;

import java.util.List;

import com.neorays.dto.ProductDTO;

public interface PaginationProductService {
	public static final int PAGE_SIZE=4;
	public  int getPageCount();
	public List<ProductDTO> getReportData(int pageNo);

}
