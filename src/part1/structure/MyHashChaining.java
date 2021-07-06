package part1.structure;

public class MyHashChaining {
    public Slot[] hashTable;

    public MyHashChaining(int size) {
        this.hashTable = new Slot[size];
    }

    static class Slot {
        String key;
        String value;
        Slot next;
        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    /** Division 기법 **/
    public int hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public void saveData(String key, String value) {
        int address = this.hashFunc(key);
        Slot headSlot = this.hashTable[address];
        if (headSlot != null) {
            Slot findSlot = headSlot;
            Slot prevSlot = headSlot;
            while (findSlot != null) {
                if (findSlot.key.equals(key)) {
                    findSlot.value = value;
                }
                prevSlot = findSlot;
                findSlot = findSlot.next;
            }
            prevSlot.next = new Slot(key, value);
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
    }

    public String getData(String key) {
        int address = this.hashFunc(key);
        Slot findSlot = this.hashTable[address];
        while (findSlot != null) {
            if (findSlot.key.equals(key)) {
                return findSlot.value;
            }
            findSlot = findSlot.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashChaining hash = new MyHashChaining(20);
        hash.saveData("Dave", "111");
        hash.saveData("DaveLee", "222");
        System.out.println(hash.getData("Dave"));
        System.out.println(hash.getData("DaveLee"));
    }
}
