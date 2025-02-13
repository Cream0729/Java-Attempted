package SchoolInformationManagement;

import java.io.*;
import java.util.ArrayList;

public class FileControl {
    FileOutputStream fos = null;
    FileInputStream fis = null;
    File file = null;
    public<T> void outputData (ArrayList<T> data, String date) {
        try {
            fos = new FileOutputStream(new File("src//SchoolInformationManagement", date + ".data"));
            for (T datum : data) {
                fos.write((Integer) datum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}