import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class StudentHashSetDemo {

    static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Student)) return false;
            Student other = (Student) obj;
            return id == other.id && Objects.equals(name, other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "'}";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Student> studentSet = new HashSet<>();

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID for student " + (i + 1) + ": ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            Student student = new Student(id, name);
            if (!studentSet.add(student)) {
                System.out.println("Duplicate student ignored: " + student);
            }
        }

        System.out.println("\nStudents in HashSet:");
        for (Student s : studentSet) {
            System.out.println(s);
        }

        scanner.close();
    }
}
