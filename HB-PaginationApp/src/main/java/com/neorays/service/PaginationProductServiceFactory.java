package com.neorays.service;

public class PaginationProductServiceFactory {
	
	public static PaginationProductService getInstance(){
		return new PaginationProductServiceImpl();
	}

}
