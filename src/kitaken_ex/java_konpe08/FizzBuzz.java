package kitaken_ex.java_konpe08;

public class FizzBuzz {
	public static void main(String[] arg){
		
		for(int i=1;i<=100;i++){
			String s="";
			if(i%3==0){
				s="Fizz";
			}
			if(i%5==0){
				s=s+"Buzz";
			}
			if(s.length()==0){
				s=""+i;
			}
			System.out.println(s);
		}
	}
}
