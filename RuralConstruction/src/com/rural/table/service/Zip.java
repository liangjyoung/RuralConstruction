package com.rural.table.service;


import java.io.*;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;




/**
 * 程序实现了ZIP压缩。共分为2部分 ： 压缩（compression）与解压（decompression）
 * <p>
 * 大致功能包括用了多态，递归等JAVA核心技术，可以对单个文件和任意级联文件夹进行压缩和解压。 需在代码中自定义源输入路径和目标输出路径。
 * <p>
 * 在本段代码中，实现的是压缩部分；解压部分见本包中Decompression部分。
 * 
 * @author HAN
 * 
 */

public class Zip
{
  static final int BUFFER = 8192;

  public Zip()
  {

  }

  private static void compress(File file, ZipOutputStream out, String basedir)
  {
    /* 判断是目录还是文件 */
    if (file.isDirectory())
    {
      // System.out.println("压缩：" + basedir + file.getName());
      compressDirectory(file, out, basedir);
    }
    else
    {
      // System.out.println("压缩：" + basedir + file.getName());
      compressFile(file, out, basedir);
    }
  }

  /** 压缩一个目录 */
  private static void compressDirectory(File dir, ZipOutputStream out, String basedir)
  {
    if (!dir.exists()) return;

    File[] files = dir.listFiles();
    for (int i = 0; i < files.length; i++)
    {
      /* 递归 */
      compress(files[i], out, basedir + dir.getName() + "/");
    }
  }

  /** 压缩一个文件 */
  private static void compressFile(File file, ZipOutputStream out, String basedir)
  {
    if (!file.exists())
    {
      return;
    }
    try
    {
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
      ZipEntry entry = new ZipEntry(basedir + file.getName());
      out.putNextEntry(entry);
      int count;
      byte data[] = new byte[BUFFER];
      while ((count = bis.read(data, 0, BUFFER)) != -1)
      {
        out.write(data, 0, count);
      }
      bis.close();
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }

  public void zip(String srcPathName, String zipFileName)
  {
    File file = new File(srcPathName);
    File zipFile = new File(zipFileName);
    if (!file.exists()) throw new RuntimeException(srcPathName + "不存在！");
    try
    {
      FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
      CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream, new CRC32());
      ZipOutputStream out = new ZipOutputStream(cos);
      out.setEncoding(System.getProperty("sun.jnu.encoding"));//设置文件名编码方式
      String basedir = "";
      compress(file, out, basedir);
      out.close();
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
    System.out.println("压缩完成");
  }

//  public static void main(String[] args)
//  {
//    Zip.zip("D:\\applicationtables", "D:\\ZipTestCompressing.zip");
//   // book.zip("D:\\ZipTestCompressing.zip",new File("D:\\applicationtables"));
//  }
}

