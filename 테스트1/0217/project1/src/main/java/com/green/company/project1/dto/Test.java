package com.green.company.project1.dto;

import com.green.company.project1.domain.Product;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class Test {
    public static void main(String[] args) {
        Score a = new Score() {
            @Override
            public void run() {
                System.out.println("사랑");
            }
        };
        a.run();
        System.out.println("===========================");
        a = () -> System.out.println("행복");
        a.run();

//        Magic이라는 함수형 인테페이스를 생성 후 사용하세요.
//        함수형 인터페이스를 만든다.
//        Magic m = new Magic(){
//        @Override
//        public int tt(int a, int b) {
//            return a+b;
//        }
//    };

        Function<Integer,Integer> fn = (Integer t) -> t*2;
        int v = fn.apply(11);

        System.out.println(v);

        Function<Integer, ProductDTO> fn2 = (U) ->{
            return new ProductDTO().builder()
                    .pno(11l)
                    .price(340000)
                    .pname("사랑합니다")
                    .pdesc("행복합니다.")
                    .build();
        };

        ProductDTO vvv = fn2.apply(11);
        System.out.println(vvv);
        Predicate<Integer> p1 = (i) -> i%2 == 0;
        boolean vvvv = p1.test(11);
        System.out.println(vvvv);

       List<ProductDTO> list = IntStream.rangeClosed(1,1000).filter(i -> i % 2 ==0)
                .mapToObj(i -> {
                    return new ProductDTO().builder()
                            .pno((long)i)
                            .price(i*100)
                            .pname("사랑합니다"+i)
                            .pdesc("행복합니다"+i)
                            .build();

                }).collect(Collectors.toList());

       System.out.println(list);

    }
}
