/**
 * HashTable class for storing key-value pairs with collision resolution using quadratic probing.
 * 
 * @author Joseph Kabesha
 * @author
 */
public class HashTable {
    /** Default capacity of the hash table. */
    public static final int defaultCapacity = 11; // Prime number for improved key distribution

    /** Array to hold the hash table entries. */
    private HashEntry[] table;

    /**
     * Constructs a hash table with default capacity.
     */
    public HashTable() {
        table = new HashEntry[defaultCapacity];
    }

    /**
     * Inserts a key-value pair into the hash table.
     * @param key The key to insert.
     * @param value The value associated with the key.
     */
    public void insert(Integer key, String value) {
        int index = hash(key);
        int i = 1;
        while (table[index] != null && !table[index].isRemoved()) {
            index = (index + i * i) % table.length; // Quadratic probing
            i++;
        }
        table[index] = new HashEntry(key, value);
    }

    /**
     * Removes the key-value pair associated with the given key from the hash table.
     * @param key The key to remove.
     */
    public void remove(int key) {
        int index = hash(key);
        int i = 1;
        while (table[index] != null) {
            if (table[index].getKey() == key && !table[index].isRemoved()) {
                table[index] = null; // Remove the entry from the table
                return;
            }
            index = (index + i * i) % table.length; // Quadratic probing
            i++;
        }
    }

    /**
     * Searches for the value associated with the given key in the hash table.
     * @param key The key to search for.
     * @return The value associated with the key, or null if not found.
     */
    public String search(int key) {
        int index = hash(key);
        int i = 1;
        int count = 0; // Track the number of iterations to prevent infinite loop
        while (count < table.length && table[index] != null) {
            if (table[index].getKey() == key && !table[index].isRemoved()) {
                return table[index].getValue();
            }
            index = (index + i * i) % table.length; // Quadratic probing
            i++;
            count++;
        }
        return null; // Return null if key is not found
    }

    /**
     * Displays the current state of the hash table.
     */
    public void displayTable() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println("Index: " + i + ", Key: " + table[i].getKey() + ", Value: " + table[i].getValue());
            } else {
                System.out.println("Index: " + i + ", Empty");
            }
        }
    }

    /**
     * Computes the hash value for the given key.
     * @param key The key to hash.
     * @return The hash value.
     */
    private int hash(int key) {
        return key % table.length;
    }

    /**
     * Inner class representing an entry in the hash table.
     */
    private static class HashEntry {
        /** The key of the entry. */
        private int key;
        /** The value associated with the key. */
        private String value;
        /** Indicator for removal. */
        private boolean removed;

        /**
         * Constructs a new hash entry with the given key and value.
         * @param key The key of the entry.
         * @param value The value associated with the key.
         */
        public HashEntry(int key, String value) {
            this.key = key;
            this.value = value;
            this.removed = false; // Initially not removed
        }

        /**
         * Retrieves the key of the entry.
         * @return The key.
         */
        public int getKey() {
            return key;
        }

        /**
         * Retrieves the value associated with the key.
         * @return The value.
         */
        public String getValue() {
            return value;
        }

        /**
         * Checks if the entry has been marked as removed.
         * @return True if removed, false otherwise.
         */
        public boolean isRemoved() {
            return removed;
        }

        /**
         * Marks the entry as removed.
         */
        @SuppressWarnings("unused")
        public void markRemoved() {
            this.removed = true;
        }
    }

    /**
     * Main method for testing the HashTable class.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert(1, "One");
        hashTable.insert(11, "Eleven");
        hashTable.insert(21, "Twenty-One");
        hashTable.insert(31, "Thirty-One");
        hashTable.insert(41, "Forty-One");
        hashTable.displayTable();
        System.out.println("Search for key 11: " + hashTable.search(11));
        hashTable.remove(11);
        System.out.println("After removing key 11:");
        hashTable.displayTable();
    }
}
