package multiscripter.classusage;

import multiscripter.classusage.models.Entry;
import multiscripter.classusage.models.Main;
import org.junit.Test;
import java.util.TreeSet;

public class RequesterTests {

    @Test
    public void test() throws Exception {
        Requester requester = new Requester();
        Main repos = requester.requestMain();
//        for (Item item : repos.getItems()) {
//            System.out.println(item);
        requester.processRepository(repos.getItems()[1]);
        TreeSet<Entry> tree
            = new TreeSet<>((e1, e2) -> e1.getCount() < e2.getCount() ? 1
            : e1.getCount() > e2.getCount() ? -1 : (
                    e1.getName().compareToIgnoreCase(e2.getName())
                ));
        tree.addAll(requester.getEntries().values());
        for (Entry entry : tree) {
            System.out.println(entry);
        }
//        }
    }
}
