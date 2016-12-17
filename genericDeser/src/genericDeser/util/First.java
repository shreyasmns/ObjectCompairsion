package genericDeser.util;

import genericDeser.logger.Logger;
import genericDeser.logger.Logger.debugLevels;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class First {
	
	private int intValue;
	private float floatValue;
	private short shortValue;
	private String stringValue;
	
	public First(){
		Logger.writeOutput(debugLevels.CONSTRUCTOR, "Inside the First Constructor"); 
	}

	/**
	 * @return the intValue
	 */
	public int getIntValue() {
		return intValue;
	}

	/**
	 * @param intValue the intValue to set
	 */
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	/**
	 * @return the floatValue
	 */
	public float getFloatValue() {
		return floatValue;
	}

	/**
	 * @param floatValue the floatValue to set
	 */
	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}

	/**
	 * @return the shortValue
	 */
	public short getShortValue() {
		return shortValue;
	}

	/**
	 * @param shortValue the shortValue to set
	 */
	public void setShortValue(short shortValue) {
		this.shortValue = shortValue;
	}

	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * @param stringValue the stringValue to set
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + intValue;
		result = prime * result + Float.floatToIntBits(shortValue);
		if(stringValue != null){
			for (int i = 0; i < stringValue.length(); i++) {
				result = result*31 + stringValue.charAt(i);
			} 
		}
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		 if (obj == null)
			return false; 
		 if (!(getClass() == obj.getClass()))
			return false;
		 if (this == obj)
			return true;
		
		First other = (First) obj;
		
		 if (intValue != other.intValue)
			 	return false;
		 if (Float.floatToIntBits(floatValue) != Float.floatToIntBits(other.floatValue))
				return false;
	     if(shortValue != other.shortValue)
				return false;
	     if(other.stringValue != null){
	    	 if(!stringValue.equals(other.stringValue))
			 	return false;
	     }
	  return true;
	}

}
