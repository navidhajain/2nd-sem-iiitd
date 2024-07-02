public class buff {
    public static void main(String[] args) {
        String s="{{)}}";
        // s= s.replace("{}", "");
        System.out.println(balancedbrackets(s));
    }

    public static String balancedbrackets(String s){
		int n = -1;
		while (s.length() != n) {
			n = s.length();
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
		}
		if (s.length() == 0){
			return "YES";}
		else {
			return "NO";}
	}
}
