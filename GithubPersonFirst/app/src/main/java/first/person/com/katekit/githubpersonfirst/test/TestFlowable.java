package first.person.com.katekit.githubpersonfirst.test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;

/**
 * Created by 黄明灿 on 2018/6/12 19:41.
 * Describe :
 */
public class TestFlowable {
    public static Flowable myAll() {
        return Flowable.just("", "ss")
                .map(it -> {
                    System.out.println("it:" + it);
                    return it;
                }).all(it -> !(it.isEmpty())).toFlowable();
    }

    public static Flowable myContains() {
        return Flowable.just("11", "ss", "22", "ss")
                .map(it -> {
                    System.out.println("it:" + it);
                    return it;
                }).contains("ss").map(it -> {
                    System.out.println("it contains:" + it);
                    return it;
                }).toFlowable();
    }

    public static Flowable myEmpty() {
        return Flowable.just("11", "ss", "22", "ss")
                .map(it -> {
                    System.out.println("it:" + it);
                    return it;
                }).filter(it -> false).isEmpty().map(it -> {
                    System.out.println("it contains:" + it);
                    return it;
                }).toFlowable();
    }

    public static Flowable myDefaultEmpty() {
        return Flowable.just("11", "ss", "22", "ss")
                .map(it -> {
                    System.out.println("it:" + it);
                    return it;
                }).filter(it -> false).defaultIfEmpty("haha").map(it -> {
                    System.out.println("it contains:" + it);
                    return it;
                });
    }

    public static Flowable myPublish() {
        return Flowable.just("11")
                .map(it -> {
                    System.out.println("it:" + it);
                    return it;
                });
    }

    public static Flowable myRangeSample(Scheduler scheduler) {
        return Flowable.range(0, 1000).sample(10, TimeUnit.SECONDS,scheduler)
                .map(it -> {
                    System.out.println("it:" + it);
                    return it;
                });
    }

    public static Flowable<Long> myInterval(Scheduler scheduler) {
        return Flowable.merge(Flowable.just(-1L),Flowable.interval(10, TimeUnit.SECONDS,scheduler))
                .map(it -> {
                    System.out.println("it:" + it);
                    return it;
                }).take(100);
    }

    public static ConnectableFlowable<Long> myConnect(Scheduler scheduler) {
        return Flowable.merge(Flowable.just(-1L),Flowable.interval(10, TimeUnit.SECONDS,scheduler))
                .map(it -> {
                    System.out.println("it:" + it);
                    return it;
                }).take(100).publish();
    }
    public static Flowable<Long> myRefCount(Scheduler scheduler) {
        return Flowable.merge(Flowable.just(-1L),Flowable.interval(10, TimeUnit.SECONDS,scheduler))
                .map(it -> {
                    System.out.println("it:" + it);
                    return it;
                }).take(100)
                .publish().refCount();
//                .share();
    }
    public static ConnectableFlowable<Long> myReplay(Scheduler scheduler) {
        return Flowable.merge(Flowable.just(-1L),Flowable.interval(10, TimeUnit.SECONDS,scheduler))
                .map(it -> {
                    System.out.println("it:" + it);
                    return it;
                }).take(100)
                .replay();
//                .share();
    }
    public static void myMaterialize() {
        Byte a = 1;
        Integer b = a.intValue();
        Flowable.just("").materialize().subscribe(it->{
            System.out.println("it:" + it.getValue());
        },e->{
            System.out.println("er:" + e.getMessage());
        },()->{
            System.out.println("com:");
        });
    }
}
