package DynamicProgramming;

public class LongestCommonSubString {

    public static void main(String[] args) {
        String firstWord  = "fish";
        String secondWord = "hish";
        printMatrix(subStringMatrix(firstWord,secondWord));
        printMaxSubString(firstWord,secondWord);
    }

    public static int[][] subStringMatrix(String aWord, String bWord)   {
        int[][] matrix = new int[aWord.length()][bWord.length()];
        lab1:for (int i = 0; i <aWord.length() ; i++) {
            for (int j = i; j <bWord.length() ; j++) {
                if(aWord.charAt(i)== bWord.charAt(j))   {
                    if(i>0 && j>0)
                    matrix[i][j]=matrix[i-1][j-1] + 1;
                    else
                        matrix[i][j]=1;
                }
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix)    {
        for (int[] a : matrix)  {
            for (int i : a) {
            System.out.print(i+" ");
            }
        System.out.println("");
     }
    }

    public static void printMaxSubString(String aWord, String bWord)    {
        int [][] matrix = subStringMatrix(aWord,bWord);
        int maxCountOfSubString=0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]>maxCountOfSubString)    {
                    System.out.print(aWord.charAt(i));
                    maxCountOfSubString++;
                }

            }
        }
    }

}
