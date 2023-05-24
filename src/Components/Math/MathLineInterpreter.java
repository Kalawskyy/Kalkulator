package Components.Math;

public class MathLineInterpreter {
    private String lines[];
    public String result(String lines[]) {
        this.lines=lines;
        Double number1=Double.valueOf(lines[0]);
        if (lines[1].isEmpty()){
            return (String.valueOf(number1));
        } else if (lines[1].length()>1&&"**".equals((String.valueOf(lines[1].charAt(lines[1].length() - 1))+String.valueOf(lines[1].charAt(lines[1].length() - 2))))){
             return(String.valueOf(number1*number1));
        } else if ("*".equals(String.valueOf(lines[1].charAt(lines[1].length() - 1)))) {
            Double number2=Double.valueOf(lines[2]);
            return  String.valueOf(number1*number2);
        } else if ("/".equals(String.valueOf(lines[1].charAt(lines[1].length() - 1)))) {
            Double number2=Double.valueOf(lines[2]);
            if (number2==0){
                return "Błąd";
            }
            return  String.valueOf(number1/number2);
        }else if ("+".equals(String.valueOf(lines[1].charAt(lines[1].length() - 1)))) {
            Double number2=Double.valueOf(lines[2]);
            return  String.valueOf(number1+number2);
        }else if ("-".equals(String.valueOf(lines[1].charAt(lines[1].length() - 1)))) {
            Double number2=Double.valueOf(lines[2]);
            return  String.valueOf(number1-number2);
        }else if ("√".equals(String.valueOf(lines[1].charAt(lines[1].length() - 1)))) {
            return  String.valueOf(Math.sqrt(number1));
        }else if ("%".equals(String.valueOf(lines[1].charAt(lines[1].length() - 1)))) {
            Double number2=Double.valueOf(lines[2]);
            return  String.valueOf((number1/100)*number2);
        }
        return"";
    }
}
