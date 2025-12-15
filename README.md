FinalCSProject – Academic Management System

Justin Lachapelle
Id: 2583626

Project Overview

This project is an academic management system developed entirely as the final project for the class Introduction to Programming at College Vanier. The system kind of models a school environment: students are associated with their department, can register for courses, complete assignments and receive grade. 
The project focuses on applying many things we learned this semester such asclass design, data validation, method creating and unit testing. 
It is built using Java code, Maven, lombok and JUnit 5.


System Capabilities

- Creating academic departments (automatic Id generation)
- Creating students (Personal/Academic information)
- Registering/Droping students from courses
- Creating courses (Under specific departments)
- Adding assignments (Weighted grading schemes)
- Generating/Calculating student scores
- Displaying scores (Assignment averages/Final score for all students)


Class Overview and Responsibilities

Department

Represents an academic department in the school

Responsibilities:

- Stores the department (Name/Department ID)
- Automatically generates the ID
- Validates department names (Letters/Spaces only)

Student

Represents a student enrolled in the school.

Responsibilities:

- Stores student ID/name/gender/address/department
- Automatically generates student IDs
- Registers for/drops courses
- Maintains a list of registered courses 
- Provides simplified/detailed string representations of student data


Course

Represents a course offered by a department

Responsibilities:

- Stores course ID/course name/credit value/department
- Automatically generates course IDs
- Manages registered students
- Stores assignments (weights too)
- Validates that total assignment weights equal 100%
- Calculates weighted averages for students
- Displays course score tables including assignment averages/final scores

Assignment

Represents an assignment within a course.

Responsibilities:

- Stores assignment ID/name/weight
- Stores student scores
- Generates random scores(Many rules)
- Calculates assignment averages

Address

Represents a student's address.

Responsibilities:

- Stores street number/Street name/city/province/postal code
- Validates Canadian postal codes (specific format)
- Ensures postal codes are stored in uppercase

