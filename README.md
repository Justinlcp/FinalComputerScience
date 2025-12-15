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

Department:
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
