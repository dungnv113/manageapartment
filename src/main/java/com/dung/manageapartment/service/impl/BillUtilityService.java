package com.dung.manageapartment.service.impl;

import com.dung.manageapartment.model.BillUtility;
import com.dung.manageapartment.model.Utility;

import java.util.List;

public interface BillUtilityService {
    List<Utility> getUtility();

    List<BillUtility> getBillUtility();

}
