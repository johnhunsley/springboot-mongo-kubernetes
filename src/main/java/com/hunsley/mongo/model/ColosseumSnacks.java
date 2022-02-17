package com.hunsley.mongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "colesseum-snacks")
public class ColosseumSnacks {

  @Id
  private Long identifier;

  @Field
  private int ottersNoses;

  @Field
  private int wolfNipples;

  @Field
  private int larksTongues;

  @Field
  private int wrensLivers;
}
