package psyco.reactiveX;

import com.google.common.collect.Lists;
import org.junit.Test;
import rx.Observable;
import rx.functions.Func1;

import java.util.List;

/**
 * Created by lipeng on 15/7/20.
 */
public class OperatorDemo {

    public Observable<List<String>> query(String text) {
        return Observable.just(Lists.newArrayList("fuck", "you", "shit", "baster"));
    }

    Observable<String> getTitle(String s) {
        return Observable.just(s.substring(0, 1));
    }

    @Test
    public void stupid() {
//        Observable.from(new String[]{"url1", "url2", "url3", "url"}).subscribe(url -> System.out.println(url));
        query("Hello, world!").subscribe(urls -> urls.forEach(e -> System.out.println(e)));

    }

    @Test
    public void app() {
        /**flatMap:             把一个Observable转换成另一个Observable
         * Observable.from(List):   that takes a collection of items and emits each them one at a time
         * */
        query("Hello, world!")
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> urls) {
                        return Observable.from(urls);
                    }
                })
                .subscribe(url -> System.out.println(url));
        /** Observable.from(), that takes a collection of items and emits each them one at a time */
        query("Hello, world!")
                .flatMap(urls -> Observable.from(urls))
                .subscribe(title -> System.out.println(title));
    }
}

