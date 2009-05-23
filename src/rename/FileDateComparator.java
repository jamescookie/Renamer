package rename;

import java.io.File;
import java.util.Comparator;

public class FileDateComparator implements Comparator<File> {

    public int compare(File f1, File f2) {
        long fileDate1 = f1.lastModified();
        long fileDate2 = f2.lastModified();

        return (int) (fileDate1 - fileDate2);
    }

}
