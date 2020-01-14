import java.util.Scanner;

public class MedianOfStream {
	private static int median = 0;
	static MinHeap minHeap;
	static MaxHeap maxHeap;
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		minHeap = new MinHeap();
		maxHeap = new MaxHeap();
		int N = sc.nextInt();
		for(int i=0; i<N;i++) {
			int ele = sc.nextInt();
			getMedian(ele);
			System.out.println(median);
		}
	}
	
	static int getMedian(int x) {
		int leftHeapSize = maxHeap.getHeapSize();
		int rightHeapSize = minHeap.getHeapSize();
		int diff = leftHeapSize - rightHeapSize;
		//System.out.println("diff :"+diff);
		if(diff == 0) {
			if(x < median) {
				//System.out.println(" max insert ");
				maxHeap.insertIntoHeap(x);
				try {
					median = maxHeap.getRoot();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				minHeap.insertIntoHeap(x);
				//System.out.println(" min insert ");
				try {
					median = minHeap.getRoot();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if (diff == 1) {
			if(median > x) {
				int y = maxHeap.extract();
				//System.out.println("max extaxt :"+y);
				minHeap.insertIntoHeap(y);
				maxHeap.insertIntoHeap(x);
			} else {
				minHeap.insertIntoHeap(x);
			}
			try {
				//System.out.print("min getroot : "+ minHeap.getRoot()+ " max getroot: "+maxHeap.getRoot()+"\n");
				median = ((minHeap.getRoot() + maxHeap.getRoot()) / 2);
			} catch (Exception e) {
				e.printStackTrace();
			}
 		} else if (diff == -1) {
			if(median > x) {
				maxHeap.insertIntoHeap(x);
			} else {
				int y = minHeap.extract();
				//System.out.println("min extaxt :"+y);
				maxHeap.insertIntoHeap(y);
				minHeap.insertIntoHeap(x);
			}
			
			try {
				//System.out.print("min getroot : "+ minHeap.getRoot()+ " max getroot: "+maxHeap.getRoot()+"\n");
				median = ((minHeap.getRoot() + maxHeap.getRoot()) / 2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return median;
	}
}
