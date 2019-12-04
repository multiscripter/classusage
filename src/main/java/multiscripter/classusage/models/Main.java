package multiscripter.classusage.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Realizes entity "Main response".
 *
 * @author Multiscripter
 * @version 2019-12-04
 * @since 2019-12-04
 */
public class Main {

    /**
     * Total count of repositories.
     */
    @JsonProperty("total_count")
    private Long count;

    /**
     * result status. "true" if incomplete. Otherwise "false";
     */
    @JsonProperty("incomplete_results")
    private boolean incompleteResults;

    /**
     * Repository array.
     */
    @JsonProperty("items")
    private Item[] repositories;

    /**
     * Gets total count of repositories.
     *
     * @return total count of repositories.
     */
    public Long getCount() {
        return this.count;
    }

    /**
     * Sets total count of repositories.
     *
     * @param totalCount total count of repositories.
     */
    public void setCount(final Long totalCount) {
        this.count = totalCount;
    }

    /**
     * Returns incomplete results status.
     *
     * @return incomplete results status.
     */
    public boolean isIncompleteResults() {
        return this.incompleteResults;
    }

    /**
     * Sets incomplete results status.
     *
     * @param status incomplete results status.
     */
    public void setIncompleteResults(final boolean status) {
        this.incompleteResults = status;
    }

    /**
     * Gets repositories array.
     *
     * @return repositories array.
     */
    public Item[] getItems() {
        return this.repositories;
    }

    /**
     * Sets repositories array.
     *
     * @param items repositories array.
     */
    public void setItems(final Item[] items) {
        this.repositories = items;
    }

    /**
     * Checks items for null.
     *
     * @return true if items is null.
     */
    public boolean isItemsNull() {
        return this.repositories == null;
    }

    /**
     * Checks items for zero length.
     *
     * @return true if items have zero length.
     */
    public boolean isItemsZero() {
        return this.repositories.length == 0;
    }
}
