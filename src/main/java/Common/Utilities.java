package Common;

import java.io.File;

public class Utilities {
    public static String getProjectPath() {
    String projectPath = new File("C:\\Users\\Ngan Tam\\Downloads\\SeleniumLevel1\\Selenium_1").getAbsolutePath();
    return projectPath;
    }
}
