package org.arun.readme;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    String name;
    List<TreeNode> children;

    TreeNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    void addChild(TreeNode child) {
        this.children.add(child);
    }
}
