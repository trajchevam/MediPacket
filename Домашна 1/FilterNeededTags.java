package ProektAiDnS;

public class FilterNeededTags implements Filter<String>{
    @Override
    public String execute(String input) {
        String[] parts = input.split("\\s{2,}");
        String name = "", openHours="";
        int initInfo=-1;

        for(int i=0; i<parts.length; i++){
            if(parts[i].contains("name\"")){
                String p = parts[i].substring(17);
                int j = p.indexOf("\"");
                name = p.substring(0,j);
            }
            else if(parts[i].contains("open")){
                openHours = parts[i];
            }
            else if(parts[i].contains("lon=")){
                initInfo=i;
            }
        }
        if(initInfo != -1 && name!="" && openHours!="")
            return String.format("%-30s %s   %s", name, parts[initInfo], openHours);
        else if(initInfo != -1 && name!="")
            return String.format("%-30s %s", name, parts[initInfo]);
        else
            return "";
    }
}
