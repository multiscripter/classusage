package multiscripter.classusage.models;

import java.util.Objects;

/**
 * Realizes entity "Full class name occurrences quantity".
 *
 * @author Multiscripter
 * @version 2019-12-04
 * @since 2019-12-04
 */
public class Entry {

    /**
     * Full class name.
     */
    private String name;

    /**
     * Occurrences quantity.
     */
    private long count;

    /**
     * Constructor.
     *
     * @param fullClassName full class name.
     */
    public Entry(final String fullClassName) {
        this.count = 1;
        this.name = fullClassName;
    }

    /**
     * Compares current object with another one.
     *
     * @param o another object.
     * @return true if objects are equal. Otherwise false.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry that = (Entry) o;
        return this.count == that.getCount()
            && Objects.equals(this.name, that.getName());
    }

    /**
     * Computes and returns object hash.
     *
     * @return object hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.count);
    }

    /**
     * Increment occurrences quantity.
     */
    public void increment() {
        this.count++;
    }

    /**
     * Gets full class name.
     *
     * @return full class name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets full class name.
     *
     * @param fullClassName full class name.
     */
    public void setName(final String fullClassName) {
        this.name = fullClassName;
    }

    /**
     * Gets occurrences quantity.
     *
     * @return occurrences quantity.
     */
    public long getCount() {
        return this.count;
    }

    /**
     * Sets occurrences quantity.
     *
     * @param quantity occurrences quantity.
     */
    public void setCount(final long quantity) {
        this.count = quantity;
    }

    /**
     * Returns string representation of object.
     *
     * @return string representation of object.
     */
    @Override
    public String toString() {
        return String.format("Entry{count: %d, name: %s",
            this.count, this.name);
    }
}
