import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckNumberTest {
    CheckNumber cn;

    @BeforeEach
    void setUp(){
        cn = new CheckNumber();
    }

    @Test
    void testEven(){
        assertEquals(true, cn.isEven(2) );
    }


    @Test
    void testOdd(){
        assertEquals(false, cn.isEven(3) );
    }
}
