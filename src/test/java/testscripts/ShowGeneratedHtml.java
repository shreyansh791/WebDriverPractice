package testscripts;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ShowGeneratedHtml {

    public static void main(String[] args) throws Exception {
    File file=new File("abc.html");
    BufferedWriter bw=new BufferedWriter(new FileWriter(file));
    String html="<h1><table border=1 style=\"width:100%\">"
    		+ ""
    		+ ""+
    		"<tr>"+
    	    "<td>Firstname</td>"+
    	    "<td>Lastname</td>" +
    	    "<td>Age</td>"+
    	  "</tr>"    		+ ""
    		+ "</table></h1>";
    bw.write(html);
    bw.close();
    
    }
}

