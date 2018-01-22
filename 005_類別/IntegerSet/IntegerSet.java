package lesson009_5d;
// 整數設置
public class IntegerSet {
	// 儲存之數字陣列： 最小長度為10
	private int element[];
	// 數字量
	private int count;
	// 建構子
	public IntegerSet() {
		// 呼叫建構子(含整數變數) ->須為首行
		this(10);	
	}
	// 建構子： 引數為容量
	public IntegerSet(int size) {
		count = 0;
		element	= new int[size];
	}
	// 新增新值；重複不計
	public void insert(int value) {
		// 索引超過陣列大小
		if(getElement(this.count) == -1)
			this.resize();
		// 值存在
		if(search(value) != -1)
			return;
		
		this.element[this.count++] = value;
	}
	// 加入編號i的元素，索引超出範圍則回傳-1
	public int getElement(int i) {
		if(i >= this.element.length)
			return this.count;
		return -1;
	}
	// 印出集合之所有元素
	public void output() {
		for(int i = 0; i < this.count; i++)
		{
			if(i == 0)
				System.out.print(this.element[i]);
			else
				System.out.print(", " + this.element[i]);		
		}
			
		System.out.println("\n");
	}
	// 搜尋value是否存在於集合：存在回傳其index、否則-1
	public int search(int value) {
		for(int i = 0; i < this.count; i++)
		{
			// 該值存在
			if(value == this.element[i])
				return this.count;			
		}
		// 不存在
		return -1;
	}
	// 移除該元素
	public void delete(int value) {
		// 初始化存在索引為-1
		int existIndex = -1;
		int temp[] = new int[this.element.length];
		for(int i = 0; i < this.count; i++)
		{
			if(value == this.element[i])
				existIndex = i;
			if(existIndex == -1)
				temp[i] = this.element[i];
			else
				temp[i] = this.element[i + 1];			
		}
		this.element = temp;
		count--;
	}
	// 與A之交集並回傳
	public IntegerSet intersection(IntegerSet A) {
		IntegerSet inter = new IntegerSet();
		for(int i = 0; i < A.count ; i++)
		{
			// 值存在則存入
			if(this.search(A.element[i]) != -1)
				inter.insert(A.element[i]);
		}
		return inter;
	}
	// 與A之聯集並回傳
	public IntegerSet union(IntegerSet A) {	
		IntegerSet uni = new IntegerSet();
		// 將該物件存入新物件
		for(int i = 0; i < this.count; i++)
			uni.insert(this.element[i]);
		// 將A物件存入新物件；值存在則不存入
		for(int i = 0; i < A.count; i++)
			uni.insert(A.element[i]);
		return uni;
	}
	// 數字量大於陣列長度則變更陣列大小
	private void resize() {
		int temp[] = new int[this.element.length * 2];
		for(int i = 0; i < this.count; i++)
			temp[i] = this.element[i];
		this.element = temp;
	}
}
