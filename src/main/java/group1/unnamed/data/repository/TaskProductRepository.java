package group1.unnamed.data.repository;

import group1.unnamed.data.entity.TaskProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskProductRepository extends JpaRepository<TaskProductEntity, Integer> {

    List<TaskProductEntity> findAllByTaskEntity_Id(int taskId);

}
