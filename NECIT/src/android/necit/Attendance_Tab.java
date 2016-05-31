package android.necit;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class Attendance_Tab extends TabActivity{
	
TabHost host;
Resources res; 
TabHost.TabSpec spec;

public void onCreate(Bundle savedInstanceState){
	
	super.onCreate(savedInstanceState);
	
	Intent add = new Intent(getApplicationContext(),Add_Attendance.class);
	
	Intent edit = new Intent(getApplicationContext(),Edit_Attendance.class);
	
	Intent delete = new Intent(getApplicationContext(),Delete_Attendance.class);
	
	Intent home = new Intent(getApplicationContext(),Admin_Activity.class);
	
	home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	
	//int num = getIntent().getExtras().getInt("tab_num");
	
	res=getResources();
	host=getTabHost();
	host.setCurrentTab(3);
	
	spec=host.newTabSpec("1").setIndicator("",res.getDrawable(R.drawable.add)).setContent(add);
	host.addTab(spec);
	

	spec=host.newTabSpec("2").setIndicator("",res.getDrawable(R.drawable.edit)).setContent(edit);
	host.addTab(spec);
	
	spec=host.newTabSpec("4").setIndicator("",res.getDrawable(R.drawable.delete)).setContent(delete);
	host.addTab(spec);
	
	spec=host.newTabSpec("5").setIndicator("",res.getDrawable(R.drawable.home)).setContent(home);
	host.addTab(spec);

	
	}
}