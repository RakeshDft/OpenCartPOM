package com.pom.demoopencart.enums;

public enum LoginEnum {
	LoginEmail("rakesh.charana@gmail.com"),
	LoginPassword("Sreepathi1@");
	private final String name;
	LoginEnum(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	}


