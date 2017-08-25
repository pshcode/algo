package pshcode.algorithm.btree;

import java.util.Stack;

import lombok.Setter;

/**
 * 균형 검색 트리.
 *
 * @author SungHoon, Park
 */
public class Btree {
	public static final int M_WAY_SIZE = 5;

	@Setter
	private Node rootNode;

	public NodeData search(int key) {
		NodeData nodeData = null;
		Node currentNode = rootNode;
		int index;

		while (currentNode != null) {
			for (index = 0; index < currentNode.getStoredCount(); index++) {
				NodeData currentNodeData = currentNode.getDataArray()[index];
				int currentKey = currentNodeData.getKey();

				if (key == currentKey) {
					return currentNodeData;
				}

				if (key < currentKey) {
					break;
				}
			}

			currentNode = currentNode.getChildrenArray()[index];
		}

		return nodeData;
	}

	public boolean add(NodeData nodeData) {
		Stack<Node> nodeStack = new Stack<Node>();

		Node currentNode = rootNode;
		Node parentNode = null;
		int index;

		while (currentNode != null) {
			nodeStack.add(currentNode);
			parentNode = currentNode;

			for (index = 0; index < currentNode.getStoredCount(); index++) {
				NodeData currentNodeData = currentNode.getDataArray()[index];
				int currentKey = currentNodeData.getKey();

				if (nodeData.getKey() == currentKey) {
					nodeStack.pop();
					return false;
				}

				if (nodeData.getKey() < currentKey) {
					break;
				}
			}

			currentNode = currentNode.getChildrenArray()[index];
		}

		if (parentNode == null) {
			rootNode = createNode(nodeData);
		} else {
			//TODO 여기부터 다시 시작
		}

		return true;
	}

	private Node createNode(NodeData nodeData) {
		Node node = new Node();
		node.getDataArray()[0] = nodeData;
		node.increateStoredCount();

		return node;
	}
}
