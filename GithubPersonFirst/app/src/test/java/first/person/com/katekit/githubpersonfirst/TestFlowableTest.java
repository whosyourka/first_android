package first.person.com.katekit.githubpersonfirst;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.schedulers.TestScheduler;
import io.reactivex.subscribers.TestSubscriber;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by 黄明灿 on 2018/6/12 19:43.
 * Describe :
 */
public class TestFlowableTest {
    @Test
    public void myAll() {
        TestFlowable.myAll().test().assertValue(true);
        TestFlowable.myAll().test().assertValue(false);
    }

    @Test
    public void myContains() {
        TestFlowable.myContains().test().assertValue(true);
    }

    @Test
    public void myEmpty() {
        TestFlowable.myEmpty().test().assertValue(true);
    }

    @Test
    public void myDefaultEmpty() {
        TestFlowable.myDefaultEmpty().test().assertValue("haha");
    }

    @Test
    public void myPublish() {
        TestFlowable.myPublish().test().assertComplete();
        TestFlowable.myPublish().test().assertComplete();
    }



    @Test
    public void myRangeSample() {
        TestScheduler scheduler = new TestScheduler();
        TestSubscriber<Long> testObserver = TestFlowable.myRangeSample(scheduler).test();

        scheduler.advanceTimeTo(12, SECONDS);
        testObserver.assertValueCount(1000);

//        scheduler.advanceTimeTo(9, SECONDS);
//        testObserver.assertValueCount(0);
    }

    @Test
    public void myInterval() {
        TestScheduler scheduler = new TestScheduler();
        TestSubscriber<Long> testObserver = TestFlowable.myInterval(scheduler).test();


        scheduler.advanceTimeBy(9, SECONDS);
        testObserver.assertValueCount(1);
        scheduler.advanceTimeBy(1, SECONDS);
        testObserver.assertValueCount(2);

        scheduler.advanceTimeTo(10, SECONDS);
        testObserver.assertValueCount(2);
        scheduler.advanceTimeTo(10, SECONDS);
        testObserver.assertValueCount(2);

//        scheduler.advanceTimeTo(1000, SECONDS);
//        testObserver.assertValueCount(100)
//            .assertValueAt(0,it -> it == 0)
//            .assertValueAt(3,it -> it == 3);
    }
    @Test
    public void myConnect() {
        TestScheduler scheduler = new TestScheduler();
        ConnectableFlowable<Long> flowable = TestFlowable.myConnect(scheduler);
        TestSubscriber testObserver = flowable.test();
        flowable.subscribe(it->{
            System.out.println("haha");
        });
        flowable.subscribe(it->{
            System.out.println("lala");
        });

        scheduler.advanceTimeBy(10, SECONDS);
        testObserver.assertValueCount(0);
        flowable.connect();
        scheduler.advanceTimeBy(10, SECONDS);
        testObserver.assertValueCount(2);
    }
    @Test
    public void myRefCount() {
        TestScheduler scheduler = new TestScheduler();
        Flowable<Long> flowable = TestFlowable.myRefCount(scheduler);
        TestSubscriber testObserver = flowable.test();
        flowable.subscribe(it->{
            System.out.println("haha");
        });
        flowable.subscribe(it->{
            System.out.println("lala");
        });

        scheduler.advanceTimeBy(10, SECONDS);
        testObserver.assertValueCount(2);
        flowable.subscribe(it->{
            System.out.println("gaga");
        });
        scheduler.advanceTimeBy(10, SECONDS);
        testObserver.assertValueCount(3);

    }
    @Test
    public void myReplay() {
        TestScheduler scheduler = new TestScheduler();
        ConnectableFlowable<Long> flowable = TestFlowable.myReplay(scheduler);
        TestSubscriber testObserver = flowable.test();

        flowable.subscribe(it->{
            System.out.println("haha");
        });
        flowable.subscribe(it->{
            System.out.println("lala");
        });
        flowable.connect();
        scheduler.advanceTimeBy(20, SECONDS);
        testObserver.assertValueCount(3);

        flowable.subscribe(it->{//会多调用2次
            System.out.println("gaga");
        });
        scheduler.advanceTimeBy(10, SECONDS);
        testObserver.assertValueCount(4);

    }



}