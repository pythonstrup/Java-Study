package com.pythonstrup.proxy.protection;

public class PersonImpl implements Person {

  String name;
  String gender;
  String interests;
  int rating;
  int ratingCount = 0;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getGender() {
    return gender;
  }

  @Override
  public String getInterests() {
    return interests;
  }

  @Override
  public int getGeekRating() {
    if (ratingCount == 0) return 0;
    return (rating/ratingCount);
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public void setGender(final String gender) {
    this.gender = gender;
  }

  @Override
  public void setInterests(final String interests) {
    this.interests = interests;
  }

  @Override
  public void setGeekRating(final int rating) {
    this.rating += rating;
    ratingCount++;
  }
}
