package org.arun.readme;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GenerateReadmeMd {

	public static final List<String> ROOT_DIRS = List.of("C:/ARUN/Github Chnages/My-Public-Learning", "C:/ARUN/Github Chnages/My-Public-Projects");
	public static final String README_MD = "README.md";
	public static final String ALL_READMES_MD = "/readmes.md";
	public static final String ALL_READMES_FILE_URL_REGEX = "\\(([^)]+)\\)";
	public static final Map<String, String> PROJECT_NAME_WITH_CONTENT = new LinkedHashMap<>();

	public static void main(String[] args) throws IOException {
		for(String projectFolder: ROOT_DIRS) {
			DeleteAndLoadReadMe.processDeleteAndLoad(projectFolder);
			CreateReadmeMd.createNewReadmeMd(projectFolder);
		}
		System.out.println("DONEEEEEE");
	}
	
}
