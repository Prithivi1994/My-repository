package com.jvmreport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReportGenerate extends BaseClass {
public static void generateJVMreport(String jsonFile) throws IOException {
		String path = System.getProperty("user.dir");
		
		File file=new File(path+getPropertyValue("jvmReportPath"));		
	
		Configuration configuration=new Configuration(file,"Adactin");
		
		configuration.addClassifications("browser", "chrome");
		configuration.addClassifications("browser version", "101");
		configuration.addClassifications("OS", "Windows11");
		
		List<String> jsonFiles=new ArrayList<String>();
		
		jsonFiles.add(jsonFile);
			
		ReportBuilder builder=new ReportBuilder(jsonFiles,configuration);
		
		builder.generateReports();	
		
	}

}
