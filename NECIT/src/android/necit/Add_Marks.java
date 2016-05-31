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

public class Add_Marks extends Activity {
	
	EditText s1,s2,s3,s4,s5,s6;
	
	Button m_insert;
	
    String sub1,sub2,sub3,sub4,sub5,sub6,sp;
    
    Spinner spin;
    
    protected String[] sblr;
    
   	private ArrayAdapter<CharSequence> adpter; 
   	
   	private String results;
   	
  
   	
    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_marks);
		
		spin=(Spinner)findViewById(R.id.m_spinner);
		
		 s1 = (EditText)findViewById(R.id.s1);
		 s2 = (EditText)findViewById(R.id.s2);
		 s3 = (EditText)findViewById(R.id.s3);
		 s4 = (EditText)findViewById(R.id.s4);
		 s5 = (EditText)findViewById(R.id.s5);
		 s6 = (EditText)findViewById(R.id.s6);
		
		
		
		m_insert=(Button)findViewById(R.id.m_insert);
		 
		adpter=new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
		spin.setAdapter(adpter);
		
		
		
		
			Database db = new Database(Add_Marks.this);
			
		
				
				db.open();
				
				
				Cursor c=db.spinner_add();
				
				int i=0;
				
				while(i!=c.getCount()){
					
		        	results=c.getString(0);
		        	
		        	adpter.add(results);
		        	
		        	c.moveToNext();
		        	
		        	i++;	}
				
			db.close();
			
			
			
			
			
				
				
		
				m_insert.setOnClickListener(new OnClickListener() {
					
					
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						sp=spin.getSelectedItem().toString();
						
						
						sub1 = s1.getText().toString().trim();
						sub2 = s2.getText().toString().trim();
						sub3 = s3.getText().toString().trim();
						sub4 = s4.getText().toString().trim();
						sub5 = s5.getText().toString().trim();
						sub6 = s6.getText().toString().trim();
						
					
						
						Database db = new Database(Add_Marks.this);
						
						db.open();
						
					if(db.add_marks(sp, sub1,sub2,sub3,sub4,sub5,sub6)){
						
						                  
						                   s2.setText("");
						                   s3.setText("");
						                   s4.setText("");
						                   s5.setText("");
						                   s6.setText("");
						                   s1.setText("");
						                  
						
						
					
						
							Toast.makeText(getApplicationContext(), sp+ " RECORD ADDED", 20000).show();
							
					}
						
					else {
						
						
						   s2.setText("");
		                   s3.setText("");
		                   s4.setText("");
		                   s5.setText("");
		                   s6.setText("");
		                   s1.setText("");
						
							Toast.makeText(getApplicationContext(), sp +"  RECORD ALREADY EXISTED", 20000).show();
						
					}	
						db.close();
					}
				});
						
				      
					
					
				       
					    
			
				
				
	}
    
}

