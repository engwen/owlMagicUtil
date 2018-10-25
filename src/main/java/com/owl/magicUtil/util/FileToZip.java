package com.owl.magicUtil.util;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 将文件夹下面的文件
 * 打包成zip压缩文件
 * 这个方法里面的文件夹不能为空
 * @author admin
 */
public abstract class FileToZip {
    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     * @param sourceFilePath :待压缩的文件路径
     * @param zipFilePath    :压缩后存放路径
     * @param fileName       :压缩后文件的名称
     * @return boolean
     */
    public static boolean fileToZip(String sourceFilePath, String zipFilePath, String fileName) {
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if (sourceFile.exists() == false) {
            System.out.println("待压缩的文件目录：" + sourceFilePath + "不存在.");
        } else {
            try {
                File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
                if (zipFile.exists()) {
                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
                } else {
                    File[] sourceFiles = sourceFile.listFiles();
                    if (null == sourceFiles || sourceFiles.length < 1) {
                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                    } else {
                        fos = new FileOutputStream(zipFile);
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
                        byte[] bufs = new byte[1024 * 10];
                        for (int i = 0; i < sourceFiles.length; i++) {
                            //创建ZIP实体，并添加进压缩包  
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);
                            //读取待压缩的文件并写进压缩包里  
                            fis = new FileInputStream(sourceFiles[i]);
                            bis = new BufferedInputStream(fis, 1024 * 10);
                            int read = 0;
                            while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                                zos.write(bufs, 0, read);
                            }
                        }
                        flag = true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                //关闭流  
                try {
                    if (null != bis) bis.close();
                    if (null != zos) zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String sourceFilePath = "H:\\Course\\2015_11_12\\123123张  红＜中国近现代史＞";
        String zipFilePath = "H:\\Course\\2015_11_12\\123123张  红＜中国近现代史＞";
        String fileName = "＜中国近现代史＞.zip";
        boolean flag = FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName);
        if (flag) {
            System.out.println("文件打包成功!");
        } else {
            System.out.println("文件打包失败!");
        }
    }

    /**
     * 传入list的文件路径，打包到指定的新生成ZIP文件中，如果已存在的Zip，将会被覆盖
     * <p>
     * 特注：zos一定放在循环外结束，不然我打不死你
     * @param zipFilename 名稱
     * @param path 路徑
     * @return boolean
     * @throws Exception
     */
    public static boolean createFileToZip(String zipFilename, List<String> path) throws Exception {
        //压缩文件名
        File objFile = new File(zipFilename);
        ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(objFile), 1024));
        InputStream is;//每写完一个文件关闭一下
        ZipEntry ze = null;
        for (int i = 0; i < path.size(); i++) {
            if (null != path.get(i)) {
                continue;
            }
            File sourceFile = new File(path.get(i));
            if (!sourceFile.exists()) {
                continue;
            }
            byte[] buf = new byte[1024];
            //创建一个ZipEntry，并设置Name和最后时间
            ze = new ZipEntry(sourceFile.getName());
            ze.setSize(sourceFile.length());
            ze.setTime(sourceFile.lastModified());
            //将ZipEntry加到zos中
            zos.putNextEntry(ze);
            is = new BufferedInputStream(new FileInputStream(sourceFile));
            int readLen = -1;
            while ((readLen = is.read(buf, 0, 1024)) != -1) {
                zos.write(buf, 0, readLen);
            }
            is.close();
        }
        zos.close();
        return true;
    }

}  