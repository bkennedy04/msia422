package Project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project 2 - Java  
 * The MyDataFrame class offers interfaces similar
 * to those found in Python Pandas dataframes.
 *
 * @author Brooke Kennedy
 * @author Jamie Chen
 * @since 2017-12-05
 */
public class MyDataFrame {
	
	//member variables
	String[] headers;
	public ArrayList<Object> babynames;
	
	//Construct MyDataFrame with header row;
	public MyDataFrame(String[] header) {
		babynames = new ArrayList<>();
		this.headers = header;
	}
	
	//Construct MyDataFrame without header row;
	public MyDataFrame() {
		babynames = new ArrayList<>();
	}
	
	//Returns the first n rows of the data
	public MyDataFrame head(int n) {
		MyDataFrame top = new MyDataFrame(headers);
		if(babynames.size() >= n) {
			for(int i = 0; i < n; i++) {
				top.babynames.add(babynames.get(i));
			}
		}
		return top;
	}
	
	//Returns the last n rows of the data
	public MyDataFrame tail(int n) {
		MyDataFrame end = new MyDataFrame(headers);
		//make sure you have enough elements
		if(babynames.size() >= n) {
			for(int i = 1; i <= n; i++) {
				end.babynames.add(babynames.get(babynames.size()-i));
			}
		}
		return end;
	}
	
	//Returns the type of the column specified by index.
	//If the type is not uniform, returns String.
	public String dType(int index) {
		String type = null;
		if(index == 2 || index == 4) {
			type = "int";
		}
		else if(index == 0 || index == 1 || index == 3){
			type = "String";
		}
		return type;
	}
	
	//Returns the type of the column specified by name.
	//If the type is not uniform, returns String.
	public String dType(String name) {
		String type = null;
		if(name.toLowerCase().equals("year") || name.toLowerCase().equals("count")) {
			type = "int";
		}
		else if(name.toLowerCase().equals("state") || name.toLowerCase().equals("gender") || name.toLowerCase().equals("name")) {
			type = "String";
		}
		return type;
	}
	
	//Returns the column specified by index
	public MyDataFrame slice(int index) {
		MyDataFrame sli = new MyDataFrame();
		
		switch(index) {
			case 0:
				for(int i = 0; i < babynames.size(); i++) {
					sli.babynames.add(MyData.getState((MyData) babynames.get(i)));
				}
				break;
				
			case 1:
				for(int i = 0; i < babynames.size(); i++) {
					sli.babynames.add(MyData.getGender((MyData) babynames.get(i)));
				}
				break;
				
			case 2:
				for(int i = 0; i < babynames.size(); i++) {
					sli.babynames.add(MyData.getYear((MyData) babynames.get(i)));
				}
				break;
				
			case 3:
				for(int i = 0; i < babynames.size(); i++) {
					sli.babynames.add(MyData.getName((MyData) babynames.get(i)));
				}
				break;
				
			case 4:
				for(int i = 0; i < babynames.size(); i++) {
					sli.babynames.add(MyData.getCount((MyData) babynames.get(i)));
				}
				break;
		}	
		return sli;
	}
	
	//Returns the column specified by name
	public MyDataFrame slice(String name) {
		MyDataFrame sli = new MyDataFrame();
		
		switch(name) {
			case "state":
				for(int i = 0; i < babynames.size(); i++) {
					sli.babynames.add(MyData.getState((MyData) babynames.get(i)));
				}
				break;
				
			case "gender":
				for(int i = 0; i < babynames.size(); i++) {
					sli.babynames.add(MyData.getGender((MyData) babynames.get(i)));
				}
				break;
				
			case "year":
				for(int i = 0; i < babynames.size(); i++) {
					sli.babynames.add(MyData.getYear((MyData) babynames.get(i)));
				}
				break;
				
			case "name":
				for(int i = 0; i < babynames.size(); i++) {
					sli.babynames.add(MyData.getName((MyData) babynames.get(i)));
				}
				break;
				
			case "count":
				for(int i = 0; i < babynames.size(); i++) {
					sli.babynames.add(MyData.getCount((MyData) babynames.get(i)));
				}
				break;
		}
		return sli;
	}
	
	//Returns the columns specified by an index array
	public MyDataFrame slice(int[] indexArr) {
		
		MyDataFrame sli = new MyDataFrame();
		int index;
		
		for(int i = 0; i < babynames.size(); i++) {
			List<Object> row = new ArrayList<Object>();
			for(int x = 0; x < indexArr.length; x++) {
				index = indexArr[x];
				
				switch(index) {
					case 0:
						row.add(MyData.getState((MyData) babynames.get(i)));
						break;
						
					case 1:
						row.add(MyData.getGender((MyData) babynames.get(i)));
						break;
						
					case 2:
						row.add(MyData.getYear((MyData) babynames.get(i)));
						break;
						
					case 3:
						row.add(MyData.getName((MyData) babynames.get(i)));
						break;
						
					case 4:
						row.add(MyData.getCount((MyData) babynames.get(i)));
						break;
				}		
			}
			sli.babynames.add(row);
		}
		return sli;
	}
	
	//Returns the columns specified by a name array
	public MyDataFrame slice(String[] nameArr) {
		
		MyDataFrame sli = new MyDataFrame();
		String col;
		
		for(int i = 0; i < babynames.size(); i++) {
			List<Object> row = new ArrayList<Object>();
			for(int x = 0; x < nameArr.length; x++) {
				col = nameArr[x];
				
				switch(col) {
					case "state":
						row.add(MyData.getState((MyData) babynames.get(i)));
						break;
						
					case "gender":
						row.add(MyData.getGender((MyData) babynames.get(i)));
						break;
						
					case "year":
						row.add(MyData.getYear((MyData) babynames.get(i)));
						break;
						
					case "name":
						row.add(MyData.getName((MyData) babynames.get(i)));
						break;
						
					case "count":
						row.add(MyData.getCount((MyData) babynames.get(i)));
						break;
				}		
			}
			sli.babynames.add(row);
		}
		return sli;
	}	
	
	//Returns data filtered by applying "col op o" on MyDataFrame object
	//col = {state, gender, year, name, count }
	//op = { =, <, >, <=, >= }
	//o must be of type col
	public MyDataFrame filter(String col, String op, Object o) {
		MyDataFrame filtered = new MyDataFrame();
		switch(col) {
			case "state":
				for(Object row: babynames) {
					String st = MyData.getState((MyData) row);	
					if(st.equals((String) o)) {
						filtered.babynames.add(row);
					}
				}
				break;
				
			case "gender":
				for(Object row: babynames) {
					String g = MyData.getGender((MyData) row);	
					if(g.equals((String) o)) {
						filtered.babynames.add(row);
					}
				}
				break;
				
			case "year":
				for(Object row: babynames) {
					int yr = MyData.getYear((MyData) row);
					switch(op) {
						case "=":
							if(yr == (int) o) {
								filtered.babynames.add(row);
							}
							break;
						case "<":
							if(yr < (int) o) {
								filtered.babynames.add(row);
							}
							break;
						case ">":
							if(yr > (int) o) {
								filtered.babynames.add(row);
							}
							break;
						case "<=":
							if(yr <= (int) o) {
								filtered.babynames.add(row);
							}
							break;
						case ">=":
							if(yr >= (int) o) {
								filtered.babynames.add(row);
							}
							break;
					}
				}
				break;
				
			case "name":
				for(Object row: babynames) {
					String n = MyData.getName((MyData) row);	
					if(n.equals((String) o)) {
						filtered.babynames.add(row);
					}
				}
				break;
				
			case "count":
				for(Object row: babynames) {
					int c = MyData.getCount((MyData) row);
					switch(op) {
						case "=":
							if(c == (int) o) {
								filtered.babynames.add(row);
							}
							break;
						case "<":
							if(c < (int) o) {
								filtered.babynames.add(row);
							}
							break;
						case ">":
							if(c > (int) o) {
								filtered.babynames.add(row);
							}
							break;
						case "<=":
							if(c <= (int) o) {
								filtered.babynames.add(row);
							}
							break;
						case ">=":
							if(c >= (int) o) {
								filtered.babynames.add(row);
							}
							break;
					}
				}
				break;
		}
		return filtered;
	}
	
	//Returns the rows starting from index
	public MyDataFrame loc(int index) {
		
		MyDataFrame loc = new MyDataFrame();
		
		for(int i = index; i < babynames.size(); i++) {
			loc.babynames.add(babynames.get(i));
		}
		return loc;
	}
	
	//Returns the rows between from and to (including from and to)
	public MyDataFrame loc(int from, int to) {
		
		MyDataFrame loc = new MyDataFrame();
		
		for(int i = from; i <= to; i++) {
			loc.babynames.add(babynames.get(i));
		}
		return loc;
	}
	
	//Returns the data sorted by the column specified by index
	public MyDataFrame sort(int index) {
		
		int[] indexes = new int[babynames.size()];
		MyDataFrame sorted = new MyDataFrame();
		
		switch(index) {
			//state
			case 0:
				ArrayList<String> colState = new ArrayList<>();
				for(int i = 0; i < babynames.size(); i++) {
					colState.add(MyData.getState((MyData) babynames.get(i)));
				}
				//make a copy of the column list
				ArrayList<String> indState = new ArrayList<String>(colState);
				//sort column list
				Collections.sort(colState);
				//get the initial indexes from the sorted list
				for (int n = 0; n < colState.size(); n++){
				    indexes[n] = indState.indexOf(colState.get(n));
				    sorted.babynames.add(babynames.get(indexes[n]));
				    indState.set(indexes[n], null);
				}
				break;
				
			//gender
			case 1:
				ArrayList<String> colGender = new ArrayList<>();	
				for(int i = 0; i < babynames.size(); i++) {
					colGender.add(MyData.getGender((MyData) babynames.get(i)));
				}
				//make a copy of the column list
				ArrayList<String> indGender = new ArrayList<String>(colGender);
				//sort column list
				Collections.sort(colGender);
				//get the initial indexes from the sorted list
				for (int n = 0; n < colGender.size(); n++){
				    indexes[n] = indGender.indexOf(colGender.get(n));
				    sorted.babynames.add(babynames.get(indexes[n]));
				    indGender.set(indexes[n], null);
				}
				break;
				
			//year
			case 2:
				ArrayList<Integer> colYear = new ArrayList<>();	
				for(int i = 0; i < babynames.size(); i++) {
					colYear.add(MyData.getYear((MyData) babynames.get(i)));
				}
				//make a copy of the column list
				ArrayList<Integer> indYear = new ArrayList<Integer>(colYear);
				//sort column list
				Collections.sort(colYear);
				//get the initial indexes from the sorted list
				for (int n = 0; n < indexes.length; n++){
				    indexes[n] = indYear.indexOf(colYear.get(n));
				    sorted.babynames.add(babynames.get(indexes[n]));
				    indYear.set(indexes[n], null);
				}
				break;
				
			//name
			case 3:
				ArrayList<String> colName = new ArrayList<>();	
				for(int i = 0; i < babynames.size(); i++) {
					colName.add(MyData.getName((MyData) babynames.get(i)));
				}
				//make a copy of the column list
				ArrayList<String> indName = new ArrayList<String>(colName);
				//sort column list
				Collections.sort(colName);
				//get the initial indexes from the sorted list
				for (int n = 0; n < colName.size(); n++){
				    indexes[n] = indName.indexOf(colName.get(n));
				    sorted.babynames.add(babynames.get(indexes[n]));
				    indName.set(indexes[n], null);
				}
				break;
				
			//count
			case 4:
				ArrayList<Integer> colCount = new ArrayList<>();		
				for(int i = 0; i < babynames.size(); i++) {
					colCount.add(MyData.getCount((MyData) babynames.get(i)));
				}
				//make a copy of the column list
				ArrayList<Integer> indCount = new ArrayList<Integer>(colCount);
				//sort column list
				Collections.sort(colCount);
				//get the initial indexes from the sorted list
				for (int n = 0; n < colCount.size(); n++){
				    indexes[n] = indCount.indexOf(colCount.get(n));
				    sorted.babynames.add(babynames.get(indexes[n]));
				    indCount.set(indexes[n], null);
				}
				break;
		}
		return sorted;
	}
	
	//Returns the data sorted by the column specified by name
	public MyDataFrame sort(String name) {
		
		int[] indexes = new int[babynames.size()];
		MyDataFrame sorted = new MyDataFrame();
		
		switch(name) {
			case "state":
				ArrayList<String> colState = new ArrayList<>();
				for(int i = 0; i < babynames.size(); i++) {
					colState.add(MyData.getState((MyData) babynames.get(i)));
				}
				//make a copy of the column list
				ArrayList<String> indState = new ArrayList<String>(colState);
				//sort column list
				Collections.sort(colState);
				//get the initial indexes from the sorted list
				for (int n = 0; n < colState.size(); n++){
				    indexes[n] = indState.indexOf(colState.get(n));
				    sorted.babynames.add(babynames.get(indexes[n]));
				    indState.set(indexes[n], null);
				}
				break;
				
			case "gender":
				ArrayList<String> colGender = new ArrayList<>();	
				for(int i = 0; i < babynames.size(); i++) {
					colGender.add(MyData.getGender((MyData) babynames.get(i)));
				}
				//make a copy of the column list
				ArrayList<String> indGender = new ArrayList<String>(colGender);
				//sort column list
				Collections.sort(colGender);
				//get the initial indexes from the sorted list
				for (int n = 0; n < colGender.size(); n++){
				    indexes[n] = indGender.indexOf(colGender.get(n));
				    sorted.babynames.add(babynames.get(indexes[n]));
				    indGender.set(indexes[n], null);
				}
				break;
				
			case "year":
				ArrayList<Integer> colYear = new ArrayList<>();	
				for(int i = 0; i < babynames.size(); i++) {
					colYear.add(MyData.getYear((MyData) babynames.get(i)));
				}
				//make a copy of the column list
				ArrayList<Integer> indYear = new ArrayList<Integer>(colYear);
				//sort column list
				Collections.sort(colYear);
				//get the initial indexes from the sorted list
				for (int n = 0; n < indexes.length; n++){
				    indexes[n] = indYear.indexOf(colYear.get(n));
				    sorted.babynames.add(babynames.get(indexes[n]));
				    indYear.set(indexes[n], null);
				}
				break;
				
			case "name":
				ArrayList<String> colName = new ArrayList<>();	
				for(int i = 0; i < babynames.size(); i++) {
					colName.add(MyData.getName((MyData) babynames.get(i)));
				}
				//make a copy of the column list
				ArrayList<String> indName = new ArrayList<String>(colName);
				//sort column list
				Collections.sort(colName);
				//get the initial indexes from the sorted list
				for (int n = 0; n < colName.size(); n++){
				    indexes[n] = indName.indexOf(colName.get(n));
				    sorted.babynames.add(babynames.get(indexes[n]));
				    indName.set(indexes[n], null);
				}
				break;
				
			case "count":
				ArrayList<Integer> colCount = new ArrayList<>();		
				for(int i = 0; i < babynames.size(); i++) {
					colCount.add(MyData.getCount((MyData) babynames.get(i)));
				}
				//make a copy of the column list
				ArrayList<Integer> indCount = new ArrayList<Integer>(colCount);
				//sort column list
				Collections.sort(colCount);
				//get the initial indexes from the sorted list
				for (int n = 0; n < colCount.size(); n++){
				    indexes[n] = indCount.indexOf(colCount.get(n));
				    sorted.babynames.add(babynames.get(indexes[n]));
				    indCount.set(indexes[n], null);
				}
				break;
		}
		return sorted;
	}
	
	//Returns the minimum element of the column specified by index
	public Object getMin(int index) {
		MyDataFrame col = new MyDataFrame();
		ArrayList<String> strs = new ArrayList<String>();
		Object min = null;
		switch(index) {
			//state
			case 0:
				for(int i = 0; i < babynames.size(); i++) {
					strs.add(MyData.getState((MyData) babynames.get(i)));
				}
				min = Collections.min(strs);
				break;
				
			//gender
			case 1:
				for(int i = 0; i < babynames.size(); i++) {
					strs.add(MyData.getGender((MyData) babynames.get(i)));
				}
				min = Collections.min(strs);
				break;

			//year
			case 2:
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getYear((MyData) babynames.get(i)));
				}
				min = Integer.MAX_VALUE;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = (int) col.babynames.get(i);
					if(num < (int) min) {
						min = num;
					}
				}
				break;
				
			//name -- returns name with min length
			case 3:
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getName((MyData) babynames.get(i)));
				}
				min = Integer.MAX_VALUE;
				int minInd = 0;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = ((String) col.babynames.get(i)).length();
					if(num < (int) min) {
						min = num;
						minInd = i;
					}
				}
				min = col.babynames.get(minInd);
				break;
				
			//count
			case 4:
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getCount((MyData) babynames.get(i)));
				}
				min = Integer.MAX_VALUE;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = (int) col.babynames.get(i);
					if(num < (int) min) {
						min = num;
					}
				}
				break;
		}
		return min;
	}
	
	//Returns the minimum element of the column specified by label
	public Object getMin(String label) {
		MyDataFrame col = new MyDataFrame();
		ArrayList<String> strs = new ArrayList<String>();
		Object min = null;
		switch(label) {
			case "state":
				for(int i = 0; i < babynames.size(); i++) {
					strs.add(MyData.getState((MyData) babynames.get(i)));
				}
				min = Collections.min(strs);
				break;
				
			case "gender":
				for(int i = 0; i < babynames.size(); i++) {
					strs.add(MyData.getGender((MyData) babynames.get(i)));
				}
				min = Collections.min(strs);
				break;

			case "year":
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getYear((MyData) babynames.get(i)));
				}
				min = Integer.MAX_VALUE;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = (int) col.babynames.get(i);
					if(num < (int) min) {
						min = num;
					}
				}
				break;
				
			case "name":
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getName((MyData) babynames.get(i)));
				}
				min = Integer.MAX_VALUE;
				int minInd = 0;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = ((String) col.babynames.get(i)).length();
					if(num < (int) min) {
						min = num;
						minInd = i;
					}
				}
				min = col.babynames.get(minInd);
				break;
				
			case "count":
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getCount((MyData) babynames.get(i)));
				}
				min = Integer.MAX_VALUE;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = (int) col.babynames.get(i);
					if(num < (int) min) {
						min = num;
					}
				}
				break;
		}
		return min;
	}
	
	//Returns the maximum element of the column specified by index
	public Object getMax(int index) {
		MyDataFrame col = new MyDataFrame();
		ArrayList<String> strs = new ArrayList<String>();
		Object max = null;
		switch(index) {
			//state
			case 0:
				for(int i = 0; i < babynames.size(); i++) {
					strs.add(MyData.getState((MyData) babynames.get(i)));
				}
				max = Collections.max(strs);
				break;
				
			//gender
			case 1:
				for(int i = 0; i < babynames.size(); i++) {
					strs.add(MyData.getGender((MyData) babynames.get(i)));
				}
				max = Collections.max(strs);
				break;

			//year
			case 2:
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getYear((MyData) babynames.get(i)));
				}
				max = Integer.MIN_VALUE;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = (int) col.babynames.get(i);
					if(num > (int) max) {
						max = num;
					}
				}
				break;
				
			//name -- returns name with min length
			case 3:
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getName((MyData) babynames.get(i)));
				}
				max = Integer.MIN_VALUE;
				int maxInd = 0;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = ((String) col.babynames.get(i)).length();
					if(num > (int) max) {
						max = num;
						maxInd = i;
					}
				}
				max = col.babynames.get(maxInd);
				break;
				
			//count
			case 4:
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getCount((MyData) babynames.get(i)));
				}
				max = Integer.MIN_VALUE;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = (int) col.babynames.get(i);
					if(num > (int) max) {
						max = num;
					}
				}
				break;
		}
		return max;
	}
	
	//Returns the maximum element of the column specified by label
	public Object getMax(String label) {
		MyDataFrame col = new MyDataFrame();
		ArrayList<String> strs = new ArrayList<String>();
		Object max = null;
		switch(label) {

			case "state":
				for(int i = 0; i < babynames.size(); i++) {
					strs.add(MyData.getState((MyData) babynames.get(i)));
				}
				max = Collections.max(strs);
				break;
				
			case "gender":
				for(int i = 0; i < babynames.size(); i++) {
					strs.add(MyData.getGender((MyData) babynames.get(i)));
				}
				max = Collections.max(strs);
				break;
				
			case "year":
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getYear((MyData) babynames.get(i)));
				}
				max = Integer.MIN_VALUE;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = (int) col.babynames.get(i);
					if(num > (int) max) {
						max = num;
					}
				}
				break;
				
			case "name":
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getName((MyData) babynames.get(i)));
				}
				max = Integer.MIN_VALUE;
				int maxInd = 0;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = ((String) col.babynames.get(i)).length();
					if(num > (int) max) {
						max = num;
						maxInd = i;
					}
				}
				max = col.babynames.get(maxInd);
				break;
				
			case "count":
				for(int i = 0; i < babynames.size(); i++) {
					col.babynames.add(MyData.getCount((MyData) babynames.get(i)));
				}
				max = Integer.MIN_VALUE;
				for(int i =0; i < col.babynames.size(); i++) {
					int num = (int) col.babynames.get(i);
					if(num > (int) max) {
						max = num;
					}
				}
				break;
		}
		return max;
	}
}
