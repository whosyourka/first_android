package com.katekit.common.util.rx;


import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by »ÆÃ÷²Ó on 2017/10/23 10:06.
 */

public class RxUtil {

//    public final static FlowableTransformer schedulersTransformer = new FlowableTransformer() {
//        @Override
//        public Flowable apply(@NonNull Flowable upstream) {
//            return upstream.subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread());
//        }
//    };

//    @SuppressWarnings("unchecked")
//    public static <T> FlowableTransformer<T, T> applySchedulers() {
//        return (FlowableTransformer<T, T>) schedulersTransformer;
//    }

    public static <T> FlowableTransformer<T, T> toMain() {
        return new FlowableTransformer<T, T>() {

            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}

