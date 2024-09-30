package banat1.tect_10__17.hw10_17.hw14;

public class  lect14 {
    public static void main(String[] args) {
        String[][] inputArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "text"} // Invalid entry for testing
        };

        try {
            int sum = processArray(inputArray);
            System.out.println("Sum of elements: " + sum);
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static int processArray(String[][] array) throws AppArraySizeException, AppArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new AppArraySizeException("Array size is not 4x4.");
        }

        int sum = 0;
        StringBuilder errorSlots = new StringBuilder();
        boolean hasErrors = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    errorSlots.append("Invalid value at [" + i + "][" + j + "] ");
                    hasErrors = true;
                }
            }
        }

        if (hasErrors) {
            throw new AppArrayDataException(errorSlots.toString().trim());
        }

        return sum;
    }
}
