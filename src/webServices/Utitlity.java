/*package webServices;

import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Utitlity {

	@SuppressWarnings("unchecked")
	public static String constructJsonCustomerVO(List list) {
		// TODO Auto-generated method stub
		
		JSONObject mainJson = new JSONObject();
		JSONArray mainJsonArray = new JSONArray();
		JSONArray jsonArray = new JSONArray();
		try {
			if (!list.isEmpty()){
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
			
					
					CustomerVo vo = (CustomerVo) iterator.next();
					
					ObjectMapper mapper = new ObjectMapper();

					try {
						// Convert object to JSON string and save into a file directly
						// Convert object to JSON string
						String jsonInString = mapper.writeValueAsString(vo);
						//System.out.println(jsonInString);

						// Convert object to JSON string and pretty print
						jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vo);
						System.out.println(jsonInString);
						//mainJson.put(vo, jsonInString.toString() );
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
					
					JSONObject obj = new JSONObject();
					obj.put("Customer_id", vo.getCustomer_id());
					obj.put("user_name", vo.getUser_name());
					obj.put("password", vo.getPassword());
					obj.put("first_name", vo.getFirst_name());
					obj.put("last_name", vo.getLast_name());
					obj.put("dob", vo.getDob());
					obj.put("number", vo.getNumber());
					obj.put("email", vo.getEmail());
					obj.put("gender", vo.getGender());
					obj.put("address", vo.getAddress());
					obj.put("country", vo.getCountry());
					obj.put("state", vo.getState());
					obj.put("city", vo.getCity());
					
				
					mainJsonArray.add(obj);
				}
			} else {
				
				mainJson.put("success", "false");
			}
			mainJson.put("customer", mainJsonArray);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mainJson.toString();
	}

	@SuppressWarnings("unchecked")
	public static String constructJsonOrderVO(List list) {
		// TODO Auto-generated method stub
		
		JSONObject mainJson = new JSONObject();
		JSONArray mainJsonArray = new JSONArray();
		JSONArray jsonArray = new JSONArray();
		try {
			if (!list.isEmpty()){
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
			
					
					OrderVo vo = (OrderVo) iterator.next();
					
					ObjectMapper mapper = new ObjectMapper();

					try {
						// Convert object to JSON string and save into a file directly
						// Convert object to JSON string
						String jsonInString = mapper.writeValueAsString(vo);
						//System.out.println(jsonInString);

						// Convert object to JSON string and pretty print
						jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vo);
						System.out.println(jsonInString);
						//mainJson.put(vo, jsonInString.toString() );
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
					
					JSONObject obj = new JSONObject();
					obj.put("order_id", vo.getOrder_id());
					obj.put("date", vo.getDate());
					obj.put("amount", vo.getAmount());
					obj.put("v", vo.getCustomerVo().getCustomer_id());
					obj.put("last_name", vo.getLast_name());
					obj.put("dob", vo.getDob());
					obj.put("number", vo.getNumber());
					obj.put("email", vo.getEmail());
					obj.put("gender", vo.getGender());
					obj.put("address", vo.getAddress());
					obj.put("country", vo.getCountry());
					obj.put("state", vo.getState());
					obj.put("city", vo.getCity());
					
					mainJsonArray.add(obj);
				}
			} else {
				
				mainJson.put("success", "false");
			}
			mainJson.put("order", mainJsonArray);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mainJson.toString();
	}

	@SuppressWarnings("unchecked")
	public static String constructJsonOrderDetailsVO(List list) {
		// TODO Auto-generated method stub
		
		JSONObject mainJson = new JSONObject();
		JSONArray mainJsonArray = new JSONArray();
		JSONArray jsonArray = new JSONArray();
		try {
			if (!list.isEmpty()){
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
			
					
					OrderDetailsVo vo = (OrderDetailsVo) iterator.next();
					
					ObjectMapper mapper = new ObjectMapper();

					try {
						// Convert object to JSON string and save into a file directly
						// Convert object to JSON string
						String jsonInString = mapper.writeValueAsString(vo);
						//System.out.println(jsonInString);

						// Convert object to JSON string and pretty print
						jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vo);
						System.out.println(jsonInString);
						//mainJson.put(vo, jsonInString.toString() );
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
					
					JSONObject obj = new JSONObject();
					
					//obj.put("orderdetails_id", vo.getOrderdetails_id());
					obj.put("items", vo.getItem());
					obj.put("quantity", vo.getQuantity());
					obj.put("date", vo.getOrderVo().getDate());
					obj.put("amount", vo.getProductamount());
					
					mainJsonArray.add(obj);
				}
			} else {
				
				mainJson.put("success", "false");
				
			}
			return mainJsonArray.toString();

//			mainJson.put("orderDetails", mainJsonArray);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mainJson.toString();
	}

	@SuppressWarnings("unchecked")
	public static String constructJsonProductNameVO(List list) {
		// TODO Auto-generated method stub
		JSONObject mainJson = new JSONObject();
		JSONArray mainJsonArray = new JSONArray();
		JSONArray jsonArray = new JSONArray();
		try {
			if (!list.isEmpty()){
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
			
					
					OrderDetailsVo vo = (OrderDetailsVo) iterator.next();
					
					ObjectMapper mapper = new ObjectMapper();

					try {
						// Convert object to JSON string and save into a file directly
						// Convert object to JSON string
						String jsonInString = mapper.writeValueAsString(vo);
						//System.out.println(jsonInString);

						// Convert object to JSON string and pretty print
						jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vo);
						System.out.println(jsonInString);
						//mainJson.put(vo, jsonInString.toString() );
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
					
					JSONObject obj = new JSONObject();
					
					//obj.put("orderdetails_id", vo.getOrderdetails_id());
					obj.put("items", vo.getItem());
					obj.put("quantity", vo.getQuantity());
					obj.put("date", vo.getOrderVo().getDate());
					obj.put("amount", vo.getProductamount());
					
					mainJsonArray.add(obj);
				}
			} else {
				
				mainJson.put("success", "false");
				
			}
			return mainJsonArray.toString();

//			mainJson.put("orderDetails", mainJsonArray);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mainJson.toString();
	}

	
	@SuppressWarnings("unchecked")
	public static String constructJsonProductVO(List list) {
		// TODO Auto-generated method stub
		JSONObject mainJson = new JSONObject();
		JSONArray mainJsonArray = new JSONArray();
		JSONArray jsonArray = new JSONArray();
		try {
			if (!list.isEmpty()){
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
			
					ProductVo vo = new ProductVo();
					
					ObjectMapper mapper = new ObjectMapper();

					try {
						// Convert object to JSON string and save into a file directly
						// Convert object to JSON string
						String jsonInString = mapper.writeValueAsString(vo);
						//System.out.println(jsonInString);

						// Convert object to JSON string and pretty print
						jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vo);
						System.out.println(jsonInString);
						//mainJson.put(vo, jsonInString.toString() );
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
					
					JSONObject obj = new JSONObject();
					obj.put("product_name", vo.getProduct_name());
					
					mainJsonArray.add(obj);
				}
			} else {
				
				mainJson.put("success", "false");
			}
			mainJson.put("product", mainJsonArray);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mainJson.toString();
		
	}

	public static String constructJSON(String tag, boolean status) {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
        obj.put("tag", tag);
		obj.put("status", new Boolean(status));
        return obj.toString();
	}

	public static boolean isNotNull(String uname) {
		// TODO Auto-generated method stub
		 return uname != null && uname.trim().length() >= 0 ? true : false;
	}

	public static String constructJSON(String tag, boolean status, String err_msg) {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
        obj.put("tag", tag);
		obj.put("status", new Boolean(status));
		obj.put("error_msg", err_msg);
        return obj.toString();
	}
	
	

}
*/