package com.zsy.basemodule.base.utils

import android.text.TextUtils
import java.io.File

/**
 * File option utils
 */
object FileUtil {
    /**
     * 创建文件夹
     *
     * @param dir
     */
    fun makeDir(dir: File): Boolean {
        return if (dir.isDirectory && dir.exists()) {
            true
        } else dir.mkdir()
    }

    /**
     * 删除文件
     */
    fun deleteFile(path: String?): Boolean {
        val status: Boolean
        status = if (!TextUtils.isEmpty(path)) {
            val checker = SecurityManager()
            val file = File(path)
            checker.checkDelete(file.toString())
            if (file.exists() && file.isFile) {
                try {
                    file.delete()
                    true
                } catch (se: SecurityException) {
                    se.printStackTrace()
                    false
                }
            } else false
        } else false
        return status
    }

    fun deleteFile(file: File?): Boolean {
        if (file == null) return false
        val path = file.absolutePath
        return deleteFile(path)
    }

    /**
     * 递归删除文件和文件夹
     *
     * @param file 要删除的根目录
     */
    fun deleteAll(file: File) {
        if (file.exists()) {
            if (file.isFile) {
                file.delete()
                return
            }
            if (file.isDirectory) {
                val childFile = file.listFiles()
                if (childFile == null || childFile.size == 0) {
                    file.delete()
                    return
                }
                for (f in childFile) {
                    deleteDirFiles(f)
                }
                file.delete()
            }
        }
    }

    /**
     * 递归删除文件夹下的所有文件（不包含文件夹）
     *
     * @param file 要删除的根目录
     */
    fun deleteDirFiles(file: File) {
        if (file.exists()) {
            if (file.isFile) {
                file.delete()
            } else if (file.isDirectory) {
                //是文件夹，拿到他下面的所有文件
                val childFile = file.listFiles()
                if (childFile != null && childFile.size > 0) {
                    for (f in childFile) {
                        deleteDirFiles(f)
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
    fun createFile(folderPath: String?, fileName: String?): File {
        val destDir = File(folderPath)
        if (!destDir.exists()) {
            //创建文件夹
            destDir.mkdirs()
        }
        return File(folderPath, fileName)
    }

    /**
     * 计算一个文件及下面所有文件的大小总和
     *
     * @param file
     * @return
     * @throws Exception
     */
    @Throws(Exception::class)
    fun calculateFileSize(file: File): Long {
        var size: Long = 0
        try {
            val fileList = file.listFiles()
            for (aFileList in fileList) {
                // 如果下面还有文件
                size = if (aFileList.isDirectory) {
                    size + calculateFileSize(aFileList)
                } else {
                    size + aFileList.length()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return size
    }
}