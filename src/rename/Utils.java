package rename;

import com.jamescookie.graphics.ImageManipulator;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utils {
    private static final String SAFE_PREFIX = "~~~";

    public static void doUpdate(String directoryPath, String fileName, String extension, Comparator<File> comparator, int start) {
        File directory = new File(directoryPath);
        List<File> filesList = findFiles(directory);

        if (comparator != null) {
            Collections.sort(filesList, comparator);
        }

        for (int i = 0; i < filesList.size(); i++) {
            filesList.get(i).renameTo(new File(directory, SAFE_PREFIX + fileName + pad(i) + "." + extension));
        }

        filesList = findFiles(directory);

        Collections.sort(filesList, new FileNameComparator());

        for (File file : filesList) {
            file.renameTo(new File(directory, fileName + pad(start++) + "." + extension));
        }
    }

    private static List<File> findFiles(File directory) {
        File[] files = directory.listFiles();
        List<File> filesList = new ArrayList<File>();

        for (File file : files) {
            if (!file.isDirectory() && !file.isHidden()) {
                filesList.add(file);
            }
        }
        return filesList;
    }

    private static String pad(int i) {
        String retValue = "" + i;

        while (retValue.length() < 3) {
            retValue = "0" + retValue;
        }

        return retValue;
    }

    public static void doResize(String directoryPath, int size) {
        File directory = new File(directoryPath);
        List<File> filesList = findFiles(directory);
        Double scale;

        for (File file : filesList) {
            String fileName = file.getName();
            File newfile = new File(directory, SAFE_PREFIX + fileName);
            try {
                FileOutputStream out = new FileOutputStream(newfile);
                ImageManipulator im = new ImageManipulator(file, out);
                String ext = fileName.substring(fileName.lastIndexOf('.') + 1);
                im.setOutputImageType(ext);

                if (im.getWidth() > im.getHeight()) {
                    scale = (double) im.getWidth() * ((double) size / 100 );
                } else {
                    scale = (double) im.getHeight() * ((double) size / 100 );
                }

                im.writeThumbnail(scale.intValue());
                out.flush();
                out.close();
                file.delete();
                newfile.renameTo(new File(directory, fileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
