package osdesign.partition;

import osdesign.entity.FreeBlock;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-03
 * @Description: WorstFit
 * @Version: 1.0
 */
public class WorstFit implements PartitionAlgorithm {
    @Override
    public int allocate(FreeBlock head, int size) {
        FreeBlock current = head;
        FreeBlock worstFit = null;
        while (current != null) {
            if (current.getSize() >= size && (worstFit == null || current.getSize() > worstFit.getSize())) {
                worstFit = current;
            }
        }
        if (worstFit != null) {
            // 分配并更新链表
            return worstFit.getStartAddress();
        }
        return -1; // 分配失败
    }
}
