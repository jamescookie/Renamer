package rename;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static final String SAFE_PREFIX = "~~~";

    public static void doUpdate(String directoryPath, String fileName, String extension, Comparator<File> comparator, int start) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        List<File> filesList = new ArrayList<File>();

        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory() && !files[i].isHidden()) {
                filesList.add(files[i]);
            }
        }

        if (comparator != null) {
            Collections.sort(filesList, comparator);
        }

        for (int i = 0; i < filesList.size(); i++) {
            ((File) filesList.get(i)).renameTo(new File(directory, SAFE_PREFIX + fileName + pad(i) + "." + extension));
        }

        files = directory.listFiles();
        filesList = new ArrayList<File>();

        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory() && !files[i].isHidden()) {
                filesList.add(files[i]);
            }
        }

        Collections.sort(filesList, new FileNameComparator());

        for (int i = 0; i < filesList.size(); i++) {
            ((File) filesList.get(i)).renameTo(new File(directory, fileName + pad(start++) + "." + extension));
        }
    }

    private static String pad(int i) {
        String retValue = "" + i;

        while (retValue.length() < 3) {
            retValue = "0" + retValue;
        }

        return retValue;
    }
}
