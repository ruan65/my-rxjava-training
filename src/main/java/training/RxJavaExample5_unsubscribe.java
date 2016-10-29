package training;

import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by a on 26/10/2016.
 */
public class RxJavaExample5_unsubscribe {

    public static void main(String[] args) {

        PublishSubject<Integer> ps = PublishSubject.create();


        ps.onNext(100);

        Subscription subscription1 = ps.subscribe(i -> System.out.println("sbs_1: " + i));
        Subscription subscription2 = ps.subscribe(i -> System.out.println("sbs_2: " + i));

        ps.onNext(200);
        ps.onNext(777);

        subscription1.unsubscribe();
        System.out.println("sbs_1 has been unsubscribed");

        ps.onNext(300);
        ps.onNext(0);

        ps.subscribe(i -> System.out.println("sbs_3: " + i));

        ps.onNext(1);




    }
}
