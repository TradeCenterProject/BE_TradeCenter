package group1.unnamed.data.repository;

import group1.unnamed.data.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    List<TaskEntity> findAllByBossEntity_IdOrEmployeeEntity_Id(int bossId, int employeeId);
    int countAllByDateAndType(String date, String type);
}
