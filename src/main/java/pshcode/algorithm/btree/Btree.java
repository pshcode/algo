package pshcode.algorithm.btree;

import java.util.EmptyStackException;
import java.util.Stack;

import lombok.Setter;

/**
 * 균형 검색 트리.
 *
 * @author SungHoon, Park
 */
public class Btree {
	public static final int BTREE_ORDER = 5;

	@Setter
	private Node rootNode;

	public NodeData search(int key) {
		NodeData nodeData = null;
		Node currentNode = rootNode;
		int index;

		while (currentNode != null) {
			for (index = 0; index < currentNode.getStoredCount(); index++) {
				NodeData currentNodeData = currentNode.dataArray[index];
				int currentKey = currentNodeData.getKey();

				if (key == currentKey) {
					return currentNodeData;
				}

				if (key < currentKey) {
					break;
				}
			}

			currentNode = currentNode.childrenArray[index];
		}

		return nodeData;
	}

	public boolean add(NodeData nodeData) {
		Stack<Node> nodeStack = new Stack<Node>();

		Node currentNode = rootNode;
		Node parentNode = null;
		int index;

		while (currentNode != null) {
			nodeStack.push(currentNode);
			parentNode = currentNode;

			for (index = 0; index < currentNode.getStoredCount(); index++) {
				NodeData currentNodeData = currentNode.dataArray[index];
				int currentKey = currentNodeData.getKey();

				if (nodeData.getKey() == currentKey) {
					System.out.println("중복된 키: key=" + nodeData.getKey());
					nodeStack.pop();
					return false;
				}

				if (nodeData.getKey() < currentKey) {
					break;
				}
			}

			currentNode = currentNode.childrenArray[index];
		}

		if (parentNode == null) {
			rootNode = new Node(nodeData);
		} else {
			parentNode.addNodeData(nodeData, null);
			splitNode(nodeStack);
		}

		return true;
	}

	private void splitNode(Stack<Node> nodeStack) {

		if (nodeStack == null) {
			return;
		}

		int pivotIndex = BTREE_ORDER / 2;
		int index;

		Node parentNode = null;
		Node currentNode = nodeStack.pop();

		while (currentNode != null) {
			if (currentNode.getStoredCount() >= BTREE_ORDER) {
				Node newNode = new Node();

				NodeData pivotNodeData = currentNode.dataArray[pivotIndex];
				currentNode.dataArray[pivotIndex] = null;

				for (index = pivotIndex + 1; index < BTREE_ORDER; index++) {
					int newIndex = index - pivotIndex - 1;

					newNode.dataArray[newIndex] = currentNode.dataArray[index];
					newNode.childrenArray[newIndex] = currentNode.childrenArray[index];

					currentNode.dataArray[index] = null;
					currentNode.childrenArray[index] = null;
				}

				newNode.childrenArray[index - pivotIndex - 1] = currentNode.childrenArray[index];
				newNode.setStoredCount(BTREE_ORDER - pivotIndex - 1);

				currentNode.childrenArray[index] = null;
				currentNode.setStoredCount(pivotIndex);

				try {
					parentNode = nodeStack.pop();
				} catch (EmptyStackException e) {
					parentNode = null;
				}

				if (parentNode != null) {
					parentNode.addNodeData(pivotNodeData, newNode);
				} else {
					rootNode = new Node(pivotNodeData);
					rootNode.childrenArray[0] = currentNode;
					rootNode.childrenArray[1] = newNode;
				}
			}

			currentNode = parentNode;
			parentNode = null;
		}
	}

	public void remove(int key) {
		Stack<Node> nodeStack = new Stack<Node>();

		Node currentNode = rootNode;
		Node parentNode = null;
		int index = 0;
		boolean isFind = false;

		while (currentNode != null && !isFind) {
			parentNode = currentNode;
			nodeStack.push(parentNode);

			for (index = 0; index < currentNode.getStoredCount(); index++) {
				NodeData currentNodeData = currentNode.dataArray[index];
				int currentKey = currentNodeData.getKey();

				if (key == currentKey) {
					isFind = true;
					break;
				}

				if (key < currentKey) {
					break;
				}
			}

			currentNode = currentNode.childrenArray[index];
		}

		if (isFind) {
			if (isLeafNode(parentNode)) {
				deleteNodeData(parentNode, index);
			} else {
				parentNode = replaceLeafNode(parentNode, index, nodeStack);
			}

			if (parentNode.getStoredCount() < (BTREE_ORDER / 2)) {
				balanceBtree(nodeStack);
			}
		} else {
			System.out.println("삭제대상이 존재하지 않습니다: key=" + key);
		}
	}

	private void balanceBtree(Stack<Node> nodeStack) {
		Node currentNode = nodeStack.pop();

		if (currentNode.getStoredCount() >= (BTREE_ORDER / 2)) {
			return;
		}

		Node parentNode = nodeStack.pop();
		int index = getIndexInfo(parentNode, currentNode);

		if (index < parentNode.getStoredCount() && parentNode.childrenArray[index + 1].getStoredCount() >= (BTREE_ORDER / 2 + 1)) {    //오른쪽에서 빌려옴
			borrowFromRight(parentNode, currentNode, index, parentNode.childrenArray[index + 1]);
		} else if (index > 0 && parentNode.childrenArray[index - 1].getStoredCount() >= (BTREE_ORDER / 2 + 1)) {   //왼쪽에서 빌려옴
			borrowFromLeft(parentNode, currentNode, index, parentNode.childrenArray[index - 1]);
		} else {
			mergeNode(parentNode, currentNode, index, nodeStack);
		}
	}

	private void mergeNode(Node parentNode, Node currentNode, int index, Stack<Node> nodeStack) {
		if (parentNode == null || currentNode == null) {
			return;
		}

		Node leftNode;
		Node rightNode;
		NodeData parentElement;
		int pivotIndex = 0;

		if (index < parentNode.getStoredCount()) { //오른쪽 노드와 병합
			leftNode = currentNode;
			rightNode = parentNode.childrenArray[index + 1];
			pivotIndex = index;
			parentElement = parentNode.dataArray[pivotIndex];
		} else { //왼쪽 노드와 병합
			leftNode = parentNode.childrenArray[index - 1];
			rightNode = currentNode;
			pivotIndex = index - 1;
			parentElement = parentNode.dataArray[pivotIndex];
		}

		leftNode.addNodeData(parentElement, rightNode.childrenArray[0]);

		for (int i = 0; i < rightNode.getStoredCount(); i++) {
			leftNode.addNodeData(rightNode.dataArray[i], rightNode.childrenArray[i + 1]);
		}

		deleteNodeData(parentNode, pivotIndex);

		if (parentNode.getStoredCount() < (BTREE_ORDER / 2)) {
			if (parentNode.getStoredCount() == 0) {
				rootNode = leftNode;
			} else {
				currentNode = parentNode;

				try {
					parentNode = nodeStack.pop();
				} catch (EmptyStackException e) {
					parentNode = null;
				}

				if (parentNode != null) {
					index = getIndexInfo(parentNode, currentNode);
					mergeNode(parentNode, currentNode, index, nodeStack);
				}
			}

		}
	}

	private void borrowFromLeft(Node parentNode, Node currentNode, int index, Node leftNode) {
		currentNode.addNodeData(parentNode.dataArray[index - 1], null);

		int count = leftNode.getStoredCount();
		NodeData leftNodeData = leftNode.dataArray[count - 1];
		parentNode.dataArray[index - 1] = leftNodeData;
		deleteNodeData(leftNode, count - 1);
	}

	private void borrowFromRight(Node parentNode, Node currentNode, int index, Node rightNode) {
		int count = currentNode.getStoredCount();
		currentNode.dataArray[count] = parentNode.dataArray[index];
		currentNode.increaseStoredCount();

		parentNode.dataArray[index] = rightNode.dataArray[0];

		deleteNodeData(rightNode, 0);
	}

	private int getIndexInfo(Node parentNode, Node currentNode) {
		int index;

		for (index = 0; index < parentNode.getStoredCount(); index++) {
			if (parentNode.childrenArray[index] == currentNode) {
				break;
			}
		}

		return index;
	}

	private Node replaceLeafNode(Node deleteNode, int findIndex, Stack<Node> nodeStack) {
		Node parentNode = deleteNode;
		Node childNode;
		int count = findIndex;

		do {
			childNode = parentNode.childrenArray[findIndex];
			nodeStack.push(childNode);

			count = childNode.getStoredCount();
			parentNode = childNode;
		} while (childNode.childrenArray[count] != null);

		NodeData leafNodeData = childNode.dataArray[count - 1];
		deleteNode.dataArray[findIndex] = leafNodeData;
		deleteNodeData(childNode, count - 1);

		return childNode;
	}

	private void deleteNodeData(Node parentNode, int findIndex) {
		int storedCount = parentNode.getStoredCount();

		for (int index = findIndex + 1; index < storedCount; index++) {
			parentNode.dataArray[index - 1] = parentNode.dataArray[index];
			parentNode.childrenArray[index] = parentNode.childrenArray[index + 1];
		}

		parentNode.dataArray[storedCount - 1] = null;
		parentNode.childrenArray[storedCount] = null;
		parentNode.decreaseStoredCount();
	}

	private boolean isLeafNode(Node parentNode) {
		boolean isLeafNode = true;

		for (Node childNode : parentNode.childrenArray) {
			if (childNode != null) {
				isLeafNode = false;
				break;
			}
		}

		return isLeafNode;
	}

	@Override
	public String toString() {
		return (rootNode != null) ? rootNode.toString() : "";
	}
}
