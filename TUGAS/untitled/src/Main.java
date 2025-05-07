// Superclass dengan enkapsulasi dan konstruktor
class Person {
    // Enkapsulasi: atribut private
    private String name;
    private int age;

    // Konstruktor untuk inisialisasi
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter dan Setter (enkapsulasi)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    // Method untuk menampilkan info
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    // Method yang akan di-override
    public void work() {
        System.out.println(name + " is working.");
    }
}

// Subclass yang mewarisi Person
class Employee extends Person {
    private String company;
    private double salary;

    // Konstruktor subclass menggunakan super keyword untuk memanggil konstruktor superclass
    public Employee(String name, int age, String company, double salary) {
        super(name, age); // memanggil konstruktor Person
        this.company = company;
        this.salary = salary;
    }

    // Getter dan Setter untuk atribut baru
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    // Override method work() dari superclass
    @Override
    public void work() {
        // Memanggil method work() superclass dengan super
        super.work();
        System.out.println(getName() + " is working at " + company + " with salary " + salary);
    }

    // Method tambahan untuk menaikkan gaji
    public void raiseSalary(double amount) {
        if (amount > 0) {
            salary += amount;
            System.out.println("Salary raised by " + amount + ". New salary: " + salary);
        }
    }

    // Method untuk menampilkan info lengkap
    @Override
    public void displayInfo() {
        super.displayInfo(); // memanggil displayInfo() superclass
        System.out.println("Company: " + company + ", Salary: " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat objek Employee
        Employee emp = new Employee("Alice", 30, "TechCorp", 5000.0);

        // Memanggil method-method
        emp.displayInfo();   // menampilkan info lengkap (override + super)
        emp.work();          // method overriding dengan super
        emp.raiseSalary(500); // method tambahan menaikkan gaji

        // Menggunakan enkapsulasi untuk mengubah data
        emp.setAge(31);
        emp.setCompany("Innovatech");
        emp.displayInfo();
    }
}
