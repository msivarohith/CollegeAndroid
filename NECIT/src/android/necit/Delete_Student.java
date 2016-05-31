package android.necit;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Delete_Student extends Activity{
	
	Button delete;
	
	Spinner spin;
	
	protected String[] sblr;
	
	private ArrayAdapter<CharSequence> adpter;
	
	private String results, delete_spinner;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.delete_student);
		
		
		 
		 
		delete=(Button)findViewById(R.id.student_delete);
		
		spin=(Spinner)findViewById(R.id.delete_spinner);
		
		adpter=new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spin.setAdapter(adpter);		
        
        Database db = new Database(Delete_Student.this); 
		
		
			
			db.open();
			
			Cursor cn=db.spinner_add();
			
			int i=0;
			
			while(i!=cn.getCount()){
	        	results=cn.getString(0);
	        	adpter.add(results);
	        	cn.moveToNext();
	        	i++;
	        }
			
			delete.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					delete_spinner = spin.getSelectedItem().toString();
					
					Database db=new Database(Delete_Student.this);
				     	
					db.open();
				     	
				     	
				       if(db.del_student(delete_spinner)){
				    	
					 Toast.makeText(getApplicationContext(),delete_spinner+ " RECORD DELETED",Toast.LENGTH_LONG).show(); 	
				       }
				       
				       else{
				    	   Toast.makeText(getApplicationContext(),"USER NOT DELETED ",Toast.LENGTH_LONG).show();	   
				       }
				       db.close(); 
				       }
				    
					
				
			});
	    
	}
}
