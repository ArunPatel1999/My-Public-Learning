package org.arun.readme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TreeOpration {

	private Map<String, TreeNode> nodeMap = new HashMap<>();
	
	public void addNode(String parentName, String childName) {
		TreeNode parentNode = nodeMap.computeIfAbsent(parentName, TreeNode::new);
		TreeNode childNode = nodeMap.computeIfAbsent(childName, TreeNode::new);
		parentNode.addChild(childNode);
	}

	public List<Map.Entry<String, Set<String>>> bottomToTopTraversal() {
		if (nodeMap.isEmpty())
			return Collections.emptyList();

		Queue<TreeNode> queue = new LinkedList<>();
		Map<String, Set<String>> result = new LinkedHashMap<>();
		
		queue.add(nodeMap.get(GenerateReadmeMd.ROOT_DIR));

		while (!queue.isEmpty()) {
			int levelSize = queue.size();

			for (int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				Set<String> childrenNames = new LinkedHashSet<>();

				for (TreeNode child : currentNode.children) {
					childrenNames.add(child.name);
					queue.add(child);
				}

				result.put(currentNode.name, childrenNames);
			}
		}
		List<Map.Entry<String, Set<String>>> reversed = new ArrayList<>(result.entrySet());
		Collections.reverse(reversed);

		return new LinkedList<>(reversed);
	}

}
