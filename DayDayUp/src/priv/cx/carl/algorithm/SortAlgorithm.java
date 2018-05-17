package priv.cx.carl.algorithm;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月11日 下午1:14:42
 */
public class SortAlgorithm {

	public static void main(String[] args) {
		int numbers[] = { 3, 10, 5, 7, 2, 4, 9, 6, 8, 1 };
		// bubbleSort(numbers); // 冒泡排序
		// quickSort(numbers, 0, numbers.length - 1); // 快速排序
		// insertionSort(numbers); // 直接插入排序
		// dichotomyInsertionSort(numbers); // 二分法插入排序
		// shellSort(numbers); // 希尔排序
		// selectSort(numbers); // 简单选择排序
		// heapSort(numbers); // 堆排序
		// mergeSort(numbers, 0, numbers.length - 1); // 归并排序
		// radixSort(numbers, numbers.length + 1); // 基数排序 又称桶排序
		for (int i : numbers)
			System.out.print(i + " ");
	}

	/**
	 * 冒泡排序 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。 针对所有的元素重复以上的步骤，除了最后一个。
	 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	 * 
	 * @param numbers
	 *            需要排序的整型数组
	 */
	public static void bubbleSort(int[] numbers) {
		int temp = 0;
		int size = numbers.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				// 交换两数位置
				if (numbers[j] > numbers[j + 1]) {
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 快速排序 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
	 * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
	 * 
	 * @param numbers
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] numbers, int low, int high) {
		int start = low;
		int end = high;
		int key = numbers[low];
		while (end > start) {
			// 从后往前比较
			// 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
			while (end > start && numbers[end] >= key)
				end--;
			if (numbers[end] <= key) {
				int temp = numbers[end];
				numbers[end] = numbers[start];
				numbers[start] = temp;
			}
			// 从前往后比较
			// 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
			while (end > start && numbers[start] <= key)
				start++;
			if (numbers[start] >= key) {
				int temp = numbers[start];
				numbers[start] = numbers[end];
				numbers[end] = temp;
			}
			// 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
		}
		// 递归
		if (start > low)
			quickSort(numbers, low, start - 1);// 左边序列。第一个索引位置到关键值索引-1
		if (end < high)
			quickSort(numbers, end + 1, high);// 右边序列。从关键值索引+1到最后一个
	}

	/**
	 * 插入排序（直接插入排序） 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排 好顺序的，现在要把第n 个数插到前面的有序数中，使得这
	 * n个数 也是排好顺序的。如此反复循环，直到全部排好顺序。 平均O(n^2),最好O(n),最坏O(n^2);空间复杂度O(1)
	 * 
	 * @param numbers
	 */
	public static void insertionSort(int[] numbers) {
		int temp;
		for (int i = 1; i < numbers.length; i++) {
			for (int j = i; j > 0; j--) {
				if (numbers[j] < numbers[j - 1]) {
					temp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}

	/**
	 * 二分法插入排序 思想和直接插入一样，只是找合适的插入位置的方式不同，这里是按二分法找到合适的位置，可以减少比较的次数。
	 * 
	 * @param numbers
	 */
	public static void dichotomyInsertionSort(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			int temp = numbers[i];
			int left = 0;
			int right = i - 1;
			int mid = 0;
			while (left <= right) {
				mid = (left + right) / 2;
				if (temp < numbers[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				numbers[j + 1] = numbers[j];
			}
			if (left != i) {
				numbers[left] = temp;
			}
		}
	}

	/**
	 * 希尔排序（最小增量排序） 算法先将要排序的一组数按某个增量 d（n/2,n为要排序数的个数）分成若 干组，每组中记录的下标相差
	 * d.对每组中全部元素进行直接插入排序，然后再用一个较小 的增量（d/2）对它进行分组，在每组中再进行直接插入排序。当增量减到 1 时，进行直接
	 * 插入排序后，排序完成。
	 * 
	 * @param numbers
	 */
	public static void shellSort(int[] numbers) {
		int d = numbers.length;
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < numbers.length; i = i + d) {
					int temp = numbers[i];
					int j;
					for (j = i - d; j >= 0 && numbers[j] > temp; j = j - d) {
						numbers[j + d] = numbers[j];
					}
					numbers[j + d] = temp;
				}
			}
			if (d == 1) {
				break;
			}
		}
	}

	/**
	 * 简单选择排序 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
	 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
	 * 
	 * @param numbers
	 */
	public static void selectSort(int[] numbers) {
		int position = 0;
		for (int i = 0; i < numbers.length; i++) {
			int j = i + 1;
			position = i;
			int temp = numbers[i];
			for (; j < numbers.length; j++) {
				if (numbers[j] < temp) {
					temp = numbers[j];
					position = j;
				}
			}
			numbers[position] = numbers[i];
			numbers[i] = temp;
		}
	}

	/**
	 * 堆排序
	 * 具有n个元素的序列（h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）(i=1,2
	 * ,...,n/2)时称之为堆。在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。
	 * 完全二叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，
	 * 使之成为一个堆，这时堆的根节点的数最大。然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，
	 * 直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。从算法描述来看，堆排序需要两个过程，一是建立堆，
	 * 二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
	 * 
	 * @param numbers
	 */
	public static void heapSort(int[] numbers) {
		if (numbers == null || numbers.length <= 1) {
			return;
		}
		buildMaxHeap(numbers);

		for (int i = numbers.length - 1; i >= 1; i--) {
			int temp = numbers[0];
			numbers[0] = numbers[i];
			numbers[i] = temp;

			maxHeap(numbers, i, 0);
		}
	}

	private static void buildMaxHeap(int[] numbers) {
		if (numbers == null || numbers.length <= 1) {
			return;
		}

		int half = numbers.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(numbers, numbers.length, i);
		}
	}

	private static void maxHeap(int[] numbers, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && numbers[left] > numbers[index]) {
			largest = left;
		}

		if (right < heapSize && numbers[right] > numbers[largest]) {
			largest = right;
		}

		if (index != largest) {
			int temp = numbers[index];
			numbers[index] = numbers[largest];
			numbers[largest] = temp;

			maxHeap(numbers, heapSize, largest);
		}
	}

	/**
	 * 归并排序 将两个（或两个以上）有序表合并成一个新的有 序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并
	 * 为整体有序序列。
	 * 
	 * @param numbers
	 */
	public static int[] mergeSort(int[] numbers, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			// 左边
			mergeSort(numbers, low, mid);
			// 右边
			mergeSort(numbers, mid + 1, high);
			// 左右归并
			merge(numbers, low, mid, high);
		}
		return numbers;
	}

	public static void merge(int[] numbers, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;

		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (numbers[i] < numbers[j]) {
				temp[k++] = numbers[i++];
			} else {
				temp[k++] = numbers[j++];
			}
		}

		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = numbers[i++];
		}

		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = numbers[j++];
		}

		// 把新数组中的数覆盖numbers数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			numbers[k2 + low] = temp[k2];
		}
	}

	/**
	 * 基数排序 又称桶排序 从低位开始（我们采用LSD的方式），将所有元素对应该位的数字存到相应的桶子里去（对应二维数组的那一列）。
	 * 然后将所有桶子里的元素按照桶子标号从小到大取出，对于同一个桶子里的元素，先放进去的先取出，后放进去的后取出（保证排序稳定性）。
	 * 这样原数组就按该位排序完毕了，继续下一位操作，直到最高位排序完成。
	 * 
	 * @param numbers
	 * @param d
	 */
	public static void radixSort(int[] numbers, int d) {
		int n = 1;// 代表位数对应的数：1,10,100...
		int k = 0;// 保存每一位排序后的结果用于下一位的排序输入
		int length = numbers.length;
		int[][] bucket = new int[10][length];// 排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
		int[] order = new int[length];// 用于保存每个桶里有多少个数字
		while (n < d) {
			// 将数组array里的每个数字放在相应的桶里
			for (int num : numbers) {
				int digit = (num / n) % 10;
				bucket[digit][order[digit]] = num;
				order[digit]++;
			}
			// 将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
			for (int i = 0; i < length; i++) {
				// 这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
				if (order[i] != 0) {
					for (int j = 0; j < order[i]; j++) {
						numbers[k] = bucket[i][j];
						k++;
					}
				}
				order[i] = 0;// 将桶里计数器置0，用于下一次位排序
			}
			n *= 10;
			k = 0;// 将k置0，用于下一轮保存位排序结果
		}
	}
	
}
