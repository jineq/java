package kitaken_ex.java_konpe09to14;

public class prime {
	public static boolean isprims(int n){
		boolean n1=true;
		
		if((n%2==0 && n>2)|| n==1){
			n1=false;
			return n1;
		}
		for(int i=3;i*i<=n;i+=2){
			if(n%i==0){
				n1=false;
				break;
			}
		}
		return n1;
	}
	public static void main(String[] args){
		int n=4;
		System.out.println("n = "+n +" is prime?"+" answer: "+prime.isprims(n));
	}
}
