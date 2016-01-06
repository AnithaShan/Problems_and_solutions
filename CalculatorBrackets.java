
import java.util.*;
public class CalculatorBrackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str ="(2*3)/(2*3)";
		calcAssign(str);
	}
	static void calcAssign(String str){
		String calcStr = str;
		int value, start, end;
		while(calcStr.contains("(")){
			start = calcStr.indexOf("(")+1;
			end = calcStr.indexOf(")");
			calcStr = calcStr.substring(start, end);
			value = calcSeg(calcStr);
			calcStr = str.replace("("+calcStr+")", Integer.toString(value));
			str = calcStr;
		}
		value = calcSeg(calcStr);
		System.out.println(value);
		
	}
	static int calcSeg(String calcStr){
		char[] a = calcStr.toCharArray();
		int value;
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
			num.add(Integer.parseInt(calcStr.substring(initial, (index.get(i)))));
			initial = (index.get(i))+1;
			i++;	
		}
		num.add(Integer.parseInt(calcStr.substring(initial, calcStr.length())));
		value = calc(op, num);	
		return value;
	}
	static int calc(ArrayList<String> op ,ArrayList<Integer> num){
		int i,value;
		i=0;
		while(i<op.size()){
			while(op.contains("*") ||op.contains("/") ){
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
				else if(op.get(i).equals("-")){
					value = num.get(i) - num.get(i+1);
					op.remove(i);
					num.remove(i+1);
					num.remove(i);
					num.add(i, value);
					i=0;
				}
			}
		}
		return num.get(0);
	}
}
