
package itaf.WsCartItemService;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import itaf.framework.ws.server.cart.impl.WsCartItemService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-19T10:49:22.662+08:00
 * Generated source version: 3.0.1
 * 
 */
public final class WsCartItemService_WsCartItemServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.cart.server.ws.framework.itaf/", "WsCartItemService");

    private WsCartItemService_WsCartItemServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WsCartItemService.WSDL_LOCATION;
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
      
        WsCartItemService ss = new WsCartItemService(wsdlURL, SERVICE_NAME);
        itaf.WsCartItemService.WsCartItemService port = ss.getWsCartItemServiceImplPort();  
        
      /* {
        System.out.println("Invoking putProductInCartItem...");
        itaf.WsCartItemService.BzCartItemDto _putProductInCartItem_dto = new itaf.WsCartItemService.BzCartItemDto();
        itaf.WsCartItemService.SysUserDto _putProductInCartItem_dtoSysUserDto = new itaf.WsCartItemService.SysUserDto();
        _putProductInCartItem_dtoSysUserDto.setId(Long.valueOf(1l));

        itaf.WsCartItemService.BzProductDto _putProductInCartItem_dtoBzProductDto = new itaf.WsCartItemService.BzProductDto();
        _putProductInCartItem_dtoBzProductDto.setId(Long.valueOf(1l));

        java.util.List<javax.xml.bind.JAXBElement<? extends java.lang.Object>> _putProductInCartItem_dtoBzProductDtoRest = new java.util.ArrayList<javax.xml.bind.JAXBElement<? extends java.lang.Object>>();
        javax.xml.bind.JAXBElement<? extends java.lang.Object> _putProductInCartItem_dtoBzProductDtoRestVal1 = null;
        _putProductInCartItem_dtoBzProductDtoRest.add(_putProductInCartItem_dtoBzProductDtoRestVal1);
        _putProductInCartItem_dtoBzProductDto.getRest().addAll(_putProductInCartItem_dtoBzProductDtoRest);
        _putProductInCartItem_dto.setBzProductDto(_putProductInCartItem_dtoBzProductDto);
        _putProductInCartItem_dto.setSysUserDto(_putProductInCartItem_dtoSysUserDto);
        _putProductInCartItem_dto.setItemNum(Long.valueOf(1l));
        _putProductInCartItem_dto.setItemUnitPrice(new java.math.BigDecimal("1"));
        _putProductInCartItem_dto.setItemDiscount(new java.math.BigDecimal("1"));
        _putProductInCartItem_dto.setItemPreferential(new java.math.BigDecimal("1"));
        _putProductInCartItem_dto.setItemPrice(new java.math.BigDecimal("1"));
        itaf.WsCartItemService.WsPageResult _putProductInCartItem__return = port.putProductInCartItem(_putProductInCartItem_dto);
        System.out.println("putProductInCartItem.result=" + _putProductInCartItem__return);


        }*/
        /* {
        System.out.println("Invoking deleteByIds...");
        java.lang.String _deleteByIds_ids = "1";
        itaf.WsCartItemService.WsPageResult _deleteByIds__return = port.deleteByIds(_deleteByIds_ids);
        System.out.println("deleteByIds.result=" + _deleteByIds__return);


        }*/
        {
        System.out.println("Invoking findListByUserId...");
        java.lang.Long _findListByUserId_userId = Long.valueOf(1l);
        itaf.WsCartItemService.WsPageResult _findListByUserId__return = port.findListByUserId(_findListByUserId_userId);
        System.out.println("findListByUserId.result=" + _findListByUserId__return);


        }

        System.exit(0);
    }

}