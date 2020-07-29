package com.sdstc.word.pub;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.IOUtils;

/**
 * 
 * @author cheng
 *
 */
public class ZipUtil {
	
	/**
	 * 替换文件
	 * @param files
	 * @param zipFile   原压缩文件
	 * @param outZipFile 新压缩文件
	 */
	public void replaceZipFile(Map<String, File> files, File zipFile,File outZipFile) {
		try {
			ZipArchiveInputStream is = new ZipArchiveInputStream(new FileInputStream(zipFile));
			ZipArchiveOutputStream os = new ZipArchiveOutputStream(outZipFile);

			ZipArchiveEntry entry = null;
			//替换原文件
			while ((entry = (ZipArchiveEntry) is.getNextEntry()) != null) {
				if (files.containsKey(entry.getName())) {
					File tempFile = files.get(entry.getName());
					ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(tempFile, entry.getName());
					os.putArchiveEntry(zipArchiveEntry);
					IOUtils.copy(new FileInputStream(tempFile), os);
					files.remove(entry.getName());
				} else {
					os.putArchiveEntry(entry);
					if (!entry.isDirectory()) {
						IOUtils.copy(is, os);
					}
				}
			}
			//追加文件
			for (String key : files.keySet()) {
				File tempFile = files.get(key);
				ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(tempFile, key);
				os.putArchiveEntry(zipArchiveEntry);
				IOUtils.copy(new FileInputStream(tempFile), os);
			}

			os.closeArchiveEntry();
			is.close();
			os.flush();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
