package history.pkg202007;

import java.util.List;

public class L690 {

    private class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(final List<Employee> employees, final int id) {
        for (int i = 0; i < employees.size(); i++) {
            final Employee employee = employees.get(i);
            if (employee.id == id) {
                int sum = employee.importance;
                for (final Integer employeeId : employee.subordinates) {
                    sum += this.getImportance(employees, employeeId);
                }
                return sum;
            }
        }
        return 0;
    }
}
