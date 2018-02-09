package com.katekit.common.util.rx;


import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by »ÆÃ÷²Ó on 2017/10/23 10:06.
 */

public class RxUtil {
//    FlowableTransformer<Object, Object> myTransformer = new FlowableTransformer<Object, Object>() {
//        @Override
//        public Publisher<Object> apply(@NonNull Flowable<Object> upstream) {
//            return null;
//        }
//    };

    public final static FlowableTransformer schedulersTransformer = new FlowableTransformer() {
        @Override
        public Flowable apply(@NonNull Flowable upstream) {
            return upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    FlowableTransformer schedulersTransformers = new FlowableTransformer() {
        @Override
        public Publisher apply(@NonNull final Flowable upstream) {
            return Flowable.create(new FlowableOnSubscribe() {
                @Override
                public void subscribe(@NonNull FlowableEmitter e) throws Exception {
                    upstream.subscribe(new Consumer() {
                        @Override
                        public void accept(Object o) throws Exception {

                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    });
                }
            }, BackpressureStrategy.LATEST);
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> FlowableTransformer<T, T> applySchedulers() {
        return (FlowableTransformer<T, T>) schedulersTransformer;
    }

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

