package at.spengergasse.company.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Company implements Serializable {

    public static final String CSV_DELIMITER = ";";

    private String companyName;
    private String companyAddress;

    private ArrayList<Employee> staff;

    private Company() {
        staff = new ArrayList<>();
        companyName = "n/a";
        companyAddress = "n/a";
    }

    private Company(String name, String address) throws CompanyException {
        setCompanyName(name);
        setCompanyAddress(address);
        staff = new ArrayList<>();
    }

    private static Company companyInstance = null;
    public static Company getInstance() {
        if (companyInstance == null) {
            companyInstance = new Company();
            try {
                companyInstance.fillDebugData();
            } catch (CompanyException e) {
                e.printStackTrace();
            }
        }
        return companyInstance;
    }

    public static void loadFromFile(InputStream is) throws CompanyException {
        companyInstance = Company.readFromFile(is);
    }
    public static void loadFromFile(String filename) throws CompanyException {
        companyInstance = Company.readFromFile(filename);
    }

    public static void clearInstance() {
        companyInstance = null;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) throws CompanyException {
        if (companyName != null && !companyName.isBlank()) {
            this.companyName = companyName;
        } else {
            throw new CompanyException("Invalid company name: null or empty. ");
        }
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) throws CompanyException {
        if (companyAddress != null && !companyAddress.isBlank()) {
            this.companyAddress = companyAddress;
        } else {
            throw new CompanyException("Invalid company address: null or empty. ");
        }
    }

    public void hire(Employee emp) throws CompanyException {
        if (emp != null) {
	        if (emp.getId() == null) {
                emp.setId(Employee.idCounter++);
            }
            if (!staff.contains(emp)) {
                staff.add(emp);
            } else {
                throw new CompanyException("Error: employee already exists in company. ");
            }
        } else {
            throw new CompanyException("Error: invalid employee: null. ");
        }
    }

    public boolean fire(Employee emp) throws CompanyException {
        if (emp != null) {
            if (staff.contains(emp)) {
                staff.remove(emp);
                return true;
            } else {
                // this is not necessarily an exception
                return false;
            }
        } else {
            throw new CompanyException("Error: employee is null. ");
        }

    }

    /**
     * All (!) employees that match the criterion are removed from the company!
     */
    public boolean fire(String firstName, String lastName) throws CompanyException {
        boolean removed;
        if (firstName != null && lastName != null) {
            removed = false;

            Iterator<Employee> it = staff.iterator();
            while (it.hasNext()) {
                Employee e = it.next();
                if (e.getLastName().equals(lastName) && e.getFirstName().equals(firstName)) {
                    it.remove();
                    removed = true;
                }
            }
        } else {
            throw new CompanyException("Error: invalid parameters (null values are not allowed). ");
        }
        return removed;
    }

    public boolean fire(Long id) throws CompanyException {
        if (id != null) {
            Iterator<Employee> it = staff.iterator();
            while (it.hasNext()) {
                Employee employee = it.next();
                if (id.equals( employee.getId())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        } else {
            throw new CompanyException("Error: provided id is null. ");
        }
    }

    public int numberOfEmployees() {
        return staff.size();
    }

    public Employee getEmployee(int index) throws CompanyException {
        if (index < staff.size()) {
            return staff.get(index);
        } else {
            throw new CompanyException("Error: employee with index " + index + " does not exist. ");
        }
    }

    public Employee getEmployee(Long id) throws CompanyException {
        return staff.stream().filter(e -> e.getId().equals(id))
                .findFirst().orElseThrow( () -> new CompanyException("Error: no employee with id "
                        + id + " exists. " ));
    }

    public List<Employee> getStaff() {
        return new ArrayList<>(staff);
    }

    public int numberOfManagers() {
        return (int)(staff.stream().filter(e->e.getRole().equals(Employee.Role.MANAGER)).count());
    }

    public List<Employee> employeesSortedLastName() {
        ArrayList<Employee> sorted = new ArrayList<>(staff);
        // sorted.sort((Employee a, Employee b) -> { a.getLastName().compareTo(b.getLastName()); });
        sorted.sort(Comparator.comparing(Employee::getLastName));
        return sorted;
    }

    public List<Employee> employeesSortedSalaryDecreasing() {
        ArrayList<Employee> sorted = new ArrayList<>(staff);
        sorted.sort((Employee a, Employee b) -> (b.getSalary()-a.getSalary()) );
        return sorted;
    }

    public List<Employee> employeesSortedSalaryDecreasing(int minSalary) {
        return staff.stream()
                .filter(e -> (e.getSalary() > minSalary))
                .sorted((Employee a, Employee b) -> (b.getSalary()-a.getSalary()))
                .collect(Collectors.toList());
    }

    public void increaseSalaryByPercent(int percent) throws CompanyException {
        if (percent > 0 && percent <= 100) {
            staff.stream().forEach(e -> {
                try {
                    e.setSalary((int) (e.getSalary() * (100 + percent) / 100.));
                } catch (CompanyException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } else {
            throw new CompanyException("Error: invalid percentage provided. ");
        }
    }

    public void serialize(String filename) throws CompanyException {
        if (filename != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(this);
            } catch (FileNotFoundException e) {
                throw new CompanyException("Error: File not found. ", e);
            } catch (IOException e) {
                throw new CompanyException("Error: IO Exception. ", e);
            }
        } else {
            throw new CompanyException("Error: filename is null. ");
        }
    }

    public static Company deserialize(String filename) throws CompanyException {
        Company company = null;
        if (filename != null) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                Object o = ois.readObject();
                company = (Company) o;
            } catch (FileNotFoundException e) {
                throw new CompanyException("Error: FileNotFoundException. ", e);
            } catch (IOException e) {
                throw new CompanyException("Error: IO Exception. ", e);
            } catch (ClassNotFoundException e) {
                throw new CompanyException("Error reading object from file. ", e);
            }
        } else {
            throw new CompanyException("Error: filename is null. ");
        }
        return company;
    }

    public void writeToFile(String filename) throws CompanyException {
        if (filename != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                bw.write(this.toCsvString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new CompanyException("Error: filename is null. ");
        }
    }

    public static Company readFromFile(InputStream is) throws CompanyException {
        Company company = new Company("n/a", "n/a");
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            try (BufferedReader br = new BufferedReader(isr)) {
                String line = br.readLine();
                if (!line.contains(";")) {
                    company.setCompanyName(line);
                } else {
                    throw new CompanyException("Invalid first line. Single column with company name expected. " );
                }
                line = br.readLine();
                if (!line.contains(";")) {
                    company.setCompanyAddress(line);
                } else {
                    throw new CompanyException("Invalid second line. Single column with company address expected. " );
                }
                line = br.readLine();
                while (line != null) {
                    String[] tokens = line.split(";");
                    if (tokens.length > 0) {
                        Employee empl = new Employee(line);
                        company.hire(empl);
                    } else {
                        throw new CompanyException("Error: invalid line: " + line);
                    }
                    line = br.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new CompanyException("Error: filename is null. ");
        }
        return company;
    }

    public static Company readFromFile(String filename) throws CompanyException {
        Company company = new Company("n/a", "n/a");
        if (filename != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line = br.readLine();
                if (!line.contains(";")) {
                    company.setCompanyName(line);
                } else {
                    throw new CompanyException("Invalid first line. Single column with company name expected. " );
                }
                line = br.readLine();
                if (!line.contains(";")) {
                    company.setCompanyAddress(line);
                } else {
                    throw new CompanyException("Invalid second line. Single column with company address expected. " );
                }
                line = br.readLine();
                while (line != null) {
                    String[] tokens = line.split(";");
                    if (tokens.length > 0) {
                        Employee empl = new Employee(line);
                        company.hire(empl);
                    } else {
                        throw new CompanyException("Error: invalid line: " + line);
                    }
                    line = br.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new CompanyException("Error: filename is null. ");
        }
        return company;
    }


    public String toCsvString() {
        String csv = companyName + "\n" + companyAddress + "\n";
        for (Employee e : staff) {
            csv += e.toCsvString() + "\n";
        }
        return csv;
    }

    @Override
    public String toString() {
        final String line = "------------------------------------------------";
        String str = "Company Name: " + companyName + "\n";
        str += "Address: " + companyAddress + "\n";
        str += line + "\n";
        str += "Staff: " + "\n";
        for (Employee emp : staff) {
            str += emp + "\n";
        }
        str += line + "\n";
        return str;
    }

    public void print() {
        System.out.println(this);
    }

    protected void fillDebugData() throws CompanyException {
        if (staff.size() == 0) {
            setCompanyName("Spenger Inc.");
            setCompanyAddress("Spengergasse 20, 1070 Wien");

            hire(new Employee(1001l, "Donald", "Knuth", "knuth@spengergasse.at", "+43 1 54615 101",
                    LocalDate.of(1938, 1, 10), Employee.Role.DEVELOPER, 12000, false));
            hire(new Employee(1002l, "Bjarne", "Stroustrup", "stroustrup@spengergasse.at", "+43 1 54615 102",
                    LocalDate.of(1950, 12, 30), Employee.Role.MANAGER, 13000, false));
            hire(new Employee(1003l, "Dennis", "Ritchie", "ritchie@spengergasse.at", "+43 1 54615 113",
                    LocalDate.of(1941, 9, 9), Employee.Role.DEVELOPER, 9000, true));
            hire(new Employee(1004l, "Linus", "Torwalds", "torwalds@spengergasse.at", "+43 1 54615 121",
                    LocalDate.of(1969, 12, 28), Employee.Role.MANAGER, 7000, false));
            hire(new Employee(1005l, "Martin", "Fowler", "fowler@spengergasse.at", "+43 1 54615 127",
                    LocalDate.of(1963, 12, 18), Employee.Role.ANALYST, 11000, false));
        }
    }

}
