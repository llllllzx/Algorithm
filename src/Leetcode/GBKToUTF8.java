package Leetcode;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by zhaoxinliu on 2019/4/17
 */
public class GBKToUTF8 {
    public static void main(String[] args) throws IOException {
        //GBK编码格式源码路径
        String srcDirPath = "G:\\gbk";
        //转为UTF-8编码格式源码路径
        String utf8DirPath = "G:\\utf";
        //获取所有java文件
        Collection<File> javaGbkFileCol =  FileUtils.listFiles(new File(srcDirPath), new String[]{"java"}, true);

        for (File javaGbkFile : javaGbkFileCol) {
            //UTF8格式文件路径
            String utf8FilePath = utf8DirPath+javaGbkFile.getAbsolutePath().substring(srcDirPath.length());
            //使用GBK读取数据，然后用UTF-8写入数据
            FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));
        }
    }
}
