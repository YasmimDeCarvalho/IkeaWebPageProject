package com.ikea.steps;

import java.io.File;

import com.ikea.testbase.BaseClass;
import com.ikea.util.CommonMethods;
import com.ikea.util.ScreenRecorderUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

	@Before
	public void start() {
		BaseClass.setUp();
		try {
			// Start recording
			ScreenRecorderUtil.startRecord("testRecord");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void end(Scenario scenario) {
		byte[] screenshot;

		if (scenario.isFailed()) {
			// Take a screenshot and save it under "failed" folder
			screenshot = takeScreenshot("failed/" + scenario.getName());
		} else {
			// Take a screenshot and save it under "passed" folder
			screenshot = takeScreenshot("passed/" + scenario.getName());
		}

		// Attach screenshot to the report
		scenario.attach(screenshot, "image/png", scenario.getName());

		try {
			// Stop the video recording
			ScreenRecorderUtil.stopRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Clean up videos and screenshots after each test
		cleanUpFiles();

		// Close and tear down WebDriver
		BaseClass.tearDown();
	}

	// Method to clean up old screenshots and video files
	private void cleanUpFiles() {
		File screenshotDir = new File("target/screenshots/");
		if (screenshotDir.exists()) {
			File[] screenshotFiles = screenshotDir.listFiles();
			if (screenshotFiles != null) {
				for (File file : screenshotFiles) {
					file.delete(); // Delete each file in the directory
				}
			}
		}

		File videoDir = new File("target/videos/");
		if (videoDir.exists()) {
			File[] videoFiles = videoDir.listFiles();
			if (videoFiles != null) {
				for (File file : videoFiles) {
					file.delete(); // Delete each video file
				}
			}
		}
	}

}
