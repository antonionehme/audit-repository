package audit.server.datasize;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.*;

public class InstrumentationAgent {
	 private static volatile Instrumentation globalInstrumentation;
	 
	    public static void premain(String agentArgs, Instrumentation inst) {
	        globalInstrumentation = inst;
	    }
	 
	    public static long getObjectSize(Object object) {
	        if (globalInstrumentation == null) {
	            throw new IllegalStateException("Agent not initialized.");
	        }
	        return globalInstrumentation.getObjectSize(object);
	    }
	
}
