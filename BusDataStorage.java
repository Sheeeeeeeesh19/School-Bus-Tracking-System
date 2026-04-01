import java.util.ArrayList;


public class BusDataStorage {

    private static BusDataStorage instance;


    public ArrayList<String[]> busList = new ArrayList<String[]>();

    private BusDataStorage() {}

    public static BusDataStorage getInstance() {
        if (instance == null) {
            instance = new BusDataStorage();
        }
        return instance;
    }
}