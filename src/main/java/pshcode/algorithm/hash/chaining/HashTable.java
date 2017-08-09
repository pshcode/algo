package pshcode.algorithm.hash.chaining;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 해시 테이블.
 *
 * @author SungHoon, Park
 */
public class HashTable {
	List<HashSlot>[] buckets;
	int bucketSize;

	public HashTable(int bucketSize) {
		if (bucketSize <= 0) {
			throw new IllegalArgumentException("bucket size must be greater than zero.");
		}

		this.buckets = new List[bucketSize];
		this.bucketSize = bucketSize;
	}

	boolean add(HashSlot hashSlot) {
		int hash = hashCode(hashSlot.getKey());

		if (buckets[hash] == null) {
			buckets[hash] = new LinkedList<HashSlot>();
		}

		List<HashSlot> slotList = buckets[hash];
		slotList.add(hashSlot);

		return true;
	}

	boolean remove(String key) {
		List<HashSlot> slotList = searchSlotList(key);

		if (slotList != null) {
			for (int index = 0; index < slotList.size(); index++) {
				if (StringUtils.equals(key, slotList.get(index).getKey())) {
					slotList.remove(index);
					return true;
				}
			}
		}

		return false;
	}

	List<HashSlot> searchSlotList(String key) {
		int hash = hashCode(key);

		if (buckets[hash] == null) {
			return null;
		}

		return buckets[hash];
	}

	HashSlot search(String key) {
		List<HashSlot> slotList = searchSlotList(key);

		for (HashSlot hashSlot : slotList) {
			if (StringUtils.equals(key, hashSlot.getKey())) {
				return hashSlot;
			}
		}

		return null;
	}

	int hashCode(String key) {
		if (StringUtils.isEmpty(key)) {
			return -1;
		}

		long hash = hornersMethod(key);

		if (hash > 0) {
			hash = hash % bucketSize;
		}

		if (hash < 0 || hash >= bucketSize) {
			throw new IllegalStateException("hashCode value is invalid.");
		}

		return (int)hash;
	}

	long hornersMethod(String key) {
		long hornersHash = 0;

		for (char character : key.toCharArray()) {
			hornersHash = (hornersHash * 31) + character;
		}

		return hornersHash;
	}

	public void printAll() {
		for (int index = 0; index < buckets.length; index++) {
			System.out.println("[" + index + "] " + buckets[index]);
		}
	}
}
