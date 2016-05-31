package android.necit;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class Search_Student extends Activity {
	
	TextView search_name, search_address, search_phone, search_email;
	
	
	
    String name, address, phone, email, search_spinner;
    
    Spinner spin;
    
    protected String[] sblr;
    
   	private ArrayAdapter<CharSequence> adpter; 
   	
   	private String results;
   	
   	Database db;
   	
    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.search_student);
		
		spin=(Spinner)findViewById(R.id.search_spinner);
		
		search_name=(TextView)findViewById(R.id.search_name);
		
		search_address=(TextView)findViewById(R.id.search_address);
		
		search_phone=(TextView)findViewById(R.id.search_phone);
		
		search_email=(TextView)findViewById(R.id.search_email);
		 
		adpter=new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
		spin.setAdapter(adpter);
		
		
		 db = new Database(Search_Student.this);
			
			
		
		      db.open();
			
			Cursor cn=db.spinner_add();
			
			int i=0;
			
			while(i!=cn.getCount()){
	        	results=cn.getString(0);
	        	adpter.add(results);
	        	cn.moveToNext();
	        	i++;
	        }
				db.close();
				
		
			spin.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						 search_spinner = spin.getSelectedItem().toString(); 
						
							 db.open();		
							 
					        Cursor c = db.select_student(search_spinner);
					        
					        StringBuilder sb1=new StringBuilder();
					        StringBuilder sb2=new StringBuilder();
					        StringBuilder sb3=new StringBuilder();
					        StringBuilder sb4=new StringBuilder();
					        
					       
					        search_name.setText(sb1.append(c.getString(0)).toString());
					        search_address.setText(sb2.append(c.getString(1)).toString());
					        search_phone.setText(sb3.append(c.getString(2)).toString());
					        search_email.setText(sb4.append(c.getString(3)).toString());
					        
					        db.close();
					       
					}

					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
				});
			
    }
}