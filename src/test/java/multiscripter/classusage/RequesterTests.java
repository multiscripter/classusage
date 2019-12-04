package multiscripter.classusage;

import java.util.TreeSet;
import multiscripter.classusage.models.Entry;
import org.junit.Test;

/**
 * Tests application.
 */
public class RequesterTests {

    @Test
    public void test() throws Exception {
        Engine engine = new Engine(5);
        engine.start();
        System.out.println("-------------------------------------------------");

        TreeSet<Entry> tree
            = new TreeSet<>((e1, e2) -> e1.getCount() < e2.getCount() ? 1
            : e1.getCount() > e2.getCount() ? -1 : (
                    e1.getName().compareToIgnoreCase(e2.getName())
                ));
        tree.addAll(engine.getStorage().getEntries().values());

        System.out.println("------------- Top 100 used classes -------------");
        int top = 0;
        for (Entry entry : tree) {
            System.out.println(entry);
            if (++top == 100) {
                break;
            }
        }
    }
}
