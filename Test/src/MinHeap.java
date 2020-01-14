
public class MinHeap extends Heap {
	

	public int getHeapSize() {
		return super.getHeapSize();
	}
	
	public MinHeap() {
		super(comp);
	}
	
	public int getRoot() throws Exception {
		return super.getRoot();
	}
	
	public void insertIntoHeap(int num) {
		super.insertIntoHeap(num);
	}
	
	public int extract() {
		return super.extract();
	}
	protected void heapify(int i) {
		super.heapify(i);
	}

	public static Comparator comp = new Comparator() {
		
		@Override
		public int compare(int x, int y) {
			if(x > y) {
				return 1;
			}
			return 0;
		}
	};

}
