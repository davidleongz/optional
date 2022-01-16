package com.david.optional.dto;

public class MemberCardDTO {

  private String name;
  private MembershipLevelEnum level;

  public MemberCardDTO(String id) {

    this(id, MembershipLevelEnum.REGULAR);
  }

  public MemberCardDTO(String name, MembershipLevelEnum level) {

    this.name = name;
    this.level = level;
  }

  public String getName() {
    return name;
  }

  public MembershipLevelEnum getLevel() {
    return level;
  }

  public void setLevel(MembershipLevelEnum level) {
    this.level = level;
  }
}
