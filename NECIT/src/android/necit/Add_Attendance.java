package android.necit;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_Attendance extends Activity {
	
	EditText attendance_conducted, attendance_attended;
	
	Button attendance_insert;
	
    String conducted,attended,add_spinner;
    
    Spinner spin;
    
    protected String[] sblr;
    
   	private ArrayAdapter<CharSequence> adpter; 
   	
   	private String results;
   	
  
   	
    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_attendance);
		
		spin=(Spinner)findViewById(R.id.attendance_add_spinner);
		
		attendance_attended = (EditText)findViewById(R.id.add_attended);
		
		attendance_conducted = (EditText)findViewById(R.id.add_conducted);
		
		
		
		attendance_insert = (Button)findViewById(R.id.attendance_insert);
		
		 
		adpter=new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
		spin.setAdapter(adpter);
		
		
		
		
			Database db = new Database(Add_Attendance.this);
			
		
				
				db.open();
				
				
				Cursor c=db.spinner_add();
				
				int i=0;
				
				while(i!=c.getCount()){
					
		        	results=c.getString(0);
		        	
		        	adpter.add(results);
		        	
		        	c.moveToNext();
		        	
		        	i++;	}
				
			db.close();
			
			
			
			
			
				
				
		
				attendance_insert.setOnClickListener(new OnClickListener() {
					
					
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						add_spinner = spin.getSelectedItem().toString();
						
						
						conducted = attendance_conducted.getText().toString().trim();
						
						attended = attendance_attended.getText().toString().trim();
						
						attendance_attended.setText("");
						attendance_conducted.setText("");
						
						Database db = new Database(Add_Attendance.this);
						
						db.open();
						
					if(db.add_attendence(add_spinner, attended, conducted)){
						
						
						
					
						
							Toast.makeText(getApplicationContext(), add_spinner+ " RECORD INSERTED", 20000).show();
							
					}
						
					else {
							Toast.makeText(getApplicationContext(), add_spinner + "  RECORD ALREADY EXISTED", 20000).show();
						
					}	
						db.close();
					}
				});
						
				      
					
					
				       
					    
			
				
				
	}
    
}

