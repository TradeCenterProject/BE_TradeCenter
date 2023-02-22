package group1.unnamed.data.repository;

import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.data.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    List<TaskEntity> findAllByAdminEntity_IdOrStaffEntity_Id(int adminId, int staffId);

}
