package rename;

import java.io.File;
import java.util.Comparator;

public class FileNameComparator implements Comparator<File> {

    public int compare(File f1, File f2) {
        String fileName1 = f1.getName();
        String fileName2 = f2.getName();

        return fileName1.compareTo(fileName2);
    }

}