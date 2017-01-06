package com.cheney.gencode.util.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Moudle: FileUtil 
 * @version:v1.0
 * @Description: 文件工具
 * @author: xuyushuai
 * @date: 2014年10月23日 上午11:40:25
 *
 */
public class FileUtil {
    private static File createFile(String path,String fileName) throws IOException
    {
        File file = new File(path + "/" + fileName);
        file.delete();
        file.createNewFile();
        
        return file;
    }
    
    /**
    *
    * <p>Title: getFileOutputStream</p>
    * <p>author : xuyushuai</p>
    * <p>date : 2014年10月23日 上午11:45:39</p>
    * @param path
    * @param fileName
    * @return 输出文件流
    * @throws IOException
    */ 
    public static FileOutputStream getFileOutputStream(String path,String fileName) throws IOException
    {
        File file = createFile(path,fileName);
        return new FileOutputStream(file, true);
    }
    
}
