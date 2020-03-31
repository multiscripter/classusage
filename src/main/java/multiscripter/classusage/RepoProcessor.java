package multiscripter.classusage;

import multiscripter.classusage.models.EntryStorage;
import multiscripter.classusage.models.Item;
import multiscripter.classusage.models.DocumentReceiver;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Realizes entity "Repository processor".
 *
 * @author Multiscripter
 * @version 2020-03-31
 * @since 2019-12-04
 */
public class RepoProcessor implements Runnable {

    /**
     * GitHub base URL.
     */
    private static final String HUB = "https://github.com";

    /**
     * Processed HTML-references.
     */
    private int processed;

    /**
     * Document receiver.
     */
    private DocumentReceiver receiver;

    /**
     * GitHub repository.
     */
    private Item repo;

    /**
     * Entry storage.
     */
    private EntryStorage storage;

    /**
     * Constructor.
     *
     * @param entryStorage entry storage.
     * @param receiver document receiver.
     * @param repository gitHub repository.
     */
    RepoProcessor(
            final EntryStorage entryStorage,
            final Item repository,
            final DocumentReceiver receiver) {
        this.storage = entryStorage;
        this.receiver = receiver;
        this.repo = repository;
    }

    /**
     * Starts thread.
     */
    @Override
    public void run() {
        try {
            this.processRef(this.repo.getHtmlUrl(), this.repo.getHtmlUrl());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Process html reference.
     *
     * @param url html reference.
     * @param root html reference.
     * @throws Exception any exception.
     */
    private void processRef(final String url, final String root)
        throws Exception {
        System.err.format("Repo: %s. Processed refs: %d%s",
            this.repo.getName(), this.processed, System.lineSeparator());
        Document doc = this.getDocument(url);
        if (doc != null) {
            Elements refs = doc.select(".files .js-navigation-open");
            if (refs != null && refs.size() > 0) {
                for (Element ref : refs) {
                    String href = ref.attr("href");
                    if (href.endsWith(".java")) {
                        this.processJava(HUB + href);
                    } else if (!href.contains("/.")) {
                        String[] fragments = href.split("/");
                        if (!fragments[fragments.length - 1].contains(".")
                                && !"..".equals(ref.ownText())
                                && !root.equals(HUB + href)) {
                            this.processRef(HUB + href, root);
                        }
                    }
                }
            }
            this.processed++;
        } else {
            System.err.println("processRef(). NULL for " + url);
        }
    }

    /**
     * Process java file.
     *
     * @param url java file URL.
     * @throws Exception any exception.
     */
    private void processJava(final String url) throws Exception {
        Document doc = this.getDocument(url);
        if (doc != null) {
            Elements lines = doc.select(".js-file-line");
            for (Element line : lines) {
                if (line.select(".pl-k").text().contains("import")) {
                    String fullClassName = line.select(".pl-smi").text();
                    this.storage.addOrIncrease(fullClassName);
                }
            }
        } else {
            System.err.println("processJava(). NULL for " + url);
        }
    }

    private synchronized Document getDocument(String url) throws Exception {
        while (true) {
            try {
                return this.receiver.getDocument(url);
            } catch (Exception ex) {
                if (!ex.toString().contains("Status=429")) {
                    ex.printStackTrace();
                    break;
                }
                System.err.println(ex.toString());
                this.wait(1000);
            }
        }
        return null;
    }
}
