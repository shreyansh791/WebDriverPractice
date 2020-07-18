package testscripts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HtmlDesign {
	public static void main(String[] args) throws IOException {
		File file=new File("abc.html");
	    BufferedWriter bw=new BufferedWriter(new FileWriter(file));
	    
	   
	    
		ArrayList<String> list = new ArrayList<String>();
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		list.add("RunOATS_FIN_IEX_RRF_03 (Schedule ID 16031332) Tie");
		list.add("RunOATS_FIN_FA_RRF_00 (Schedule ID 0003464346)");

		list.add("RunOATS_FIN_IEX_RRF_03 (Schedule ID 16031332) Tie");
		list.add("RunOATS_FIN_CRT_RRF_00 (Schedule ID 0003464346)");

		list.add("RunOATS_FIN_CCP_RRF_03 (Schedule ID 16031332) Tie");
		list.add("RunOATS_FIN_CCP_RRF_00 (Schedule ID 0003464346)");

		list.add("RunOATS_FIN_FA_RRF_03 (Schedule ID 16031332) Tie");
		list.add("RunOATS_FIN_FA_RRF_00 (Schedule ID 0003464346)");

		for (String temp : list) {
			String str[] = temp.split("_");
			if (!map.containsKey(str[2])) {
				map.put(str[2], 1);
			} else {
				map.put(str[2], map.get(str[2]) + 1);
			}
		}
		String html="<h1><table border=1   style=\"width:100%\">"
	    		+ ""+
	    		"<tr>"+
	    	    "<td>A</td>"+
	    	    "<td>B</td>" +
	    	    "<td>C</td>"+
	    	  "</tr>";
	    		
	    bw.write(html);
	    
	    
		Iterator<Map.Entry<String, Integer>> it=map.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<String, Integer> mapEntry=it.next();
			bw.write("<tr>"+"<td>"+mapEntry.getKey()+"</td>");
			bw.write("<td>"+mapEntry.getValue()+"</td>"+"</tr>");
			
			
			
		}
		bw.write("");
		bw.write("</table></h1>");
bw.flush();
		bw.close();
	}
}
