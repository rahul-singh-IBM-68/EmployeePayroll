package EmployeePayroll;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class services

{
	// ---( internal utility methods )---

	final static services _instance = new services();

	static services _newInstance() { return new services(); }

	static services _cast(Object o) { return (services)o; }

	// ---( server methods )---




	public static final void calculateSalary (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(calculateSalary)>> ---
		// @sigtype java 3.5
		// [i] field:0:required workingDays
		// [i] field:0:required tax
		// [i] field:0:required minmumSal
		// [i] field:0:required position
		// [o] field:0:required monthlySal
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	workingDays = IDataUtil.getString( pipelineCursor, "workingDays" );
		String	tax = IDataUtil.getString( pipelineCursor, "tax" );
		String	minmumSal = IDataUtil.getString( pipelineCursor, "minmumSal" );
		String	position = IDataUtil.getString( pipelineCursor, "position" );
		pipelineCursor.destroy();	
		
		int perDaySal = Integer.valueOf(minmumSal)/30;
		
		int totalSal = perDaySal*Integer.valueOf(workingDays);
		
		int totalTax = 0;
		switch(position) {
		  case "1":
		// code block
		  totalTax = (totalSal*30)/100;
		  totalSal = totalSal- totalTax;
		break;
		  case "2":
		// code block
		  totalTax = (totalSal*30)/100;
		  totalSal = totalSal- totalTax+5000;
		break;
		  default:
		// code block
		}
		String totalSalStr = Integer.toString(totalSal);
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "monthlySal", totalSalStr );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}
}

