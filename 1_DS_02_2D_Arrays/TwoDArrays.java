public class TwoDArrays {
    public static void main(String[] args) {
        // 2D array = array of arrays

        String[][] cars = new String[3][3];

        // Access -> [row][col]
        cars[0][0] = "Camaro";
        cars[0][1] = "Corvet";
        cars[0][2] = "Silverado";
        cars[1][0] = "Mustang";
        cars[1][1] = "Ranger";
        cars[1][2] = "F-150";
        cars[2][0] = "Ferrari";
        cars[2][1] = "Lambo";
        cars[2][2] = "Tesla";

        // Iteration
        for (int i = 0; i < cars.length; i++) {
            System.out.println();
            for (int j = 0; j < cars[i].length; j++) {
                System.out.print(cars[i][j] + " ");
            }
        }

        // Another way to declare
        String[][] cars2 = {
                { "Camaro", "Corvet", "Silverado" },
                { "Mustang", "Ranger", "F-150" },
                { "Ferrari", "Lambo", "Tesla" }
        };
        cars2[0][0] = "Chevrolet";
    }
}
