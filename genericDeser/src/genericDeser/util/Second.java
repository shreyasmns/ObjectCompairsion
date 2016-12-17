package genericDeser.util;

import genericDeser.logger.Logger;
import genericDeser.logger.Logger.debugLevels;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class Second {
	
	private int intValue;
	private double doubleValue;
	private boolean booleanValue;
	
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
	 * @return the doubleValue
	 */
	public double getDoubleValue() {
		return doubleValue;
	}


	/**
	 * @param doubleValue the doubleValue to set
	 */
	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}


	/**
	 * @return the booleanValue
	 */
	public boolean isBooleanValue() {
		return booleanValue;
	}


	/**
	 * @param booleanValue the booleanValue to set
	 */
	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}


	public Second(){
		Logger.writeOutput(debugLevels.CONSTRUCTOR, "Inside the Second Constructor");
	}

		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + intValue;
		result = (int) (prime * result + Double.doubleToLongBits(doubleValue));
		result = prime * result + (booleanValue ? 1231 : 1237);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Second other = (Second) obj;
		
		 if (intValue != other.intValue)
			return false;
		 if (Double.doubleToLongBits(doubleValue) != Double.doubleToLongBits(other.doubleValue))
			return false;
		 if (booleanValue != other.booleanValue)
			return false;
	   return true;
	}

}
