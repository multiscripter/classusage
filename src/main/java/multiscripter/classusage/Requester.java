package multiscripter.classusage;

import com.fasterxml.jackson.databind.ObjectMapper;
import multiscripter.classusage.models.Main;
import org.springframework.web.client.RestTemplate;

/**
 * Realizes entity "Github requester".
 *
 * @author Multiscripter
 * @version 2019-12-04
 * @since 2019-12-04
 */
public class Requester {

    /**
     * Make main request.
     *
     * @return object with request results;
     * @throws Exception any exception.
     */
    public Main request() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url
            = "https://api.github.com/search/repositories?q=language:java";
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, Main.class);
    }
}
