package genericDeser.driver;

import java.io.File;
import genericDeser.fileOperations.FileProcessor;
import genericDeser.logger.Logger;
import genericDeser.logger.Logger.debugLevels;
import genericDeser.util.PopulateObjects;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class Driver {
	
	public static void main(String args[]){
		Driver driver = new Driver();
		if(!driver.validateArgs(args)){
			System.exit(1);
		}
		
		Logger.setDebugLevel(Integer.parseInt(args[2]));
		int iterations = Integer.parseInt(args[1]);
		FileProcessor fileprocessor;
		
		long startTime = System.currentTimeMillis();
		for(int i=0; i< iterations; i++){
			fileprocessor = new FileProcessor(args[0]);
			PopulateObjects populate = new PopulateObjects(fileprocessor);
			populate.deserObjects();
			fileprocessor.returnResources();
			Logger.writeOutput(debugLevels.RESULT, populate.toString());
		}
		long endTime = System.currentTimeMillis();
		long avgTime = (endTime-startTime)/iterations;
		//Logger.writeOutput(debugLevels.RESULT, "Total time : "+avgTime +" mili seconds.");
	}

	/**
	 * @param args
	 * @return
	 */
	private boolean validateArgs(String[] args) {
		return validateNumArgs(args.length) && validateInFile(args[0]) && validateNumIterations(args[1]) 
				&& validateDebugVal(args[2]);
	}

	/**
	 * @param string
	 * @return
	 */
	private static boolean validateDebugVal(String debugValIn) {
		try{
			int debugVal = Integer.parseInt(debugValIn);
		} catch(NumberFormatException e){
			System.out.println("Please Enter the Debug Value as Integer");
			e.printStackTrace();
			System.exit(1);
		}
		return true;
	}

	/**
	 * @param string
	 * @return
	 */
	private static boolean validateNumIterations(String iterationsIn) {
		try{
			int iterations = Integer.parseInt(iterationsIn);
		} catch(NumberFormatException e){
			System.out.println("Please Enter the Debug Value as Integer");
			e.printStackTrace();
			System.exit(1);
		}
		return true;
	}

	/**
	 * @param string
	 * @return
	 */
	private static boolean validateInFile(String fileIn) {
		boolean res= false;
		File file = new File(fileIn);
		if(file.isFile() && file.canRead() && file.length() > 0){
			res = true;
		}
		else{
			System.err.println("Please Provide a Valid Input File");
			System.exit(1);
		}
		return res;
	}

	/**
	 * @param length
	 * @return 
	 */
	private static boolean validateNumArgs(int lengthIn) {
		if(lengthIn != 3){
			System.err.println("Please Enter the Valid Number of Input Arguements");
			System.exit(1);
		}
		return true;
	}
	
}
