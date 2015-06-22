package movefiletoonedir;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.io.FilenameUtils;

public class MoveFileToOneDir {

    File srcDir, destDir;

    // Constructor for this class
    public MoveFileToOneDir(File srcDir, File destDir) {

        this.srcDir = srcDir;
        this.destDir = destDir;
    }

    /**
     * This method will call from out side of the class
     */
    public void moveFiles() {
        int oldSize=destDir.listFiles().length;
        moveFile(srcDir);
        System.out.println(destDir.listFiles().length -oldSize + " files moved successfully");
    }

    /**
     * This method will move all files into one directory. Its a recursive
     * method for invoke its sub directories
     *
     * @param srcDir source directory in File type
     */
    public void moveFile(File srcDir) {

        for (File file : srcDir.listFiles()) {

            if (file.isDirectory()) {
                moveFile(file);     // if a file is directory then it invoke this method itself
            } else if (file.isFile() && !file.isHidden()) {
                int i = 1;
                String ext = "";
                String fileName = file.getName();
                //this will repeat until the file name is new one it means that the file name should no exist in the directory
                // once it is a uniq name the move the file to destination dir and the loop will break
                while (true) {
                    if (new File(destDir.getAbsolutePath() + "/" + FilenameUtils.removeExtension(fileName) + ext + "." + FilenameUtils.getExtension(fileName)).exists()) {
                        ext = "_" + i++;
                    } else {
                        String extension=FilenameUtils.getExtension(fileName);
                        file.renameTo(new File(destDir.getAbsolutePath() + "/" + FilenameUtils.removeExtension(fileName) + ext + ((extension.length()>0)?"."+extension:"")));
                        ext = "";
                        i = 1;
                        break;
                    }
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {

        File srcDir, destDir;

        System.out.println("Enter the source directory :");
        srcDir = getDir();

        System.out.println("Enter the destination directory :");

        destDir = getDir();

        MoveFileToOneDir mov = new MoveFileToOneDir(srcDir, destDir);
        mov.moveFiles();
    }

    /**
     * This method will return the File object which is read from the user
     *
     * @return the File object
     * @throws IOException Throws IOException
     */
    public static File getDir() throws IOException {
        File dir;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter the path from the root : " + new File(System.getProperty("user.home")).getAbsolutePath());
            dir = new File(System.getProperty("user.home") + in.readLine());
            if (dir.exists()) {
                return dir;
            } else {
                System.out.println("The directory " + dir.getAbsolutePath() + " is not valid :(");
            }
        }
    }

}
