package multiscripter.classusage.models;

import java.util.HashMap;

/**
 * Realizes entity "Entry storage".
 *
 * @author Multiscripter
 * @version 2019-12-04
 * @since 2019-12-04
 */
public class EntryStorage {

    /**
     * Entry storage.
     */
    private HashMap<String, Entry> entries;

    /**
     * Monitor.
     */
    private final Object lock;

    /**
     * Constructor.
     */
    public EntryStorage() {
        this.entries = new HashMap<>();
        this.lock = this;
    }

    /**
     * Gets entry storage.
     *
     * @return entry storage.
     */
    public HashMap<String, Entry> getEntries() {
        return this.entries;
    }

    /**
     * Adds full class name to storage if it not exists or increase name count.
     *
     * @param fullClassName full class name.
     */
    public void addOrIncrease(final String fullClassName) {
        synchronized (this.lock) {
            if (this.entries.containsKey(fullClassName)) {
                this.entries.get(fullClassName).increment();
            } else {
                this.entries.put(fullClassName, new Entry(fullClassName));
            }
        }
    }
}
