package classexamples;

import java.util.Calendar;


/**
 * Represents a typical UAA course. This allows storing all information about
 * a course at UAA, including its name, section, credits, schedule, 
 * students, teacher, etc.
 * 
 * Note that in many of the class attributes additional information may want
 * to be stored. You can achieve this by storing those attributes as objects
 * that have their own attributes.
 * 
 * @author rnixon
 */
class Course {
    
    private String name;
    
    private String section;
    
    private int credits;
    
    private Meeting[] schedule;
    
    private Person teacher;
    
    public static Course getAllCourses() {
        Course crs = new Course();
        crs.name = "Programming Concepts I";
        crs.credits = 3;
        
        crs.schedule = new Meeting[2];
        
        
        crs.schedule[0] = new Meeting();
        crs.schedule[0].day = Calendar.getInstance();
        crs.schedule[0].day.set(2012, 1, 15, 11, 30); //Tuesday's meeting time
        crs.schedule[0].location = "ENG 109";
        
        crs.schedule[1] = new Meeting();
        crs.schedule[1].day = Calendar.getInstance();
        crs.schedule[1].day.set(2012, 1, 17, 11, 30); //Thursday's meeting time
        crs.schedule[1].location = "ENG 109";
        
        //What about Thursday? Can we do that?
        
        
        crs.teacher = new Person();
        crs.teacher.setFirst("Ryan");
        crs.teacher.setLast("Nixon");
        
        //What about students?
        
        return crs;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public String getSection() {
        return section;
    }
    
    public static class Meeting {
        public Calendar day;
        public String location;        
    }
    
}
