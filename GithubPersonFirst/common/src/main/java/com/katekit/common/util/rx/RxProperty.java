package com.katekit.common.util.rx;

import io.reactivex.Observable;
import io.reactivex.processors.BehaviorProcessor;

/**
 * Project Name：workplace
 * Packagee Name：  com.chinanetcenter.broadband.util
 * Description：
 *
 * @author: huangmc
 * @date: 2015/10/14 17:07
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class RxProperty<T> {
    private final BehaviorProcessor<T> assignSubject = BehaviorProcessor.create();
    public final Observable<T> whenAssigned = assignSubject.toObservable();
    public final Observable<T> whenChanged = whenAssigned.distinctUntilChanged();

    private T value;
    public RxProperty() {
    }
    public RxProperty(T value) {
        this.set(value);
    }
    public T get() {
        return value;
    }
    public synchronized void set(T value) {
        this.value = value;
        this.assignSubject.onNext(value);
    }
}