package data.structure;

public class MyHashLinearProbing {
    public Slot[] hashTable;

    public MyHashLinearProbing(int size) {
        this.hashTable = new Slot[size];
    }

    static class Slot {
        String key;
        String value;
        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int) key.charAt(0) % this.hashTable.length;
    }

    public void saveData(String key, String value) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key.equals(key)) {
                this.hashTable[address].value = value;
            } else {
                int currentAddress = address + 1;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key.equals(key)) {
                        this.hashTable[currentAddress].value = value;
                    }
                    currentAddress++;
                    if (currentAddress >= this.hashTable.length) {
                        return;
                    }
                }
                this.hashTable[currentAddress] = new Slot(key, value);
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
    }

    public String getData(String key) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key.equals(key)) {
                return this.hashTable[address].value;
            }
            int currentAddress = address;
            while (this.hashTable[currentAddress] != null) {
                if (this.hashTable[currentAddress].key.equals(key)) {
                    return this.hashTable[currentAddress].value;
                }
                currentAddress++;
            }
        }
        return null;
    }
}
