package osdesign.partition;

import osdesign.entity.FreeBlock;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-03
 * @Description: FirstFit
 * @Version: 1.0
 */
public class FirstFit implements PartitionAlgorithm {
    @Override
    public int allocate(FreeBlock head, int size) {
        FreeBlock current = head;
        while (current != null) {
            if (current.getSize() >= size) {
                // 分配并更新链表
                return current.getStartAddress();
            }
            current = current.getNext();
        }
        return -1; // 分配失败
    }
}
