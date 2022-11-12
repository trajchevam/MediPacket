package ProektAiDnS;

public class FilterOutput implements Filter<String>{
    @Override
    public String execute(String input) {
        if(input == "")
            return "";

        //System.out.println(input);

        String[] tags = input.split("\\s{2,}");
        String name = tags[0];

        //take lon and lat
        String[] partsInitInfo = tags[1].split(" ");
        String lat = partsInitInfo[1].substring(5).replace("\"","");
        String lon = partsInitInfo[2].substring(5).replace("\"","");

        String address = "https://maps.google.com/?q="+lat+","+lon;

        //opening hours
        String openHours = "";
        if(tags.length==3){
            openHours = tags[2].substring(26);
            int i = openHours.indexOf("\"");
            openHours = openHours.substring(0,i);
        }

        return String.format("%-30s %s %s", name, address, openHours);
    }
}
