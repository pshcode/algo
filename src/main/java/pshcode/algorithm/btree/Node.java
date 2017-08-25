package pshcode.algorithm.btree;

import lombok.Data;

/**
 * 노드.
 *
 * @author SungHoon, Park
 */
@Data
public class Node {
	int storedCount;
	NodeData[] dataArray;
	Node[] childrenArray;

	public Node() {
		dataArray = new NodeData[Btree.M_WAY_SIZE];
		childrenArray = new Node[Btree.M_WAY_SIZE];
	}

	public void increateStoredCount() {
		storedCount++;
	}
}
