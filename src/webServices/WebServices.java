package webServices;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/main")
public class WebServices {
	
	@POST
	@Path("/insert")
	public String insert(@FormParam("fn") String fn, @FormParam("ln") String ln){
		String fullname = fn + " " + ln;
		return fullname;
	}
	

}
