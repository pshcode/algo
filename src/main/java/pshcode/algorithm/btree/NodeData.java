package pshcode.algorithm.btree;

import lombok.Data;

/**
 * 노드 정보.
 *
 * @author SungHoon, Park
 */
@Data
public class NodeData {
	private int key;

	public NodeData(int key) {
		this.key = key;
	}
}
