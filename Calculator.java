
import java.util.*;
public class Calculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="20";
		char[] a = str.toCharArray();
		int i,j;
		ArrayList<String> op = new ArrayList<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		j=0;
		i=0;
		for(char output : a){
			if((output== '+') ||(output== '*') || (output== '-') || (output== '/'))
			{
				index.add(i);
				j=j+1;
				op.add(Character.toString(output));
			}
				
			i++;
		}
		int initial = 0;
		 i=0;
		while(i<index.size()){
			num.add(Integer.parseInt(str.substring(initial, (index.get(i)))));
			initial = (index.get(i))+1;
			i++;	
		}
		num.add(Integer.parseInt(str.substring(initial, str.length())));
		calc(op, num);	
	}
	static void calc(ArrayList<String> op ,ArrayList<Integer> num){
		int i,value;
		i=0;
		while(i<op.size()){
			while(op.contains("*") ||op.contains("/") ){
//				i=0;
//				System.out.println(  "----" + i);
				if(op.get(i).equals("*")){
					value = num.get(i) * num.get(i+1);
					op.remove(i);
					num.remove(i+1);
					num.remove(i);
					num.add(i, value);
					i=0;
				}
				else if(op.get(i).equals("/")){
					value = num.get(i) / num.get(i+1);
					op.remove(i);
					num.remove(i+1);
					num.remove(i);
					num.add(i, value);
					i=0;
				}
				else{
					i++;
				}
			}
			if(op.size()>0){
				if(op.get(i).equals("+")){
					value = num.get(i) + num.get(i+1);
					op.remove(i);
					num.remove(i+1);
					num.remove(i);
					i=0;
					num.add(i, value);
				}
				if(op.get(i).equals("-")){
					value = num.get(i) - num.get(i+1);
					op.remove(i);
					num.remove(i+1);
					num.remove(i);
					num.add(i, value);
					i=0;
				}
			}
		}
		for(i=0;i<num.size();i++){
			System.out.println(num.get(i));
		}
	}
}
