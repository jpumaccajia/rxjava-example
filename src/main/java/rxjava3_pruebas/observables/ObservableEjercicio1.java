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


//        3. Suscriptor
        observableString.subscribe(
                nombre -> System.out.println("onNext " + nombre),
                error -> System.out.println("error: " + error.getMessage()),
                () -> System.out.println("onComplete")
        );
    }

}
