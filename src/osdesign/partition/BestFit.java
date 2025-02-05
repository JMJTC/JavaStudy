package osdesign.partition;

import osdesign.entity.FreeBlock;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-03
 * @Description: BestFit
 * @Version: 1.0
 */
public class BestFit implements PartitionAlgorithm {
    @Override
    public int allocate(FreeBlock head, int size) {
        FreeBlock current = head;
        FreeBlock bestFit = null;
        while (current != null) {
            if (current.getSize() >= size && (bestFit == null || current.getSize() < bestFit.getSize())) {
                bestFit = current;
            }
        }
        if (bestFit != null) {
            // 分配并更新链表
            return bestFit.getStartAddress();
        }
        return -1; // 分配失败
    }

}
