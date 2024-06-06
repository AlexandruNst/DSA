public class Arrays {
    public static void main(String[] args) {

        // array = used to store multiple values in a single variable
        String[] cars = { "Camaro", "Corvet", "Tesla" };

        // Access
        cars[0] = "Mustang";
        System.out.println(cars[1]);

        // cars[3] = "Chevrolet"; -> will throw a ArrayIndexOutOfBoundsException
        // cars[1] = 123; -> array elements have to be of the same type

        // Another way to type an array
        String[] cars2 = new String[3];
        cars2[0] = "BMW";
        cars2[1] = "Mustang";
        cars2[2] = "Chevrolet";

        // Iterating through the array
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
    }
}