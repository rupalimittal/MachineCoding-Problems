import java.util.List;

public interface HomeService {

    public void addDevice(Device device);

    public void addSmartHomeDevice(SmartHomeDevice smartHomeDevice);

    public void sendCommand(Command command);

    public List<SmartHomeDevice> getConnectedSmartHomeDeviceList(int deviceId);

    public List<DeviceUsageDetails> getDeviceUsageDetails();


}
