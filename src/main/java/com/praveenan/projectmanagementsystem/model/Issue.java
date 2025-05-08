package com.praveenan.projectmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;
  private String description;
  private String status;
  private Long projectID;
  private String priority;
  private LocalDate dueDate;
  private List<String> tags = new ArrayList<>();

  @ManyToOne
  private User assignee;

  @JsonIgnore
  @ManyToOne
  private Project project;

  @JsonIgnore
  @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
  private List<Comment> comments = new ArrayList<>();

}
