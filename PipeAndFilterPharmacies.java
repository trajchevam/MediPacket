package ProektAiDnS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PipeAndFilterPharmacies {
    public static void main(String[] args) throws FileNotFoundException {

        PipeProject<String> pipe = new PipeProject<String>();

        FilterPharmacy filterPharmacy = new FilterPharmacy();
        FilterNeededTags filterNeededTags = new FilterNeededTags();
        FilterOutput filterOutput = new FilterOutput();

        pipe.addFilter(filterPharmacy);
        pipe.addFilter(filterNeededTags);
        pipe.addFilter(filterOutput);

        Scanner scanner = new Scanner(new File("C:\\Users\\Mila\\OneDrive - UKIM, FINKI\\Desktop\\Fakultet\\AiDnS\\src\\ProektAiDnS\\map"));

        StringBuilder input = new StringBuilder();

        while(scanner.hasNext()){
            input.append(scanner.nextLine());
        }

        String[] nodes= input.toString().split("<node");
        nodes[nodes.length-1]="";
        int i = 1;

        for(String node : nodes){

            String out = pipe.runFilter(node);
            if(out.equals(""))
                continue;
            else{
                System.out.println(i+". "+out);
                i++;
            }

        }

    }
}
