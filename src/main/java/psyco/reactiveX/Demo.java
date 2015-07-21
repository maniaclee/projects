package psyco.reactiveX;

import com.google.common.collect.Lists;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by lipeng on 15/7/20.
 */
public class Demo {
    static Observable<String> OBSERVABLE = Observable.just("Hello, world!");
    static Subscriber SUBSCRIBER = new Subscriber() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Object o) {
            System.out.println(o);
        }
    };

    @Test
    /**
     * Observable.just就是用来创建只发出一个事件就结束的Observable对象
     */
    public void just() {
        Observable<String> myObservable = Observable.just("Hello, world!");
        myObservable.subscribe(s -> System.out.println(s));
    }

    /**
     * subscribe方法有一个重载版本，接受三个Action1类型的参数，分别对应OnNext，OnComplete， OnError函数
     */
    public void subscribeAction() {
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
        OBSERVABLE.subscribe(s -> System.out.println(s), null, null);
        /*这里调用的不是subscriber，而是Action1*/
        OBSERVABLE.subscribe(onNextAction);
    }

    public void method() {
        OBSERVABLE.map(e -> e.concat("---shit")).delay(1, TimeUnit.SECONDS).repeat(3).subscribe(SUBSCRIBER);
    }

    public void from() {
        List<String> list = Lists.newArrayList("fuck", "you", "shit", "sdfsdf");
    }


    @Test
    public void testFlatMap() {
        List<List<String>> s = Lists.newArrayList(Lists.newArrayList("shif", "fuck"), Lists.newArrayList("shif", "fuck"));
        List<String> re = s.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(re);
    }

}
