package com.sdstc.zip;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ZipTest {
	public static void main(String[] args) {
		try {
			String content = FileUtils.readFileToString(new File("e://document1.xml"), Charset.defaultCharset());
			String content2 = content.replace("\t", "").replace("\r", "").replace("\n", "");
			
			File tempFile=File.createTempFile("document", "xml");
			FileUtils.writeStringToFile(tempFile, content2, Charset.defaultCharset());

			ZipArchiveInputStream is = new ZipArchiveInputStream(new FileInputStream(new File("e://report.docx")));
			ZipArchiveOutputStream os = new ZipArchiveOutputStream(new File("e://report2.docx"));

			ZipArchiveEntry entry = null;
			while ((entry = (ZipArchiveEntry) is.getNextEntry()) != null) {
				if (entry.getName().equals("word/document.xml")) {
					ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(tempFile, "word/document.xml");
					os.putArchiveEntry(zipArchiveEntry);
					IOUtils.copy(new FileInputStream(tempFile), os);
				} else {
					os.putArchiveEntry(entry);
					if (!entry.isDirectory()) {
						IOUtils.copy(is, os);
					}
				}
			}
			tempFile.delete();
			os.closeArchiveEntry();
			is.close();
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void unzip(String zipFile, String destDir) {
		try {
			InputStream stream = new FileInputStream(zipFile);
			ZipArchiveInputStream inputStream = new ZipArchiveInputStream(stream);
			ZipArchiveEntry entry = null;
			while ((entry = inputStream.getNextZipEntry()) != null) {
				System.out.println(entry.getName());
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				// 读取内容
				IOUtils.copy(inputStream, outputStream);
				System.out.println(outputStream.toString());
			}
			inputStream.close();
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
