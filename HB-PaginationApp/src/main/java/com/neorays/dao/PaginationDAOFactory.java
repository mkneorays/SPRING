package com.neorays.dao;

public class PaginationDAOFactory {
	public static PaginationProductDAO getInstance(){
		return new PaginationProductDAOImpl();
	}

}
