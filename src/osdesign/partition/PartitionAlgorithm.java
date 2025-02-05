package osdesign.partition;

import osdesign.entity.FreeBlock;

/**
 * @author jmjtc
 */
public interface PartitionAlgorithm {
    int allocate(FreeBlock head, int size);
}
