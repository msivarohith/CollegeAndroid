package android.necit;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Delete_Marks extends Activity{
	
	Button delete;
	Spinner spin;
	
	protected String[] sblr;
	
	private ArrayAdapter<CharSequence> adpter;
	
	private String results,sp;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.delete_marks);
		
		delete=(Button)findViewById(R.id.mark_del);
		spin=(Spinner)findViewById(R.id.delmarkspin);
		
		adpter=new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spin.setAdapter(adpter);		
        
    Database db = new Database(Delete_Marks.this); 
		
		
			
			db.open();
			
			Cursor cn=db.spinner_marks();
			
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
					sp=spin.getSelectedItem().toString();
					
					Database db=new Database(Delete_Marks.this);
				     	
					db.open();
				     	
				     	
				       if(db.del_marks(sp)){
				    	
					 Toast.makeText(getApplicationContext(),sp + " RECORD DELETED",Toast.LENGTH_LONG).show(); 	
				       }
				       
				       else{
				    	   Toast.makeText(getApplicationContext(),"USER NOT DELETED ",Toast.LENGTH_LONG).show();	   
				       }
				       db.close(); 
				       }
				    
					
				
			});
	    
	}
}
