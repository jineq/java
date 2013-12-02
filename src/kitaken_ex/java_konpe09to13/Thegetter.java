package kitaken_ex.java_konpe09to13;

public class Thegetter {

	Thegetter(){
		
	}
	
	public static void main(String[] args){
		Thegetter getter=new Thegetter();
		int a=2,b=1,c=-1;
		System.out.println("a ="+a+" b="+b+" c ="+c+"  max="+getter.getMax(a, b,c));
		System.out.println("a ="+a+" b="+b+" c ="+c+"  min="+getter.getMin(a, b,c));
		System.out.println("a ="+a+" b="+b+" c ="+c+"  middle="+getter.getMiddle(a, b,c));
	}
	
	public int getMax(int a,int b){
		return (a>b?a:b);
	}
	public int getMax(int a,int b,int c){
		int max=(a>b?a:b);
		max=(max>c?max:c);
		return max;
	}
	public int getMin(int a,int b){
		return (a<b?a:b);
	}
	public int getMin(int a,int b,int c){
		int min=(a<b?a:b);
		min=(min<c?min:c);
		return min;
	}
	public int getMiddle(int a,int b,int c){
		int[] s={a,b,c};
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s.length-i-1;j++){
				if(s[j]<s[j+1]){
					int temp=s[j];
					s[j]=s[j+1];
					s[j+1]=temp;
				}
			}
		}
		return s[1];
	}
}
