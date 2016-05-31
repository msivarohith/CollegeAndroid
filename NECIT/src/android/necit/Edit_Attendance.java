package android.necit;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Edit_Attendance extends Activity {
	
	EditText edit_conducted, edit_attended;
	
	Button update;
	
    String conducted,attended,edit_spinner;
    
    Spinner spin;
    
    protected String[] sblr;
    
   	private ArrayAdapter<CharSequence> adpter; 
   	
   	private String results;
   	
  
   	
    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_attendance);
		
		spin=(Spinner)findViewById(R.id.attendance_edit_spinner);
		
		edit_attended = (EditText)findViewById(R.id.edit_attended);
		
		edit_conducted = (EditText)findViewById(R.id.edit_conducted);
		
		
		
		update=(Button)findViewById(R.id.attendance_update);
		
		 
		adpter=new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
		spin.setAdapter(adpter);
		
		
		
		
			Database db = new Database(Edit_Attendance.this);
			
		
				
				db.open();
				
				
				Cursor c=db.spinner_attendance();
				
				int i=0;
				
				while(i!=c.getCount()){
					
		        	results=c.getString(0);
		        	
		        	adpter.add(results);
		        	
		        	c.moveToNext();
		        	
		        	i++;	}
				
			db.close();
			
			
			spin.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					 edit_spinner = spin.getSelectedItem().toString(); 
					 
					 Database db = new Database(Edit_Attendance.this);
					
						 db.open();		     		     
				        Cursor c = db.select_attendance(edit_spinner);
				        
				        StringBuilder sb1=new StringBuilder();
				        StringBuilder sb2=new StringBuilder();
				        
				        edit_attended.setText("");
				        edit_conducted.setText("");
				        
				        
				       
				        edit_attended.append(sb1.append(c.getString(0)).toString());
				        edit_conducted.append(sb2.append(c.getString(1)).toString());
				      
				        
				        db.close();
				       
				}

				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			
			
			});	
				
				
		
				update.setOnClickListener(new OnClickListener() {
					
					
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						edit_spinner = spin.getSelectedItem().toString();
						
						attended = edit_attended.getText().toString().trim();
						conducted = edit_conducted.getText().toString().trim();
						
						edit_attended.setText("");
						edit_conducted.setText("");
						
						Database db = new Database(Edit_Attendance.this);
						
						db.open();
						
					
						
						if(db.edit_attendance(edit_spinner, attended, conducted)){
							
							
					
						
							Toast.makeText(getApplicationContext(), edit_spinner+ " RECORD UPDATED", 20000).show();
							
					}
						
					else {
							Toast.makeText(getApplicationContext(), " NOT UPDATED", 20000).show();
						
					}	
						db.close();
					}
				});
						
				      
					
					
				       
						    
			
				
				
	}
    
}

