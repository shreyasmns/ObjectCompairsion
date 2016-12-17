package genericDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import genericDeser.fileOperations.FileProcessor;
import genericDeser.logger.Logger;
import genericDeser.logger.Logger.debugLevels;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class PopulateObjects {
		
	private Map<First, Integer> firstObjects = new HashMap<>();
	private Map<Second, Integer> secondObjects = new HashMap<>();
	private Map<String, Class> objectTypes = new HashMap<>();
	private FileProcessor fileProcessor=null;
	private String fqn = null;
	private String line = null;
	private Class cls;
	private Object object=null;
	private String type=null, var=null, val = null;
	
	{
		objectTypes.put("int", Integer.TYPE);
		objectTypes.put("float", Float.TYPE);
		objectTypes.put("short", Short.TYPE);
		objectTypes.put("String", String.class);
		objectTypes.put("double", Double.TYPE);
		objectTypes.put("boolean", Boolean.TYPE);
	}
	
	public PopulateObjects(FileProcessor fileProcessorIn){
		Logger.writeOutput(debugLevels.CONSTRUCTOR, "Inside the PopulateObjects Constructor"); 
		this.fileProcessor = fileProcessorIn;	
	}
	
	public void deserObjects(){
		Integer count = 0;
		while((line=fileProcessor.readLine()) != null){
		try{
			 if(line.contains("First") || line.contains("Second")){
				 if(count > 0){
					 if(fqn.contains("First")){
						 processFirstObject(object);
					 }
					 else if(fqn.contains("Second")){
						 processSecondObject(object);
					 }
				}
				 count = 0;
   				 fqn = line.split(":")[1].trim();
				 cls = Class.forName(fqn);
				 object = cls.newInstance();
			 }
			 else if(validDataTypes(line)){
				count++;
				String[] values = line.split(", ");
				type = values[0].split("=")[1].trim();
				var = values[1].split("=")[1].trim();
				val = values[2].split("=")[1].trim();
				
				Class[] classes = new Class[1];
				classes[0] = objectTypes.get(type);
                String method = "set" + var;
                Method methodName = cls.getMethod(method,classes); 
                Object[] params = new Object[1];
                params[0] = createTypeVariable(type,val);
                Object res = methodName.invoke(object, params);      
		  }
		} catch (ClassNotFoundException classNotFoundEx) {
			System.err.println(classNotFoundEx.getMessage());
			System.exit(1);
		} catch (InstantiationException instantiationEx) {
			System.err.println(instantiationEx.getMessage());
			System.exit(1);
		} catch (IllegalAccessException illegalEx) {
			System.err.println(illegalEx.getMessage());
			System.exit(1);
		} catch (SecurityException securityEx) {
			System.err.println(securityEx.getMessage());
			System.exit(1);
		} catch (NoSuchMethodException noSuchMethodEx) {
			System.err.println(noSuchMethodEx.getMessage());
			System.exit(1);
		} catch (IllegalArgumentException illegalArgEx) {
			System.err.println(illegalArgEx.getMessage());
			System.exit(1);
		} catch (InvocationTargetException invocationTargetEx) {
			System.err.println(invocationTargetEx.getMessage());
			System.exit(1);
		}
	 }
  }


	/**
	 * @param line
	 * @return boolean
	 */
	private boolean validDataTypes(String lineInput) {
		if(lineInput.contains("int") || lineInput.contains("float") || lineInput.contains("short") || lineInput.contains("String")
				|| lineInput.contains("double") || lineInput.contains("boolean")){
				return true;
		}
		else {
			return false;
		}
	}

	/**
	 * @param type parameter
	 * @param value
	 * @return object of the type with the value
	 */
	private Object createTypeVariable(String typeIn, String valIn) {
		if(type.equals("int")){
			return new Integer(valIn);
		}
		else if(type.equals("float")){
			return new Float(valIn);
		}
		else if(type.equals("short")){
			return new Short(valIn);
		}
		else if(type.equals("String")){
			return new String(valIn);
		}
		else if(type.equals("double")){
			return new Double(valIn);
		}
		else if(type.equals("boolean")){
			return new Boolean(valIn);
		}
		else{
			System.err.println("Wrong 'Type' parameter in the Input File. Hence Exiting.");
			System.exit(1);
			return null;
		}
	}

	/**
	 * @param object
	 */
	private void processFirstObject(Object objectIn) {
	if(null != objectIn){
		if(objectIn instanceof First){
			if(firstObjects.containsKey((First)objectIn)){
				int val = firstObjects.get((First)objectIn);
				firstObjects.put((First)objectIn, val+1);
			}
			else{
				firstObjects.put((First)objectIn, 1);
			}
		 }
	  }
   }


	/**
	 * @param object
	 */
	private void processSecondObject(Object objectIn) {
	if(null != objectIn){
		if(objectIn instanceof Second){
			if(secondObjects.containsKey((Second)objectIn)){
				int val = secondObjects.get((Second)objectIn);
				secondObjects.put((Second)objectIn, val+1);
			}
			else{
				secondObjects.put((Second)objectIn, 1);
			}
		 }
	  }
   }
	
	
	/**
	 * @return
	 */
	private String TotalFirstObjects() {
		int totalFirst = 0;
		Set<Entry<First, Integer>> set = firstObjects.entrySet();
		for(Map.Entry<First, Integer> item : set){
			totalFirst += item.getValue();
		}
		return String.valueOf(totalFirst);
	}
	
	
	
	/**
	 * @return
	 */
	private String TotalSecondObjects() {
		int totalSecond = 0;
		Set<Entry<Second, Integer>> set = secondObjects.entrySet();
		for(Map.Entry<Second, Integer> item : set){
			totalSecond += item.getValue();
		}
		return String.valueOf(totalSecond);
	}

	
	public String toString(){
		String output = "";
		output += "Number of Unique First Objects : "+firstObjects.size()+"\n";
		output += "Total Number of First Objects : "+TotalFirstObjects()+"\n";
		output += "Number of Unique Second Objects : "+secondObjects.size()+"\n";
		output += "Total Number of Second Objects : "+TotalSecondObjects()+"\n";
		
		return output;
	}

}
