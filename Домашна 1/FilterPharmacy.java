package ProektAiDnS;

public class FilterPharmacy implements Filter<String>{
    @Override
    public String execute(String input) {

        if(input.contains("pharmacy")){
            return input;
        }

        return "";
    }
}
