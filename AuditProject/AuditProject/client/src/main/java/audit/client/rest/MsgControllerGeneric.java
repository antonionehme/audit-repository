package audit.client.rest;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import audit.client.WorkflowGenericParticipant;
import audit.client.WorkflowParticipant;
import audit.client.WorkflowParticipant3;
import audit.client.WorkflowParticipant4;
import audit.client.WorkflowParticipant5;
import audit.client.service.MsgService;
import audit.common.domain.Transaction;
//import audit.server.AuditNode;

import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("participant")
public class MsgControllerGeneric {

	private static final Logger LOG = LoggerFactory.getLogger(MsgControllerGeneric.class);

	private final WorkflowGenericParticipant msgService;//MsgService msgService;
	// private final NodeService nodeService;

	@Autowired
	public MsgControllerGeneric(WorkflowGenericParticipant msgService) {//public MsgController(MsgService msgService) {//this is changed to Merge if we are to combine the classes for AuditRec verif.
		this.msgService = msgService;
		// this.nodeService = nodeService;
	}

	/**
	 * Retrieve all Transactions, which aren't in a block yet
	 * 
	 * @return JSON list of Transactions
	 */
	@RequestMapping
	List<String> getTransactionPool() {
		return msgService.getmsgPool();
	}

	//Added this to clean participants.
    @RequestMapping(value="clean",method = RequestMethod.DELETE)
    void clean(){
    	msgService.clean();
    }
	/**
	 * Add a new Transaction to the pool. It is expected that the transaction has a
	 * valid signature and the correct hash.
	 *
	 * @param transaction
	 *            the Transaction to add
	 * @param publish
	 *            if true, this Node is going to inform all other Nodes about the
	 *            new Transaction
	 * @param response
	 *            Status Code 202 if Transaction accepted, 406 if verification fails
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.POST)
	void addTransaction(@RequestBody String message, @RequestParam(required = false) Boolean publish) throws Exception { // HttpServletResponse
																											// response)
																											// {
		// LOG.info("Add transaction " +
		// Base64.encodeBase64String(transaction.getHash()));
		boolean success = msgService.add(message);//Had to throw exceptions after I added AuditRecordverification(message);

		/*
		 * if (success) { response.setStatus(HttpServletResponse.SC_ACCEPTED);
		 * 
		 * if (publish != null && publish) { // nodeService.broadcastPut("transaction",
		 * transaction); } } else {
		 * response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE); }
		 */
	}
	
	@RequestMapping(value= "call", method = RequestMethod.POST)
	void callParticipant(@RequestBody String port, @RequestParam(required = false) String first) throws Exception { // HttpServletResponse
			//This has been added for an orchestrator to call participants while passing recipients. It is only used for Brite evaluation.																						// response)
																											// {
		// LOG.info("Add transaction " +
		// Base64.encodeBase64String(transaction.getHash()));
		msgService.sendThroughURLCall(port, first);//Had to throw exceptions after I added AuditRecordverification(message);

		/*
		 * if (success) { response.setStatus(HttpServletResponse.SC_ACCEPTED);
		 * 
		 * if (publish != null && publish) { // nodeService.broadcastPut("transaction",
		 * transaction); } } else {
		 * response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE); }
		 */
	}

	
	

}
