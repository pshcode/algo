package pshcode.algorithm.hash.openaddressing;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HashTableTest {
	@Test
	public void addFirstHashBucket() throws Exception {
		//given
		HashBucket hashBucket = new HashBucket("january", 1);

		//when
		HashTable hashTable = new HashTable(13);
		boolean actual = hashTable.add(hashBucket);

		//then
		assertTrue(actual);
	}

	@Test
	public void addHashBuckets() throws Exception {
		//given
		HashBucket bucket01 = new HashBucket("january", 1);
		HashBucket bucket02 = new HashBucket("february", 2);
		HashBucket bucket03 = new HashBucket("march", 3);
		HashBucket bucket04 = new HashBucket("april", 4);
		HashBucket bucket05 = new HashBucket("may", 5);
		HashBucket bucket06 = new HashBucket("june", 6);
		HashBucket bucket07 = new HashBucket("july", 7);
		HashBucket bucket08 = new HashBucket("august", 8);
		HashBucket bucket09 = new HashBucket("september", 9);
		HashBucket bucket10 = new HashBucket("october", 10);
		HashBucket bucket11 = new HashBucket("november", 11);
		HashBucket bucket12 = new HashBucket("december", 12);

		//when
		HashTable hashTable = new HashTable(13);
		hashTable.add(bucket01);
		hashTable.add(bucket02);
		hashTable.add(bucket03);
		hashTable.add(bucket04);
		hashTable.add(bucket05);
		hashTable.add(bucket06);
		hashTable.add(bucket07);
		hashTable.add(bucket08);
		hashTable.add(bucket09);
		hashTable.add(bucket10);
		hashTable.add(bucket11);
		hashTable.add(bucket12);

		//then
		hashTable.printAll();
	}

	@Test
	public void hornersMethodABC() throws Exception {
		//given
		String key = "ABC";

		//when
		HashTable hashTable = new HashTable(13);
		long actual = hashTable.hornersMethod(key);

		//then
		assertEquals(64578, actual);
	}

	@Test
	public void hornersMethodCBA() throws Exception {
		//given
		String key = "CBA";

		//when
		HashTable hashTable = new HashTable(10);
		long actual = hashTable.hornersMethod(key);

		//then
		assertEquals(66498, actual);
	}

	@Test
	public void hashCode_january() throws Exception {
		//given
		String key = "january";

		//when
		HashTable hashTable = new HashTable(10);
		int actual = hashTable.hashCode(key);

		//then
		assertEquals(2, actual);
	}
}