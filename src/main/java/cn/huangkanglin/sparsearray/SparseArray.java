package cn.huangkanglin.sparsearray;

/**
 * 稀疏数组结构<br>
 * row|column|value<br/>
 * 11   11    2    <br/>
 * 2    3     1    <br/>
 * 3    3     1    <br/>
 * =======================
 * 行 | 列 | 值
 * 11   11   2    数组11*11 有2个值
 * 2    3    1    a[2][3] = 1
 * 3    3    1    a[3][3] =1
 */
public class SparseArray {

    public static void main(String[] args) {
        // 1.创建一个数组
        int[][] arrays = new int[11][11];

        // 2.在a[2][3] 和 a[3][3] 放一个
        for (int i = 0; i < arrays.length; i++) {
            int[] array = arrays[i];
            for (int j = 0; j < array.length; j++) {
                // 如果角标是a[2][3] 和 a[3][3]则将值设置为1,数组下面都是0开始
                if (i == 1 || i == 2) {
                    if (j == 2) {
                        arrays[i][j] = 1;
                    }
                } // end if
            }// end for_j
        }// end for_i

        // 3.创建一个稀疏数组;
        // 3.1 求原数组有效个数
        int sparseSize = 0;
        for (int i = 0; i < arrays.length; i++) {
            int[] array = arrays[i];
            for (int j = 0; j < array.length; j++) {
                if (arrays[i][j] != 0) {
                    sparseSize++;
                }
            }// end for_j
        }// end for_i

        // 3.2 创建一个稀疏数组
        int[][] sparse = new int[3][3];
        sparse[0][0] = 11; // 行数
        sparse[0][1] = 11; // 列数
        sparse[0][2] = sparseSize; // 有效个数

        // 3.3 循环设置一个值
        int row = 1;
        for (int i = 0; i < arrays.length; i++) {
            int[] array = arrays[i];
            for (int j = 0; j < array.length; j++) {
                if (arrays[i][j] != 0) {
                    sparse[row][0] = i;
                    sparse[row][1] = j;
                    sparse[row][2] = arrays[i][j];
                    row++;
                }
            }// end for_j
        }// end for_i

        // 4.将稀疏数组返回成二维数组
        int[][] arrays2 = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1 ; i <= sparse[0][2] ; i++) {
            arrays2[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        prinitArrays(arrays2);

    }

    /**
     * 输出一个二维数组
     *
     * @return
     */
    public static void prinitArrays(int[][] arrays) {
        for (int[] array : arrays) {
            for (int x : array) {
                System.out.printf("%d\t", x);
            }
            System.out.println();
        }
    }

}
