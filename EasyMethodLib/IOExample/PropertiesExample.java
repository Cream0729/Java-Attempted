package EasyMethodLib.IOExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
    static Properties prop = new Properties();
    static FileOutputStream fos = null;
    static FileInputStream fis = null;
    public static void main(String[] args) throws IOException {
        String local = "src\\EasyMethodLib\\IOExample\\test.properties";
        createProperties(local, true);
        getProperties(local, true);
    }

    public static void createProperties(String local,boolean control) throws IOException {
        if (control) {
            prop.put("aaa", "111");
            prop.put("bbb", "222");
            prop.put("ccc", "333");
            prop.put("ddd", "444");
            prop.put("eee", "555");
            prop.put("fff", "666");
            prop.put("ggg", "777");
            prop.put("hhh", "888");
            prop.put("iii", "999");
            fos = new FileOutputStream(local);
            prop.store(fos, "test");
            fos.close();
        }
    }

    public static void getProperties(String local, boolean control) throws IOException {
        if (control) {
            fis = new FileInputStream(local);
            prop.load(fis);
            fis.close();
            System.out.println(prop);
        }
    }
}
