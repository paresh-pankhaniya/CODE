
public class Heap {
	private int heapSize;
	private int arr[];
	private Comparator comp;
	
	public int getHeapSize() {
		return heapSize;
	}
	
	public Heap(Comparator comp) {
		arr = new int[Constant.MAX_HEAP_SIZE];
		this.comp = comp;
		heapSize = -1;
	}

	public int getRoot() throws Exception {
		if(heapSize >= 0)
			return arr[0];
		throw new Exception("heapSize is invalid");
	}
	
	public void insertIntoHeap(int num) {
		heapSize++;
		arr[heapSize] = num;
		heapify(heapSize);
	}
	
	public int extract() {
		if(heapSize < 0) {
			return -1;
		}
		int res = arr[0];
		arr[0] = arr[heapSize];
		heapSize--;
		int i = ((heapSize + 1) - 1)/2; 
		heapify(i);
		return res;
	}
	protected void heapify(int i) {
	
		int parent = (i-1)/2;
		//System.out.println("arr[p] :" + arr[parent]+ " arr[i]: "+arr[i]);
		if(parent>=0 && comp.compare(arr[parent], arr[i]) == 1) {
			
			int temp = arr[parent];
			arr[parent] = arr[i];
			arr[i] = temp;
			heapify(parent);
		}
	}
	
}
