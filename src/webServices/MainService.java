/*package webServices;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code39Writer;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;

@Path("/main")
public class MainService {
	
	String response= null;

	@GET
	@Path("/insert1")
	public String insert(@PathParam("firstname") String fn,@PathParam("lastname") String ln){
		return fn + ln;
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String insert(@FormParam("edfirstname") String Firstname,@FormParam("edlastname") String Lastname,@FormParam("edusername") String Username,
			@FormParam("edpassword") String Password,@FormParam("edgender") String Gender,@FormParam("eddob") String Dob,
			@FormParam("edphone") String Phone,@FormParam("edemail") String Email,@FormParam("edaddress") String Address,@FormParam("edcountry") String Country,
			@FormParam("edstate") String State,@FormParam("edcity") String City) {
		
	public String insert(MultivaluedMap<String, String> map){
		String Firstname = map.getFirst("edfirstname");
		String Lastname = map.getFirst("edlastname");
		String Username = map.getFirst("edusername");
		String Password = map.getFirst("edpassword");
		String Gender = map.getFirst("edgender");
		String Dob = map.getFirst("eddob");
		String Phone = map.getFirst("edphone");
		String Email = map.getFirst("edemail");
		String Address = map.getFirst("edaddress");
		String Country = map.getFirst("edcountry");
		String State = map.getFirst("edstate");
		String City = map.getFirst("edcity");
		
		System.out.println(Firstname+ " "+ Lastname+ " "+ Username+ " "+ Password+ " "+ Gender+ " "+ Dob+ " "+ Phone+ " "+Email+ " "+ Address+ " "+ Country+ " "+ State+ " "+City);

		MainDao da = new MainDao();
		List <CustomerVo> user = new ArrayList();
		user = da.search_customer();
		
		int flag = 0;
		for(int i = 0 ;i<user.size();i++){
			if(Username.equals(user.get(i).getUser_name())){
				 flag = 1;
				 break;
			}
		}
	
		
		CustomerVo vo = new CustomerVo();

		if(flag==0){
			vo.setFirst_name(Firstname);
			vo.setLast_name(Lastname);
			vo.setUser_name(Username);
			vo.setPassword(Password);
			vo.setGender(Gender);
			vo.setDob(Dob);
			vo.setNumber(Phone);
			vo.setEmail(Email);
			vo.setAddress(Address);
			vo.setCountry(Country);
			vo.setState(State);
			vo.setCity(City);
			
			da.insert_customer(vo);
			
			String b="asd";
			return b;

		}
		else{
			String a="abc";
			return a;
		}
	}
	
	@POST
	@Path("/insert_order")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public OrderDetailsVo insert_order(MultivaluedMap<String, String> map){
		String quantity = map.getFirst("quantity");
		String item = map.getFirst("item");
		String user = map.getFirst("username");
		
		List<CustomerVo> name = new ArrayList();
		List<OrderVo> order = new ArrayList();
		List<ProductVo> product = new ArrayList();

		MainDao da = new MainDao();

		
		CustomerVo v = new CustomerVo();
		v.setUser_name(user);

		name = da.get_customer(v);
		System.out.println(name.size());
		
		CustomerVo customerVo = new CustomerVo();
		customerVo.setCustomer_id(name.get(0).getCustomer_id());
		
		OrderVo vo = new OrderVo();
		vo.setCustomerVo(customerVo);
		
		order = da.get_order(vo);
		System.out.println(order.size());
		
		OrderVo orderVo = new OrderVo();
		orderVo.setOrder_id(order.get(0).getOrder_id());
		System.out.println("orderId : "+order.get(0).getOrder_id());
		
		OrderDetailsVo vod = new OrderDetailsVo();
		vod.setItem(item);
		vod.setQuantity(quantity);
		vod.setOrderVo(orderVo);
		
		da.insert_orderdetails(vod);
		return null;
	}

	
	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public String search() {
		//JSONObject j = new JSONObject();
		List list = new ArrayList();
		MainDao da = new MainDao();
		list = da.search_customer();
		response = Utitlity.constructJsonCustomerVO(list);
		return "[" + response + "]";
	}

	@GET
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@javax.ws.rs.PathParam("id") int id  ){
		System.out.println(id);
		
		CustomerVo vo = new CustomerVo();
		vo.setCustomer_id(id);
		
		MainDao da = new MainDao();
		da.delete_customer(vo);
		
	}
	
	
	@POST
	@Path("/insertstaff")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public AdminVo insertstaff(MultivaluedMap<String, String> map) {
		String Firstname = map.getFirst("edfirstname");
		String Lastname = map.getFirst("edlastname");
		String Username = map.getFirst("edusername");
		String Password = map.getFirst("edpassword");
		String Gender = map.getFirst("edgender");
		String Dob = map.getFirst("eddob");
		String Phone = map.getFirst("edphone");
		String Position = map.getFirst("edposition");
		String Email = map.getFirst("edemail");
		String Address = map.getFirst("edaddress");
		String Country = map.getFirst("edcountry");
		String State = map.getFirst("edstate");
		String City = map.getFirst("edcity");
		
		System.out.println(Firstname+ " "+ Lastname+ " "+ Username+ " "+ Password+ " "+ Gender+ " "+ Dob+ " "+ Phone + " "+ Position + " "+Email+ " "+ Address+ " "+ Country+ " "+ State+ " "+City);

		AdminVo vo = new AdminVo();
		vo.setFirst_name(Firstname);
		vo.setLast_name(Lastname);
		vo.setUser_name(Username);
		vo.setPassword(Password);
		vo.setGender(Gender);
		vo.setDob(Dob);
		vo.setNumber(Phone);
		vo.setPosition(Position);
		vo.setEmail(Email);
		vo.setAddress(Address);
		vo.setCountry(Country);
		vo.setState(State);
		vo.setCity(City);
		
		MainDao da = new MainDao();
		da.insert_staff(vo);
		
		return null;
	}

	@GET
	@Path("/searchstaff")
//	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String searchstaff() {

		List list = new ArrayList();
		MainDao da = new MainDao();
		list = da.search_staff();
		response = Utitlity.constructJsonCustomerVO(list);
		return "[" + response + "]";
	}

	@POST
	@Path("/insertproduct")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductVo insertproduct(MultivaluedMap<String, String> map) {
		String product_name = map.getFirst("edproduct");
		int weight = Integer.parseInt(map.getFirst("edweight"));
		String category = map.getFirst("edcategory");
		String subcategory = map.getFirst("edsubcategory");
		String location = map.getFirst("edlocation");
		int mrp = Integer.parseInt(map.getFirst("edmrp"));
		Float discount = Float.parseFloat(map.getFirst("eddiscount"));
		Float tax = Float.parseFloat(map.getFirst("edtax"));
		int stock = Integer.parseInt(map.getFirst("edquantity"));
		String path = map.getFirst("xyz");
		int amount = (int) (mrp - (mrp*(discount/100)) + (mrp*(tax/100)));
		//int barcode = map.getFirst("edproduct");
		
		System.out.println(product_name+ " "+ weight+ " "+ category+ " "+ subcategory+ " "+ location+ " "+ mrp+ " "+ discount + " "+ tax + " "+stock + " " + path + " " + amount);

		ProductVo vo = new ProductVo();
		vo.setProduct_name(product_name);
		vo.setWeight(weight);
		vo.setCategory(category);
		vo.setSubcategory(subcategory);;
		vo.setLocation(location);
		vo.setMrp(mrp);
		vo.setDiscount(discount);
		vo.setTax(tax);
		vo.setStock(stock);
		vo.setPath(path);
		vo.setAmount(amount);
		//vo.setBarcode(barcode);
		
		MainDao da = new MainDao();
		da.insert_product(vo);
		
		return null;
	}
	
	@GET
	@Path("/searchproduct")
	@Produces(MediaType.APPLICATION_JSON)
	public String searchproduct() {

		List<ProductVo> list = new ArrayList<ProductVo>();
		MainDao da = new MainDao();
		list = da.search_product();
		response = Utitlity.constructJsonCustomerVO(list);
		return "[" + response + "]";
	}
	
	@GET
	@Path("/getproduct")
	@Produces("application/json")
	public JsonObject getproduct() {
		
		JsonArray array = new JsonArray();
		List<ProductVo> list = new ArrayList<ProductVo>();
		MainDao da = new MainDao();
		list = da.search_product();
		List name = new ArrayList();
		for(int i = 0;i<list.size();i++ ){
			System.out.println(list.get(i).getProduct_name());
			name.add(list.get(i).getProduct_name());
		}
		JsonObject json = new JsonObject();
		try{
			for(int j = 0;j<name.size();j++){
				json.append("name"+j, name.get(j));
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println(json);
		array.put(json);
		//response = Utitlity.constructJsonProductVO(name);
		return json;
		//return list;
		
	}

	
	//@SuppressWarnings("rawtypes")
	@POST
	@Path("/listproduct")
//	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String listproduct(@FormParam("barcode") String bid){

		List list = new ArrayList();
		ProductVo vo= new ProductVo();
		vo.setBarcode(bid);
		MainDao da = new MainDao();
		list = da.show_product(vo);
		
		JSONArray array = new JSONArray();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			ProductVo prdobj = (ProductVo) iterator.next();
			
			JSONObject object = new JSONObject();
			object.put("product_name", prdobj.getProduct_name());
			object.put("amount", prdobj.getAmount());
			array.add(object);
		}
		System.out.println(array.toString());
		return array.toString();
		
	}	

 	@POST
    @Path("/login")
//    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public boolean Login(@FormParam("user_name") String uname, @FormParam("password") String pwd){
        boolean response = false;
 		boolean x= false;
        x=checkCredentials(uname, pwd);
        return x;
 		if(checkCredentials(uname, pwd)){
            response = true;//Utitlity.constructJSON("login",true);
        }else{
            response = false;//Utitlity.constructJSON("login", false, "Incorrect Email or Password");
        }
 		System.out.println(response);
 		return response;        
    }
 
 	private boolean checkCredentials(String uname, String pwd){
        System.out.println("Inside checkCredentials");
        boolean result = false;
        //if(Utitlity.isNotNull(uname) && Utitlity.isNotNull(pwd)){
            try {
                result = MainDao.checkLogin(uname, pwd);
                System.out.println("Inside checkCredentials try "+result);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                //System.out.println("Inside checkCredentials catch");
                result = false;
            }
        }else{
            //System.out.println("Inside checkCredentials else");
            result = false;
        }
        return result;
    }
 	
	@POST
    @Path("/loginstaff")
//    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public boolean Loginstaff(@FormParam("user_name") String uname, @FormParam("password") String pwd){
        boolean response = false;
 		boolean x= false;
        x=checkCredentials(uname, pwd);
        return x;
 		if(checkCredentials(uname, pwd)){
            response = true;//Utitlity.constructJSON("login",true);
        }else{
            response = false;//Utitlity.constructJSON("login", false, "Incorrect Email or Password");
        }
 		System.out.println(response);
 		return response;        
    }
 
 	private boolean checkCredentialsstaff(String uname, String pwd){
        System.out.println("Inside checkCredentials");
        boolean result = false;
        //if(Utitlity.isNotNull(uname) && Utitlity.isNotNull(pwd)){
            try {
                result = MainDao.checkLogin(uname, pwd);
                System.out.println("Inside checkCredentials try "+result);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                //System.out.println("Inside checkCredentials catch");
                result = false;
            }
        }else{
            //System.out.println("Inside checkCredentials else");
            result = false;
        }
        return result;
    }
 	
 		@POST
 		@Path("/generate")
 		public void Writter(@FormParam("barcode") String barcode){
 			try{
 				
 				// this is the text that we want to encode  
 				String text = barcode;
 				
 				int width = 400;  
 				int height = 300; // change the height and width as per your requirement  
 				  
 				//System.out.println("bbbbbbbbbbbb"+barcode);
 				///(ImageIO.getWriterFormatNames() returns a list of supported formats)  
 				String imageFormat = "png"; // could be "gif", "tiff", "jpeg"   
 				BitMatrix bitMatrix = new Code39Writer().encode(text, BarcodeFormat.CODE_39, width, height);  
 				MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, new FileOutputStream(new File("c:/Project/" + barcode + ".png")));
 				System.out.println("Bar Code Generated.");			
 
 			}catch(Exception e){
 				e.printStackTrace();
 			}
 		}

 	    @POST
 	    @Path("/log")
 	    @Produces(MediaType.APPLICATION_JSON) 
 	    //@WebMethod(operationName = "authenticateUser")
 	    public boolean authenticateUser(@FormParam("username") String username, @FormParam("password") String password) {
 	        //TODO write your implementation code here:
 	        boolean result = false;
 	        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("pass")){
 	            result = true;
 	            System.out.println("ho");
 	        }
 	        System.out.println("Invoked");
 	        return result;
 	    }

 	    @POST
 	    @Path("/wallet")
 	    @Produces(MediaType.APPLICATION_JSON) 
 	    //@WebMethod(operationName = "authenticateUser")
 	    public String wallet(@FormParam("user_name") String username) {
 	        //TODO write your implementation code here:
 	        List list = new ArrayList();
 	        
 	    	CustomerVo vo =new CustomerVo();
 	        vo.setUser_name(username);
 	        MainDao da = new MainDao();
 	        list = da.insert_wallet(vo);
 	        
 			JSONArray array = new JSONArray();
 			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
 				CustomerVo prdobj = (CustomerVo) iterator.next();
 				
 				JSONObject object = new JSONObject();
 				object.put("Wallet", prdobj.getWallet());
 				array.add(object);
 			}
 			System.out.println(array.toString());
 			return array.toString();
 	    }
 	    
 	    @POST
	    @Path("/walletupdate")
	    //@Produces(MediaType.APPLICATION_JSON) 
	    //@WebMethod(operationName = "authenticateUser")
	    public int wallet_update(@FormParam("user_name") String username,@FormParam("date") String date,@FormParam("wallet") int amount, @FormParam("cart") JsonArray cart) {
 	    	
 	    	int wallet=0;
 	        

			
 	    	List list = new ArrayList();
 	    	
 	    	int id=0;
 	        
 	        System.out.println(cart);
 	        
 	        String user = null,last = null,first = null,pass = null,
 	        		gen = null,dob = null,phone = null,email = null,
 	        		add = null,country = null,state = null,city = null;
 	    	
 	        CustomerVo vo =new CustomerVo();
 	        vo.setUser_name(username);
 	        
 	        MainDao dao = new MainDao();
 	        List<CustomerVo> list1 = new ArrayList(); 	        
 	        list1 = dao.get_customer(vo);
 	        wallet = list1.get(0).getWallet();
 	        
 	       int newWallet = wallet - amount;
			if(newWallet >= 0){
	  	    
 	        OrderVo ord = new OrderVo();
 	        ord.setDate(date);
 	        ord.setAmount(amount);
 	        ord.setCustomerVo(list1.get(0));
 	        
 	        dao.insert_order(ord);
 	        
  	       	try{
  	          
  	           
  	    	   	for (int i = 0; i < cart.length(); i++) {
  	    		   
  	    		   	JsonObject jsonObj = cart.getJsonObject(i);
  	    		   	String qun = jsonObj.getString("Quantity");
  	    		   	Integer amt = jsonObj.getInt("Amount");
  	    		   	String prd = jsonObj.getString("Name");
  	    		   
		  	   		List<CustomerVo> name = new ArrayList();
		  	   		List<OrderVo> order = new ArrayList();
		  	   		List<ProductVo> product = new ArrayList();
		  	   		
		  	   		CustomerVo v = new CustomerVo();
		  	   		v.setUser_name(username);
		
		  	   		name = dao.get_customer(v);
		  	   		System.out.println(name.size());
		  	   		
		  	   		CustomerVo customerVo = new CustomerVo();
		  	   		customerVo.setCustomer_id(name.get(0).getCustomer_id());
		  	   		
		  	   		OrderVo voa = new OrderVo();
		  	   		voa.setCustomerVo(customerVo);
		  	   		voa.setDate(date);
		  	   		
		  	   		order = dao.get_order(voa);
		  	   		System.out.println(order.size());
		  	   		
		  	   		OrderVo orderVo = new OrderVo();
		  	   		orderVo.setOrder_id(order.get(0).getOrder_id());
		  	   		//orderVo.setDate(date);
		  	   		System.out.println("orderId : "+order.get(0).getOrder_id());
		  	   		
		  	   		OrderDetailsVo vod = new OrderDetailsVo();
		  	   		vod.setItem(prd);
		  	   		vod.setQuantity(qun);
		  	   		vod.setOrderVo(orderVo);
		  	   		vod.setProductamount(amt);
		  	//   		vod.setProductamount(amt);
		  	   		
		  	   		dao.insert_orderdetails(vod);

  	    	   }
	  	 		
  	    	   	
	  	       }catch(Exception e){
	  	    	   e.printStackTrace();
	  	       }
  	    	   
	    	
	 	        list = dao.update_wallet(username);
	 	        
	 	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					CustomerVo prdobj = (CustomerVo) iterator.next();
					
					wallet = prdobj.getWallet();
					id=prdobj.getCustomer_id();
					user=prdobj.getUser_name();
					first=prdobj.getFirst_name();
					last=prdobj.getLast_name();
					pass=prdobj.getPassword();
					gen=prdobj.getGender();
					dob=prdobj.getDob();
					phone=prdobj.getNumber();
					email=prdobj.getEmail();
					add=prdobj.getAddress();
					country=prdobj.getCountry();
					state=prdobj.getState();
					city=prdobj.getCity();
					
				}
					//object.put("Wallet", wallet);
					//array.add(object);
					
						vo.setCustomer_id(id);
						vo.setWallet(newWallet);
						vo.setAddress(add);
						vo.setFirst_name(first);
						vo.setLast_name(last);
						vo.setCity(city);
						vo.setCountry(country);
						vo.setDob(dob);
						vo.setEmail(email);
						vo.setGender(gen);
						vo.setNumber(phone);
						vo.setPassword(pass);
						vo.setState(state);
						vo.setUser_name(user);
						//vo.setUser_name(username);
						dao.update(vo);
						
					System.out.println(newWallet);
						return newWallet;
					}
					else{
						return -1;
					}
 	    } 
 	    
 	   @POST
	    @Path("/searchname")
	    //@Produces(MediaType.APPLICATION_JSON) 
	    //@WebMethod(operationName = "authenticateUser")
	    public String search_name(@FormParam("username") String username,@FormParam("item") String item) {
 		   	List<CustomerVo> name = new ArrayList();
 			List<OrderVo> ord = new ArrayList();
	  	   	List main = new ArrayList();
 			
 		   	String response = null;
			CustomerVo customer = new CustomerVo();
			customer.setUser_name(username);

			MainDao dao = new MainDao();
			
			name = dao.get_customer(customer);
	   		System.out.println(name.size());
	   		
	   		CustomerVo customerVo = new CustomerVo();
	   		customerVo.setCustomer_id(name.get(0).getCustomer_id());
	   		
			OrderDetailsVo order = new OrderDetailsVo();
			order.setItem(item);
			
  	   		OrderVo voa = new OrderVo();
  	   		voa.setCustomerVo(customerVo);

  	   		ord = dao.get_orderDetails(voa);
  	   		//System.out.println(ord);
  	   		
  	   		main=dao.get_orderDetails1(voa);
  	   		//System.out.println(main);
  	   		
  	   		OrderVo orderVo = new OrderVo();
  	   	//	for(int i = 0;i<ord.size();i++){
  	   		
  	   		orderVo.setOrder_id(ord.get(0).getOrder_id());
  	   		
  	   		
  	   	
			List get = new ArrayList();
			get = dao.get_name(orderVo);
			
			System.out.println(get.size());		
			
			if(ord.size() >= 1){
			
				OrderDetailsVo orderDetails = new OrderDetailsVo();
				orderDetails.setOrderVo(orderVo);
				orderDetails.setItem(item);
				
				List<OrderDetailsVo> list = new ArrayList();
				list = dao.search_item(orderDetails,main);
			
				System.out.println( "list" + list );
				
				response = Utitlity.constructJsonOrderDetailsVO(list); 				
			
  	   		}
			System.out.println( response);
			return  response; 
	    }
	    
 	   @POST
 	   @Path("/searchdate")
 	   @Produces(MediaType.APPLICATION_JSON) 
 	   //@WebMethod(operationName = "authenticateUser")
	    public String search_date(@FormParam("date") String date,@FormParam("username") String user) {
 	   		List<CustomerVo> name = new ArrayList();
 	   		String response = null;
 			CustomerVo customer = new CustomerVo();
 			customer.setUser_name(user);

 			MainDao dao = new MainDao();
 			
 			name = dao.get_customer(customer);
  	   		System.out.println(name.size());
  	   		
  	   		CustomerVo customerVo = new CustomerVo();
  	   		customerVo.setCustomer_id(name.get(0).getCustomer_id());
  	   		
 			OrderVo order = new OrderVo();
 			order.setDate(date);
 			order.setCustomerVo(customerVo);

 			List<OrderVo> get = new ArrayList<OrderVo>();
 			get = dao.get_order(order);
 			
 			System.out.println(get);		
 			
 			if(get.size() >= 1){
 			
 				OrderDetailsVo orderDetails = new OrderDetailsVo();
 				orderDetails.setOrderVo(order);
 				
 				List<OrderDetailsVo> list = new ArrayList();
 				list = dao.search_date(orderDetails,user);
 			
// 				System.out.println(list.size());
 				
 				response = Utitlity.constructJsonOrderDetailsVO(list); 				
 			}
 			System.out.println( response);
 			return  response; 
	    }
	   
 	   @POST
 	   @Path("/searchboth")
 	   @Produces(MediaType.APPLICATION_JSON) 
 	   //@WebMethod(operationName = "authenticateUser")
	    public String search_both(@FormParam("date") String date,@FormParam("item") String item,@FormParam("username") String user) {
 	   		List<CustomerVo> name = new ArrayList();
 	   		String response = null;
 			CustomerVo customer = new CustomerVo();
 			customer.setUser_name(user);

 			MainDao dao = new MainDao();
 			
 			name = dao.get_customer(customer);
  	   		System.out.println(name.size());
  	   		
  	   		CustomerVo customerVo = new CustomerVo();
  	   		customerVo.setCustomer_id(name.get(0).getCustomer_id());
  	   		
 			OrderVo order = new OrderVo();
 			order.setDate(date);
 			order.setCustomerVo(customerVo);
 			
 			OrderDetails odetails = new OrderDetails();
 			
 			List get = new ArrayList();
 			get = dao.get_order(order);
 			
 			System.out.println(get);		
 			
 			if(get.size() >= 1){
 			
 				OrderDetailsVo orderDetails = new OrderDetailsVo();
 				orderDetails.setItem(item);
 				orderDetails.setOrderVo(order);
 				
 				List<OrderDetailsVo> list = new ArrayList();
 				list = dao.search_both(orderDetails,user);
 			
 				System.out.println(list.size());
 				
 				response = Utitlity.constructJsonOrderDetailsVO(list); 				
 			}
 			System.out.println( response);
 			return  response; 
	    }
 	   
 	   @POST
 	   @Path("/searchnull")
 	   @Produces(MediaType.APPLICATION_JSON) 
 	   //@WebMethod(operationName = "authenticateUser")
	    public String search_null(@FormParam("username") String user) {
 	   		List<CustomerVo> name = new ArrayList();
 	   		String response = null;
 			CustomerVo customer = new CustomerVo();
 			customer.setUser_name(user);

 			MainDao dao = new MainDao();
 			
 			name = dao.get_customer(customer);
  	   		System.out.println(name.size());
  	   		
  	   		CustomerVo customerVo = new CustomerVo();
  	   		customerVo.setCustomer_id(name.get(0).getCustomer_id());
  	   		
 			OrderVo order = new OrderVo();
 			order.setCustomerVo(customerVo);

 			List<OrderVo> get = new ArrayList<OrderVo>();
 			get = dao.get_null(order);
 			System.out.println(get.get(0).getCustomerVo().getUser_name());
 			
 			System.out.println(get);		
 			
 			if(get.size() >= 1){
 			
 				OrderDetailsVo orderDetails = new OrderDetailsVo();
 				orderDetails.setOrderVo(order);
 				System.out.println(orderDetails.toString());
 				
 				List<OrderDetailsVo> list = new ArrayList();
 				list = dao.search_null(orderDetails,user);
 			
 				System.out.println(list.size());
 				
 				response = Utitlity.constructJsonOrderDetailsVO(list); 				
 			}
 			System.out.println( response);
 			return  response; 
	    }
 	   @POST
	   @Path("/search_date")
	   //@Produces(MediaType.APPLICATION_JSON) 
	   //@WebMethod(operationName = "authenticateUser")
	   public String searchdate(@FormParam("date") String date,@FormParam("username") String user) {	
		   
		   List order = new ArrayList();
		   
		   OrderVo orderVo = new OrderVo();
		   orderVo.setDate(date);
		   
		   MainDao dao = new MainDao();
		   order = dao.get_order(orderVo);
		   
		   OrderDetails orderDetails = new OrderDetails();
		   
		   
		   return null;
	   }
 	   
 	   	@POST
	    @Path("/check")
	    //@Produces(MediaType.APPLICATION_JSON) 
	    //@WebMethod(operationName = "authenticateUser")
	    public void check(@FormParam("xyz") JsonObject list) {
	    	System.out.println(list);
	    }
 	   	

}


@FormParam("edfirstname") String fn,@FormParam("edlastname") String ln,@FormParam("edusername") String un
,@FormParam("edpassword") String pass,@FormParam("edgender") String gender,@FormParam("eddob") String dob,
@FormParam("edphone") String phone,@FormParam("edemail") String email,@FormParam("edaddress") String address,
@FormParam("edcountry") String country,@FormParam("edstate") String state,@FormParam("edcity") String city

	  	        List<CustomerVo> name = new ArrayList();
	List<OrderVo> order = new ArrayList();
	List<ProductVo> product = new ArrayList();
	
	ProductVo p = new ProductVo();
	p.setProduct_name(item);
	
	
	MainDao dao = new MainDao();
	//product = da.get_product(p);

	ProductVo productVo = new ProductVo();
	productVo.setAmount(product.get(0).getAmount());
	System.out.println("Amount :: "+product.get(0).getAmount());
	
	
	CustomerVo v = new CustomerVo();
	v.setUser_name(username);

	name = dao.get_customer(v);
	CustomerVo customerVo = new CustomerVo();
	customerVo.setCustomer_id(name.get(0).getCustomer_id());
	System.out.println("Customerid :" + customerVo.getCustomer_id());
	
	OrderVo voa = new OrderVo();
	voa.setCustomerVo(customerVo);
	
	order = dao.get_order(voa);
	
	OrderVo orderVo = new OrderVo();
	orderVo.setOrder_id(order.get(0).getOrder_id());
	System.out.println("orderId : "+order.get(0).getOrder_id());
	
	OrderDetailsVo vod = new OrderDetailsVo();
	vod.setItem(item);
	vod.setQuantity(quantity);
	//vod.setProductVo(productVo);
	vod.setOrderVo(orderVo);
	
	
	da.insert_orderdetails(vod);
	
int i=0;
	do{
		
		item=cart.get("Name"+i).toString();	
		System.out.println(cart.get("Name"+i));
		System.out.println();
		quantity=(String) cart.get("Quantity"+i);	
		System.out.println(cart.get("Quantity"+i));
		System.out.println();
		amou=(int) cart.get("AMount"+i);	
		System.out.println(cart.get("AMount"+i));
		System.out.println();

		i++;
    }while(cart.get("Name"+i).equals(null));
 

*/