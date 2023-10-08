package com.Actitime.Testscript;

import org.testng.annotations.Test;

import com.Actitime.Genericlibrary.Baseclass;
import com.Actitime.Genericlibrary.FileLibrary;
import com.Actitime.Pom.Homepage;
import com.Actitime.Pom.Taskpage;

public class CreateCustmer extends Baseclass{
	
	@Test
	public void create() {
		Homepage hp=new Homepage(driver);
		hp.getTasktab().click();
		Taskpage tp=new Taskpage(driver);
		tp.getAddnew().click();
		tp.getNewcustmer().click();
		FileLibrary f=new FileLibrary();
		String custname = f.readDatafromexcel("wantedlist", 2, 1);
		 tp.getCustname().sendkeys(custname);
		String custdesp = f.readDatafromexcel("wantedlist", 2, 2);
		tp.getCustdesp().sendKeys(custdesp);
		tp.getCreatwbtn().click();
		
		
		
		
	}
	
	
	

}
