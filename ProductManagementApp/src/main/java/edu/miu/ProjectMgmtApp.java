package edu.miu;

import edu.miu.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProjectMgmtApp
{
    public static void main( String[] args )
    {
        System.out.println( "Hello ProjectMgmtApp!" );

        var products = new Product[] { //Local variable type inference
                new Product(3128874119L, "Banana", LocalDate.of(2023, 01, 24), 124, 0.55 ),
                new Product(2927458265L, "Apple", LocalDate.of(2023, 12, 9), 18, 1.09 ),
                new Product(9189927460L, "Carrot", LocalDate.of(2023, 03, 31), 89, 2.99 )
        };
        printProducts(products);
    }

    private static void printProducts(Product[] products) {
        if(products != null ) {
            if(products.length > 0) {
                //Sort
//                Arrays.sort(products, new Comparator<Product>() {
//                    @Override
//                    public int compare(Product o1, Product o2) {
//                        return o1.getName().compareTo(o2.getName());
//                    }
//                });

                //Stream API
                var sortedProducts = Arrays.stream(products)
                        // .sorted(Comparator.comparing(Product::getName));
                        .sorted(Comparator.comparing(p -> p.getName()))
                        .toList();
                //Print JSON format
                var numProducts = sortedProducts.size();
                for (int i = 0; i < sortedProducts.size(); i++) {
                    if((i + 1) < numProducts) {
                        System.out.printf("%s, \n", sortedProducts.get(i).toJSONString());
                    } else {
                        System.out.println(sortedProducts.get(i).toJSONString());
                    }
                }
            }
        }
    }
}