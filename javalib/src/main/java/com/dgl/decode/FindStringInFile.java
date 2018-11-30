package com.dgl.decode;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by dugaolong on 18/8/17.
 * 查找文件夹下所有的文件中，是否有指定的内容
 */

public class FindStringInFile {

    public static void main(String[] args) {
        //指定文件名及路径
        File oldFile = new File("/Users/dugaolong/otherProject/decode/");
        //要修改的文件的内容
        func(oldFile,"com/when/wannianli");
        System.out.println("执行结束");
    }
    private static void func(File file,String oldstr) {
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f,oldstr);
            if (f.isFile()) {
                findFileContent(f,oldstr);
            }
        }
    }


    private static void findFileContent(File file2, String oldstr) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file2, "rw");
            String line = null;
            while ((line = raf.readLine()) != null) {
                if (line.contains(oldstr)) {
                    System.out.println(file2.getName()+" 中还包含有："+oldstr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
