package Common;

import java.io.File;

public class Utilities {
    public static String getProjectPath() {
    String projectPath = new File("F:\\TestAutomation\\Selenium_1").getAbsolutePath();
    return projectPath;
    }
}
