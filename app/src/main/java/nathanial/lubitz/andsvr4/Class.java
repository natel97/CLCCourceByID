package nathanial.lubitz.andsvr4;

/**
 * Created by Nate on 4/24/2017.
 */

public class Class {
    Class(String ID, String Name, String Days, String Time, String Instructor){
        this.ID = ID;
        this.Name = Name;
        this.Days = Days;
        this.Time = Time;
        this.Instructor = Instructor;

    }
    private String ID;
    private String Name;
    private String Days;
    private String Time;
    private String Instructor;

    @Override
    public String toString() {
        return "" +
                "Class ID:" + ID +
                ", Title: " + Name + '\'' +
                ", Days: " + Days + '\'' +
                ", Time: " + Time + '\'' +
                ", Instructor: " + Instructor + '\'';
    }
}
