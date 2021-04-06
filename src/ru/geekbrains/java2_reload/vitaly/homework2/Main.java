package ru.geekbrains.java2_reload.vitaly.homework2;

public class Main {

    static final int SIZE = 4;
    public static void  main(String[] args)
    {
        String string = "10 3 1 2 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        String[][] arr2d;
        int[][] numArray;
        int halfSum;

        try {

            arr2d = splitString(string);
            print2dArray(arr2d);

            numArray = stringToIntArray(arr2d);
            print2dArray(numArray);

            halfSum = halfSumOfMatrix(numArray);
            System.out.println(halfSum);
        }
        catch( SizeOfArrayException | IsNotNumberInArrayException e)
        {
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }

    }

    private static String[][] splitString(String string) throws SizeOfArrayException
    {
        String[] arr = string.split("\n");

        if(arr.length != SIZE)
        {
            throw new SizeOfArrayException("Size_y is not equals "+ SIZE +", is equal " + SIZE);
        }

        String[][] arr2d = new String[SIZE][];
        for(int i = 0; i < SIZE; i++)
        {
            arr2d[i] = arr[i].split(" ");
            if(arr2d[i].length != SIZE) {
                throw new SizeOfArrayException("Size_x[" + i + "] is not equal "+ SIZE +", is equal " + arr2d[i].length);
            }
        }

        return arr2d;
    }

    private static int[][] stringToIntArray(String[][] stringArray) throws IsNotNumberInArrayException
    {
        int[][] intArray = new int[SIZE][SIZE];
        for(int y = 0; y < SIZE; y++)
        {
            for (int x = 0; x < SIZE; x++)
            {
                try{
                    intArray[y][x] = Integer.parseInt(stringArray[y][x]);
                }catch(NumberFormatException e)
                {
                    throw new IsNotNumberInArrayException("Is not a number inside array");
                }

            }
        }
        return  intArray;
    }

    private static int halfSumOfMatrix(int[][] arr)
    {
        int result = 0;
        for(int y = 0; y < SIZE; y++)
        {
            for(int i : arr[y])
            {
                result += i;
            }
        }

        return result/2;
    }

    private static void print2dArray(Object[][] array2d)
    {
        for(int y = 0; y < SIZE; y++)
        {
            for(int x = 0; x < SIZE; x++)
            {
                System.out.print(array2d[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void print2dArray(int[][] array2d)
    {
        for(int y = 0; y < SIZE; y++)
        {
            for(int x = 0; x < SIZE; x++)
            {
                System.out.print(array2d[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static class SizeOfArrayException extends  Exception
    {
        SizeOfArrayException(String string)
        {
            super(string);
        }
    }

    private static class IsNotNumberInArrayException extends NumberFormatException
    {
        IsNotNumberInArrayException(String s)
        {
            super(s);
        }
    }
}
