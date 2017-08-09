package pshcode.algorithm.hash.chaining;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HashTableTest {
	@Test
	public void addTest() throws Exception {
		//given
		HashTable hashTable = getHashTableFixture();

		//then
		hashTable.printAll();
	}

	private HashTable getHashTableFixture() {
		HashTable hashTable = new HashTable(10);

		hashTable.add(new HashSlot("january", 1));
		hashTable.add(new HashSlot("february", 2));
		hashTable.add(new HashSlot("march", 3));
		hashTable.add(new HashSlot("april", 4));
		hashTable.add(new HashSlot("may", 5));
		hashTable.add(new HashSlot("june", 6));
		hashTable.add(new HashSlot("july", 7));
		hashTable.add(new HashSlot("august", 8));
		hashTable.add(new HashSlot("september", 9));
		hashTable.add(new HashSlot("october", 10));
		hashTable.add(new HashSlot("november", 11));

		return hashTable;
	}

	@Test
	public void findTest() throws Exception {
		//given
		HashTable hashTable = getHashTableFixture();

		//when
		HashSlot actual = hashTable.search("august");

		//then
		assertThat(actual.getKey(), is("august"));
		assertThat(actual.getValue(), is(8));
	}

	@Test
	public void removeTest() throws Exception {
		//given
		HashTable hashTable = getHashTableFixture();

		//when
		boolean actual = hashTable.remove("july");

		//then
		assertTrue(actual);

		System.out.println("=== removeTest ===");
		hashTable.printAll();
	}
}