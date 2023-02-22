package group1.unnamed.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class TaskStockEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private TaskEntity taskEntity;
    @ManyToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    private StockEntity stockEntity;
    private int amount;

    public TaskStockEntity(TaskEntity taskEntity, StockEntity stockEntity, int amount) {
        this.taskEntity = taskEntity;
        this.stockEntity = stockEntity;
        this.amount = amount;
    }
}
