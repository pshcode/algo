package pshcode.algorithm.hash.openaddressing;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 해시 버킷.
 *
 * @author SungHoon, Park
 */
@ToString
public class HashBucket {
	@Getter
	String key;
	@Getter
	int value;
	@Getter
	@Setter
	Status status;

	public HashBucket(String key, int value) {
		this.key = key;
		this.value = value;
		this.status = Status.USED;
	}

	public void remove() {
		this.key = "";
		this.value = 0;
		this.status = Status.DELETED;
	}
}
