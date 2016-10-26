package training;

import rx.Observable;
import rx.Observer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by a on 26/10/2016.
 */
public class RxJavaExample2 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Hello", "Streams", "Not");

        Observable.from(list)
                .filter(s -> s.contains("e"))
                .map(s -> s.toUpperCase())
                .reduce(new StringBuilder(), StringBuilder::append)
                .subscribe(System.out::println, e -> {}, () -> System.out.println("!"));
    }
}
