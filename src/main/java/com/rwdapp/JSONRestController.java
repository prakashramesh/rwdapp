package com.rwdapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/get/parts")
public class JSONRestController {
	
	public JSONRestController() {
		generateParts();
	}
	
	public List<Part> generatedParts;
	
	public static class Part {
		Part(String pn, String pname) {
			partNo = pn;
			partName = pname;
		}

		public String getPartNo() {
			return partNo;
		}

		public void setPartNo(String partNo) {
			this.partNo = partNo;
		}

		public String getPartName() {
			return partName;
		}

		public void setPartName(String partName) {
			this.partName = partName;
		}

		String partNo;
		String partName;
	}


	@RequestMapping(value = "{partCount}", method = RequestMethod.GET)
	public @ResponseBody List<Part> getParts(@PathVariable int partCount) {
		return generatedParts.subList(0, partCount-1);
	}
	
	private void generateParts(){
		List<Part> returnParts= new ArrayList<Part>();
		for (int i = 0; i < 10; i++) {
			Part returnPart = new Part(i+"", "Part No "+i);	
			returnParts.add(returnPart);
		}
		generatedParts = returnParts;
	}
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void getPartForID(@RequestBody String partID) {
		System.out.println("Received PART ID -->" + partID);
	}

}
