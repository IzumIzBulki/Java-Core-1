package com.zergatstage.javacore.seminar03;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Person> staff = new ArrayList<>(5);
        staff.add(new Person("Josh",33, 25000));
        staff.add(new Person("Abram",54, 36000));
        staff.add(new Person("Luck",33, 18000, 1,12,99));
        staff.add(new Person("Amber",45, 27000));
        staff.add(new Person("Bonny",33, 55000,12,12,99));


        System.out.println(staff);
        EmployeeProcessor.increaseSalary(staff);
        System.out.println(staff);
        EmployeeProcessor.increaseSalary(staff,32, 999);
        System.out.println(staff);


        //## task01
        //compare by bitwise
        Person targPerson = staff.get(4);
        int compareResult = staff.get(2).compareByAgeShift(targPerson.getBirthDay(),targPerson.getBirthMonth(),targPerson.getBirthYear());
        //demonstrates the difference between full birthdate bitwise comparator and simple comparator
        System.out.println("Compare result by bitwise: " + compareResult);
        System.out.printf("Compare by comparator: %d", staff.get(2).compareTo(targPerson));


        //## task02
        // promote salary to any workers except director
        Person boss = new Director("Philly", 67, 125000);
        staff.add(boss);
        EmployeeProcessor.increaseSalary(staff, String.valueOf(Director.class));
        System.out.println("\n ##Task02 \n " + staff);
    }
}
