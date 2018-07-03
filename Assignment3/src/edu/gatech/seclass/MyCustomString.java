package src.edu.gatech.seclass;

public class MyCustomString implements MyCustomStringInterface{

    private String str = null;

    public String getString(){

        if (this.str == null)
            return null;
        else
            return this.str;
    }

    public void setString(String string){
        this.str = string;
    }

    public int countNumbers(){

        if (this.str == null || this.str.length() == 0)
            return 0;

        int idx = 0;
        int count = 0;
        while (idx < this.str.length()){

            if (Character.isDigit((this.str.charAt(idx)))){
                while (idx < this.str.length() && Character.isDigit((this.str.charAt(idx))))
                    idx++;
                count++;
            }
            idx++;

        }

        return count;
    }

    public String rotateCharacters(int n, boolean right){
            StringBuilder sb = new StringBuilder();
            String strstr = this.str;

            for (int i = 0; i < strstr.length(); i = i+n){
                if (right == true){
                    if (i+n < str.length()){
                        String tmp = strstr.substring(i, i+n);
                        sb.append(tmp.charAt(tmp.length()-1));
                        sb.append(tmp.substring(0, tmp.length()-1));

                    }else if(i+n > str.length()){
                        String tmp = strstr.substring(i, str.length());
                        sb.append(tmp.charAt(tmp.length()-1));
                        sb.append(tmp.substring(0, tmp.length()-1));

                    }
                }else if (right == false){
                    if (i+n < str.length()){
                        String tmp = strstr.substring(i, i+n);
                        sb.append(tmp.substring(1, tmp.length()));
                        sb.append(tmp.charAt(0));

                    }else if(i+n > str.length()){
                        String tmp = strstr.substring(i, str.length());
                        sb.append(tmp.substring(1, tmp.length()));
                        sb.append(tmp.charAt(0));


                    }

                }
            }

        return sb.toString();
    }

    public void convertLettersToDigitsInSubstring(int startPosition, int endPosition){

        if (this.str == null || this.str.length() == 0)
            return;

        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < this.str.length(); i++){
            if (i >= startPosition && i <= endPosition && Character.isLetter(this.str.charAt(i))){
                int val = Character.toLowerCase(this.str.charAt(i))- 'a' + 1;
                tmp.append(val);
                if (i + 1 < this.str.length() && Character.isLetter(this.str.charAt(i+1)) && i != this.str.length() - 1){
                    if (i != endPosition)
                        tmp.append(',');
                }
            }else{
                tmp.append(this.str.charAt(i));
            }

        }
        this.str = String.valueOf(tmp);
    }

}
