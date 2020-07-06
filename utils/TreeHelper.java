package utils;

public class TreeHelper {

    /**
     * [5,4,8,11,null,13,4,7,2,null,null,null,1]
     * 
     * @return
     */
    public static TreeNode stringToTree(String treeStr) {
        String[] treeNodeVal = treeStr.substring(1, treeStr.length() - 1).split(",");
        TreeNode[] treeNodes = new TreeNode[treeNodeVal.length];
        for (int i = 0; i < treeNodeVal.length; i++) {
            if (treeNodeVal[i].equals("null")) {
                treeNodes[i] = null;
            }
            else {
                treeNodes[i] = new TreeNode(Integer.parseInt(treeNodeVal[i]));
            }
        }

        TreeNode root = treeNodes[0];
        for (int i = 0; i < treeNodes.length; i++) {
            if (treeNodes[i] == null) {
                continue;
            }
            if (2 * i + 1 < treeNodes.length && treeNodes[2 * i + 1] != null) {
                treeNodes[i].left = treeNodes[2 * i + 1];
            }
            if (2 * i + 2 < treeNodes.length && treeNodes[2 * i + 2] != null) {
                treeNodes[i].right = treeNodes[2 * i + 2];
            }
        }
        return root;
    }
}
