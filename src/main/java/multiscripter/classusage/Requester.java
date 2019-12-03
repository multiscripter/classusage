package multiscripter.classusage;

import com.fasterxml.jackson.databind.ObjectMapper;
import multiscripter.classusage.models.Entry;
import multiscripter.classusage.models.Item;
import multiscripter.classusage.models.Main;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class Requester {

    private final String hub = "https://github.com";

    private HashMap<String, Entry> entries = new HashMap<>();

    public HashMap<String, Entry> getEntries() {
        return this.entries;
    }

    public Main requestMain() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/search/repositories?q=language:java";
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, Main.class);
    }

    public void processRepository(final Item repository) throws Exception {
        this.processRef(repository.getHtmlUrl(), repository.getHtmlUrl());
    }

    public void processRef(final String url, final String root) throws Exception {
        System.err.println("processing: " + url);
        Document doc = Jsoup.connect(url).get();
        Elements refs = doc.select(".files .js-navigation-open");
        if (refs != null && refs.size() > 0) {
            for (Element ref : refs) {
                String href = ref.attr("href");
                if (href.endsWith(".java")) {
                    this.processJava(this.hub + href);
                } else if (!href.contains("/.")) {
                    String[] fragments = href.split("/");
                    if (!fragments[fragments.length - 1].contains(".")
                    && !"..".equals(ref.ownText())
                    && !root.equals(this.hub + href)) {
                        this.processRef(this.hub + href, root);
                    }
                }
            }
        }
    }

    public void processJava(final String url) throws Exception {
        Document doc = Jsoup.connect(url).get();
        Elements lines = doc.select(".js-file-line");
        for (Element line : lines) {
            if (line.select(".pl-k").text().contains("import")) {
                String fullClassName = line.select(".pl-smi").text();
                if (this.entries.containsKey(fullClassName)) {
                    this.entries.get(fullClassName).increment();
                } else {
                    this.entries.put(fullClassName, new Entry(fullClassName));
                }
            }
        }
    }
}
