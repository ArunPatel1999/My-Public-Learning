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

	public static void processDeleteAndLoad() throws IOException {
		File rootDirectory = new File(GenerateReadmeMd.ROOT_DIR);
		if (rootDirectory.isDirectory()) {
			readAllGenerateReadmeMdUrlFromFile(rootDirectory);
		} else {
			System.err.println("Invalid root directory: " + GenerateReadmeMd.ROOT_DIR);
			System.exit(0);
		}
	}

	private static void readAllGenerateReadmeMdUrlFromFile(File rootDirectory) throws IOException {
		Pattern pattern = Pattern.compile(GenerateReadmeMd.ALL_READMES_FILE_URL_REGEX);
		Set<String> keepFiles  = new TreeSet<>();
		List<String> lines = Files.readAllLines(Paths.get(GenerateReadmeMd.ROOT_DIR + GenerateReadmeMd.ALL_READMES_MD));
		for (String line : lines) {
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				String finalUrl = matcher.group(1);
				keepFiles.add(finalUrl.replace("%20", " "));
			}
		}
		if (!keepFiles.isEmpty()) {
			deleteUnwantedReadmes(rootDirectory, keepFiles);
		} else {
			System.err.println("No Child ReadMe Found");
			System.exit(0);
		}
	}

	private static void deleteUnwantedReadmes(File directory, Set<String> keepFiles) throws IOException {
		File[] files = directory.listFiles();
		if (files == null)
			return;

		String newRoot = GenerateReadmeMd.ROOT_DIR.replace("/", "\\") + "\\";
		for (File file : files) {
			if (file.isDirectory()) {
				deleteUnwantedReadmes(file, keepFiles);
			} else if (file.isFile() && file.getName().equalsIgnoreCase(GenerateReadmeMd.README_MD)) {
				String canonicalPath = file.getAbsolutePath().replace(newRoot, "");
				if (!keepFiles.contains(canonicalPath.replace("\\", "/"))) {
					file.delete();
//					System.out.println(canonicalPath+" ==> "+ file.delete());
				} else {
					loadDataInMap(file);
				}
			}
		}
	}
	
	private static void loadDataInMap(File file) throws IOException {
		String currentParent = getParentFileName(file);
		GenerateReadmeMd.PROJECT_NAME_WITH_CONTENT.put(currentParent, 
				Files.readAllLines(file.toPath()).stream().map(line -> "\t" + line).collect(Collectors.joining(System.lineSeparator())));
		createParentAndChildRelation(file.getParentFile(), currentParent);
	}
	
	private static void createParentAndChildRelation(File file, String child) {
		String currentParent = getParentFileName(file);
		TreeOpration.addNode(currentParent, child);

		if(!GenerateReadmeMd.ROOT_DIR.contains(currentParent)) {
			createParentAndChildRelation(file.getParentFile(), currentParent);
		}
	}
	
	private static String getParentFileName(File file) {
		return file.getParent().replace("\\", "/");
	}
	
}
