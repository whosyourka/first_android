package first.person.com.katekit.githubpersonfirst;

import org.junit.Test;

/**
 * Created by 黄明灿 on 2018/6/12 19:43.
 * Describe :
 */
public class TestFlowableTest {
    @Test
    public void testMyAll() {
        TestFlowable.myAll().test().assertValue(true).assertValue(false);
        TestFlowable.myAll().test().assertValue(false).assertValue(true);
    }

    @Test
    public void myContains() {
        TestFlowable.myAll().test().assertValue(true).assertValue(false);
    }
}