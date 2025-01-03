package org.arun.readme;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class GenerateReadmeMd {

	public static final String ROOT_DIR = "C:/ARUN/Github Chnages/My-Public-Repository";
	public static final String README_MD = "README.md";
	public static final String ALL_READMES_MD = "/readmes.md";
	public static final String ALL_READMES_FILE_URL_REGEX = "\\(([^)]+)\\)";
	public static final Map<String, String> PROJECT_NAME_WITH_CONTENT = new LinkedHashMap<>();

	public static void main(String[] args) throws IOException {
		DeleteAndLoadReadMe.processDeleteAndLoad();
		CreateReadmeMd.createNewReadmeMd();
		System.out.println("DONEEEEEE");
	}
	
}
