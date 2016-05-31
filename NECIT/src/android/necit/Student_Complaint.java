package android.necit;

import java.util.Calendar;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Student_Complaint extends Activity {
	
	protected static final int DATE_PICKER = 1;
	
	private int DaySelected,MonthSelected,YearSelected;
	
	EditText  cmp_reason ;
	
	TextView cmp_dt,cmpid;
	
	Button send;
	
    String reason,tv, old_date;
    
    Database db;
   	
    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.student_complaint);
		
		cmpid = (TextView)findViewById(R.id.cmp_spinner);
		
		cmp_dt=(TextView)findViewById(R.id.cmp_dt);
		
		cmp_reason=(EditText)findViewById(R.id.reason);
		
	
		
		send=(Button)findViewById(R.id.send);
		
		
		 
		
		
		SharedPreferences prefs = getSharedPreferences("MY", MODE_WORLD_WRITEABLE);
	        
	        
	        final  String user =prefs.getString("id", "No Id Is There");
		
		
		
		        	
		cmpid.setText(user);
		        
		        
		tv = cmpid.getText().toString();
		       
		Toast.makeText(getApplicationContext(), tv, 2000).show();
		
				
				
							
						 final Calendar c=Calendar.getInstance();
			                
					        DaySelected=c.get(Calendar.DAY_OF_MONTH);
					        MonthSelected=c.get(Calendar.MONTH);
					        
					       int M = MonthSelected+1;
					        
					        YearSelected=c.get(Calendar.YEAR);
					        
					     cmp_dt.setText(new StringBuilder().append(DaySelected).append("-").append(M).
					        		append("-").append(YearSelected));
					     	        
					        
				
				send.setOnClickListener(new OnClickListener() {
					
					
					public void onClick(View v) {
					
					
					
						old_date = cmp_dt.getText().toString();
					     
					
					reason = cmp_reason.getText().toString();
					
					cmp_reason.setText("");
					
					 db = new Database(Student_Complaint.this);
					 
					 
					 db.open();
					
						
					    
					     if( db.cmp_send(tv, old_date, reason))
				        {                	
				        	Toast.makeText(getApplicationContext(), "COMPLAINT SENT",Toast.LENGTH_LONG).show();
				        }
				        
				        else{
				        	Toast.makeText(getApplicationContext(),"YOU WILL BE WAIT FOR SOME TIME TILL YOUR LAST COMPLAINT WILL BE VERIFIED",Toast.LENGTH_LONG).show();
				        }
				       
				       db.close();
				       
				     
				        }
					
					
				      
					    
				});
				
		  		
	}
    

}
