package pshcode.algorithm.btree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BtreeRemoveTest {
	@Test
	public void remove() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(36);
		rootNode.getDataArray()[1] = new NodeData(63);
		rootNode.setStoredCount(2);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(9);
		childNode1.getDataArray()[1] = new NodeData(12);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(36);
		childNode2.getDataArray()[1] = new NodeData(39);
		childNode2.getDataArray()[2] = new NodeData(48);
		childNode2.getDataArray()[3] = new NodeData(53);
		childNode2.setStoredCount(4);

		Node childNode3 = new Node();
		childNode3.getDataArray()[0] = new NodeData(65);
		childNode3.getDataArray()[1] = new NodeData(89);
		childNode3.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;
		rootNode.getChildrenArray()[2] = childNode3;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.remove(9);

		//then
		System.out.println(btree);
	}

	@Test
	public void remove_왼쪽에서_가져오기() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(14);
		rootNode.getDataArray()[1] = new NodeData(19);
		rootNode.setStoredCount(2);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(9);
		childNode1.getDataArray()[1] = new NodeData(12);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(16);
		childNode2.getDataArray()[1] = new NodeData(17);
		childNode2.getDataArray()[2] = new NodeData(18);
		childNode2.setStoredCount(3);

		Node childNode3 = new Node();
		childNode3.getDataArray()[0] = new NodeData(22);
		childNode3.getDataArray()[1] = new NodeData(24);
		childNode3.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;
		rootNode.getChildrenArray()[2] = childNode3;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.remove(24);

		//then
		System.out.println(btree);
	}

	@Test
	public void remove_오른쪽에서_가져오기() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(14);
		rootNode.getDataArray()[1] = new NodeData(19);
		rootNode.setStoredCount(2);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(9);
		childNode1.getDataArray()[1] = new NodeData(12);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(16);
		childNode2.getDataArray()[1] = new NodeData(17);
		childNode2.getDataArray()[2] = new NodeData(18);
		childNode2.setStoredCount(3);

		Node childNode3 = new Node();
		childNode3.getDataArray()[0] = new NodeData(22);
		childNode3.getDataArray()[1] = new NodeData(24);
		childNode3.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;
		rootNode.getChildrenArray()[2] = childNode3;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.remove(9);

		//then
		System.out.println(btree);
	}

	@Test
	public void remove_병합테스트_1() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(19);
		rootNode.getDataArray()[1] = new NodeData(63);
		rootNode.setStoredCount(2);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(9);
		childNode1.getDataArray()[1] = new NodeData(12);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(36);
		childNode2.getDataArray()[1] = new NodeData(39);
		childNode2.getDataArray()[2] = new NodeData(48);
		childNode2.getDataArray()[3] = new NodeData(53);
		childNode2.setStoredCount(4);

		Node childNode3 = new Node();
		childNode3.getDataArray()[0] = new NodeData(65);
		childNode3.getDataArray()[1] = new NodeData(89);
		childNode3.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;
		rootNode.getChildrenArray()[2] = childNode3;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//then
		System.out.println(btree);
	}

	@Test
	public void remove_병합테스트_2() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(36);
		rootNode.getDataArray()[1] = new NodeData(63);
		rootNode.setStoredCount(2);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(12);
		childNode1.getDataArray()[1] = new NodeData(19);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(39);
		childNode2.getDataArray()[1] = new NodeData(48);
		childNode2.getDataArray()[2] = new NodeData(53);
		childNode2.setStoredCount(3);

		Node childNode3 = new Node();
		childNode3.getDataArray()[0] = new NodeData(65);
		childNode3.getDataArray()[1] = new NodeData(89);
		childNode3.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;
		rootNode.getChildrenArray()[2] = childNode3;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.remove(89);

		//then
		System.out.println(btree);
	}

	@Test
	public void remove_병합테스트_3() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(36);
		rootNode.getDataArray()[1] = new NodeData(53);
		rootNode.setStoredCount(2);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(12);
		childNode1.getDataArray()[1] = new NodeData(19);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(39);
		childNode2.getDataArray()[1] = new NodeData(48);
		childNode2.setStoredCount(2);

		Node childNode3 = new Node();
		childNode3.getDataArray()[0] = new NodeData(63);
		childNode3.getDataArray()[1] = new NodeData(65);
		childNode3.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;
		rootNode.getChildrenArray()[2] = childNode3;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.remove(39);

		//then
		System.out.println(btree);
	}

	@Test
	public void remove_병합테스트_4() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(36);
		rootNode.setStoredCount(1);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(12);
		childNode1.getDataArray()[1] = new NodeData(19);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(48);
		childNode2.getDataArray()[1] = new NodeData(53);
		childNode2.getDataArray()[2] = new NodeData(63);
		childNode2.getDataArray()[3] = new NodeData(65);
		childNode2.setStoredCount(4);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.remove(63);

		//then
		System.out.println(btree);
	}

	@Test
	public void remove_병합테스트_5() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(36);
		rootNode.setStoredCount(1);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(12);
		childNode1.getDataArray()[1] = new NodeData(19);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(48);
		childNode2.getDataArray()[1] = new NodeData(53);
		childNode2.getDataArray()[2] = new NodeData(65);
		childNode2.setStoredCount(3);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.remove(53);

		//then
		System.out.println(btree);
	}

	@Test
	public void remove_병합테스트_6() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(36);
		rootNode.setStoredCount(1);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(12);
		childNode1.getDataArray()[1] = new NodeData(19);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(48);
		childNode2.getDataArray()[1] = new NodeData(65);
		childNode2.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.remove(36);

		//then
		System.out.println(btree);
	}
}