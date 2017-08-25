package pshcode.algorithm.btree;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BtreeTest {
	@Test
	public void 검색시_루트노트가_없을경우_NULL을_리턴() throws Exception {
		//given
		Btree btree = new Btree();

		//when
		NodeData actual = btree.search(123);

		//then
		assertNull(actual);
	}

	@Test
	public void 키값_63을_찾는다() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(19);
		rootNode.getDataArray()[1] = new NodeData(74);
		rootNode.setStoredCount(2);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(9);
		childNode1.getDataArray()[1] = new NodeData(12);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(63);
		childNode2.getDataArray()[1] = new NodeData(68);
		childNode2.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		NodeData actual = btree.search(63);

		//then
		assertEquals(63, actual.getKey());
	}

	@Test
	public void 존재하지_않는_키값을_찾을경우_NULL을_리턴() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(19);
		rootNode.getDataArray()[1] = new NodeData(74);
		rootNode.setStoredCount(2);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(9);
		childNode1.getDataArray()[1] = new NodeData(12);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(63);
		childNode2.getDataArray()[1] = new NodeData(68);
		childNode2.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		NodeData actual = btree.search(1414141);

		//then
		assertNull(actual);
	}

	@Test
	public void 가장_큰값을_찾는다() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(19);
		rootNode.setStoredCount(1);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(9);
		childNode1.getDataArray()[1] = new NodeData(12);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(63);
		childNode2.getDataArray()[1] = new NodeData(68);
		childNode2.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		NodeData actual = btree.search(68);

		//then
		assertEquals(68, actual.getKey());
	}
}