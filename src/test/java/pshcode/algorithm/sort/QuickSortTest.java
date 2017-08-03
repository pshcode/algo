package pshcode.algorithm.sort;

import static org.junit.Assert.*;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuickSortTest {
	@Test
	public void sort() throws Exception {
		//given
		int[] values = {80, 75, 10, 60, 15, 49, 12, 25};
		QuickSort quickSort = new QuickSort(values);

		//when
		quickSort.sort(0, values.length - 1);
		String actual = ArrayUtils.toString(quickSort.getValues());

		//then
		String expected = "{10,12,15,25,49,60,75,80}";
		assertEquals(expected, actual);
	}
}