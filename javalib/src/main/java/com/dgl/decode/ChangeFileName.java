package com.dgl.decode;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by dugaolong on 18/8/17.
 * 修改文件夹名字
 */

public class ChangeFileName {

    public static void main(String[] args) {
        //指定文件名及路径
        File oldFile = new File("/Users/dugaolong/otherProject/decode/smali/com/jmm/www/calendar");
        //要修改的文件的内容
        func(oldFile,"com/when/wannianli","com/jmm/www/calendar");
    }

    private static void func(File file,String oldstr, String newStr) {
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f,oldstr,newStr);
            if (f.isFile()) {
                //若是文件，修改内容
                String fileName = f.getName();
                // 获取文件后缀名并转化为写，用于后续比较
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
                if (fileType.equals("smali")) {
                    System.out.println(f);
                    if(modifyFileContent(f,oldstr,newStr)){
                        System.out.println("修改文件内容成功");
                    }else {
                        System.out.println("失败了");
                    }
                }
            }
        }
    }


    private static boolean modifyFileContent(File file2, String oldstr, String newStr) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file2, "rw");
            String line = null;
            long lastPoint = 0; //记住上一次的偏移量
            while ((line = raf.readLine()) != null) {
                final long ponit = raf.getFilePointer();
                if (line.contains(oldstr)) {
                    String str = line.replace(oldstr, newStr);
                    raf.seek(lastPoint);
                    raf.writeBytes(str);
                }
                lastPoint = ponit;
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
        return true;
    }

    private static void changeName(File oldFile) {
        if (!oldFile.exists()) {
            try {
                oldFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("修改前文件名称是：" + oldFile.getName());
        String rootPath = oldFile.getParent();
        System.out.println("根路径是：" + rootPath);
        File newFile = new File(rootPath + File.separator + "bbbb");
        System.out.println("修改后文件名称是：" + newFile.getName());
        if (oldFile.renameTo(newFile)) {
            System.out.println("修改成功!");
        } else {
            System.out.println("修改失败");
        }
    }


}
