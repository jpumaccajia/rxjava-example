package rxjava3_pruebas.observables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableTest {

    public static void main(String[] args){

//        1. Observable
        Observable<String> observableString = Observable.create(
                emmiter -> {
                    emmiter.onNext("Maria");
                    emmiter.onNext("Jose");
                    emmiter.onNext("Jimmy");
                    emmiter.onNext("Javier");
                    emmiter.onComplete();
                }
        );

        observableString = observableString.filter(x -> x.length() == 4);

//        2. Observador
        Observer<String> observerString = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

//        3. Suscriptor
        observableString.subscribe(observerString);
    }

}
