package pshcode.algorithm.hash;

import org.apache.commons.lang3.StringUtils;

/**
 * 해시 테이블.
 *
 * @author SungHoon, Park
 */
public class HashTable {
	private static final int INCREMENT = 1;

	HashBucket[] hashBuckets;
	int bucketSize;

	public HashTable(int bucketSize) {
		if (bucketSize <= 0) {
			throw new IllegalArgumentException("bucket size must be greater than zero.");
		}

		this.bucketSize = bucketSize;
		this.hashBuckets = new HashBucket[bucketSize];
	}

	boolean add(HashBucket hashBucket) {
		int hash = hashCode(hashBucket.getKey());
		int tempIndex = hash;

		do {
			if (hashBuckets[tempIndex] == null) {
				hashBuckets[tempIndex] = hashBucket;
				return true;
			}

			if (StringUtils.equals(hashBucket.getKey(), hashBuckets[tempIndex].getKey())) {
				break;
			}

			tempIndex = linearProbing(tempIndex);

			if (tempIndex == hash) {
				break;
			}

		} while (tempIndex != hash);

		return false;
	}

	boolean remove(String key) {
		HashBucket found = search(key);

		if (found != null) {
			found.remove();
			return true;
		}

		return false;
	}

	HashBucket search(String key) {
		int hash = hashCode(key);
		int tempIndex = hash;

		HashBucket found = null;

		do {
			HashBucket temp = hashBuckets[tempIndex];

			if (temp == null) {
				break;
			}

			if (temp.getStatus() == Status.USED && temp.getKey() == key) {
				found = temp;
				break;
			} else {
				tempIndex = linearProbing(tempIndex);

				if (tempIndex == hash) {
					break;
				}
			}
		} while (tempIndex != hash);

		return found;
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

	int linearProbing(int value) {
		return (value + INCREMENT) % bucketSize;
	}

	public void printAll() {
		for (int index = 0; index < hashBuckets.length; index++) {
			System.out.println("[" + index + "] " + hashBuckets[index]);
		}
	}
}
