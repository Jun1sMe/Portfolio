import java.util.Arrays;

public class SparseMatrix
{
	private Term[] terms;

	/*copy matrix'data to this matrix*/
	public SparseMatrix(SparseMatrix matrix) 
	{
		// set row and col
		this(matrix.terms[0].row, matrix.terms[0].col);
		int mCount = matrix.terms[0].value;	
		// exclusion first
		// storage the terms[0].value
		for(int i = 1 ; i <= mCount ; i++)
			this.setTerm(matrix.terms[i].row, matrix.terms[i].col, matrix.terms[i].value);		
	}
	public SparseMatrix(int r, int c) 
	{
		// initialize
		terms = new Term[2];
		terms[0] = new Term();
		terms[0].row = r;
		terms[0].col = c;
		terms[0].value = 0;
	}

	public Term getTerm(int index) 
	{
		return terms[index];
	}
	public void setTerm(int r , int c, int v)
	{
		// save operation time
		int count = terms[0].value;
		if(++count >= terms.length)
			terms = Arrays.copyOf(terms, terms.length * 2);
		// input
		this.terms[count] = new Term();
		this.terms[count].row = r;
		this.terms[count].col = c;
		this.terms[count].value = v;
		// first value is count
		terms[0].value++;
	}
	public boolean isEqual(SparseMatrix matrix)
	{
		if(this.terms[0].row == matrix.terms[0].row && this.terms[0].col == matrix.terms[0].col)
			return true;
		return false;
	}
		
	public void transpose() 
	{
		int count = this.terms[0].value;
		// count + value(1) + null
		Term[] temp = new Term[count + 2];
		temp[0] = new Term();
		int row = temp[0].row = this.terms[0].col;
		temp[0].col = this.terms[0].row;
		temp[0].value = count;
		// there's number
		if(count > 0)
		{		
			for(int i = 1, k = 1 ; i <= row ; i++)
			{
				for(int j = 1 ; j <= count ; j++)
				{
					if(this.terms[j].col == i - 1)
					{
						temp[k] = new Term();
						temp[k].row = this.terms[j].col;
						temp[k].col = this.terms[j].row;
						temp[k].value = this.terms[j].value;
						if(k < count)
							k++;
					}				
				}
			}
			this.terms = temp;
		}	
	}
	public void fastTranspose()
	{
		int count = this.terms[0].value;
		// count + value(1) + null
		Term[] temp = new Term[count + 2];
		temp[0] = new Term();
		int row = temp[0].row = this.terms[0].col;
		temp[0].col = this.terms[0].row;
		temp[0].value = count;
		// 穝皚ぇ羆计
		int[] rowTerms = new int[row];
		int[] startingPos = new int[row]; 
		if (count > 0)	// nonzero matrix
		{
			// ﹍て
			for (int i = 0; i < row; i++)
				rowTerms[i] = 0;
			// тじ计
			for (int i = 1; i <= count; i++)
				rowTerms[this.terms[i].col]++;
			// 	﹍て癬﹍竚
			startingPos[0] = 1;
			for (int i = 1; i < row; i++)
				startingPos[i] = startingPos[i - 1] + rowTerms[i - 1];
			for (int i = 1; i <= count; i++) 
			{
				int j = startingPos[this.terms[i].col]++;			
				temp[j] = new Term();
				temp[j].row = this.terms[i].col;
				temp[j].col = this.terms[i].row;
				temp[j].value = this.terms[i].value;
			}
		}
		this.terms = temp;
	}
	public static SparseMatrix add(SparseMatrix matrix1, SparseMatrix matrix2)
	{
		// can't calculate
		if (!matrix1.isEqual(matrix2))
			return null;

		// max count
		int count = matrix1.terms[0].value + matrix2.terms[0].value;
		// count + value(1)
		Term[] temp = new Term[count + 1];
		// totalA琌材痻皚獶箂兜计
		int totalA = matrix1.terms[0].value;
		int totalB = matrix2.terms[0].value;
		// setting bound: count + next one for adding 
		matrix1.terms[totalA + 1] = new Term();
		matrix2.terms[totalB + 1] = new Term();
		matrix1.terms[totalA + 1].row = matrix1.terms[0].row;
		matrix2.terms[totalB + 1].row = matrix2.terms[0].row;
		matrix2.terms[totalB + 1].col = 0; 
		// initialize
		int i = 1, j= 1, totalD = 0;
		// j: add 1 to storage item
		while (j <= totalB + 1)
		{
			if(matrix1.terms[i].row == matrix2.terms[j].row)
			{				
				if(matrix1.terms[i].col == matrix2.terms[j].col)
				{
					totalD = storeSum(temp, totalD, matrix1.terms[i].row, matrix1.terms[i].col, matrix1.terms[i++].value + matrix2.terms[j++].value);				
				}
				else if(matrix1.terms[i].col < matrix2.terms[j].col)
				{
					totalD = storeSum(temp, totalD, matrix1.terms[i].row, matrix1.terms[i].col, matrix1.terms[i++].value);
				}
				else
				{
					totalD = storeSum(temp, totalD, matrix2.terms[j].row, matrix2.terms[j].col, matrix2.terms[j++].value);
				}

			}
			else if(matrix1.terms[i].row < matrix2.terms[j].row)
			{
				totalD = storeSum(temp, totalD, matrix1.terms[i].row, matrix1.terms[i].col, matrix1.terms[i++].value);	
			}
			else
			{
				totalD = storeSum(temp, totalD, matrix2.terms[j].row, matrix2.terms[j].col, matrix2.terms[j++].value);				
			}
		} //end while 

		temp[0] = new Term();
		temp[0].row = matrix1.terms[0].row;
		temp[0].col = matrix1.terms[0].col;
		temp[0].value = totalD;
		matrix1.terms = temp;
		return matrix1;
	}
	public static SparseMatrix mult(SparseMatrix matrix1, SparseMatrix matrix2)
	{		
		// can't calculate
		if (matrix1.terms[0].col != matrix2.terms[0].row)
			return null;
		// transpose for calculating
		matrix2.transpose();		
		// totalA琌材痻皚獶箂兜计
		int totalA = matrix1.terms[0].value;
		int totalB = matrix2.terms[0].value;
		int rowsA = matrix1.terms[0].row;
		int colsA = matrix1.terms[0].col;
		int rowsB = matrix2.terms[0].row;
		int colsB = matrix2.terms[0].col;
		// length: 1st row & 2nd col  + value
		Term[] temp = new Term[rowsA * colsB + 1];        
		// setting bound: count + next one for adding 
		matrix1.terms[totalB + 1] = new Term();
		matrix2.terms[totalB + 1] = new Term();
		matrix1.terms[totalA + 1].row = rowsA;
		matrix2.terms[totalB + 1].row = rowsB;
		matrix2.terms[totalB + 1].col = 0;       
		// initialize
		int row = matrix1.terms[1].row;
		int column, rowBegin = 1;
		int i = 1, sum = 0, totalD = 0;

		// count: num
		while (i <= totalA)
		{
			column = matrix2.terms[1].row;
			int j = 1;
			// j: add 1 to storage item
			while (j <= totalB + 1)
			{
				// arow * bcolumn
				if (matrix1.terms[i].row != row)
				{
					totalD = storeSum(temp, totalD, row, column, sum);
					sum = 0;
					// reborn
					i = rowBegin;
					// go to next column
					while (matrix2.terms[j].row == column)
						j++;
					column = matrix2.terms[j].row;
				}
				else if (matrix2.terms[j].row != column)
				{
					totalD = storeSum(temp, totalD, row, column, sum);
					sum = 0;
					// reborn
					i = rowBegin;
					// go to next column
					column = matrix2.terms[j].row;
				}
				else
				{
					// A go to next
					if (matrix1.terms[i].col - matrix2.terms[j].col < 0)
						i++;
					// add terms, a, b go to next term
					else if (matrix1.terms[i].col - matrix2.terms[j].col == 0) 
						sum += (matrix1.terms[i++].value * matrix2.terms[j++].value);
					// b go to next 
					else  
						j++;
				}
			} //end of for i <= totalA 
			while (matrix1.terms[i].row == row)
				i++;
			rowBegin = i;
			row = matrix1.terms[i].row;
		}
		temp[0] = new Term();
		temp[0].row = rowsA;
		temp[0].col = colsB;
		temp[0].value = totalD;
		matrix1.terms = temp;
		return matrix1;
	}
	private static int storeSum(Term[] d, int totalD, int row, int column, int sum)
	{
		/* 安sum != 0, 玥sum籔ㄤ┮籔︽穦砆dいtotalD+1竚*/
		if (sum != 0) 
		{
			d[++totalD] = new Term();
			d[totalD].row = row;
			d[totalD].col = column;
			d[totalD].value = sum;
		}
		return totalD;
	}
}
