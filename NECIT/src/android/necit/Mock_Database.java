package android.necit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mock_Database extends SQLiteOpenHelper {

	static final String DATABASE = "MOCK_TEST";
	
	static final String TABLE = "TEST";
	
	static final String QID= "QID";
	
	static final String QNAME = "QNAME";
	
	static final String OPTIONA = "OPTIONA";
	
	static final String OPTIONB = "OPTIONB";
	
	static final String OPTIONC = "OPTIONC";
	
	static final String OPTIOND = "OPTIOND";
	
	static final String ANS = "ANS";
	
	
	
	
	public Mock_Database(Context context) {
		super(context, DATABASE, null,1);
		
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
	
		
		db.execSQL("CREATE TABLE "+TABLE+" ("+QID+" TEXT, "+
				QNAME+" TEXT, "+OPTIONA+" TEXT,"+OPTIONB+" TEXT,"+OPTIONC+" TEXT,"+OPTIOND+" TEXT,"+ANS+" TEXT) ;");
		
	//	db.execSQL("insert into "+TestTable+"values('10','Grace period for the renewal of a permanent Driving License','a)Nill','b)30days','C)60days','D)90days');");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		db.execSQL("DROP TABLE IF EXISTS "+TABLE);
		onCreate(db);
	}
	
public 	 void AddTest()
	{
		 
		 
		 SQLiteDatabase db= this.getWritableDatabase();
		 
		
		ContentValues cv1=new ContentValues();
		
		cv1.put(QID, "1");
		
		cv1.put(QNAME, "QT : What Is The present Version Of Android");
		
		cv1.put(OPTIONA, "5.0");
		
		cv1.put(OPTIONB, "6.0.7");
		
		cv1.put(OPTIONC, "9.0.9");
		
		cv1.put(OPTIOND, "4.0.3");
		
		cv1.put(ANS, "4.0.3");
	
		
		
		db.insert(TABLE, null, cv1);
	
		
ContentValues cv2=new ContentValues();
		
		cv2.put(QID, "2");
		
		cv2.put(QNAME, "QT : Who Is The Main Vendor Android ");
		
		cv2.put(OPTIONA, "HTC");
		
		cv2.put(OPTIONB, "GOOGLE");
		
		cv2.put(OPTIONC, "SAMSUNG");
		
		cv2.put(OPTIOND, "APPLE");
		
		cv2.put(ANS, "GOOGLE");
	
		
		
		db.insert(TABLE, null, cv2);

ContentValues cv3=new ContentValues();
		
		cv3.put(QID, "3");
		
		cv3.put(QNAME, "QT : Which Mobile Company Leading Profits Through Android ");
		
		cv3.put(OPTIONA, "BLACK BERRY");
		
		cv3.put(OPTIONB, "APPLE");
		
		cv3.put(OPTIONC, "MICRO MAX");
		
		cv3.put(OPTIOND, "SAMSUNG");
		
		cv3.put(ANS, "SAMSUNG");
	
		
		
		db.insert(TABLE, null, cv3);
		
		
		
	
		
		
		db.close();
		
		
	}
	  	 
	 public  Cursor GetData(int ctr)
	 { 
		 SQLiteDatabase db=this.getReadableDatabase();
		
		 Cursor c=db.query(TABLE, null, QID + "=?", new String[]{String.valueOf(ctr)}, null, null, null);
	
		return c;
		
		 }
	 

}


