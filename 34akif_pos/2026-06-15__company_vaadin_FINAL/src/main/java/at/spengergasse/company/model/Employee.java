package at.spengergasse.company.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import at.spengergasse.company.model.CompanyException;

public class Employee implements Serializable {

    private static final int MAX_SALARY = 100000;
    public static Long idCounter = 1000L;

    // keep konsistent with csv-ctor
    public enum Role { ADMIN, ASSISTANT, DEVELOPER, ANALYST, MANAGER};

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private Role role;
    private int salary; // gross salary (per month)
    private boolean subcontractor;

    public Employee() {
        id = null;
        firstName = "[first name not set]";
        lastName = "[last name not set]";
        email = "office@spengergasse.at";
        phone = "+43 1 54615 0";
        dateOfBirth = LocalDate.of(1970, 01, 01);
        role = Role.ADMIN;
        salary = 1400;
        subcontractor = false;
    }


    public Employee(String firstName, String lastName, String email,
                    String phone, LocalDate dateOfBirth,
                    Role role, int salary, boolean subcontractor)
            throws CompanyException
    {
        setId(Employee.idCounter++);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        setDateOfBirth(dateOfBirth);
        setRole(role);
        setSalary(salary);
        setSubcontractor(subcontractor);
    }

    public Employee(Long id, String firstName, String lastName, String email,
                    String phone, LocalDate dateOfBirth,
                    Role role, int salary, boolean subcontractor)
            throws CompanyException
    {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        setDateOfBirth(dateOfBirth);
        setRole(role);
        setSalary(salary);
        setSubcontractor(subcontractor);
    }

    public Employee(String csvString) throws CompanyException {
        if (csvString != null) {
            String[] tokens = csvString.split(";");
            if (tokens.length >= 9) {
                try {
                    Long id = Long.parseLong(tokens[0]);
                    setId(id);
                } catch (NumberFormatException e) {
                    throw new CompanyException("Error: invalid id in line " + csvString + ". ", e);
                }
                setFirstName(tokens[1]);
                setLastName(tokens[2]);
                setEmail(tokens[3]);
                setPhone(tokens[4]);
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate dob = LocalDate.parse(tokens[5], formatter);
                    setDateOfBirth(dob);
                } catch (DateTimeParseException e) {
                    System.out.println("Date String: " + tokens[5]);
                    throw new CompanyException("Error: could not read date in line "
                            + csvString + ". ", e);
                }
                switch (tokens[6]) {
                    case "ADMIN": setRole(Role.ADMIN); break;
                    case "ASSISTANT": setRole(Role.ASSISTANT); break;
                    case "DEVELOPER": setRole(Role.DEVELOPER); break;
                    case "ANALYST": setRole(Role.ANALYST); break;
                    case "MANAGER": setRole(Role.MANAGER); break;
                    default: throw new CompanyException("Error: invalid role value in line "
                            + csvString + ". ");
                }
                try {
                    int salary = Integer.parseInt(tokens[7]);
                    setSalary(salary);
                } catch (NumberFormatException e) {
                    throw new CompanyException("Error: invalid salary in line "
                            + csvString + ". ", e);
                }

                if ("Employee".equals(tokens[8])) {
                    setSubcontractor(false);
                } else if ("Subcontractor".equals(tokens[8])) {
                    setSubcontractor(true);
                } else {
                    throw new CompanyException("Error: invalid employment status in line "
                            + csvString
                            + ". Expected: 'Employee' or 'Subcontractor'.");
                }
            } else {
                throw new CompanyException("Error: invalid csv line: " + csvString
                        + ". Not enough values (columns). ");
            }
        } else {
            throw new CompanyException("Error: csvString is null. ");
        }
    }

    public void setId(Long id) throws CompanyException {
        if (id >= 0) {
            if (id >= Employee.idCounter) {
                Employee.idCounter = id + 1;
            }
            this.id = id;
        } else {
            throw new CompanyException("Error: invalid id: " + id);
        }
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) throws CompanyException {

        if (firstName != null && firstName.length() > 2 && !firstName.isBlank()) {
            this.firstName = firstName;
        } else {
            throw new CompanyException("Error: invalid first name: " + firstName);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws CompanyException {
        if (lastName != null && lastName.length() > 2 && !lastName.isBlank()) {
            this.lastName = lastName;
        } else {
            throw new CompanyException("Error: invalid last name: " + lastName);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws CompanyException {
        if (email != null && email.length() > 5 && email.contains("@")
                && email.contains("."))
        {
            this.email = email;
        } else {
            throw new CompanyException("Error: invalid email address: " + email);
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws CompanyException {
        if (phone != null) {
            this.phone = phone;
        } else {
            throw new CompanyException("Error: invalid phone (null). ");
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) throws CompanyException {
        if (role != null) {
            this.role = role;
        } else {
            throw new CompanyException("Error: invalid role " + role);
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) throws CompanyException {
        if (salary > 518 && salary < MAX_SALARY) {
            this.salary = salary;
        } else {
            throw new CompanyException("Error: invalid salary: " + salary);
        }
    }

    public boolean isSubcontractor() {
        return subcontractor;
    }

    public void setSubcontractor(boolean subcontractor) {
        this.subcontractor = subcontractor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;
        if (this.id != employee.getId()) return false;
        return true;
    }

    public String toCsvString() {
        String str = id + Company.CSV_DELIMITER;
        str += firstName + Company.CSV_DELIMITER + lastName + Company.CSV_DELIMITER;
        str += email + Company.CSV_DELIMITER + phone + Company.CSV_DELIMITER;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        str += formatter.format(dateOfBirth) + Company.CSV_DELIMITER;
        str += role + Company.CSV_DELIMITER;
        str += salary + Company.CSV_DELIMITER;
        str += subcontractor ? "Subcontractor" : "Employee";
        return str;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
                " (E: " + email + ", P:" + phone + "), " +
                "date of birth: " + dateOfBirth +
                ", role: " + role +
                ", gross salary: " + salary + " per month, " +
                (subcontractor ? "Subcontractor" : "Employee") +
                ", id=" + id;
    }

}
