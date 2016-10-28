package training;

import rx.Observable;
import rx.Observer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by a on 26/10/2016.
 */
public class RxJavaExample4 {

    public static Observable<String> getFirst2Letters(String s) {
        return Observable.just(s.substring(0, 2));
    }

    public static void main(String[] args) {

        Observable<List<String>> just = Observable.just(Arrays.asList("one", "two", "three", "ok", "aha!!!!", "zahhhhhhqaa"));


//        just.subscribe(it -> System.out.println(it));

//        just.subscribe(new Action1<List<String>>() {
//            @Override
//            public void call(List<String> strings) {
//                Observable.from(strings)
//                        .subscribe(s -> System.out.println(s));
//            }
//        });

        just
                .flatMap(it -> Observable.from(it))
                .flatMap(it -> getFirst2Letters(it))
                .map(it -> it.toUpperCase())
                .map(it -> it + "!!!")
//                .subscribe(it -> System.out.println(it));

        .subscribe(s -> System.out.println(s),
                er -> System.out.println(er.getCause()),
                () -> System.out.println("We have completed!!!"));
    }
}
