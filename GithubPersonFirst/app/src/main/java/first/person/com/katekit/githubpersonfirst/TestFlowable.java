package first.person.com.katekit.githubpersonfirst;

import io.reactivex.Flowable;

/**
 * Created by 黄明灿 on 2018/6/12 19:41.
 * Describe :
 */
public class TestFlowable {
    public static Flowable myAll(){
        return Flowable.just("","ss")
                .map(it->{
                    System.out.print("it:"+it);
                    return it;
                }).all(it -> !(it.isEmpty())).toFlowable();
    }

    public static Flowable myContains(){
        return Flowable.just("11","ss","22","ss")
                .map(it->{
                    System.out.print("it:"+it);
                    return it;
                }).contains("ss").toFlowable();
    }
}
