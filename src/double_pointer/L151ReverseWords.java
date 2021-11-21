package double_pointer;

public class L151ReverseWords {
	public String reverseWords(String s) {
        String str = s.trim();
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int i = n-1;
        int j = i;
        while(i >= 0){
            while(i >= 0 && str.charAt(i) != ' '){
                i--;
            }
            res.append(str.substring(i+1, j+1)+ " ");
            while(i >= 0 && str.charAt(i) == ' '){
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }
}
