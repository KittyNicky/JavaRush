package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static class Product {
        private int id;
        private String name;
        private String price;
        private String quantity;

        public Product(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }
    }

    public static Product getProduct(String line) {
        int id = Integer.parseInt(line.substring(0, 8).trim());
        String name = line.substring(8, 38);
        String price = line.substring(38, 46);
        String quantity = line.substring(46, 50);
        Product product = new Product(id, name, price, quantity);
        return product;
    }

    private static String fileName;

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
        }
    }

    public static boolean validateArgs(String[] args) {
        if (args.length == 0) return false;
        return true;
    }

    private static List<Product> addProducts() throws Exception {
        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = getProduct(line);
                products.add(product);
            }
        }
        return products;
    }

    private static void removeProduct(String[] args, List<Product> products) throws Exception {
        int id = Integer.parseInt(args[1]);
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getId() == id) productIterator.remove();
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Product product : products) {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            }
        }
    }

    private static void updateProduct(String[] args, List<Product> products) throws Exception {
        int id;
        String name = "";
        String price;
        String quantity;
        // id
        id = Integer.parseInt(args[1]);
        // name
        for (int i = 2; i < args.length - 2; i++) {
            name += args[i] + " ";
        }
        if (name.length() > 30) name = name.substring(0, 30);
        // price
        price = args[args.length - 2];
        if (price.length() > 8) price = price.substring(0, 8);
        // quantity
        quantity = args[args.length - 1];
        if (quantity.length() > 4) quantity = quantity.substring(0, 4);

        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
                product.setQuantity(quantity);
            }
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Product product : products) {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            }
        }
    }

    public static void switchOperation (String[] args, List<Product> products) throws Exception{
        switch (args[0]) {
            case ("-u"): {
                updateProduct(args, products);
                break;
            }
            case ("-d"): {
                removeProduct(args, products);
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (!validateArgs(args)) return;
        List<Product> products = addProducts();
        switchOperation(args, products);
    }
}