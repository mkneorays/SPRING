package com.neorays.dao;

import java.util.List;

public interface PaginationProductDAO {
	public long rowCount();
	public List<com.neorays.domain.Product> getProducts(int startPos,int pageSize);
}
