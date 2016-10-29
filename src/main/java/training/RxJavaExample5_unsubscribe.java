package training;

import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

import java.util.Arrays;
import java.util.List;

/**
 * Created by a on 26/10/2016.
 */
public class RxJavaExample5_unsubscribe {

    public static void main(String[] args) {

        PublishSubject<Integer> ps = PublishSubject.create();


        ps.onNext(100);

        CompositeSubscription comp = new CompositeSubscription();

        Subscription subscription1 = ps.subscribe(i -> System.out.println("sbs_1: " + i));
        Subscription subscription2 = ps.subscribe(i -> System.out.println("sbs_2: " + i));

        comp.add(subscription1);
        comp.add(subscription2);
        ps.onNext(200);
        ps.onNext(777);

//        subscription1.unsubscribe();

        comp.remove(subscription1);

        System.out.println("sbs_1 has been unsubscribed");

        ps.onNext(300);
        ps.onNext(0);

        comp.add(ps.subscribe(i -> System.out.println("sbs_3: " + i)));

        ps.onNext(1);

        ps.onNext(1000000);

        System.out.println("removing......");

        comp.clear();

        ps.onNext(999);



    }
}
