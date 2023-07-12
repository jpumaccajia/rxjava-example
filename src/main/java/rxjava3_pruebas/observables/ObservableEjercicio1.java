package rxjava3_pruebas.observables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableEjercicio1 {

    public static void main(String[] args){

//        1. Observable
        Observable<String> observableString = Observable.create(
                emmiter -> {
                    emmiter.onNext("Maria");
                    emmiter.onNext("Adrian");
                    emmiter.onNext("Andres");
                    emmiter.onNext("Javier");
                    emmiter.onComplete();
                }
        );

        observableString = observableString.filter(x -> x.toUpperCase().startsWith("A"))
                .map(y -> y.toUpperCase());

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
