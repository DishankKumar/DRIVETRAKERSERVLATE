package Registration;

import org.codehaus.jackson.map.ObjectMapper;

public class ObjMap {
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static Object getObjectFromJSON(String jsonString, Class<Drivepojo> reg)
	{
			
			Object readValue = null;
			

			try 
			{
				
				readValue = mapper.readValue(jsonString, reg);
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
			return readValue;

		}

		public static Object getJSONFromObject(Object object) {
			String jsondata = null;

			try
			{
				jsondata = mapper.writeValueAsString(object);
			} 
			catch (Exception e)
			{
				System.out.println(e);
			}

			return jsondata;

		}

}
