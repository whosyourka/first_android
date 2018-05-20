package first.person.com.katekit.githubpersonfirst;

import android.app.Activity;
import android.os.Bundle;

import com.katekit.common.util.log.LogUtil;

import io.reactivex.Flowable;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.initLog();
        LogUtil.i("string i");
        LogUtil.d("string d");
        LogUtil.e("string e");
        LogUtil.i("string e");
        Flowable.just("")
                .map(it->{
                    LogUtil.i("string Flowable");
                    int a = 1;
                    int b = 0;
                    int c = 1/0;
                    return it;
                }).subscribe();

//        Observer observer = new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                System.out.println("ps:publishSubject");
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println("ps:onNext:"+s);
//                ToastUtil.show(MainActivity.this,"onNext");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                System.out.println("ps:onError:"+e.toString());
//                ToastUtil.show(MainActivity.this,"onError");
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("ps:onComplete");
//                ToastUtil.show(MainActivity.this,"onComplete");
//            }
//        };
//        TextView textView = findViewById(R.id.test);
//        TextView textView1 = findViewById(R.id.test1);
//
////        PublishSubject<String> publishSubject = PublishSubject.create();
////        publishSubject.subscribe(observer);
////        textView.setOnClickListener(v -> {
////            publishSubject.onNext("哈哈");
////        });
////        textView1.setOnClickListener(v -> {
////            publishSubject.onComplete();
////        });
//
////        PublishRelay<String> relay = PublishRelay.create();
////// observer1 will receive all events
////        relay.map(s -> {
////            if ("ss".equals(s)){
////                throw new Exception();
////            }else{
////                return s;
////            }
////        }).subscribe(observer);
////        textView.setOnClickListener(v -> {
////            relay.accept("哈哈");
////        });
////        textView1.setOnClickListener(v -> {
////            relay.accept("ss");
////        });
//
//
//        Observable.just("haha",2,"lala")
//                .subscribe(v ->{
//                    System.out.println("just:" + v);
//                });
//        Observable.just("haha",2,"lala")
//                .toList()
//                .subscribe(v ->{
//                    System.out.println("just:" + v.size());
//                });
//
//        Observable.just("haha",2,"lala")
//                .doOnNext(v-> System.out.println("just onnext"))
//                .doOnError(v->  System.out.println("just onerror"))
//                .toList()
//                .subscribe(v ->{
//                    System.out.println("just:" + v.size());
//                });


    }
}
