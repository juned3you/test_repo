package startup;

import org.apache.log4j.Logger;

import com.smarthopper.service.DeactivateJobService;

public class DeactivateProcess {
	private static Logger log = Logger.getLogger(DeactivateProcess.class);
	public static void main(String str[]){
		DeactivateJobService djobSer = new DeactivateJobService();
		djobSer.start();
		log.info("------------Deactivate process finished. --------");
	}
}
