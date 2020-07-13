package pkg202007;

import java.util.List;

public class L690 {

    private class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.id == id) {
                int sum = employee.importance;
                for (Integer employeeId : employee.subordinates) {
                    sum += getImportance(employees, employeeId);
                }
                return sum;
            }
        }
        return 0;
    }
}
