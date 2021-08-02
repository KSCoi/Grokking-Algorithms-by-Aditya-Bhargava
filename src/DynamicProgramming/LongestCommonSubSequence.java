package DynamicProgramming;

public class LongestCommonSubSequence {


    public static void main(String[] args) {
        String firstWord  = "fishab";
        String secondWord = "hisheb";
        int [][] cell = cell(firstWord,secondWord);
        printMatrix(cell);
        printSubSequence(firstWord,secondWord);
    }
    public static int[][] cell(String wordA, String wordB)    {
        int[][] cell = new int[wordA.length()][wordB.length()];
        for (int i = 0; i <wordA.length() ; i++) {
            for (int j = 0; j < wordB.length(); j++) {
                cell[i][j]=0;
                if(wordA.charAt(i) == wordB.charAt(j))  {
                    if(i>0&&j>0)
                        cell[i][j] = cell[i-1][j-1] + 1;
                    else
                        cell[i][j]=1;
                }
                else    {
                    if(i>0&&j>0)
                        cell[i][j] = Math.max(cell[i][j-1],cell[i-1][j-1]);
                }
            }
        }
        return cell;
    }
    public static void printSubSequence(String aWord, String bWord) {
        int[][] cell = cell(aWord,bWord);
        int maxSeq=0;
        for (int i = 0; i <cell.length ; i++) {
            for (int j = 0; j <cell[0].length ; j++) {
                if(cell[i][j]>maxSeq)    {
                    System.out.print(aWord.charAt(i));
                    i++;
                    maxSeq++;
                }

            }
        }
    }
    public static void printMatrix(int [][] matrix)    {
        for (int[] row : matrix)    {
            for (int a : row)
                System.out.print(a + " ");
            System.out.println();
        }

    }
}
