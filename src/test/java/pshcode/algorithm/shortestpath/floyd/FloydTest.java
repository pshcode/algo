package pshcode.algorithm.shortestpath.floyd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FloydTest {
	@Test
	public void initTest() throws Exception {
		//given
		Floyd floyd = new Floyd(3);

		floyd.addEdge(0, 1, 2);
		floyd.addEdge(0, 2, 4);
		floyd.addEdge(2, 0, 4);
		floyd.addEdge(1, 2, 1);

		//when
		floyd.init();
	}

	@Test
	public void calcTest() throws Exception {
		Floyd floyd = new Floyd(3);

		floyd.addEdge(0, 1, 2);
		floyd.addEdge(0, 2, 4);
		floyd.addEdge(2, 0, 4);
		floyd.addEdge(1, 2, 1);

		//when
		floyd.init();
		floyd.calcShortestPath();
	}

	/**
	 * https://www.youtube.com/watch?v=i9SZKy2yTZw
	 *
	 * @throws Exception
	 */
	@Test
	public void calcTest2() throws Exception {
		Floyd floyd = new Floyd(5);

		floyd.addEdge(0, 1, 3);
		floyd.addEdge(0, 2, 8);
		floyd.addEdge(0, 4, -4);
		floyd.addEdge(1, 3, 1);
		floyd.addEdge(1, 4, 7);
		floyd.addEdge(2, 1, 4);
		floyd.addEdge(3, 2, -5);
		floyd.addEdge(3, 0, 2);
		floyd.addEdge(4, 3, 6);

		//when
		floyd.init();
		floyd.calcShortestPath();
	}
}