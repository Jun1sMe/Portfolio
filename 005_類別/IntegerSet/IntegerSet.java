package lesson009_5d;
// ��Ƴ]�m
public class IntegerSet {
	// �x�s���Ʀr�}�C�G �̤p���׬�10
	private int element[];
	// �Ʀr�q
	private int count;
	// �غc�l
	public IntegerSet() {
		// �I�s�غc�l(�t����ܼ�) ->��������
		this(10);	
	}
	// �غc�l�G �޼Ƭ��e�q
	public IntegerSet(int size) {
		count = 0;
		element	= new int[size];
	}
	// �s�W�s�ȡF���Ƥ��p
	public void insert(int value) {
		// ���޶W�L�}�C�j�p
		if(getElement(this.count) == -1)
			this.resize();
		// �Ȧs�b
		if(search(value) != -1)
			return;
		
		this.element[this.count++] = value;
	}
	// �[�J�s��i�������A���޶W�X�d��h�^��-1
	public int getElement(int i) {
		if(i >= this.element.length)
			return this.count;
		return -1;
	}
	// �L�X���X���Ҧ�����
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
	// �j�Mvalue�O�_�s�b�󶰦X�G�s�b�^�Ǩ�index�B�_�h-1
	public int search(int value) {
		for(int i = 0; i < this.count; i++)
		{
			// �ӭȦs�b
			if(value == this.element[i])
				return this.count;			
		}
		// ���s�b
		return -1;
	}
	// �����Ӥ���
	public void delete(int value) {
		// ��l�Ʀs�b���ެ�-1
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
	// �PA���涰�æ^��
	public IntegerSet intersection(IntegerSet A) {
		IntegerSet inter = new IntegerSet();
		for(int i = 0; i < A.count ; i++)
		{
			// �Ȧs�b�h�s�J
			if(this.search(A.element[i]) != -1)
				inter.insert(A.element[i]);
		}
		return inter;
	}
	// �PA���p���æ^��
	public IntegerSet union(IntegerSet A) {	
		IntegerSet uni = new IntegerSet();
		// �N�Ӫ���s�J�s����
		for(int i = 0; i < this.count; i++)
			uni.insert(this.element[i]);
		// �NA����s�J�s����F�Ȧs�b�h���s�J
		for(int i = 0; i < A.count; i++)
			uni.insert(A.element[i]);
		return uni;
	}
	// �Ʀr�q�j��}�C���׫h�ܧ�}�C�j�p
	private void resize() {
		int temp[] = new int[this.element.length * 2];
		for(int i = 0; i < this.count; i++)
			temp[i] = this.element[i];
		this.element = temp;
	}
}
