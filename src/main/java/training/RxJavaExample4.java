package training;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by a on 26/10/2016.
 */
public class RxJavaExample4 {

    public static Observable<String> getFirstLetter(String s) {
        return Observable.just(s.substring(0, 1));
    }

    public static void main(String[] args) {

        Observable<List<String>> just = Observable.just(Arrays.asList("one", "two", "three", "aha!!!!", "zahhhhhhqaa"));


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
                .flatMap(it -> getFirstLetter(it))
                .subscribe(it -> System.out.println(it));
    }
}
