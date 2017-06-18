package cn.bupt.other.methods;

import cn.bupt.stack.SequenceStack;




public class Expression {
	
	public static void main(String[] args) {
	
		System.out.println(new Expression().getSubfixExpression("(,a,+,b,*,c,),+,(,(,d,*,e,+,f,),*,g,)"));
		System.out.println(getResult("1,2,3,*,+,4,5,*,6,+,7,*"));
	}
	
	SequenceStack stack=new SequenceStack(20);
	
	public static double getResult(String expression){
		String token[]=expression.split(",");
		SequenceStack stack=new SequenceStack(token.length);
		for(int i=0;i<token.length;i++){
			if(isBasicOperate(token[i])){
				double num1=Double.parseDouble(stack.pop()+"");
				double num2=Double.parseDouble(stack.pop()+"");
				double result=operate(token[i], num2, num1);
				stack.push(result);
			}else{
				stack.push(token[i]);
			}
		}
		return Double.parseDouble(stack.pop()+"");
	}
	
	public static double operate(String operate,double num1,double num2){
		
		double value=Double.NaN;
		
		switch (operate) {
		case "+":
			value=num1+num2;
			break;
		case "-":
			value=num1-num2;
			break;
		case "*":
			value=num1*num2;
			break;
		case "/":
			value=num1/num2;
			break;
		}
		
		return value;
	}
	
	public static boolean isOperate(String operate){
		if("+".equals(operate)||"-".equals(operate)
				||"*".equals(operate)||"/".equals(operate)
				||"(".equals(operate)||")".equals(operate)){
			return true;
		}
		return false;
	}
	
	public String getTempExpression(String operate){
		
		String tempExpression="";
		while(!stack.isEmpty()){
			if(isBasicOperate(stack.peek()+"")&&getPriority(stack.peek()+"")>=getPriority(operate)){
				tempExpression+=stack.pop();
			}else{
				break;
			}
		}
		stack.push(operate);
		
		return tempExpression;
		
	}
	
	public String getParent(){
		
		String parent="";
		while(!stack.isEmpty()){
			if(!"(".equals(stack.peek())){
				parent+=stack.pop();
			}else{
				stack.pop();
				break;
			}
		}
		
		return parent;
	}
	
	public  String getSubfixExpression(String infixExpression){
		
		String subfixExpression="";
		String token[]=infixExpression.split(",");
		for(int i=0;i<token.length;i++){
			switch (token[i]) {
			case "+":
			case "-":
			case "*":
			case "/":
				subfixExpression+=getTempExpression(token[i]);
				break;
			case "(":
				stack.push("(");
				break;
			case ")":
				subfixExpression+=getParent();
				break;
			default:
				subfixExpression+=token[i];
			}
		}
		
		return subfixExpression;
		
	}
	
	public static int getPriority(String operate){
		
		int rank=-1;
		switch (operate) {
		case "+":
			rank=0;
			break;
		case "-":
			rank=0;
			break;
		case "*":
			rank=1;
			break;
		case "/":
			rank=1;
			break;
		case "(":
			rank=2;
			break;
		case ")":
			rank=2;
			break;
		}
		
		return rank;
		
	}
	
	public static boolean isBasicOperate(String operate){
		if("+".equals(operate)||"-".equals(operate)||"*".equals(operate)||"/".equals(operate)){
			return true;
		}
		return false;
	}
	

}
