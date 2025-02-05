package osdesign.partition;

import osdesign.entity.FreeBlock;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-03
 * @Description: PartitionManager
 * @Version: 1.0
 */
public class PartitionManager {
    private FreeBlock freeList;

    public void release(int start, int size) {
        FreeBlock newBlock = new FreeBlock(start, size);
        // 插入并合并相邻空闲区
        // 1. 查找插入位置
        FreeBlock current = freeList;
        FreeBlock prev = null;
        while (current != null && current.getStartAddress() < start) {
            prev = current;
            current = current.getNext();
        }

        // 2. 检查前驱和后继是否相邻，若相邻则合并 // 3. 更新链表
        if (prev != null && prev.getStartAddress() + prev.getSize() == start) {
            prev.setSize(prev.getSize() + size);
            if (current != null && current.getStartAddress() == start + size) {
                prev.setSize(prev.getSize() + current.getSize());
                prev.setNext(current.getNext());
            }
        } else if (current != null && current.getStartAddress() == start + size) {
            newBlock.setSize(newBlock.getSize() + current.getSize());
            newBlock.setNext(current.getNext());
            if (prev != null) {
                prev.setNext(newBlock);
            }
            else {
                freeList = newBlock;
            }
        }else {
            if (prev != null) {
                prev.setNext(newBlock);
            }
            else {
                freeList = newBlock;
            }
            newBlock.setNext(current);
        }

    }
}
