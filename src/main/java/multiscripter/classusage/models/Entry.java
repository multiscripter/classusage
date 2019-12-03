package multiscripter.classusage.models;

import java.util.Objects;

public class Entry {

    private String name;

    private long count;

    public Entry(final String name) {
        this.count = 1;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
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

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.count);
    }

    public void increment() {
        this.count++;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(final long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("Entry{count: %d, name: %s",
            this.count, this.name);
    }
}
