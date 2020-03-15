package com.student;

public class StudentTest {
	public static void main(String[] args) {
		//创建5个学生对象
		Student zhangsan = new Student("zhangsan", 18);
		Student lisi = new Student("lisi", 19);
		Student wangwu = new Student("wangwu", 20);
		Student zhaoliu = new Student("zhaoliu", 17);
		Student sunqi = new Student("sunqi",16);
		
		Student[] students = new Student[5];
		students[0] = zhangsan;
		students[1] = lisi;
		students[2] = wangwu;
		students[3] = zhaoliu;
		students[4] = sunqi;
		
		StudentTest test = new StudentTest();
		
		Student maxAgeStudent = test.getMaxAgeStudent(students);
		System.out.println("年龄最大的为："+maxAgeStudent.toString());
	}
	
	public Student getMaxAgeStudent(Student[] students) {
		for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[j].getAge() > students[i].getAge()) {
                	Student tmp = students[i];
                	students[i] = students[j];
                	students[j] = tmp;
                }

            }
        }
		return students[0];
		
	}
}
