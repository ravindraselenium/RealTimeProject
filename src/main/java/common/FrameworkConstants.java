package common;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FrameworkConstants {
	private static String userDir = System.getProperty("user.dir");

	private static Path propertiesFilePath = Paths.get(userDir, "resources", "global.properties");
	private static long defaultTimeout = 45;
	
	public static String getPropertiesFilePath() {
		return propertiesFilePath.toString();
	}

	public static long getDefaultTimeout() {
		return defaultTimeout;
	}


}
