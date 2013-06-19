package org.jersey.sample.service.impl;

import org.jersey.sample.service.Manager;
import org.springframework.stereotype.Service;

/**
 * @author: Syed Shahul
 */
@Service("manager")
public class ManagerImpl implements Manager {
  public String getIt() {
    return " Manager ";
  }
}
