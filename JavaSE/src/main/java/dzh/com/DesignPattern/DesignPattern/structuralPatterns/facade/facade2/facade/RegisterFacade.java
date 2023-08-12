package dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade2.facade;

import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade2.subSystem.Bank;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade2.subSystem.Industrial;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade2.subSystem.InlandRevenueDepartment;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade2.subSystem.QualityInspectionOffice;

/**
 *办理公司流程的门面对象
 */
public class RegisterFacade {

    public  void register(){
        Industrial industrial=new Industrial();
        industrial.checkName();

        QualityInspectionOffice q=new QualityInspectionOffice();
        q.orgCodeCertificate();

        InlandRevenueDepartment i=new InlandRevenueDepartment();
        i.taxCertificate();

        Bank bank=new Bank();
        bank.openAccount();
    }
}
