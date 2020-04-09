package Demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileDemo {

    public static void main(String[] args) throws MalformedURLException {
        File f= new File("src");
        File fs  = new File(f,"ApiDemos-debug.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3 XL API R");
        cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());

        //setting android driver

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    }


}
