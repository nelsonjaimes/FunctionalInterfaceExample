package pe.njgconsulting;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("=====> iniciamos ");
        Person p1 = new Person("Nelson", 4500);
        Person p2 = new Person("Juan", 5550);
        Person p3 = new Person("Anibal", 8000);

        //993119000
        List<Person> personList = List.of(p1, p2, p3);
        personList.stream().filter(person -> person.getAvailableAmount() > 5000)
                .sorted(Comparator.comparing(Person::getName).reversed())
                .map(Person::getName)
                .forEach(System.out::println);

        int availableAmount = personList.stream()
                .map((person -> (int) person.getAvailableAmount()))
                .reduce(Integer::sum).get();
        System.out.println("sum availableAmount: " + availableAmount);

        //===============>Fuctional interface
        SuplinerInterface consumer = () -> System.out.println("Esta es una interfaz funcional: CONSUMER");
        consumer.println();

        FuctionInterface fuc1 = a -> {
            int x = 12;
            int y = 56;
            return x * a / y;
        };
        FuctionInterface fuc2 = a -> a * 12;
        System.out.println("Fuctional interface fuc1 : " + fuc1.startOperation(45));
        System.out.println("Fuctional interface fuc2 : " + fuc2.startOperation(45));

        Supplier<LocalDateTime> s = LocalDateTime::now;
        System.out.println("LocalDatetime: " + s.get().toString());

        System.out.println("==========================>");
        Consumer<Integer> consumer1 = x -> System.out.println("Consumer:::El numero es: " + x * 10);
        consumer1.accept(20);
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println("BiConsumer:::La suma es: " + (x + y));
        biConsumer.accept(14, 6);

        Predicate<Integer> pre1 = x -> x % 2 == 0;
        System.out.println(pre1.test(5) ? "El num:5 Es par" : "El num 5 es impar");
        BiPredicate<Integer, Integer> biPre2 = (x, y) -> (x + y) % 2 == 0;
        System.out.println(biPre2.test(5, 10) ? "La suma de los numeros 5,10  es par" :
                "La suma de los numeros 5,10 es impar");

        UnaryOperator<Double> unaryOperator1 = x -> x * 12.5;
        System.out.println("UnaryOperator::: La respuesta es : " + unaryOperator1.apply(3.0));

        BinaryOperator<Integer> binaryOperator = Integer::sum;
        System.out.println("binaryOperator::: La operacion es : " + binaryOperator.apply(5, 12));

        BinaryOperator<Integer> binaryOperator2 = (x, y) -> {
            if (y == 0) return 0;
            int aux = 12;
            int currentAge = x + aux;
            return (Integer) currentAge / y;
        };

        System.out.println("binaryOperator composite:::: " + binaryOperator2.apply(15, 5));
    }
    
}