package com.owl.magicUtil.dto;

import java.util.List;

public class BanListDTO {
    private List<Long> idList;
    private Boolean status;

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
