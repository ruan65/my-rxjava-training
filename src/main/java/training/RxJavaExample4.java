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

        try {
            return Observable.just(s.substring(0, 2));
        } catch (Exception ex) {
            return Observable.just("null");
        }
    }

    public static void main(String[] args) {

        Observable<List<String>> just = Observable.just(Arrays.asList("one", "two", "0", "three", "ok", "aha!!!!",
                "zahhhhhhqaa", "0"));


//        just.subscribe(it -> System.out.println(it));

//        just.subscribe(new Action1<List<String>>() {
//            @Override
//            public void call(List<String> strings) {
//                Observable.from(strings)
//                        .subscribe(s -> System.out.println(s));
//            }
//        });

        try {
            just
                    .flatMap(it -> Observable.from(it))
                    .doOnNext(it -> System.out.println(it))
                    .take(2)
                    .flatMap(it -> getFirst2Letters(it))
                    .filter(it -> !it.equals("null"))
                    .map(it -> it.toUpperCase())
                    .doOnNext(it -> System.out.println(it))
                    .flatMap(it -> Observable.just(it + "!!!"))
    //                .subscribe(it -> System.out.println(it));

                    .subscribe(s -> System.out.println(s),
                            er -> System.out.println(er.getCause()),
                            () -> System.out.println("We have completed!!!"));
        } catch (Exception e) {
            // hihi
        }
    }
}
