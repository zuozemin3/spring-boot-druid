package com.zzm.utils;

public class ResultBuilder {

  public ResultBuilder() {
  }

  public static ResultVo buildSuccess() {
    ResultVo resultVo = new ResultVo();
    return resultVo;
  }

  public static ResultVo buildFail(String reason, String errorCode) {
    ResultVo resultVo = new ResultVo();
    resultVo.setResult(false);
    resultVo.setReason(reason);
    resultVo.setErrorCode(errorCode);
    return resultVo;
  }
}
