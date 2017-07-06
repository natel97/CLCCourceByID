package nathanial.lubitz.andsvr4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nate on 4/24/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

        public static final String DATABASE_NAME = "main.db";
        public static final String TABLE1 = "Course";
        public static final String COL11 = "CourseID";//INT
        public static final String COL12 = "Subject";//TEXT
        public static final String COL13 = "CourseNumber";//INT
        public static final String COL14 = "Section";//INT
        public static final String COL15 = "Title";//TEXT
        public static final String COL16 = "Dates";//TEXT
        public static final String COL17 = "Days";//TEXT
        public static final String COL18= "Time";//TEXT
        public static final String COL19 = "Credits";//INT
        public static final String COL110 = "Status";//TEXT
        public static final String COL111 = "Tuition";//TEXT
        public static final String COL112 = "Location";//TEXT
        public static final String TABLE2 = "Schedule";
        public static final String COL21 = "ScheduleID";//INT
        public static final String COL22 = "CourseID";//INT
        public static final String COL23 = "InstructorID";//INT
        public static final String COL24 = "Semester";//TEXT
        public static final String TABLE3 = "Instructors";
        public static final String COL31 = "InstructorID";//INT
        public static final String COL32 = "FirstName";//TEXT
        public static final String COL33 = "LastName";//TEXT

        public DatabaseHelper(Context cont){
            super(cont, DATABASE_NAME, null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //Table 1: CourseID, Subject, CourceNumber, Section, Title, Dates, Days, Time, Credits, Status, Tuition, Location

            db.execSQL("CREATE TABLE " + TABLE1 + " (" + COL11 + " TEXT PRIMARY KEY, "+COL12 + " TEXT, " +COL13 + " INTEGER, " + COL14 + " INTEGER, " +COL15 + " TEXT, " +COL16 + " TEXT, " +COL17 + " TEXT, " +COL18 + " TEXT, " +COL19 + " INTEGER, "+COL110 + " TEXT, " +COL111 + " TEXT, "  + COL112 + " TEXT)");
            db.execSQL("CREATE TABLE " + TABLE2 + " (" + COL21 + " INTEGER PRIMARY KEY, "+COL22 + " TEXT, "+COL23 + " INTEGER, " + COL24 + " TEXT)");
            db.execSQL("CREATE TABLE " + TABLE3 + " (" + COL31 + " INTEGER PRIMARY KEY AUTOINCREMENT, "+COL32 + " TEXT, " + COL33 + " TEXT) ");
            db.execSQL("insert into " + TABLE1 + " values ('000188','APPD','Programming in C#',1110,80,'08/21 - 12/15','M W','8:00am - 9:20am',3,'OPEN','$561.63','Central Lakes College-Brainerd Campus')");
            db.execSQL("insert into " + TABLE1 + " values ('000189','APPD','Problem Solving Using Java',1111,80,'08/21 - 12/15','T TH','8:00am - 9:20am',3,'OPEN','$561.63','Central Lakes College-Brainerd Campus')");
            db.execSQL("insert into " + TABLE1 + " values ('000190','APPD','Database Design Fundamentals',1115,20,'08/21 - 12/15','M W','1:00pm - 2:20pm',3,'OPEN','$561.63','Central Lakes College-Brainerd Campus')");
            db.execSQL("insert into " + TABLE1 + " values ('000191','APPD','Advanced Problem Solving with Java',2111,20,'08/21 - 12/15','M','5:00pm - 7:50pm',3,'OPEN','$561.63','Central Lakes College-Brainerd Campus')");
            db.execSQL("insert into " + TABLE1 + " values ('000192','APPD','Advanced Programming in C#',2114,20,'08/21 - 12/15','T','5:00pm - 7:50pm',3,'OPEN','$561.63','Central Lakes College-Brainerd Campus')");
            db.execSQL("insert into " + TABLE2 + " values (1, '000188',2,'Fall');");
            db.execSQL("insert into " + TABLE2 + " values (2, '000189',1,'Fall');");
            db.execSQL("insert into " + TABLE2 + " values (3, '000190',2,'Fall');");
            db.execSQL("insert into " + TABLE2 + " values (4, '000191',1,'Fall');");
            db.execSQL("insert into " + TABLE2 + " values (5, '000192',1,'Fall');");
            db.execSQL("insert into " + TABLE3 + " values (1, 'Sam', 'Espana')");
            db.execSQL("insert into " + TABLE3 + " values (2, 'To Be', 'Determined')");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
            onCreate(db);}

    public Cursor getFullList(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select a.CourseID, a.Subject, a.CourseNumber, a.Section, a.Title, a.Dates, a.Days, a.Time, a.Credits, a.Status, a.Tuition, a.Location, b.Semester, c.FirstName, c.LastName from Course a, Schedule b, Instructors c where a.CourseID = b.CourseID and b.InstructorID = c.InstructorID",null);
        return res;
    }

    public Cursor searchFromDatabase(String a){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select a.CourseID, a.Subject, a.CourseNumber, a.Section, a.Title, a.Dates, a.Days, a.Time, a.Credits, a.Status, a.Tuition, a.Location, b.Semester, c.FirstName, c.LastName from Course a, Schedule b, Instructors c where a.CourseID = b.CourseID and b.InstructorID = c.InstructorID and a.CourseID = '" + a + "'",null);
            return res;
    }
public Cursor getQuickSearch(String a){
    SQLiteDatabase db = this.getWritableDatabase();
    if (a == ""){

        return  db.rawQuery("Select a.CourseID, a.Title, a.Days, a.Time, c.FirstName, c.LastName from Course a, Schedule b, Instructors c where a.CourseID = b.CourseID and b.InstructorID = c.InstructorID", null);
    }
    else{
        return db.rawQuery("Select a.CourseID, a.Title, a.Days, a.Time, c.FirstName, c.LastName from Course a, Schedule b, Instructors c where a.CourseID = b.CourseID and b.InstructorID = c.InstructorID and a.CourseID like '%"+a+"%'", null);

    }
}

}
