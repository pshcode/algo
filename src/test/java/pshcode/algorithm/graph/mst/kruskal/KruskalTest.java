package pshcode.algorithm.graph.mst.kruskal;

import org.junit.Test;

/**
 * @author SungHoon, Park
 */
class KruskalTest {
	@Test
	void init() {
		//given
		Kruskal kruskal = new Kruskal(6);

		kruskal.initEdge(0, 1, 4);
		kruskal.initEdge(0, 2, 3);
		kruskal.initEdge(1, 2, 2);
		kruskal.initEdge(2, 3, 1);
		kruskal.initEdge(3, 4, 1);
		kruskal.initEdge(3, 5, 5);
		kruskal.initEdge(4, 5, 6);

		//when
		kruskal.print();
	}
}