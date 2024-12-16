package com.atuyto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    // Ajouter un employé à la liste
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Supprimer un employé de la liste
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    // Obtenir le salaire moyen de tous les employés
    public double getAverageSalary() {
        if (employees.isEmpty()) {
            throw new IllegalStateException("No employees available.");
        }
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / employees.size();
    }

    // Trouver un employé par nom
    public Employee findEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }
}
