package com.pom.demoopencart.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.demoopencart.base.ActionEngine;
import com.pom.demoopencart.pages.HRMApplyLeavePage;
import com.pom.demoopencart.pages.HRMDashboardPage;
import com.pom.demoopencart.pages.HRMLeavePage;
import com.pom.demoopencart.pages.HRMLoginPage;
import com.pom.demoopencart.pages.HRMMyLeavePage;
import com.pom.demoopencart.utilities.PojoReader;

public class HRM_LoginTests extends ActionEngine{
	@Test
	public void testLogin() throws IOException, InterruptedException
	{
		enterUrl(PojoReader.getPrConf().getValue("qa_hrm_url"));
		Thread.sleep(2000);
		HRMLoginPage.enterUserName();
		HRMLoginPage.enterPassword();
		HRMLoginPage.enterLoginBtn();
		String exmsg=PojoReader.getExcelObj().getCellData("sheetname","Sheet4", 2, 0);
		HRMLoginPage.validateDasboardMsg(exmsg);
		HRMDashboardPage.clickLeaveMenu();
		String expleavemsg=PojoReader.getExcelObj().getCellData("sheetname","Sheet4",3,0);
		HRMDashboardPage.validateLeavePage(expleavemsg);
		HRMLeavePage.clickApplyLeave();
		String expLeavemsg=PojoReader.getExcelObj().getCellData("sheetname","Sheet4",4,0);
		HRMApplyLeavePage.validateApplyLeaveMsg(expLeavemsg);
		HRMLeavePage.clickMyLeave();
		HRMMyLeavePage.clickMyLeaveCalender();
					Thread.sleep(3000);
		
	}

}
