
package itaf.WsRealnameCertificateApplyService;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import itaf.framework.ws.server.certificate.impl.WsRealnameCertificateApplyService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-28T13:13:59.418+08:00
 * Generated source version: 3.0.1
 * 
 */
public final class WsRealnameCertificateApplyService_WsRealnameCertificateApplyServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.certificate.server.ws.framework.itaf/", "WsRealnameCertificateApplyService");

    private WsRealnameCertificateApplyService_WsRealnameCertificateApplyServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WsRealnameCertificateApplyService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        WsRealnameCertificateApplyService ss = new WsRealnameCertificateApplyService(wsdlURL, SERVICE_NAME);
        itaf.WsRealnameCertificateApplyService.WsRealnameCertificateApplyService port = ss.getWsRealnameCertificateApplyServiceImplPort();  
        
        {
        System.out.println("Invoking create...");
        itaf.WsRealnameCertificateApplyService.BzRealnameCertificateApplyDto _create_dto = new itaf.WsRealnameCertificateApplyService.BzRealnameCertificateApplyDto();
        _create_dto.setId(Long.valueOf(2630578701261366306l));
        _create_dto.setObjId(Long.valueOf(5699693015517443603l));
        _create_dto.setCreatedBy(Long.valueOf(1084683522928744289l));
        _create_dto.setCreatedDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.492+08:00"));
        _create_dto.setUpdatedBy(Long.valueOf(-517549473377981332l));
        _create_dto.setUpdatedDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.530+08:00"));
        _create_dto.setMarkForDelete(Boolean.valueOf(true));
        itaf.WsRealnameCertificateApplyService.SysUserDto _create_dtoSysUserDto = new itaf.WsRealnameCertificateApplyService.SysUserDto();
        _create_dtoSysUserDto.setId(Long.valueOf(6453068425810225917l));

        _create_dto.setSysUserDto(_create_dtoSysUserDto);
        _create_dto.setName("1");
        _create_dto.setSex(Long.valueOf(1l));
        _create_dto.setBirthdate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.537+08:00"));
        _create_dto.setMobile("1");
        _create_dto.setIdType(Long.valueOf(-5811664261760086539l));
        _create_dto.setIdNo("1");
        java.util.List<itaf.WsRealnameCertificateApplyService.BzRealnameCertificateDto> _create_dtoBzRealnameCertificateDtos = new java.util.ArrayList<itaf.WsRealnameCertificateApplyService.BzRealnameCertificateDto>();
        itaf.WsRealnameCertificateApplyService.BzRealnameCertificateDto _create_dtoBzRealnameCertificateDtosVal1 = new itaf.WsRealnameCertificateApplyService.BzRealnameCertificateDto();
        _create_dtoBzRealnameCertificateDtosVal1.setId(Long.valueOf(1064174488302488138l));
        _create_dtoBzRealnameCertificateDtosVal1.setObjId(Long.valueOf(-6640990933987179987l));
        _create_dtoBzRealnameCertificateDtosVal1.setCreatedBy(Long.valueOf(-8729275347347503992l));
        _create_dtoBzRealnameCertificateDtosVal1.setCreatedDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.538+08:00"));
        _create_dtoBzRealnameCertificateDtosVal1.setUpdatedBy(Long.valueOf(-1117939099159562401l));
        _create_dtoBzRealnameCertificateDtosVal1.setUpdatedDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.538+08:00"));
        _create_dtoBzRealnameCertificateDtosVal1.setMarkForDelete(Boolean.valueOf(false));
        itaf.WsRealnameCertificateApplyService.BzRealnameCertificateApplyDto _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto = new itaf.WsRealnameCertificateApplyService.BzRealnameCertificateApplyDto();
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setId(Long.valueOf(590004763631386239l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setObjId(Long.valueOf(-2802040835779957208l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setCreatedBy(Long.valueOf(-1969141992306532354l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setCreatedDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.539+08:00"));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setUpdatedBy(Long.valueOf(-6263818653307218216l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setUpdatedDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.539+08:00"));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setMarkForDelete(Boolean.valueOf(false));
        itaf.WsRealnameCertificateApplyService.SysUserDto _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto = new itaf.WsRealnameCertificateApplyService.SysUserDto();
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setId(Long.valueOf(1l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setObjId(Long.valueOf(-1926431830950729884l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setCreatedBy(Long.valueOf(5516497018552432763l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setCreatedDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.540+08:00"));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setUpdatedBy(Long.valueOf(-7275713956201335223l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setUpdatedDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.540+08:00"));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setMarkForDelete(Boolean.valueOf(true));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setUsername("Username740543318");
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setPassword("Password-541428814");
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setMobile("Mobile2106782848");
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setType(Long.valueOf(1541531266247702528l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setEmail("Email970474993");
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.setNickname("Nickname774886251");
        java.util.List<itaf.WsRealnameCertificateApplyService.SysRoleDto> _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDtoSysRoles = new java.util.ArrayList<itaf.WsRealnameCertificateApplyService.SysRoleDto>();
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto.getSysRoles().addAll(_create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDtoSysRoles);
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setSysUserDto(_create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoSysUserDto);
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setBzAttachmentId(Long.valueOf(-8446045411936205269l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setName("Name994044576");
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setSex(Long.valueOf(-1350185707760391999l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setBirthdate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.541+08:00"));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setMobile("Mobile-1983502767");
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setIdType(Long.valueOf(-2039486186099346618l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setIdNo("IdNo-2059270198");
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setApprovalStatus(Long.valueOf(-3495728942487112511l));
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.setBzWorkflowId(Long.valueOf(-4310213972403227762l));
        java.util.List<itaf.WsRealnameCertificateApplyService.BzRealnameCertificateDto> _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoBzRealnameCertificateDtos = new java.util.ArrayList<itaf.WsRealnameCertificateApplyService.BzRealnameCertificateDto>();
        _create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto.getBzRealnameCertificateDtos().addAll(_create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDtoBzRealnameCertificateDtos);
        _create_dtoBzRealnameCertificateDtosVal1.setBzRealnameCertificateApplyDto(_create_dtoBzRealnameCertificateDtosVal1BzRealnameCertificateApplyDto);
        _create_dtoBzRealnameCertificateDtosVal1.setSysUserId(Long.valueOf(4576202180702717394l));
        _create_dtoBzRealnameCertificateDtosVal1.setName("Name2125844502");
        _create_dtoBzRealnameCertificateDtosVal1.setSex(Long.valueOf(6000930380933223911l));
        _create_dtoBzRealnameCertificateDtosVal1.setBirthdate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-09-28T13:13:59.542+08:00"));
        _create_dtoBzRealnameCertificateDtosVal1.setMobile("Mobile-1851510052");
        _create_dtoBzRealnameCertificateDtosVal1.setIdType(Long.valueOf(-5616716655402190890l));
        _create_dtoBzRealnameCertificateDtosVal1.setIdNo("IdNo-1436748480");
        _create_dtoBzRealnameCertificateDtos.add(_create_dtoBzRealnameCertificateDtosVal1);
        _create_dto.getBzRealnameCertificateDtos().addAll(_create_dtoBzRealnameCertificateDtos);
        itaf.WsRealnameCertificateApplyService.WsPageResult _create__return = port.create(_create_dto);
        System.out.println("create.result=" + _create__return);


        }

        System.exit(0);
    }

}