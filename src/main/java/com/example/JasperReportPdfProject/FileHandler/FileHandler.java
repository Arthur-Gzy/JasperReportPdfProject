package com.example.JasperReportPdfProject.FileHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	
	private String filePath = null;
	private String fileName;
	
	public FileHandler() {}
	
	public FileHandler(String filePath, String fileName) {
		super();
		this.filePath = filePath;
		this.fileName = fileName;
	}
	
	public FileHandler(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void findFileInProject(String fileName, File file) {
		String[] extensions = {"jrxml", "pdf"};
		
		String fileEx = getFileExtension(fileName);
		String targetDir = null;
		
		for(String ex: extensions) {
			if(fileEx.equalsIgnoreCase(ex)) {
				if(fileEx.equalsIgnoreCase("jrxml")) {
					//targetDir = "/jrxml";
					targetDir = "\\src\\main\\resources\\reports";
				}
				else if(fileEx.equalsIgnoreCase("pdf")) {
					//targetDir = "/pdfreports";
					targetDir = "\\src\\main\\resources\\compiledPdfReports";
				}
			}
		}
		
		if(targetDir != null && file.toString() == System.getProperty("user.dir")) {
			file = new File(file.toString() + targetDir);
			System.out.println("New filename:"+file);
			System.out.println(System.getProperty("user.dir"));
		}
		
		File[] list = file.listFiles();
		
		if (list != null) {
			for(File fil: list) {
				if(fileName.equalsIgnoreCase(fil.getName())) {
					setFilePath(fil.getPath());
					setFileName(fil.getName());
					System.out.println(fil.getPath());
				}
				else if(fil.isDirectory()) {
					 findFileInProject(fileName, fil);
				}
			}
		}
	}
	
	public boolean doesFileExist() {
		Path path = Paths.get(filePath);
		return Files.exists(path) && !Files.isDirectory(path);
	}
	
	public void findFileInProject(String fileName) {
		File file = new File(System.getProperty("user.dir"));
		findFileInProject(fileName, file);
	}
	
	public String getFileExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		String extension = fileName.substring(index+1);
		return extension;
	}
}

