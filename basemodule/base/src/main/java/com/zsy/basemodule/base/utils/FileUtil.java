package com.zsy.basemodule.base.utils;

import android.text.TextUtils;

import java.io.File;

/**
 * File option utils
 */
public class FileUtil {

    /**
     * 创建文件夹
     *
     * @param dir
     */
    public static boolean makeDir(File dir) {
        if (dir.isDirectory() && dir.exists()) {
            return true;
        }
        return dir.mkdir();
    }

    /**
     * 删除文件
     */
    public static boolean deleteFile(String path) {
        boolean status;
        if (!TextUtils.isEmpty(path)) {
            SecurityManager checker = new SecurityManager();
            File file = new File(path);
            checker.checkDelete(file.toString());
            if (file.exists() && file.isFile()) {
                try {
                    file.delete();
                    status = true;
                } catch (SecurityException se) {
                    se.printStackTrace();
                    status = false;
                }
            } else
                status = false;
        } else
            status = false;
        return status;
    }

    public static boolean deleteFile(File file) {
        if (file == null) return false;
        String path = file.getAbsolutePath();
        return deleteFile(path);
    }

    /**
     * 递归删除文件和文件夹
     *
     * @param file 要删除的根目录
     */
    public static void deleteAll(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            if (file.isDirectory()) {
                File[] childFile = file.listFiles();
                if (childFile == null || childFile.length == 0) {
                    file.delete();
                    return;
                }
                for (File f : childFile) {
                    deleteDirFiles(f);
                }
                file.delete();
            }
        }
    }

    /**
     * 递归删除文件夹下的所有文件（不包含文件夹）
     *
     * @param file 要删除的根目录
     */
    public static void deleteDirFiles(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                //是文件夹，拿到他下面的所有文件
                File[] childFile = file.listFiles();
                if (childFile != null && childFile.length > 0) {
                    for (File f : childFile) {
                        deleteDirFiles(f);
                    }
                }
            }
        }
    }

    /**
     * 创建文件
     *
     * @param folderPath
     * @param fileName
     * @return
     */
    public static File createFile(String folderPath, String fileName) {
        File destDir = new File(folderPath);
        if (!destDir.exists()) {
            //创建文件夹
            destDir.mkdirs();
        }
        return new File(folderPath, fileName);
    }

    /**
     * 计算一个文件及下面所有文件的大小总和
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static long calculateFileSize(File file) throws Exception {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (File aFileList : fileList) {
                // 如果下面还有文件
                if (aFileList.isDirectory()) {
                    size = size + calculateFileSize(aFileList);
                } else {
                    size = size + aFileList.length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

}