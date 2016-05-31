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

public class Edit_Student extends Activity {
	
	EditText edit_name, edit_address, edit_phone, edit_email;
	
	Button update;
	
    String name, address, phone,email, edit_spin;
    
    Spinner spin;
    
    protected String[] sblr;
    
   	private ArrayAdapter<CharSequence> adpter; 
   	
   	private String results;
   	
   	Database db;
   	
    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_student);
		
		spin=(Spinner)findViewById(R.id.edit_spinner);
		
		edit_name=(EditText)findViewById(R.id.edit_name);
		
		edit_address=(EditText)findViewById(R.id.edit_address);
		
		edit_phone=(EditText)findViewById(R.id.edit_phone);
		
		edit_email=(EditText)findViewById(R.id.edit_email);
		
		update=(Button)findViewById(R.id.student_update);
		
		
		
		adpter=new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
		spin.setAdapter(adpter);
		
		
		 db = new Database(Edit_Student.this);
			
			
				
				db.open();
				
				Cursor c = db.spinner_add();
				
			
				
				int i=0;
				
				while(i!=c.getCount()){
					
		        	results=c.getString(0);
		        	adpter.add(results);
		        	c.moveToNext();
		        	i++;
		        }
				
				db.close();
				
		
				
				spin.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						 edit_spin = spin.getSelectedItem().toString(); 
						
							 db.open();
							 
					        Cursor c = db.select_student(edit_spin);
					        
					        StringBuilder sb1=new StringBuilder();
					        StringBuilder sb2=new StringBuilder();
					        StringBuilder sb3=new StringBuilder();
					        StringBuilder sb4=new StringBuilder();
					        
					        edit_email.setText("");
					        
					        edit_name.setText("");
					        
					        edit_address.setText("");
					        
					        edit_phone.setText("");
					        
					       
					       
					        edit_email.append(sb4.append(c.getString(3)).toString());
					        edit_name.append(sb1.append(c.getString(0)).toString());
					        edit_address.append(sb2.append(c.getString(1)).toString());
					        edit_phone.append(sb3.append(c.getString(2)).toString());
					        					       
					        db.close();
					       
					}

					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
				});
			 
				update.setOnClickListener(new OnClickListener() {
					
					
					public void onClick(View v) {
					
					edit_spin = spin.getSelectedItem().toString();
					
					name = edit_name.getText().toString();
					
					address=edit_address.getText().toString();
					
					phone = edit_phone.getText().toString();
					
					email = edit_email.getText().toString();	
					
					
					edit_address.setText("");
					
					edit_phone.setText("");
					
					edit_email.setText("");
					
					edit_name.setText("");
					
				
			
					
					
						
					    db.open();  
						
				       if( db.edit_student(edit_spin, name, address, phone, email))
				        {                	
				        	Toast.makeText(getApplicationContext(), edit_spin+ " RECORD UPDATED",Toast.LENGTH_LONG).show();
				        }
				        
				        else{
				        	Toast.makeText(getApplicationContext(),"RECORD ALREADY EXISTED",Toast.LENGTH_LONG).show();
				        }
				       
				       db.close();
				        }
					
					
				       
					    
				});
				
				
						
	}
    


}
