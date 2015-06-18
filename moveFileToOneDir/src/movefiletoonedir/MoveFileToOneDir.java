
package movefiletoonedir;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveFileToOneDir {

    File srcDir,destDir;
    
    public MoveFileToOneDir(File srcDir, File destDir){
        
        this.srcDir=srcDir;
        this.destDir=destDir;
    }
   
    public void moveFiles(){
        moveFile(srcDir);
        System.out.println(destDir.listFiles().length+ " files moved successfully");
    }
    
    
    public void moveFile(File srcDir){
    
        for(File file:srcDir.listFiles()){
            
            if(file.isDirectory()){
                moveFile(file);
            }else if(file.isFile() && !file.isHidden()){
                int i=1;
                String ext=""; 
                String fileName=file.getName();
                while(true){
                    
                    if(new File(destDir.getAbsolutePath()+"/"+fileName+ext).exists()){
                        ext="_"+i++;
                    }else{
                        file.renameTo(new File(destDir.getAbsolutePath()+"/"+fileName+ext));
                        i=1;
                        break;
                    }
                }
                
                
            }
            
        }
    
    }
    
    public static void main(String[] args) throws IOException {
        
        File srcDir,destDir;
        
        System.out.println("Enter the source directory :");
        srcDir=getDir();
        
        System.out.println("Enter the destination directory :");
        
        destDir=getDir();
        
        MoveFileToOneDir mov= new MoveFileToOneDir(srcDir, destDir);
        mov.moveFiles();
    }
    
    
    public static File getDir() throws IOException{
        File dir;
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Enter the path from the root : "+ new File(System.getProperty("user.home")).getAbsolutePath());
            dir=new File(System.getProperty("user.home")+in.readLine());
            if(dir.exists()){
                return dir;
            }else{
                System.out.println("The directory "+ dir.getAbsolutePath()+" is not valid :(");
            }
        }
    }
    
}
