package co.com.MAKAIA;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Arroz", 30.5, "Alimentos", 50));
        productos.add(new Producto("Leche", 20.0, "Alimentos", 0));
        productos.add(new Producto("Laptop", 1500.0, "Electrónicos", 10));
        productos.add(new Producto("TV", 800.0, "Electrónicos", 5));
        productos.add(new Producto("Mesa", 120.0, "Hogar", 15));

        //Obtener una lista de todos los productos con stock mayor a 0 y con un precio menor a 50.
        List<Producto> productosConStockMayorACeroYPrecioMenosA50 = productos
                .stream()
                .filter(prod -> prod.getStock() > 0 && prod.getPrecio() < 50)
                .collect(Collectors.toList());
        System.out.println("\nLista de todos los productos con stock mayor a " +
                "0 y con un precio menor a 50:");
        mostrarListaProductos(productosConStockMayorACeroYPrecioMenosA50);
        /*
        productosConStockMayorACeroYPrecioMenosA50
                .stream().
                forEach(elementos -> System.out.println(elementos));
         */

        //Obtener la lista de nombres de todos los productos de la categoría "Alimentos".
        List<String> nombresProductosCategoriaAlimentos = productos
                .stream()
                .filter(producto -> producto.getCategoria().equals("Alimentos"))
                .map(producto -> producto.getNombre())
                .collect(Collectors.toList());
        System.out.println("\nLista de nombres de todos los productos de la " +
                "categoría 'Alimentos':");
        mostrarListaProductos(nombresProductosCategoriaAlimentos);
        /* nombresProductosCategoriaAlimentos
                .stream().
                forEach(elementos -> System.out.println(elementos));

         */

        //Obtener el precio total de todos los productos.
        Function<ArrayList<Producto>, Double> calcularTotalProductos =
                (listaProductos) -> {
                    double total = 0;
                    for(Producto producto: listaProductos){
                        total += producto.getPrecio() * producto.getStock();
                    }
                    return total;
                };

        double precioTotalProductos = calcularTotalProductos.apply(productos);
        System.out.println("\nPrecio total de todos los productos: $" + precioTotalProductos);
    }

    public static <T> void mostrarListaProductos (List<T> lista){
        lista.stream().forEach(elementos -> System.out.println(elementos));
    }
}
