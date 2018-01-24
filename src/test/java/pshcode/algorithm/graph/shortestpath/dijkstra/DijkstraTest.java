package pshcode.algorithm.graph.shortestpath.dijkstra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DijkstraTest {
	@Test
	public void init() throws Exception {
		//given
		Dijkstra dijkstra = new Dijkstra(6);
		dijkstra.addEdge(0, 1, 2);
		dijkstra.addEdge(0, 2, 4);
		dijkstra.addEdge(2, 0, 4);
		dijkstra.addEdge(1, 2, 1);
		dijkstra.addEdge(2, 3, 7);
		dijkstra.addEdge(3, 2, 5);
		dijkstra.addEdge(3, 4, 2);
		dijkstra.addEdge(3, 5, 6);
		dijkstra.addEdge(4, 5, 3);
		dijkstra.addEdge(5, 3, 6);

		//when
		dijkstra.init(0);

		//then
		dijkstra.printDistances(0);
	}

	@Test
	public void calcShortestPath() throws Exception {
		//given
		Dijkstra dijkstra = new Dijkstra(6);
		dijkstra.addEdge(0, 1, 2);
		dijkstra.addEdge(0, 2, 4);
		dijkstra.addEdge(2, 0, 4);
		dijkstra.addEdge(1, 2, 1);
		dijkstra.addEdge(2, 3, 7);
		dijkstra.addEdge(3, 2, 5);
		dijkstra.addEdge(3, 4, 2);
		dijkstra.addEdge(3, 5, 6);
		dijkstra.addEdge(4, 5, 3);
		dijkstra.addEdge(5, 3, 6);

		//when
		dijkstra.init(0);

		//then
		dijkstra.calcShortestPath();
	}
}