package org.runner;

import org.base.BaseClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\features", glue="org.step",dryRun = false )

public class RunnerDomino extends BaseClass{
	
	@BeforeClass
	public static void start() {
		toChromelaunch();
		//toEdgelaunch();
	}
	
	@AfterClass
	public static void end() {
		driver.quit();
	}
}
