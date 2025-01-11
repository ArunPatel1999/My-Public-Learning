package org.arun.readme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DeleteAndLoadReadMe {

	public static void processDeleteAndLoad(String projectFolder) throws IOException {
		File rootDirectory = new File(projectFolder);
		if (rootDirectory.isDirectory()) {
			readAllGenerateReadmeMdUrlFromFile(projectFolder, rootDirectory);
		} else {
			System.err.println("Invalid root directory: " + projectFolder);
			System.exit(0);
		}
	}

	private static void readAllGenerateReadmeMdUrlFromFile(String projectFolder, File rootDirectory) throws IOException {
		Pattern pattern = Pattern.compile(GenerateReadmeMd.ALL_READMES_FILE_URL_REGEX);
		Set<String> keepFiles  = new TreeSet<>();
		List<String> lines = Files.readAllLines(Paths.get(projectFolder + GenerateReadmeMd.ALL_READMES_MD));
		for (String line : lines) {
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				String finalUrl = matcher.group(1);
				keepFiles.add(finalUrl.replace("%20", " "));
			}
		}
		if (!keepFiles.isEmpty()) {
			deleteUnwantedReadmes(projectFolder, rootDirectory, keepFiles);
		} else {
			System.err.println("No Child ReadMe Found");
			System.exit(0);
		}
	}

	private static void deleteUnwantedReadmes(String projectFolder, File directory, Set<String> keepFiles) throws IOException {
		File[] files = directory.listFiles();
		if (files == null)
			return;

		String newRoot = projectFolder.replace("/", "\\") + "\\";
		for (File file : files) {
			if (file.isDirectory()) {
				deleteUnwantedReadmes(projectFolder, file, keepFiles);
			} else if (file.isFile() && file.getName().equalsIgnoreCase(GenerateReadmeMd.README_MD)) {
				String canonicalPath = file.getAbsolutePath().replace(newRoot, "");
				if (!keepFiles.contains(canonicalPath.replace("\\", "/"))) {
					file.delete();
//					System.out.println(canonicalPath+" ==> "+ file.delete());
				} else {
					loadDataInMap(projectFolder, file);
				}
			}
		}
	}
	
	private static void loadDataInMap(String projectFolder, File file) throws IOException {
		String currentParent = getParentFileName(file);
		GenerateReadmeMd.PROJECT_NAME_WITH_CONTENT.put(currentParent, 
				Files.readAllLines(file.toPath()).stream().map(line -> "\t" + line).collect(Collectors.joining(System.lineSeparator())));
		createParentAndChildRelation(projectFolder, file.getParentFile(), currentParent);
	}
	
	private static void createParentAndChildRelation(String projectFolder, File file, String child) {
		String currentParent = getParentFileName(file);
		TreeOpration.addNode(currentParent, child);

		if(!projectFolder.contains(currentParent)) {
			createParentAndChildRelation(projectFolder, file.getParentFile(), currentParent);
		}
	}
	
	private static String getParentFileName(File file) {
		return file.getParent().replace("\\", "/");
	}
	
}
