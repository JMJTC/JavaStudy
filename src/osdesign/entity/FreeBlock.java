package osdesign.entity;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-03
 * @Description: 空闲分区块
 * @Version: 1.0
 */
public class FreeBlock {
    private int startAddress;
    private int size;
    private FreeBlock prev;
    private FreeBlock next;

    // 构造方法、Getter/Setter

    public FreeBlock(int startAddress, int size, FreeBlock prev, FreeBlock next) {
        this.startAddress = startAddress;
        this.size = size;
        this.prev = prev;
        this.next = next;
    }

    public FreeBlock(int startAddress, int size) {
        this.startAddress = startAddress;
        this.size = size;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(int startAddress) {
        this.startAddress = startAddress;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public FreeBlock getPrev() {
        return prev;
    }

    public void setPrev(FreeBlock prev) {
        this.prev = prev;
    }

    public FreeBlock getNext() {
        return next;
    }

    public void setNext(FreeBlock next) {
        this.next = next;
    }
}
