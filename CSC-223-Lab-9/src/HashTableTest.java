import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for verifying the functionality of the HashTable class.
 * 
 * @author Joseph Kabesha
 * @author Isaiah Ayres
 */
public class HashTableTest {

    /**
     * Test case for inserting elements into the hash table.
     * Inserts 10 key-value pairs into a hash table instance.
     */
    @Test
    public void testInsertion() {
        HashTable hashTable = new HashTable();
        for (int i = 0; i < 10; i++) {
            hashTable.insert(i, "Value: " + i);
        }
    }

    /**
     * Test case for continuous collisions.
     * Inserts 10 key-value pairs with keys that all hash to the same index,
     * simulating continuous collisions.
     */
    @Test
    public void testContinuousCollisions() {
        HashTable hashTable = new HashTable();
        for (int i = 0; i < 10; i++) {
            hashTable.insert(i * 10, "Value" + (i * 10));
        }
    }

    /**
     * Test case for removing a non-existent item.
     * Inserts a key-value pair and attempts to remove a key that doesn't exist in the hash table.
     */
    @Test
    public void testRemovingNonExistentItem() {
        HashTable hashTable = new HashTable();
        hashTable.insert(1, "One");
        hashTable.remove(2);
    }

    /**
     * Test case for searching existing keys.
     * Creates a hash table, inserts key-value pairs, and searches for existing keys,
     * asserting that the returned values match the expected values.
     */
    @Test
    public void testSearchExistingKey() {
        // Create a new hash table
        HashTable hashTable = new HashTable();

        // Insert key-value pairs
        hashTable.insert(1, "One");
        hashTable.insert(11, "Eleven");
        hashTable.insert(21, "Twenty-One");

        // Search for existing keys and assert the values
        Assert.assertEquals("One", hashTable.search(1));
        Assert.assertEquals("Eleven", hashTable.search(11));
        Assert.assertEquals("Twenty-One", hashTable.search(21));
    }

    /**
     * Test case for searching non-existing keys.
     * Creates a hash table, inserts key-value pairs, and searches for keys that don't exist,
     * asserting that the returned values are null.
     */
    @Test
    public void testSearchingNotExistingKey() {
        // Create a new hash table
        HashTable hashTable = new HashTable();

        // Insert key-value pairs
        hashTable.insert(1, "One");
        hashTable.insert(11, "Eleven");
        hashTable.insert(21, "Twenty-One");

        // Search for non-existing keys and assert null values
        Assert.assertNull(hashTable.search(5));
        Assert.assertNull(hashTable.search(15));
        Assert.assertNull(hashTable.search(25));
    }
}