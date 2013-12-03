public class ErasingCharacters {
    public static String simulate(String s) {
	StringBuilder sb = new StringBuilder(s);
	for (int i = 0; i < sb.length()-1; )
	    if (sb.charAt(i) == sb.charAt(i+1)) {
		sb.deleteCharAt(i); sb.deleteCharAt(i);
		if (i > 0) i--;
	    }
	    else i++;
	
	return sb.toString();
    }

    public static void main(String[] args) {
	System.out.println(simulate("c") + "~" + simulate("cceett") + "~" + simulate("cceet"));
	System.out.println(simulate("cieeilll"));
    }
}