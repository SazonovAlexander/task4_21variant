package ru.vsu.cs.sazonov;

/**
 * Класс с реализацией быстрой сортировки (QuickSort) для массивов и списков
 */
public class QuickSort {

    private static int partition(int[][] data, int left, int right, int str) {
        int l = left;
        int r = right - 1;  // т.к. right не входит в диапазон

        int x = data[str][(l + r) / 2];
        while (l <= r) {
            while (data[str][l] < x) {
                l++;
            }
            while (data[str][r] > x) {
                r--;
            }
            // в этом месте:
            //   l - индекс первого элемента >= x (возможно указывает непосредственно на x)
            //   r - индекс последнего элемента <= x (возможно указывает непосредственно на x)
            if (l <= r) {
                // обмен элементов [r] и [l]
                for(int i=0; i<data.length;i++) {
                    int tmp = data[i][r];
                    data[i][r] = data[i][l];
                    data[i][l] = tmp;
                }
                l++;
                r--;
            }
            // в этом месте можно утверждать:
            //   если l <= r то:
            //     слева [l] все элементы <= x
            //     справа [r] все элементы >= x
            //   иначе (возврат с результатом l):
            //     l - индекс x или элемента, непосредственно следующего за х
        }

        // так как при обмене увеличиваем l, может оказаться, что l == right, который не входит в сортируемый диапазон
        // (возможно, если только в качестве опорного элемента брать последний элемент из диапазона)
        if (l == right) {
            l--;
        }

        return l;
    }


    private static void sort(int[][] data, int left, int right, int str) {
        if (left < right - 1) {
            int xIndex = partition(data, left, right, str);
            sort(data, left, xIndex, str);
            sort(data, xIndex, right, str);
        }
    }

    public static void sort(int[][] data,int str) {
        sort(data, 0, data[0].length, str);
    }




}
