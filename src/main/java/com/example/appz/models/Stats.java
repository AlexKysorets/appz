package com.example.appz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Stats")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stats {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "started_at")
    private String startedAt;
    @Column(name = "ended_at")
    private String endedAt;
    @Column(name = "win_count")
    private int winCount;
    @Column(name = "lose_count")
    private int loseCount;
    @Column(name = "refund_count")
    private int refundCount;
    @Column(name = "win_percent")
    private double winPercent;
    @Column(name = "min_coef")
    private double minCoef;
    @Column(name = "max_coef")
    private double maxCoef;
    @Column(name = "average_coef")
    private double averageCoef;
    @Column(name = "profit")
    private double profit;
    @Column(name = "profit_percent")
    private double profitPercent;
}
