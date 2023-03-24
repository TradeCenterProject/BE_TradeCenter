package group1.unnamed.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "task_stocks")
public class TaskProductEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private TaskEntity taskEntity;
    @ManyToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    private ProductEntity productEntity;
    private int quantity;

    public TaskProductEntity(TaskEntity taskEntity, ProductEntity productEntity, int quantity) {
        this.taskEntity = taskEntity;
        this.productEntity = productEntity;
        this.quantity = quantity;
    }
}
