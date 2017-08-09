package pshcode.algorithm.hash.chaining;

import lombok.Getter;
import lombok.ToString;

/**
 * 해시 슬롯.
 *
 * @author SungHoon, Park
 */
@ToString
public class HashSlot {
	@Getter
	String key;
	@Getter
	int value;

	public HashSlot(String key, int value) {
		this.key = key;
		this.value = value;
	}
}
