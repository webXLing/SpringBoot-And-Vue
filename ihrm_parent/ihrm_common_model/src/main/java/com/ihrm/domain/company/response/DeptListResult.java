package com.ihrm.domain.company.response;

import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

// 某个公司下的 部门实体类
public class DeptListResult {

    private String companyId;
    private String companyName;
    private String companyManage;//公司联系人
    private List<Department> depts;

    public DeptListResult(Company company, List depts) {
        this.companyId = company.getId();
        this.companyName = company.getName();
        this.companyManage = company.getLegalRepresentative();//公司联系人
        this.depts = depts;
    }
}
