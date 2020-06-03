package SudokuSolver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int[][] f = {{7, 8, 4, 1, 5, 9, 3, 2, 6}, {5, 3, 9, 6, 7, 2, 8, 4, 1}, {6, 1, 2, 4, 3, 8, 7, 5, 9},
                {9, 2, 8, 7, 1, 5, 4, 6, 3}, {3, 5, 7, 8, 4, 6, 1, 9, 2}, {4, 6, 1, 9, 2, 3, 5, 8, 7},
                {8, 7, 6, 3, 9, 4, 2, 1, 5}, {2, 4, 3, 5, 6, 1, 9, 7, 8}, {1, 9, 5, 2, 8, 7, 6, 3, 4}};
        System.out.println(sudokuCheck(f, 9));
    }

    public static boolean sudokuCheck(int[][] s, int N) throws Exception {

        //aici se verifica validitatea pe linii
        for (int linie = 0; linie < N; linie++) {
            for (int coloana1 = 0; coloana1 < N - 1; coloana1++) {
                for (int coloana2 = coloana1 + 1; coloana2 < N; coloana2++) {
                    if (s[linie][coloana1] == s[linie][coloana2]) {
                        return false;
                    }
                }
            }
        }
//aici verificam coloanele
        for (int coloana = 0; coloana < N; coloana++) {
            for (int linia1 = 0; linia1 < N - 1; linia1++) {
                for (int linia2 = linia1 + 1; linia2 < N; linia2++) {
                    if (s[linia1][coloana] == s[linia2][coloana]) {
                        return false;
                    }
                }
            }
        }

        //aici se verifica dupa o formula matematica validitatea fiecarui patratele
       int n= (int) Math.sqrt(N);
        for (int linie = 0; linie < N; linie += n) {
            for (int coloana = 0; coloana < N; coloana += n) {
                for (int pos = 0; pos < N - 1; pos++) {
                    for (int pos2 = pos + 1; pos2 < N; pos2++) {
                        if (s[ (linie + pos % n)][ (coloana + pos / n)] == s[ (linie + pos2 % n)][(coloana + pos2 /n)])
                            return false;
                    }
                }
            }

        }
        return true;
    }


}
