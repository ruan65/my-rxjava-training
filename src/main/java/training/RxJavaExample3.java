package training;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by a on 26/10/2016.
 */
public class RxJavaExample3 {

    public static void hello(String... names) {

        Observable.from(names)
                .subscribe(n -> System.out.println("Hello " + n + "!"));
    }
    public static void main(String[] args) {

        hello("John", "Maria", "LenaR");

        Observable<String> from = Observable.from(Arrays.asList("hi", "two", "melissa"));


        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed.....");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

                System.out.println(s);
            }
        };

        Observer<String> stringObserver2 = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed.....");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

                System.out.println(String.format("! %s !", s));
            }
        };



        from.subscribe(stringObserver);

        from.subscribe(stringObserver2);

        from.subscribe(it -> System.out.println("[" + it + "]"));

    }
}
