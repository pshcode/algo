package pshcode.algorithm.btree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BtreeAddTest {
	@Test
	public void add_1() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(19);
		rootNode.setStoredCount(1);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(9);
		childNode1.getDataArray()[1] = new NodeData(12);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(68);
		childNode2.getDataArray()[1] = new NodeData(74);
		childNode2.getDataArray()[2] = new NodeData(85);
		childNode2.getDataArray()[3] = new NodeData(97);
		childNode2.setStoredCount(4);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.add(new NodeData(63));

		//then
		System.out.println(btree);
	}

	@Test
	public void add_2() throws Exception {
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
		childNode2.getDataArray()[0] = new NodeData(42);
		childNode2.getDataArray()[1] = new NodeData(45);
		childNode2.getDataArray()[2] = new NodeData(63);
		childNode2.getDataArray()[3] = new NodeData(68);
		childNode2.setStoredCount(4);

		Node childNode3 = new Node();
		childNode3.getDataArray()[0] = new NodeData(85);
		childNode3.getDataArray()[1] = new NodeData(97);
		childNode3.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;
		rootNode.getChildrenArray()[2] = childNode3;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.add(new NodeData(57));

		//then
		System.out.println(btree);
	}

	@Test
	public void add_3() throws Exception {
		//given
		Node rootNode = new Node();
		rootNode.getDataArray()[0] = new NodeData(14);
		rootNode.getDataArray()[1] = new NodeData(19);
		rootNode.getDataArray()[2] = new NodeData(57);
		rootNode.getDataArray()[3] = new NodeData(74);
		rootNode.setStoredCount(4);

		Node childNode1 = new Node();
		childNode1.getDataArray()[0] = new NodeData(9);
		childNode1.getDataArray()[1] = new NodeData(12);
		childNode1.setStoredCount(2);

		Node childNode2 = new Node();
		childNode2.getDataArray()[0] = new NodeData(17);
		childNode2.getDataArray()[1] = new NodeData(18);
		childNode2.setStoredCount(2);

		Node childNode3 = new Node();
		childNode3.getDataArray()[0] = new NodeData(30);
		childNode3.getDataArray()[1] = new NodeData(42);
		childNode3.getDataArray()[2] = new NodeData(45);
		childNode3.getDataArray()[3] = new NodeData(52);
		childNode3.setStoredCount(4);

		Node childNode4 = new Node();
		childNode4.getDataArray()[0] = new NodeData(63);
		childNode4.getDataArray()[1] = new NodeData(68);
		childNode4.setStoredCount(2);

		Node childNode5 = new Node();
		childNode5.getDataArray()[0] = new NodeData(85);
		childNode5.getDataArray()[1] = new NodeData(97);
		childNode5.setStoredCount(2);

		rootNode.getChildrenArray()[0] = childNode1;
		rootNode.getChildrenArray()[1] = childNode2;
		rootNode.getChildrenArray()[2] = childNode3;
		rootNode.getChildrenArray()[3] = childNode4;
		rootNode.getChildrenArray()[4] = childNode5;

		Btree btree = new Btree();
		btree.setRootNode(rootNode);

		//when
		btree.add(new NodeData(22));

		//then
		System.out.println(btree);
	}

}