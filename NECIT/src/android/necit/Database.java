package android.necit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class Database {
	
	    
	 
	    
	    //...........DATABASE NEME & VERSION................//
	    
	    private static final String DATABASE_NAME = "NECIT" ;
	    
	    private static final int DATABASE_VERSION = 1; 
	    
	    
	    //.........TABLE NAMES............//
	    
	    private static String TABLE_REG = "REG" ;
	    
	    private static String TABLE_ATN = "ATN" ;
	     
	    private static String TABLE_MARK = "MARK" ;
	    
	    private static String TABLE_CMP = "CMP" ;
	    
	    //.........REG TABLE FIELDS..............//
	    
	    public static final String KEY_RID= "ID";
	    
	    public static final String KEY_RPASSWORD = "PASSWORD";
	    
	    public static final String KEY_RNAME = "NAME";
	    
	    public static final String KEY_RADDRESS= "ADDRESS"; 
	    
	    public static final String KEY_RPHONE= "PHONE";  
	    
	    public static final String KEY_REMAIL= "EMAIL";  
	    
	    //.........ATN TABLE FIELDS..............//
	    
	    public static final String KEY_AID= "ID";
	    
	    public static final String KEY_ATTEND = "ATTEND";
	    
	    public static final String KEY_CONDUCT = "CONDUCT";
	    
	    
	    
	    
	    //.........MARK TABLE FIELDS..............//
	    
	    public static final String KEY_MID= "ID";
	    
	    public static final String KEY_S1 = "S1";
	    
	    public static final String KEY_S2 = "S2";
	    
	    public static final String KEY_S3= "S3"; 
	    
	    public static final String KEY_S4= "S4";  
	    
	    public static final String KEY_S5= "S5"; 
	    
	    public static final String KEY_S6= "S6"; 
	    
	    
	    //...........CMP TABLE FIELDS...............//
	    
	    public static final String KEY_CID= "ID";
	    
	    public static final String KEY_DATE = "DATE";
	    
	    public static final String KEY_REASON = "REASON";
	    
	
	    //CREATING TABLES
	    
	    private static final String TABLE_REG_CRE =   
	    		"CREATE TABLE REG(ID TEXT NOT NULL, "+" PASSWORD TEXT NOT NULL, "+" NAME TEXT NOT NULL," +
			    " ADDRESS TEXT NOT NULL, "+" PHONE TEXT NOT NULL, "+" EMAIL TEXT NOT NULL);"; 
	   
	    private static final String TABLE_ATN_CRE =   
	    		"CREATE TABLE ATN(ID TEXT NOT NULL, "+" ATTEND TEXT NOT NULL, "+" CONDUCT TEXT NOT NULL);"; 
	    
	    private static final String TABLE_MARK_CRE =   
	    		"CREATE TABLE MARK(ID TEXT NOT NULL, "+" S1 TEXT NOT NULL, "+" S2 TEXT NOT NULL," +
			    " S3 TEXT NOT NULL, "+" S4 TEXT NOT NULL, "+" S5 TEXT NOT NULL,"+"S6 TEXT NOT NULL);"; 
	    
	    
	    private static final String TABLE_CMP_CRE =   
	    		"CREATE TABLE CMP(ID TEXT NOT NULL, "+" DATE TEXT NOT NULL, "+" REASON TEXT NOT NULL);"; 
	    
	    
	    
	    
	    
	    private Context context = null;  
	    private DatabaseHelper DBHelper;  
	    
	    private SQLiteDatabase db;  
		
	    
	    public Database(Context c)  
	    {  
	        this.context = c;  
	        DBHelper = new DatabaseHelper(context);  
	    } 
	    
	    
	    private static class DatabaseHelper extends SQLiteOpenHelper  
	    {  
	        DatabaseHelper(Context context)  
	        {  
	            super(context, DATABASE_NAME, null, DATABASE_VERSION);  
	        }  
	  
	          
	        public void onCreate(SQLiteDatabase db)  
	        {  
	          
	            db.execSQL(TABLE_REG_CRE);
	            
	            db.execSQL(TABLE_ATN_CRE);
	            
	            db.execSQL(TABLE_MARK_CRE);
	            
	            db.execSQL(TABLE_CMP_CRE);
	            
	           
	            
	        }


			@Override
			public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
				// TODO Auto-generated method stub
				
				 onCreate(db);  
				
			}
	}  
			
			  public void open() throws SQLException  
			    {  
			        db = DBHelper.getWritableDatabase();  
			    }  
			  
			    public void close()  
			    {  
			        DBHelper.close();  
			    } 
	    
	    
	    
	    //********REG TABLE INSERT VALUES***********//
		  
			    
			    public boolean add_student(String id, String password,String name, String address,String phone,String email)  
			    {  
			    	Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_REG + " WHERE ID=? ", new String[]{id});  
			       
			    	if (mCursor != null) {  if(mCursor.getCount() > 0)  {  return false;  }  }
		    		        	
			    	 ContentValues cv = new ContentValues();
			    	 
			         cv.put(KEY_RID,id);
			         
			         cv.put(KEY_RPASSWORD,password);
			         
			         cv.put(KEY_RNAME,name);  
			         
			         cv.put(KEY_RADDRESS,address);  
			     
			         cv.put(KEY_RPHONE,phone);  
			         
			         cv.put(KEY_REMAIL,email);  
			                   
			               
			          db.insert(TABLE_REG, null, cv);
			        
			          return true;              
			    	
			    }
			    
			    
			    //********REGISTER TABLE EDIT VALUES***********//

			    public boolean edit_student(String id,String name, String address,String phone,String email)  
			    {  
		    		        	
			    	 ContentValues cv = new ContentValues();
			         
			         cv.put(KEY_RNAME,name);  
			         
			         cv.put(KEY_RADDRESS,address);  
			     
			         cv.put(KEY_RPHONE,phone);  
			         
			         cv.put(KEY_REMAIL,email);  
			                   
			               
			          db.update(TABLE_REG, cv, KEY_RID + "=" + "'" +id+ "'", null);
			        
			          return true;
			    	}
			    	
			    
			    public boolean pwd_change(String id,String pass)  
			    {  
		    		        	
			    	 ContentValues cv = new ContentValues();
			         
			         cv.put(KEY_RPASSWORD,pass);  
			         
			         
			                   
			               
			          db.update(TABLE_REG, cv, KEY_RID + "=" + "'" +id+ "'", null);
			        
			          return true;
			    	}
			    
			    //********GETTING REGISTER TABLE ID VALUES***********//
			    
			    
			    public Cursor spinner_add()throws SQLException
			    {
			    	Cursor mcur=db.rawQuery("SELECT ID FROM REG ", null);
			    	
			        if(mcur!=null){
			        	mcur.moveToFirst();
			        }
			     return mcur;
			    }
			   
			    
			    //********SELECT REGISTER TABLE  VALUES BY IDS ***********//
			    
			    
			
			    
			    
			    public Cursor select_student(String id)throws SQLException
			    {
			    	
			    	db = DBHelper.getReadableDatabase();
			    	
			    	Cursor mCursor =
		                db.query(true, TABLE_REG, new String[] {KEY_RNAME,KEY_RADDRESS,KEY_RPHONE,KEY_REMAIL}, 
		                		
		                		KEY_RID + "=" + "'"+id+"'", 
		                		null,
		                		null, 
		                		null, 
		                		null, 
		                		null);
			
			  if (mCursor != null) {
		            mCursor.moveToFirst();
		        }
		        return mCursor;
			    }
			  
			    
			    public Cursor select_id(String id)throws SQLException
			    {
			    	
			    	db = DBHelper.getReadableDatabase();
			    	Cursor mCursor =
		                db.query(true, TABLE_REG, new String[] {KEY_RNAME}, 
		                		
		                		KEY_RID + "=" + "'"+id+"'", 
		                		null,
		                		null, 
		                		null, 
		                		null, 
		                		null);
			
			  if (mCursor != null) {
		            mCursor.moveToFirst();
		        }
		        return mCursor;
			    }
			    
			    
			    //********VERIFY USER ID & PWD FROM REGISTER TABLE ***********//

				 public boolean Login(String id, String password) throws SQLException  
				    {  
				        Cursor mCursor = db.rawQuery("SELECT ID,PASSWORD FROM " + TABLE_REG + " WHERE ID=? AND PASSWORD=?", new String[]{id,password});  
				       
				        if (mCursor != null) { 
				        	
				            if(mCursor.getCount() > 0)  
				            {  
				                return true;  
				            }  
				        }  
				     return false;  
				    }  
				 
				 
				  //********DELETE REGISTER TABLE  VALUES***********//
				 
				 
				 public boolean del_student(String id)  
				    {  
				    	Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_REG + " WHERE ID=?", new String[]{id});  
				    	
				    	
				        
				    	if (mCursor != null) {  
				            if(mCursor.getCount() > 0)  
				            {  
				            	db.delete(TABLE_REG,KEY_RID+"=" + "'" +id+ "'" ,null);
				            	return true;  
				            }  
				        }       
				                    
				         return false;
				    }
		
				 
		//..............ATTENDANCE UPDATE..............
				 
				 
				 
				 public boolean add_attendence(String id, String attend,String conduct){
					 
					 Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_ATN + " WHERE ID=? ", new String[]{id});  
					 
					 if (mCursor != null) {  if(mCursor.getCount() > 0)  {  return false;  }  }
					 
					 ContentValues cv = new ContentValues();
					 
					  cv.put(KEY_AID,id); 
					  
					  cv.put(KEY_ATTEND,attend);  
					     
				       cv.put(KEY_CONDUCT,conduct);  
				       
				       db.insert(TABLE_ATN, null, cv);
				       
				       return true;
					 
					 
				 }
				 
				 public boolean edit_attendance(String id,String attend, String conduct)  
				    {  
			    		        	
				    	 ContentValues cv = new ContentValues();
				         
				       
				         
				         cv.put(KEY_ATTEND,attend);  
				     
				         cv.put(KEY_CONDUCT,conduct);  
				         
				        
				                   
				               
				          db.update(TABLE_ATN, cv, KEY_AID + "=" + "'" +id+ "'", null);
				        
				          return true;
				    	} 
				 
				 
				  public Cursor select_attendance(String id)throws SQLException
				    {
				    	
				    	db = DBHelper.getReadableDatabase();
				    	Cursor mCursor =
			                db.query(true, TABLE_ATN, new String[] {KEY_ATTEND,KEY_CONDUCT}, 
			                		
			                		KEY_AID + "=" + "'"+id+"'", 
			                		null,
			                		null, 
			                		null, 
			                		null, 
			                		null);
				
				  if (mCursor != null) {
			            mCursor.moveToFirst();
			        }
			        return mCursor;
				    }
				 
				 
				  
					 public boolean del_attendence(String id)  
					    {  
					    	Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_ATN + " WHERE ID=?", new String[]{id});  
					    	
					    	
					        
					    	if (mCursor != null) {  
					            if(mCursor.getCount() > 0)  
					            {  
					            	db.delete(TABLE_ATN,KEY_AID+"=" + "'" +id+ "'" ,null);
					            	return true;  
					            }  
					        }       
					                    
					         return false;
					    }	 
				 
				 
					 public Cursor spinner_attendance()throws SQLException
					    {
					    	Cursor mcur=db.rawQuery("SELECT ID FROM ATN ", null);
					    	
					        if(mcur!=null){
					        	mcur.moveToFirst();
					        }
					     return mcur;
					    }
					   	 
			public Cursor get_attendance(String id){
				
				db = DBHelper.getReadableDatabase();
		    	Cursor mCursor =
	                db.query(true, TABLE_ATN, new String[] {KEY_ATTEND,KEY_CONDUCT}, 
	                		
	                		KEY_AID + "=" + "'"+id+"'", 
	                		null,
	                		null, 
	                		null, 
	                		null, 
	                		null);
		
		  if (mCursor != null) {
	            mCursor.moveToFirst();
	        }
	        return mCursor;
				
			}
			
			
			
				 
//........................ CMP TABLE ................................
			
			
//COMPLAINT SEND TO THE PRINCIPAL BY THE STUDENT
			
			
			
			
			public boolean cmp_send(String id, String date, String reason){
				
				 Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_CMP + " WHERE ID=? ", new String[]{id});  
				 
				 if (mCursor != null) {  if(mCursor.getCount() > 0)  {  return false;  }  }
				
				 ContentValues cv = new ContentValues();
				 
				  cv.put(KEY_CID,id); 
				  
				  cv.put(KEY_DATE,date);  
				     
			       cv.put(KEY_REASON,reason);  
			       
			       db.insert(TABLE_CMP, null, cv);
			       
			       return true;
				
				
			}
			
			
				 
//TO ADD THE STUDENT ID TO SPINNER FROM COMPLAINT TABLE 					 
				 
			  public Cursor spinner_complaint()throws SQLException
			    {
				  Cursor mcur=db.rawQuery("SELECT ID FROM CMP ", null);
			    	
			        if(mcur!=null){
			        	mcur.moveToFirst();
			        }
			     return mcur;
			    }	
			  
			  
				 
			  
//TO GET THE COMPLAINTS FROM THE STUDENT ACCORDING TO THEIR ROOL NUMBERS
			  
			  
			  
				public Cursor get_complaint(String id){
					
					db = DBHelper.getReadableDatabase();
					
			    	Cursor mCursor =
		                db.query(true, TABLE_CMP, new String[] {KEY_DATE,KEY_REASON}, 
		                		
		                		KEY_CID + "=" + "'"+id+"'", 
		                		null,
		                		null, 
		                		null, 
		                		null, 
		                		null);
			
			  if (mCursor != null) {
		            mCursor.moveToFirst();
		        }
		        return mCursor;
					
				}
				
				
				
//DELETE THE STUDENT COMPLAINTS BY PRINCIPAL
				
				
				
				
				 public boolean del_complaint(String id)  
				    {  
				    	Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_CMP + " WHERE ID = ? ", new String[]{id});  
				    	
				    	
				        
				    	if (mCursor != null) {  
				            if(mCursor.getCount() > 0)  
				            {  
				            	db.delete(TABLE_CMP,KEY_CID+"=" + "'" +id+ "'" ,null);
				            	return true;  
				            }  
				        }       
				                    
				         return false;
				    }	
				 
				 
				 
				 
//.............................. MARKS TABLE .........................
				 
				 public boolean add_marks(String id, String s1,String s2,String s3,String s4,String s5,String s6){
					 
					 Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_MARK + " WHERE ID=? ", new String[]{id});  
					 
					 if (mCursor != null) {  if(mCursor.getCount() > 0)  {  return false;  }  }
					 
					 ContentValues cv = new ContentValues();
					 
					  cv.put(KEY_MID,id); 
					  
					  cv.put(KEY_S1,s1);  
					     
					  cv.put(KEY_S2,s2);  
					  
					  cv.put(KEY_S3,s3);  
					  
					  cv.put(KEY_S4,s4);  
					  
					  cv.put(KEY_S5,s5);  
					  
					  cv.put(KEY_S6,s6);  
				       
				       db.insert(TABLE_MARK, null, cv);
				       
				       return true;
					 
					 
				 }	 
				 
				 
				 
				// TO ADD THE STUDENT ID TO SPINNER FROM COMPLAINT TABLE 					 
				 
				  public Cursor spinner_marks()throws SQLException
				    {
					  Cursor mcur=db.rawQuery("SELECT ID FROM MARK ", null);
				    	
				        if(mcur!=null){
				        	mcur.moveToFirst();
				        }
				     return mcur;
				    }	
				  
				  
				
				 
				 public boolean del_marks(String id)  
				    {  
				    	Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_MARK + " WHERE ID=?", new String[]{id});  
				    	
				    	
				        
				    	if (mCursor != null) {  
				            if(mCursor.getCount() > 0)  
				            {  
				            	db.delete(TABLE_MARK, KEY_MID+"=" + "'" +id+ "'" ,null);
				            	return true;  
				            }  
				        }       
				                    
				         return false;
				    }	 
			 		 
				 
				 public Cursor get_marks(String id){
						
						db = DBHelper.getReadableDatabase();
				    	Cursor mCursor =
			                db.query(true, TABLE_MARK, new String[] {KEY_S1,KEY_S2,KEY_S3,KEY_S4,KEY_S5,KEY_S6}, 
			                		
			                		KEY_MID + "=" + "'"+id+"'", 
			                		null,
			                		null, 
			                		null, 
			                		null, 
			                		null);
				
				  if (mCursor != null) {
			            mCursor.moveToFirst();
			        }
			        return mCursor;
						
					}		 
				 
				 
			}
