package com.katekit.common.util;

import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

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
    private final BehaviorSubject<T> assignSubject = BehaviorSubject.create();
    public final Observable<T> whenAssigned = assignSubject.asObservable();
    public final Observable<T> whenChanged = whenAssigned.distinctUntilChanged();
    private Subscription subscription = null;
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
    public void binding(Observable<T> observable) {
        this.unbinding();
        this.subscription = observable.subscribe(x -> this.set(x));
    }
    public void unbinding() {
        if (this.subscription != null) {
            this.subscription.unsubscribe();
            this.subscription = null;
        }
    }
}