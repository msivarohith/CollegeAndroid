package android.necit;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Complaint_Principal extends Activity{
	
	Spinner cid_spinner;
	
	TextView date,complaint;
	
	Button watch_complaint,logout;
	
	private ArrayAdapter<CharSequence> adpter; 
	
	
	Database db;
	
	String id, results;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.complaint_principal);
		
		cid_spinner=(Spinner)findViewById(R.id.cid_spinner);

		date = (TextView)findViewById(R.id.get_date);
		
		complaint = (TextView)findViewById(R.id.get_cmp);
		
		watch_complaint = (Button)findViewById(R.id.watch_complaint);
		
		logout = (Button)findViewById(R.id.prince_logout);
		
		adpter=new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
		cid_spinner.setAdapter(adpter);
		
		
		 db = new Database(Complaint_Principal.this);
			
			
			
			db.open();
			
			Cursor c = db.spinner_complaint();
			
		
			
			int i=0;
			
			while(i!= c.getCount()){
				
	        	results=c.getString(0);
	        	
	        	adpter.add(results);
	        	
	        	c.moveToNext();
	        	
	        	i++;
	        }
			
			db.close();
			
	
		
			cid_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					
					 id = cid_spinner.getSelectedItem().toString(); 
					 
					 db.open();	
					 
				        Cursor c = db.get_complaint(id);
				        
				        StringBuilder sb0=new StringBuilder();
				        StringBuilder sb1=new StringBuilder();
				        
				        
				        date.setText(sb0.append(c.getString(0)).toString());
				        complaint.setText(sb1.append(c.getString(1)).toString());
				       
				        					       
				        db.close();
				       
				}

				
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
	
	
	
});  
		watch_complaint.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				 id = cid_spinner.getSelectedItem().toString();
				
				db = new Database(Complaint_Principal.this);
				
				db.open();
				
				db.del_complaint(id);
				
				Toast.makeText(getApplicationContext(), id+ " COMPLAINT WATCHED", 5000).show();
				
				db.close();
				
			}
		});	      
		
		
 logout.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i= new Intent(Complaint_Principal.this, Login.class);
				
				i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
				
				startActivity(i);
				
			}
		});	             
			
	}
	
}