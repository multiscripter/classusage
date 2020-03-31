package multiscripter.classusage.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Realizes entity "Document receiver".
 *
 * @author Multiscripter
 * @version 2020-03-31
 * @since 2020-03-31
 */
public class DocumentReceiver {

    /**
     * Counter.
     */
    private int counter;

    /**
     * Monitor.
     */
    private final Object lock;

    private final int max;

    public DocumentReceiver() {
        this.counter = 0;
        this.lock = this;
        this.max = 30;
    }

    public Document getDocument(final String url) throws Exception {
        synchronized (this.lock) {
            Document doc = null;
            try {
                while (this.counter >= this.max) {
                    this.lock.wait(1000);
                }
                this.counter++;
                doc = Jsoup.connect(url).get();
            } catch (Exception ex) {
                throw new Exception(ex);
            } finally {
                this.counter--;
                this.lock.notifyAll();
            }
            return doc;
        }
    }
}
