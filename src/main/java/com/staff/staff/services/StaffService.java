package com.staff.staff.services;

import com.staff.staff.models.Staff;
import com.staff.staff.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public Staff save(Staff staff){
        LocalDateTime localDate = LocalDate.now().atStartOfDay();
        if (staff.getProjectStartedAt() != null){
            if (staff.getProjectFinishedAt() == null){
                staff.setProjectFinishedAt(localDate);
            }
            Long duration = Duration.between(staff.getProjectStartedAt(), staff.getProjectFinishedAt()).toDays();
            staff.setProjectDuration(duration);
        }
       return staffRepository.save(staff);
    }

    public void delete (Staff staff){
        staffRepository.delete(staff);
    }

    public List<Staff> findAll(){
        return staffRepository.findAll();
    }

    public List<Staff> findByProject() {
        List<Staff> employee = staffRepository.findAll();
        List<Staff> whoWorkedTogether = new ArrayList<>();
        Long workedTogether;

        for (int i = 0; i < employee.size(); i++) {
            Staff employeeI = employee.get(i);

            for (int j = i + 1; j < employee.size(); j++) {
                Staff employeeJ = employee.get(j);

                    if (employeeI.getProjectId() != null && employeeI.getProjectId().equals(employeeJ.getProjectId())) {
                        if (employeeI.getProjectStartedAt().isAfter(employeeJ.getProjectStartedAt())
                                && employeeJ.getProjectFinishedAt().isBefore(employeeI.getProjectFinishedAt())) {
                            workedTogether = Duration.between(employeeI.getProjectStartedAt(), employeeJ.getProjectFinishedAt()).toDays();
                            employeeI.setProjectDuration(workedTogether);
                            employeeJ.setProjectDuration(workedTogether);
                            whoWorkedTogether.add(employeeI);
                            whoWorkedTogether.add(employeeJ);
                        } else if (employeeJ.getProjectStartedAt().isAfter(employeeI.getProjectStartedAt())
                                && employeeI.getProjectFinishedAt().isBefore(employeeJ.getProjectFinishedAt())) {
                            workedTogether = Duration.between(employeeJ.getProjectStartedAt(), employeeI.getProjectFinishedAt()).toDays();
                            employeeI.setProjectDuration(workedTogether);
                            employeeJ.setProjectDuration(workedTogether);
                            whoWorkedTogether.add(employeeI);
                            whoWorkedTogether.add(employeeJ);
                        } else if (employeeI.getProjectStartedAt().isEqual(employeeJ.getProjectStartedAt())
                                && employeeI.getProjectFinishedAt().isEqual(employeeJ.getProjectFinishedAt())) {
                            workedTogether = Duration.between(employeeI.getProjectStartedAt(), employeeJ.getProjectFinishedAt()).toDays();
                            employeeI.setProjectDuration(workedTogether);
                            employeeJ.setProjectDuration(workedTogether);
                            whoWorkedTogether.add(employeeI);
                            whoWorkedTogether.add(employeeJ);
                        }
                    }
            }
        }
        return whoWorkedTogether;
    }

    public List<Staff> findEmployeesWhoWorkedTogether() {
        List<Staff> employees = staffRepository.findAll();
        List<Staff> employeesWorkedTogether = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            for (int j = i + 1  ; j < employees.size(); j++) {
                Staff employeeI = employees.get(i);
                Staff employeeJ = employees.get(j);

                if (employeeI.getProjectId() != null && employeeI.getProjectId().equals(employeeJ.getProjectId())) {
                    if (employeeI.getProjectStartedAt().isAfter(employeeJ.getProjectStartedAt())
                            && employeeI.getProjectFinishedAt().isAfter(employeeJ.getProjectFinishedAt())) {
                        long workedTogether = Duration.between(employeeI.getProjectStartedAt(), employeeJ.getProjectFinishedAt()).toDays();
                        employeeI.setProjectDuration(workedTogether);
                        employeeJ.setProjectDuration(workedTogether);
                        employeesWorkedTogether.add(employeeI);
                        employeesWorkedTogether.add(employeeJ);
                    }else if (employeeI.getProjectStartedAt().isBefore(employeeJ.getProjectStartedAt())
                            && employeeI.getProjectFinishedAt().isBefore(employeeJ.getProjectFinishedAt())){
                       Long workedTogether = Duration.between(employeeJ.getProjectStartedAt(), employeeI.getProjectFinishedAt()).toDays();
                        employeeI.setProjectDuration(workedTogether);
                        employeeJ.setProjectDuration(workedTogether);
                        employeesWorkedTogether.add(employeeI);
                        employeesWorkedTogether.add(employeeJ);
                    }else if (employeeI.getProjectStartedAt().isEqual(employeeJ.getProjectStartedAt())
                            && employeeI.getProjectFinishedAt().isBefore(employeeJ.getProjectFinishedAt())){
                        Long workedTogether = Duration.between(employeeJ.getProjectStartedAt(), employeeI.getProjectFinishedAt()).toDays();
                        employeeI.setProjectDuration(workedTogether);
                        employeeJ.setProjectDuration(workedTogether);
                        employeesWorkedTogether.add(employeeI);
                        employeesWorkedTogether.add(employeeJ);
                    }else if (employeeI.getProjectStartedAt().isEqual(employeeJ.getProjectStartedAt())
                            && employeeI.getProjectFinishedAt().isAfter(employeeJ.getProjectFinishedAt())){
                        Long workedTogether = Duration.between(employeeI.getProjectStartedAt(), employeeJ.getProjectFinishedAt()).toDays();
                        employeeI.setProjectDuration(workedTogether);
                        employeeJ.setProjectDuration(workedTogether);
                        employeesWorkedTogether.add(employeeI);
                        employeesWorkedTogether.add(employeeJ);
                    }else if (employeeI.getProjectStartedAt().isBefore(employeeJ.getProjectStartedAt())
                            && employeeI.getProjectFinishedAt().isEqual(employeeJ.getProjectFinishedAt())) {
                        Long workedTogether = Duration.between(employeeJ.getProjectStartedAt(), employeeI.getProjectFinishedAt()).toDays();
                        employeeI.setProjectDuration(workedTogether);
                        employeeJ.setProjectDuration(workedTogether);
                        employeesWorkedTogether.add(employeeI);
                        employeesWorkedTogether.add(employeeJ);
                    }else if (employeeI.getProjectStartedAt().isAfter(employeeJ.getProjectStartedAt())
                            && employeeI.getProjectFinishedAt().isEqual(employeeJ.getProjectFinishedAt())) {
                        Long workedTogether = Duration.between(employeeI.getProjectStartedAt(), employeeJ.getProjectFinishedAt()).toDays();
                        employeeI.setProjectDuration(workedTogether);
                        employeeJ.setProjectDuration(workedTogether);
                        employeesWorkedTogether.add(employeeI);
                        employeesWorkedTogether.add(employeeJ);
                    }else if (employeeI.getProjectStartedAt().isEqual(employeeJ.getProjectStartedAt())
                            && employeeI.getProjectFinishedAt().isEqual(employeeJ.getProjectFinishedAt())){
                        Long workedTogether = Duration.between(employeeI.getProjectStartedAt(), employeeJ.getProjectFinishedAt()).toDays();
                        employeeI.setProjectDuration(workedTogether);
                        employeeJ.setProjectDuration(workedTogether);
                        employeesWorkedTogether.add(employeeI);
                        employeesWorkedTogether.add(employeeJ);
                    }else if (employeeI.getProjectStartedAt().isAfter(employeeJ.getProjectStartedAt())
                            && employeeI.getProjectFinishedAt().isBefore(employeeJ.getProjectFinishedAt())){
                        Long workedTogether = Duration.between(employeeI.getProjectStartedAt(), employeeI.getProjectFinishedAt()).toDays();
                        employeeI.setProjectDuration(workedTogether);
                        employeeJ.setProjectDuration(workedTogether);
                        employeesWorkedTogether.add(employeeI);
                        employeesWorkedTogether.add(employeeJ);
                    }else if (employeeI.getProjectStartedAt().isBefore(employeeJ.getProjectStartedAt())
                            && employeeI.getProjectFinishedAt().isAfter(employeeJ.getProjectFinishedAt())){
                        Long workedTogether = Duration.between(employeeJ.getProjectStartedAt(), employeeJ.getProjectFinishedAt()).toDays();
                        employeeI.setProjectDuration(workedTogether);
                        employeeJ.setProjectDuration(workedTogether);
                        employeesWorkedTogether.add(employeeI);
                        employeesWorkedTogether.add(employeeJ);
                    }
                }
            }
        }
        return employeesWorkedTogether;
    }
}