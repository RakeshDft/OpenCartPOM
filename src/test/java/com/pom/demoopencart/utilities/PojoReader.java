package com.pom.demoopencart.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.pom.demoopencart.supporters.ExcelReader;
import com.pom.demoopencart.supporters.PropertiesReader;


public class PojoReader {
	public static ExcelReader getExcelObj() throws EncryptedDocumentException, IOException 
	{
		ExcelReader excelReader=new ExcelReader(FilePaths.excelFilePath);
		return excelReader;
	}
	
	/*
	 * public static PropertiesReader getPrOr() { PropertiesReader prOr=new
	 * PropertiesReader(FilePaths.orFilePath); return prOr; }
	 */
	public static PropertiesReader getPrConf() throws IOException 
	{
		PropertiesReader prConf=new PropertiesReader(FilePaths.confFilePath);
		return prConf;
	}
}
