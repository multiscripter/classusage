package multiscripter.classusage;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import multiscripter.classusage.models.EntryStorage;
import multiscripter.classusage.models.Item;
import multiscripter.classusage.models.Main;

/**
 * Realizes entity "App engine".
 *
 * @author Multiscripter
 * @version 2019-12-04
 * @since 2019-12-04
 */
public class Engine {

    /**
     * Entry storage.
     */
    private EntryStorage storage;

    /**
     * Thread pool.
     */
    private ExecutorService pool;

    /**
     * Thread list.
     */
    private ArrayList<RepoProcessor> threads;

    /**
     * Constructor.
     *
     * @param threadCount thread count.
     */
    public Engine(final int threadCount) {
        this.pool = Executors.newFixedThreadPool(threadCount);
        this.storage = new EntryStorage();
        this.threads = new ArrayList<>();
    }

    /**
     * Gets entry storage.
     *
     * @return entry storage.
     */
    public EntryStorage getStorage() {
        return this.storage;
    }

    /**
     * App entry point.
     *
     * @param args string array of launch arguments.
     */
    public static void main(final String[] args) {
        try {
            int threadCount = Runtime.getRuntime().availableProcessors();
            new Engine(threadCount).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Start the Engine.
     *
     * @throws Exception any exception.
     */
    public void start() throws Exception {
        Requester requester = new Requester();
        Main repos = requester.request();
        if (repos.isItemsNull()) {
            System.err.println("Main.items is null");
        } else if (repos.isItemsZero()) {
            System.err.println("Main.items.length is zero");
        } else {
            for (Item item : repos.getItems()) {
                this.threads.add(new RepoProcessor(this.storage, item));
            }
            ArrayList<Future> futureList = new ArrayList<>();
            for (RepoProcessor thread : this.threads) {
                futureList.add(this.pool.submit(thread));
            }
            for (Future item : futureList) {
                item.get();
            }
        }
    }
}
