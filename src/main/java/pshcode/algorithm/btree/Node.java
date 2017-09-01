package pshcode.algorithm.btree;

import lombok.Data;
import lombok.ToString;

/**
 * 노드.
 *
 * @author SungHoon, Park
 */
@Data
@ToString
public class Node {
	int storedCount;
	NodeData[] dataArray;
	Node[] childrenArray;

	public Node() {
		dataArray = new NodeData[Btree.BTREE_ORDER];
		childrenArray = new Node[Btree.BTREE_ORDER + 1];
	}

	public Node(NodeData nodeData) {
		this();
		dataArray[0] = nodeData;
		increaseStoredCount();
	}

	public void increaseStoredCount() {
		storedCount++;
	}

	public void decreaseStoredCount() {
		storedCount--;
	}

	public void addNodeData(NodeData nodeData, Node newNode) {
		int index;

		for (index = storedCount - 1; index >= 0; index--) {
			int tempKey = dataArray[index].getKey();

			if (nodeData.getKey() < tempKey) {
				dataArray[index + 1] = dataArray[index];
				childrenArray[index + 2] = childrenArray[index + 1];
			} else {
				break;
			}
		}

		dataArray[index + 1] = nodeData;
		childrenArray[index + 2] = newNode;
		increaseStoredCount();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < dataArray.length; i++) {
			NodeData nodeData = dataArray[i];

			sb.append("(");
			sb.append((nodeData != null) ? nodeData.getKey() : "");
			sb.append(")");
			sb.append(" ");
		}

		sb.append("\r\n");
		sb.append("\t");

		for (int i = 0; i < childrenArray.length; i++) {
			Node node = childrenArray[i];

			if (node != null) {
				sb.append("child[" + i + "] ");
				sb.append(node);
			}
		}

		return sb.toString();
	}
}
