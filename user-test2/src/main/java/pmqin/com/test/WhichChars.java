package pmqin.com.test;

import java.util.BitSet;

public class WhichChars {
	private BitSet used = new BitSet();

	//http://www.cnblogs.com/happyPawpaw/p/3823277.html
	public static void main(String[] args) {
		char d='哈';
		System.out.println(d);
		//WhichChars chars = new WhichChars("adsjb");
//		System.out.println(chars.toString());
		WhichChars chars = new WhichChars();
		BitSet bm=new BitSet();  //默认64位
        System.out.println(bm.isEmpty()+"--"+bm.size());  
        bm.set(0);  
        System.out.println(bm.isEmpty()+"--"+bm.size());  
        bm.set(1);  
        System.out.println(bm.isEmpty()+"--"+bm.size());  
        System.out.println(bm.get(65));  
        System.out.println(bm.isEmpty()+"--"+bm.size());  
        bm.set(65);  //超过64位了
        System.out.println(bm.isEmpty()+"--"+bm.size());  
        
        System.out.println(chars.toString(bm));
	}

	public WhichChars(){}
	public WhichChars(String str) {
		int tmp = 0;
		System.out.println(str.length());
		for (int i = 0; i < str.length(); i++) {
			tmp = i;
			System.out.println(str.charAt(tmp));
			used.set(str.charAt(tmp)); // set bit for char
		}
	}
	
	public String toString(BitSet used){
        String desc="[";
        int size=used.size();
         for(int i=0;i< size;i++){
            if(used.get(i))
                desc+=(char)i;
           }
            return desc+"]";
        }

}
