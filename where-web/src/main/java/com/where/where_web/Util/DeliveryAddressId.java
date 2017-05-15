package com.where.where_web.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;

public class DeliveryAddressId {
	@Test
	public  void getId(){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		String date=simpleDateFormat.format(new Date());
		UUID uuid=UUID.randomUUID();
		System.out.println( uuid.toString());
		System.out.println(date);
		//return "";
	}
}
