package org.arun.readme;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CreateReadmeMd {

	public static void createNewReadmeMd() {
		var parentChilds = TreeOpration.bottomToTopTraversal();
		while (!parentChilds.isEmpty()) {
			var data = parentChilds.removeFirst();
			if(!data.getValue().isEmpty()) {
				readDataFromChildAndCreateReadMeInParent(data.getKey(), data.getValue());
			}
		}
	}
	
	private static void readDataFromChildAndCreateReadMeInParent(String parent, Set<String> childs) {
		String data =  getReadmeMdContant(parent, new ArrayList<>(childs));
		createReadmeFile(parent, data);
		addNewData(parent, data);
	}
	
	private static void addNewData(String parent, String data) {
		data = data.replace("\n", "\n\t");
		data = "\t".concat(data);
		GenerateReadmeMd.PROJECT_NAME_WITH_CONTENT.put(parent, data);
	}
	
	private static String getReadmeMdContant(String parentFolderName, List<String> childs) {
		String parentName = getFolderName(parentFolderName);
		return "# "+parentName+"\nWelcome to the "+parentName+" folder. Below are the available projects:\n# Projects\n"+getChildData(parentFolderName, childs);
	}

	private static String getChildData(String parentUrl, List<String> childs) {
		String childData = ""; 
		for(String child : childs) {
			String newUrl = getReplaceUrlForReadme(parentUrl, child);
			childData += "\n- ["+getFolderName(child)+"]("+newUrl+")\n\t<details>\n\t<summary>Details</summary>\n\n"+replaceChiildContantUrl(newUrl, child)+" \n\t</details>\n";
		}
  		return childData;
	}
	
	private static String replaceChiildContantUrl(String addOnUrl, String child) {
		return GenerateReadmeMd.PROJECT_NAME_WITH_CONTENT.get(child).replace("](", "]("+addOnUrl);
	}
	
	private static String getReplaceUrlForReadme(String parentUrl, String data) {
		return data.replace(parentUrl+"/", "").replace(" ", "%20")+"/"; 
	}
	
	private static String getFolderName(String data) {
		return data.substring(data.lastIndexOf("/")+1);
	}
	
	private static void createReadmeFile(String location, String data) {
		try {
			File file = new File(location + "/" + GenerateReadmeMd.README_MD);
			if (!file.exists()) {
				file.createNewFile();
			}
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				writer.write(data);
				writer.newLine();
			}
//			System.out.println("Text has been successfully written to " + location);
		} catch (IOException e) {
			System.err.println("An error occurred while creating or writing to the file.");
			e.printStackTrace();
		}
	}
	
}
