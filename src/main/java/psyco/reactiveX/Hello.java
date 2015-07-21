package psyco.reactiveX;

import com.google.common.collect.Lists;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by lipeng on 15/7/20.
 */
public class Hello {
    Observable<String> myObservable = Observable.create(
            new Observable.OnSubscribe<String>() {
                @Override
                public void call(Subscriber<? super String> sub) {
                    sub.onNext("Hello, world!");
                    sub.onCompleted();
                }
            }
    );

    Observable<String> myObservablex = Observable.create(subscriber -> {
        subscriber.onNext("Hello, world!");
        subscriber.onCompleted();
    });

    Subscriber<String> mySubscriber = new Subscriber<String>() {
        @Override
        public void onNext(String s) {
            System.out.println(s);
        }

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }
    };

    @Test
    public void tes() {
//        myObservable.subscribe(mySubscriber);
        Observable.just("Hello, worldXXX!").subscribe(s -> System.out.println(s));
        Observable.just("Hello, worldXXX!").map(e -> e + " fuckyou").map(e -> Lists.newArrayList(e)).subscribe(s -> System.out.println(s + "\t" + s.getClass().getName()));
    }

}
