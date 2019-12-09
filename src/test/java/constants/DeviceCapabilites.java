package constants;

import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;

public class DeviceCapabilites {
    public static final HashMap<String, Object> PIXEL_2_CAPABILITIES = new HashMap<>();

    static {
        PIXEL_2_CAPABILITIES.put("deviceName", "Pixel 2");
        PIXEL_2_CAPABILITIES.put(CapabilityType.PLATFORM_NAME, "Android");
        PIXEL_2_CAPABILITIES.put("udid", "emulator-5554");
        PIXEL_2_CAPABILITIES.put("appPackage", "com.getir.getirtestingcasestudy");
        PIXEL_2_CAPABILITIES.put("appActivity", "com.getir.getirtestingcasestudy.ui.login.LoginActivity");
        PIXEL_2_CAPABILITIES.put("noReset", "true");
        PIXEL_2_CAPABILITIES.put("newCommandTimeout", 100000);
    }
}
