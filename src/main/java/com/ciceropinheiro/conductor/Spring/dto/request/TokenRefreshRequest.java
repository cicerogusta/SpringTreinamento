package com.ciceropinheiro.conductor.Spring.dto.request;


import com.sun.istack.NotNull;

public class TokenRefreshRequest {
  @NotNull
  private String refreshToken;

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
}
