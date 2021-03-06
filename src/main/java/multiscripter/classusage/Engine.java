package multiscripter.classusage;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import multiscripter.classusage.models.EntryStorage;
import multiscripter.classusage.models.Item;
import multiscripter.classusage.models.Main;
import multiscripter.classusage.models.DocumentReceiver;

/**
 * Realizes entity "App engine".
 *
 * @author Multiscripter
 * @version 2020-03-31
 * @since 2019-12-11
 */
public class Engine {

    /**
     * Current page number.
     */
    private int page = 1;

    /**
     * Items per page (default github value).
     */
    static final int PER_PAGE = 30;

    /**
     * Thread pool.
     */
    private ExecutorService pool;

    /**
     * Document receiver.
     */
    private DocumentReceiver receiver;

    /**
     * Entry storage.
     */
    private EntryStorage storage;

    /**
     * Constructor.
     *
     * @param threadCount thread count.
     */
    Engine(final int threadCount) {
        this.pool = Executors.newFixedThreadPool(threadCount);
        this.receiver = new DocumentReceiver();
        this.storage = new EntryStorage();
    }

    /**
     * Gets entry storage.
     *
     * @return entry storage.
     */
    EntryStorage getStorage() {
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
    void start() throws Exception {
        Requester requester = new Requester();
        Main repos;
        do {
            repos = requester.request(this.page, PER_PAGE);
            if (repos.isItemsNull()) {
                System.err.println("Main.items is null");
                break;
            } else if (repos.isItemsZero()) {
                System.err.println("Main.items.length is zero");
                break;
            } else {
                ArrayList<Future> futureList = new ArrayList<>();
                for (Item item : repos.getItems()) {
                    RepoProcessor thread
                        = new RepoProcessor(this.storage, item, this.receiver);
                    futureList.add(this.pool.submit(thread));
                }
                for (Future item : futureList) {
                    item.get();
                }
            }
        } while (repos.getCount() > this.page++ * PER_PAGE);
    }
}
