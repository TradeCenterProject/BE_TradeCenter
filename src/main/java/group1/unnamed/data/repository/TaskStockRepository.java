package group1.unnamed.data.repository;

import group1.unnamed.data.entity.TaskStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskStockRepository extends JpaRepository<TaskStockEntity, Integer> {

    List<TaskStockEntity> findAllByTaskEntity_Id(int taskId);

}
