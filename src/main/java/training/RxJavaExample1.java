package training;

import rx.Observable;
import rx.Observer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by a on 26/10/2016.
 */
public class RxJavaExample1 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Android", "Ubuntu", "Mac OS");

        Observable<List<String>> listObservable = Observable.just(list);

        listObservable.subscribe(new Observer<List<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<String> strings) {

                System.out.println(list);
            }
        });


    }
}
