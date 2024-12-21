package com.example.subjectrxjava;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="myApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //DemoAsyncSubject();
        //DemoAsyncSubject1();
        //BehaviorSubject();
        //BehaviorSubject1();
        //PublishSubject();
        //PublishSubject1();
        //ReplaySubject();
        ReplaySubject1();



    }

    public void PublishSubject1() {
        PublishSubject<String> publishSubject=PublishSubject.create();
        publishSubject.subscribe(get1stObserver());
        publishSubject.onNext("Y");
        publishSubject.onNext("X");
        publishSubject.onNext("z");
        publishSubject.subscribe(get2stObserver());
        publishSubject.onNext("XYZ");
        publishSubject.subscribe(get3stObserver());
        publishSubject.onNext("Illuminati");
        publishSubject.onComplete();
    }

    public void ReplaySubject(){
        Observable<String> myObservable=Observable.just("Shri","Radha","Kishori","Shri Radha Krishna");

        ReplaySubject<String> replaySubject=ReplaySubject.create();
        myObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(replaySubject);


        // myObservable.subscribe(behaviorSubject);

        replaySubject.subscribe(get1stObserver());
        replaySubject.subscribe(get2stObserver());
        replaySubject.subscribe(get3stObserver());
    }
    public void ReplaySubject1() {
        ReplaySubject<String> replaySubject=ReplaySubject.create();
        replaySubject.subscribe(get1stObserver());
        replaySubject.onNext("Y");
        replaySubject.onNext("X");
        replaySubject.onNext("z");
        replaySubject.subscribe(get2stObserver());
        replaySubject.onNext("XYZ");
        replaySubject.subscribe(get3stObserver());
        replaySubject.onNext("Illuminati");
        replaySubject.onComplete();
    }

    public void PublishSubject(){
        Observable<String> myObservable=Observable.just("Shri","Radha","Kishori","Shri Radha Krishna");

        PublishSubject<String> publishSubject=PublishSubject.create();
        myObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(publishSubject);


        // myObservable.subscribe(behaviorSubject);

        publishSubject.subscribe(get1stObserver());
        publishSubject.subscribe(get2stObserver());
        publishSubject.subscribe(get3stObserver());
    }
    public void BehaviorSubject1() {
        BehaviorSubject<String> behaviorSubject=BehaviorSubject.create();
        behaviorSubject.subscribe(get1stObserver());
        behaviorSubject.onNext("Y");
        behaviorSubject.onNext("X");
        behaviorSubject.onNext("z");
        behaviorSubject.subscribe(get2stObserver());
        behaviorSubject.onNext("XYZ");
        //behaviorSubject.onComplete();
        behaviorSubject.subscribe(get3stObserver());
        behaviorSubject.onNext("Illuminati");
        behaviorSubject.onComplete();
    }

    public void BehaviorSubject(){
        Observable<String> myObservable=Observable.just("Shri","Radha","Kishori","Shri Radha Krishna");

        BehaviorSubject<String> behaviorSubject=BehaviorSubject.create();
        myObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(behaviorSubject);


       // myObservable.subscribe(behaviorSubject);

        behaviorSubject.subscribe(get1stObserver());
        behaviorSubject.subscribe(get2stObserver());
        behaviorSubject.subscribe(get3stObserver());
    }

    private void DemoAsyncSubject1() {
        AsyncSubject<String> asyncSubject=AsyncSubject.create();
        asyncSubject.subscribe(get1stObserver());
        asyncSubject.onNext("Y");
        asyncSubject.onNext("X");
        asyncSubject.onNext("z");
        asyncSubject.subscribe(get2stObserver());
        asyncSubject.onNext("XYZ");
        asyncSubject.onComplete();

    }

    public void DemoAsyncSubject(){
        Observable<String> myObservable=Observable.just("Shri","Radha","Kishori","Shri Radha Krishna");
        myObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        AsyncSubject<String> asyncSubject=AsyncSubject.create();
        myObservable.subscribe(asyncSubject);
        asyncSubject.subscribe(get1stObserver());
        asyncSubject.subscribe(get2stObserver());
        asyncSubject.subscribe(get3stObserver());
    }

    Observer<String> get1stObserver(){
        return new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG, "onSubscribe: 1st" );
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.e(TAG, "onNext:1st "+s );
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "onError: "+e );

            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: 1st " );
            }
        };
    }
    Observer<String> get2stObserver(){
        return new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG, "onSubscribe: 2nd" );
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.e(TAG, "onNext:2nd "+s );
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "onError: "+e );

            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: 2nd " );
            }
        };
    }
    Observer<String> get3stObserver(){
        return new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG, "onSubscribe: 3rd" );
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.e(TAG, "onNext:3rd "+s );
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "onError: "+e );

            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: 3rd " );
            }
        };
    }

}
