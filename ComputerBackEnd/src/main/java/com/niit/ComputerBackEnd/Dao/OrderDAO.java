package com.niit.ComputerBackEnd.Dao;

import com.niit.ComputerBackEnd.Model.OrderDetail;

public interface OrderDAO
{
	public boolean receiptGenerate(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String username);
}
