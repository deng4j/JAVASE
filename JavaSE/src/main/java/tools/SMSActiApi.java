package tools;

import ru.sms_activate.SMSActivateApi;
import ru.sms_activate.client_enums.SMSActivateClientStatus;
import ru.sms_activate.error.base.SMSActivateBaseException;
import ru.sms_activate.error.wrong_parameter.SMSActivateWrongParameterException;
import ru.sms_activate.response.api_activation.SMSActivateActivation;
import ru.sms_activate.response.api_activation.SMSActivateGetFullSmsResponse;
import ru.sms_activate.response.api_activation.SMSActivateGetNumbersStatusResponse;
import ru.sms_activate.response.api_activation.extra.SMSActivateGetPriceInfo;
import ru.sms_activate.response.api_activation.extra.SMSActivateServiceInfo;
import ru.sms_activate.response.api_rent.extra.SMSActivateRentActivation;

public class SMSActiApi {

    private static Integer countid = 32;

    /**
     * 香港：14
     * 印度尼西亚：6
     * 罗马尼亚：32
     */
    public static void main(String[] args) throws SMSActivateBaseException {
        SMSActivateApi smsActivateApi = new SMSActivateApi("4Ae3d78b67b525927ff0A0b8827548ff");
        //获取您帐户的当前余额
        System.out.println(smsActivateApi.getBalance());

        SMSActivateActivation activation = smsActivateApi.getNumber(countid, "dr");//在印度尼西亚获得openai服务的激活
        System.out.println(activation.getNumber());
        smsActivateApi.setStatus(activation, SMSActivateClientStatus.MESSAGE_WAS_SENT);//发送短信以获取号码后，设置MESSAGE_WAS_SENT状态
        String code = smsActivateApi.waitSms(activation, 2);//在2分钟内设置接收短信
        if (code == null) {
            smsActivateApi.setStatus(activation, SMSActivateClientStatus.CANCEL);//如果短信尚未到达，则设置取消状态
        } else {
            SMSActivateGetFullSmsResponse smsActivateGetFullSmsResponse = smsActivateApi.getFullSms(activation);//接收短信
            System.out.println("Full SMS: " + smsActivateGetFullSmsResponse.getText());//短信输出
        }
    }


    public static void rentNumber(SMSActivateApi smsActivateApi) throws SMSActivateBaseException {
        SMSActivateGetNumbersStatusResponse smsActivateGetNumbersStatusResponse = smsActivateApi.getNumbersStatus(countid, null);//获取有关印度尼西亚可用服务的信息
        SMSActivateServiceInfo dr = smsActivateGetNumbersStatusResponse.getSMSActivateServiceInfoByShortName("dr");//获取有关openai服务号码的信息
        System.out.println("Short name service: " + dr.getShortName());//返回服务的简称
        System.out.println("Forwarding is available:" + (dr.isForward() ? " yes " : " no "));//找出服务是否具有重定向

        SMSActivateGetPriceInfo priceInfo = smsActivateApi.getAllPrices().getPriceInfo(countid, "dr");
        System.out.println("price：" + priceInfo.getCost());
        System.out.println("numbers:" + priceInfo.getCountPhoneNumbers());
        System.out.println("------------------------------------------------------");


        SMSActivateRentActivation rentActivation = smsActivateApi.getRentNumber(countid, "dr", 6);//租房
        System.out.println(">> ID: " + rentActivation.getId());//激活ID
        System.out.println(">> Number: " + rentActivation.getNumber());//获取number
        System.out.println(">> End date: " + rentActivation.getEndDate());//显示激活到期日期
        System.out.println(smsActivateApi.getRentStatus(rentActivation));//获取激活状态

    }
}
