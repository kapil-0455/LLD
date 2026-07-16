package Lect7_Build_Google_Docs.BadDesign;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// All logic in same class not following SOLID principles
class DocumentEditor{
    private List<String> documentElements;
    private String renderdString;

    DocumentEditor(){
        documentElements = new ArrayList<>();
        renderdString= "";
    }

    public void addString(String str){
        documentElements.add(str);
    }

    public void addPathImage(String path){
        documentElements.add(path);
    }


    public String render(){
        if(renderdString.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(String element : documentElements){
                if (element.length() > 4 &&
                        (element.endsWith(".png") || element.endsWith(".jpg"))) {
                    sb.append("[Image ").append(element).append("]").append("\n");
                } else {
                    sb.append(element).append("\n");
                }
            }

            renderdString = sb.toString();
        }

        return renderdString;
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(render());
            writer.close();
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }

}
public class Bad_Design {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addString("My name is Kapil");
        editor.addPathImage("whatsapp.jpg");

        System.out.println(editor.render());
        editor.saveToFile();


    }

}
