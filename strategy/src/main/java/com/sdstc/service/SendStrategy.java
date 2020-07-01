package com.sdstc.service;

import java.util.List;

public interface SendStrategy {
   void sendMsg(List<String> msg);
   String getType();
}
