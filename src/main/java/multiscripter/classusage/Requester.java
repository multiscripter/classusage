package multiscripter.classusage;

import com.fasterxml.jackson.databind.ObjectMapper;
import multiscripter.classusage.models.Main;
import org.springframework.web.client.RestTemplate;

/**
 * Realizes entity "Github requester".
 *
 * @author Multiscripter
 * @version 2020-03-31
 * @since 2019-12-11
 */
class Requester {

    /**
     * Make main request.
     *
     * @param page current page number
     * @param perPage items per page.
     * @return object with request results;
     * @throws Exception any exception.
     */
    Main request(final int page, final int perPage) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url
            = "https://api.github.com/search/repositories?q=language:java";
        if (page > 1) {
            url += "&page=" + page;
        }
        if (perPage != Engine.PER_PAGE) {
            url += "&per_page=" + Engine.PER_PAGE;
        }
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, Main.class);
    }
}
