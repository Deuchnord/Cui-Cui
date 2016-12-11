package fr.tanghevandekadsye.jee;

import fr.tanghevandekadsye.jee.entity.Message;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class MessageTest {

    @Test
    public void testParseHashtags() {
        List<String> hashtags = Message.parseHashtags("Hello World! #PremierGazouillis #TestUnitaire");

        assertEquals(2, hashtags.size());
        assertEquals("#PremierGazouillis", hashtags.get(0));
        assertEquals("#TestUnitaire", hashtags.get(1));
    }

}
